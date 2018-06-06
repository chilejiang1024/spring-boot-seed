package work.zhili.springboot2template.core.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * Title : work.zhili.springboot2template.core.handler <br>
 * Description :
 *   This will catch exceptions before {@link GlobalExceptionHandler}
 *
 * @author chile
 * @version 1.0
 * @date 2018/6/5 17:26
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private Logger logger;

    public ControllerExceptionHandler() {
        logger = LoggerFactory.getLogger(getClass());
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(Exception.class)
    @ResponseBody Object commonExceptionHandler(Exception e) {
        logger.error("Controller exception handler : ", e);
        Map<String, Object> response = new HashMap<>(2);
        response.put("code", -1);
        response.put("msg", "System is not available, please try it later.");
        response.put("result", new HashMap<>(0));
        return response;
    }

}
