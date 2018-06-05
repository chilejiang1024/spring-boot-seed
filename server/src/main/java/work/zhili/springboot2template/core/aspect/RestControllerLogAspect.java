package work.zhili.springboot2template.core.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import work.zhili.springboot2template.core.handler.GlobalExceptionHandler;
import work.zhili.springboot2template.model.User;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Title : work.zhili.springboot2template.core.aspect <br>
 * Description :
 *   log the controller request
 *
 * @author chile
 * @version 1.0
 * @date 2018/5/24 17:24
 */
@Aspect
@Component
public class RestControllerLogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 环绕通知
     * @param joinPoint 连接点
     * @return 切入点返回值
     * @throws Throwable 异常信息
     */
    @Around("@within(org.springframework.web.bind.annotation.RestController) || @annotation(org.springframework.web.bind.annotation.RestController)")
    public Object apiLog(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        boolean logFlag = this.needToLog(method);
        if (!logFlag) {
            return joinPoint.proceed();
        }

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        User loginUser = new User();

        String ip = request.getHeader("X-Forwarded-For");
        String methodName = this.getMethodName(joinPoint);
        String params = this.getParamsJson(joinPoint);
        String requester = loginUser == null ? "unknown" : String.valueOf(loginUser.getId());
        String callSource = "";
        String appVersion = "";
        String apiVersion = "";
        String userAgent = request.getHeader("user-agent");

        logger.info("Request start, requester [{}], method [{}], params [{}], IP [{}], callSource [{}], appVersion [{}], apiVersion [{}], userAgent [{}]",
                    requester, methodName, params, ip, callSource, appVersion, apiVersion, userAgent);
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        logger.info("Request end, requester [{}], method [{}], params[{}], response is [{}], cost [{}] millis ",
                    requester, methodName, params, result, System.currentTimeMillis() - start);
        return result;
    }

    private String getMethodName(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        String SHORT_METHOD_NAME_SUFFIX = "(..)";
        if (methodName.endsWith(SHORT_METHOD_NAME_SUFFIX)) {
            methodName = methodName.substring(0, methodName.length() - SHORT_METHOD_NAME_SUFFIX.length());
        }
        return methodName;
    }

    private String getParamsJson(ProceedingJoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return Arrays.toString(args);
    }

    /**
     * 判断是否需要记录日志
     */
    private boolean needToLog(Method method) {
        return method.getAnnotation(GetMapping.class) == null
                && !method.getDeclaringClass().equals(GlobalExceptionHandler.class);
    }
}
