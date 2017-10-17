package ing.gokan.cours.dm.utils;

import ing.gokan.cours.dm.repositories.IUserDtoService;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author BOURGEOIS Thibault
 * Date     17/10/2017
 * Time     17:30
 */
@Aspect
@Component
public class TrackController {

    @Autowired
    private IUserDtoService userDtoService;

    final static Logger logger = Logger.getLogger(TrackController.class);

    /**
     * This is this method who send respons
     *
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* ing.gokan.cours.dm.controllers.*.*(..)) ")
    public Object logControllers(ProceedingJoinPoint joinPoint) throws Throwable {

        // Calc time method execution
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object returnObj = joinPoint.proceed();
        stopWatch.stop();

        // Do not really understand this line
        HttpServletRequest theRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String timeMethod = "[" + stopWatch.getTotalTimeMillis() + "ms] ";
        String className  = "[" + joinPoint.getSignature().getDeclaringTypeName() + "] ";
        String httpMethod = "[" + theRequest.getMethod() + "] ";
        String specifRoad = "[" + theRequest.getRequestURI() + "] ";
        String methodName = "[" + joinPoint.getSignature().getName() + "] ";
        String specifArgs = Arrays.toString(joinPoint.getArgs());

        logger.info(timeMethod+className+httpMethod+specifRoad+methodName+specifArgs);

        return returnObj;
    }

}
