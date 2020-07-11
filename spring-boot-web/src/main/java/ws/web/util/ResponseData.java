package ws.web.util;

import lombok.Data;

/**
 * @description: 响应数据
 * @author: ws
 * @create: 2020-06-28 15:58
 **/
@Data
public class ResponseData<T> extends ResponseBase {

    private T data;

    public ResponseData(CodeEnum codeEnum) {
        super(codeEnum);
    }

    public ResponseData(CodeEnum codeEnum, T data) {
        super(codeEnum);
        this.data = data;
    }

    /**
     * 对外开放基础响应体供调用，用于增删改
     */
    public static ResponseBase out(CodeEnum codeEnum) {
        return new ResponseData<>(codeEnum);
    }

    /**
     * 用于查询
     */
    public static <T> ResponseBase out(CodeEnum codeEnum, T data) {
        return new ResponseData<>(codeEnum, data);
    }
}
