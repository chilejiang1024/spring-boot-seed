package work.zhili.springboot2template.core.handler;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Title : work.zhili.springboot2template.core.handler <br>
 * Description :
 *  <p>
 *  <ul> 
 *      <li>
 *  </ul>
 * @author chile
 * @version 1.0
 * @date 2018/3/21 18:19
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {

    /**
     * the logger, get from slf4j
     */
    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {

        logger.error("ExceptionHandler caught exception : ", e);

        // ajax requests always contain this header
        String requestType = httpServletRequest.getHeader("X-Requested-With");

        if (!StringUtils.isEmpty(requestType)) {
            // request comes from ajax, return a json
            Map<String, Object> responseMap = new HashMap<>(2);
            responseMap.put("code", -1);
            responseMap.put("msg", "System is not available, please try it later.");
            responseMap.put("result", new HashMap<>(0));
            String json = JSONObject.toJSONString(responseMap);
            // aimed to split the default error text
            json += "\n";

            httpServletResponse.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");
            try {
                httpServletResponse.getOutputStream().write(json.getBytes());
                httpServletResponse.getOutputStream().flush();
                return null;
            } catch (IOException ee) {
                logger.error("Writing json object to response writer: ", ee);
            }
        }

        // if request is not comes from ajax, redirect to 500.html or index.html
        return new ModelAndView("redirect:/500");
    }
}
