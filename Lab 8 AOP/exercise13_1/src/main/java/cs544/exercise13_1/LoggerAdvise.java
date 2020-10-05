package cs544.exercise13_1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;


//import java.time.Instant;
import java.util.Date;

@Aspect
public class LoggerAdvise {

    @After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email, message)")
    public void getNameAdvice(JoinPoint joinPoint, String email, String message) {
        System.out.printf("%s method = %s \n", new Date(), joinPoint.getSignature().getName());
        System.out.println("----------\n");
        System.out.println((new Date()) + " method=" + joinPoint.getSignature().getName() + " address=" + email);
        System.out.println("message=" + message);
        System.out.println("outgoing mail server = " + ((EmailSender) (joinPoint.getTarget())).outgoingMailServer);
    }

    @Around("execution(void cs544.exercise13_1.CustomerDAO.save(..)) ")
    public Object invoke(ProceedingJoinPoint call) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(call.getSignature().getName());
        Object retVal = call.proceed();
        sw.stop();
        long totaltime = sw.getLastTaskTimeMillis();
        // print the time to the console
        System.out.println("Time to execute save = " + totaltime + " ms");
        return retVal;
    }

}
