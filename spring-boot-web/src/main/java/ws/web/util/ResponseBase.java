package ws.web.util;

import lombok.Data;

/**
 * @description: 响应数据基类
 * @author: ws
 * @create: 2020-06-28 15:58
 **/
@Data
public class ResponseBase {

    private Integer code;

    private String msg;

    public ResponseBase(CodeEnum codeEnum) {
        this.code = codeEnum.getCode();
        this.msg = codeEnum.getMsg();
    }
}
