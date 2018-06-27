package sunxikai928.com.github.exception;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

/**
 * 致命的异常
 */
public class FatalException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * 响应码
     */
    private String code;

    /**
     * 异常现场参数等信息
     */
    private Object data;

    public FatalException(String code, Object data, Throwable cause) {
        super(cause);
        this.code = code;
        this.data = data;
    }

    public FatalException(String code, Object data) {
        this.code = code;
        this.data = data;
    }

    public FatalException(Throwable cause) {
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
