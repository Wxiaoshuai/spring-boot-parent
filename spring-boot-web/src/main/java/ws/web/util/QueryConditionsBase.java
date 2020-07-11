package ws.web.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @description: 查询基类
 * @author: ws
 * @create: 2020-07-01 12:17
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryConditionsBase implements Serializable {

    private Integer currentPage;

    private Integer limit;

}
