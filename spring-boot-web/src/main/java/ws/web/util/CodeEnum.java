package ws.web.util;

/**
 * @description: 响应状态码
 * @author: ws
 * @create: 2020-06-28 15:54
 **/
public enum CodeEnum {
    SUCCESS(0, "成功"),
    FAIL(1, "失败"),
    ;

    private final Integer code;

    private final String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    CodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
