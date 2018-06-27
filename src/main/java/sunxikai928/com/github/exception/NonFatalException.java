package sunxikai928.com.github.exception;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * 非致命异常
 */
public class NonFatalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private String code;

    /**
     * 异常现场参数等信息
     */
    private Object data;

    public NonFatalException(String code, Object data, Throwable cause) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public NonFatalException(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public NonFatalException(Throwable cause) {
        super(cause);
    }

    public String getCode() {
        return code;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String getMessage() {
        StringBuilder sb = new StringBuilder();
        String smsg = super.getMessage();
        if (StringUtils.isNotEmpty(getCode())) {
            sb.append("ERROR_CODE:").append(getCode()).append(";").append("ERROR_DATA:")
                    .append(JSONObject.toJSONString(getData()));
        }
        if (StringUtils.isNotEmpty(smsg)) {
            if (StringUtils.isNotEmpty(getCode())) {
                sb.append(";\r\n");
            }
            sb.append("ERROR_MESSAGE:").append(smsg);
        }
        return sb.toString();
    }
}
