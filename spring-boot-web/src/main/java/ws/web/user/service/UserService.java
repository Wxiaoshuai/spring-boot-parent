package ws.web.user.service;

import ws.web.user.entity.User;
import ws.web.user.pojo.UserQueryConditions;

import java.util.List;

/**
 * @description: 用户功能逻辑层接口
 * @author: ws
 * @create: 2020-06-28 19:37
 **/
public interface UserService {

    boolean login(User user);

    List<User> queryUser(UserQueryConditions queryConditions);

    void createUser(User user);

    void updateUser(User user);
}
