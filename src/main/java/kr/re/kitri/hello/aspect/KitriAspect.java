package kr.re.kitri.hello.aspect;

import kr.re.kitri.hello.annotation.TokenRequired;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
//컴포넌트를 안해주면 메모리에 안올라간다.
public class KitriAspect {

    private static Logger logger = LoggerFactory.getLogger(KitriAspect.class);

    // 음.. 특정한 메소드에대해서 보안을 걸어야할 때;
    @Before("@annotation(tokenRequired)")
    public void test(TokenRequired tokenRequired) {
        logger.debug("토큰이 적용되어야 합니다........");
    }

    @Before("execution(* kr.re.kitri.hello.service.*Service.*(..))")
    public void logging(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println(methodName + "로그를 남김김니다. ");
    }

    @Around("execution(* kr.re.kitri.hello..dao.*Dao.*(..))")
    public Object measureAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = pjp.proceed(); // 해당 함수를 실행 시킨다.
        long endTime = System.currentTimeMillis();

        long estimatedTime = endTime - startTime;
        logger.debug(pjp.getSignature().getDeclaringTypeName() + "클래스의 " +
                pjp.getSignature().getName() + "메소드의 수행 시간은 " +
                estimatedTime + "밀리초 입니다");
        return obj;
    }
}
