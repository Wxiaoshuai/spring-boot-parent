package ws.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 实体基类
 * @author: ws
 * @create: 2020-06-28 16:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntityBase implements Serializable {

    private String updateUser;

    private Date updateTime;

    private Date timeStamp;

    private Integer deleteFlag;


    public EntityBase(String updateUser) {
        this.updateUser = updateUser;
        this.updateTime = new Date();
        this.deleteFlag = 0;
    }
}
