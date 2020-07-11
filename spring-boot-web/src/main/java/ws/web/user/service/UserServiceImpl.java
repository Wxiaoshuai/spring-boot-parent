package ws.web.user.service;

import ws.web.user.entity.User;
import ws.web.user.mapper.IUserMapper;
import ws.web.user.pojo.UserQueryConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @description: 用户功能逻辑层实现
 * @author: ws
 * @create: 2020-06-28 19:37
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserMapper userMapper;

    /**
     * 判断用户名密码是否正确
     *
     * @param user
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public boolean login(User user) {
        User queryOneByUsername = userMapper.getUserByUsername(user.getUsername());
        if (queryOneByUsername != null) {
            return queryOneByUsername.checkPassword(user);
        } else {
            return false;
        }
    }

    /**
     * 根据条件查询用户
     *
     * @param queryConditions
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> queryUser(UserQueryConditions queryConditions) {
        Map<String, Object> map = new HashMap<>();
        map.put("start", (queryConditions.getCurrentPage() - 1) * queryConditions.getLimit());
        map.put("end", queryConditions.getCurrentPage() * queryConditions.getLimit());

        List<User> userList = userMapper.queryUserByConditions(map);
        return userList;
    }

    /**
     * 创建用户
     *
     * @param user
     * @return
     */
    @Override
    @Transactional
    public void createUser(User user) {
        userMapper.createUser(user.toMap());
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.updateUser(user.toMap());
    }
}
