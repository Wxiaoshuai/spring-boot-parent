package ws.web.user;

import ws.web.util.CodeEnum;
import ws.web.user.entity.User;
import ws.web.user.pojo.UserQueryConditions;
import ws.web.user.service.UserService;
import ws.web.util.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login", produces = "application/json;charset=UTF-8")
    public ResponseData login(@RequestBody User user) {
        System.out.println(user.toString());

        if (userService.login(user)) {
            return new ResponseData(CodeEnum.SUCCESS);
        } else {
            return new ResponseData(CodeEnum.FAIL);
        }
    }

    @GetMapping(value = "/queryUser")
    public ResponseData queryUser(UserQueryConditions queryConditions) {
        List<User> userList = userService.queryUser(queryConditions);
        ResponseData responseData = new ResponseData(CodeEnum.SUCCESS);
        responseData.setData(userList);
        return responseData;
    }

    @PostMapping(value = "/create", produces = "application/json;charset=UTF-8")
    public ResponseData createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseData(CodeEnum.SUCCESS);
    }

    @PostMapping(value = "/edit", produces = "application/json;charset=UTF-8")
    public ResponseData editUser(@RequestBody User user) {
        userService.updateUser(user);
        return new ResponseData(CodeEnum.SUCCESS);
    }

    @PostMapping(value = "/delete", produces = "application/json;charset=UTF-8")
    public ResponseData deleteUser(@RequestBody User user) {
        return new ResponseData(CodeEnum.SUCCESS);
    }


    @GetMapping(value = "/test")
    public String login() {
        return "success!!";
    }
}
