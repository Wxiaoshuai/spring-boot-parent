package ws.common.entity;

import java.util.Date;

/**
 * @description: 实体套装
 * @author: ws
 * @create: 2020-06-28 16:58
 **/
public class EntitySuit {

    private String updateUser;

    private Date updateTime;

    private Date timeStamp;

    private Integer deleteFlag;

    public EntitySuit(String updateUser) {
        this.updateUser = updateUser;
        this.updateTime = new Date();
        this.deleteFlag = 0;
    }

}
