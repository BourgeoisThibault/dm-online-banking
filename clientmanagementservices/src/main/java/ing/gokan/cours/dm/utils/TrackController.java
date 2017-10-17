package ing.gokan.cours.dm.utils;

import ing.gokan.cours.dm.controllers.UserController;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author BOURGEOIS Thibault
 * Date     17/10/2017
 * Time     17:30
 */
@Aspect
@Component
public class TrackController {

    final static Logger logger = Logger.getLogger(TrackController.class);

    /**
     * Execute before method in controllers package
     * @param jp
     */
    @Before("execution(* ing.gokan.cours.dm.controllers.*.*(..)) ")
    public void BeforeExec(JoinPoint jp) {

        // Do not really understand this line
        HttpServletRequest theRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String className  = jp.getSignature().getDeclaringTypeName();
        String httpMethod = theRequest.getMethod();
        String specifRoad = theRequest.getRequestURI();
        String methodName = jp.getSignature().getName();
        String specifArgs = Arrays.toString(jp.getArgs());

        logger.info("[" + className + "] [" + httpMethod + "] [" + specifRoad + "] [" + methodName + "] " + specifArgs );
    }

}
