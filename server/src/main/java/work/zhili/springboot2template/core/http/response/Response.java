package work.zhili.springboot2template.core.http.response;

/**
 * Title : work.zhili.springboot2template.core.status <br>
 * Description : <br>
 *   <p> return message when the api request successfully
 *
 * @author chile
 * @version 1.0
 * @date 2018/5/22 13:13
 */
public class Response<E> {

    /**
     * default successful message
     */
    public static final Response SUCCESSFUL_MESSAGE;

    static {
        SUCCESSFUL_MESSAGE = successfulMessage();
    }

    private static Response successfulMessage() {
        return new Response(ResultCode.SUCCESS, "Operation successful.");
    }

    private Integer code;

    private String msg;

    private String detail;

    private E data;

    public Response(ResultCode code) {
        this.code = code.code();
        this.msg  = code.message();
    }

    public Response(E data) {
        this.code = ResultCode.SUCCESS.code();
        this.msg  = ResultCode.SUCCESS.message();
        this.data = data;
    }

    public Response(ResultCode code, String detail) {
        this.code = code.code();
        this.msg  = code.message();
        this.detail = detail;
    }

    public Response(ResultCode code, E data) {
        this.code = code.code();
        this.msg  = code.message();
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
