package ws.web.user.mapper;

import ws.web.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @description: 用户mapper接口
 * @author: ws
 * @create: 2020-06-29 15:11
 **/
@Mapper
public interface IUserMapper {

    // 根据用户名查询用户
    User getUserByUsername(String username);

    List<User> queryUserByConditions(Map map);

    void createUser(Map map);

    void updateUser(Map map);
}
