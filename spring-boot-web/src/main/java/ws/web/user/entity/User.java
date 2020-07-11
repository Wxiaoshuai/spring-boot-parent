package ws.web.user.entity;

import ws.common.entity.EntityBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends EntityBase {

    private Integer id;

    private String username;

    private String password;

    private String userRole;

    //用户名密码校验
    public boolean checkPassword(User userFromWeb) {
        if (!userFromWeb.getPassword().isEmpty() && password.equals(userFromWeb.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    public Map toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", username);
        map.put("password", password);
        map.put("userRole", userRole);
        map.put("updateUser", "admin");
        map.put("updateTime", new Date());
        return map;
    }
}
