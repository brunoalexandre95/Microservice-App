package application.aspects;

import application.annotation.SaveRequestInDatabase;
import application.domain.RequestHistory;
import application.enumerate.RequestTypeEnum;
import application.repository.RequestHistoryRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Date;

@Aspect
@Component
public class ExampleAspect {

    @Autowired
    private RequestHistoryRepository requestHistoryRepository;

    @Around("@annotation(application.annotation.SaveRequestInDatabase)")
    public Object saveRequestInDatabase(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature2 = (MethodSignature) joinPoint.getSignature();
        Method method = signature2.getMethod();
        SaveRequestInDatabase myAnnotation = method.getAnnotation(SaveRequestInDatabase.class);
        RequestTypeEnum requestType  = myAnnotation.requestType();

        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;

        RequestHistory requestHistory = new RequestHistory();
        requestHistory.setRequestDate(new Date());
        requestHistory.setRequestTime(executionTime);
        requestHistory.setRequestType(requestType);
        requestHistoryRepository.save(requestHistory);

        return proceed;
    }
}
