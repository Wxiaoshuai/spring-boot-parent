package ws.web.user.pojo;

import ws.web.util.QueryConditionsBase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 用户查询条件
 * @author: ws
 * @create: 2020-07-01 12:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserQueryConditions extends QueryConditionsBase {

    private String username;

    private String role;

}
