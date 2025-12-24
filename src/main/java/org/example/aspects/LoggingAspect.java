package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

    @Before("execution(* org.example.auth.AuthService.authenticate(..))")
    public void logBeforeAuth(JoinPoint joinPoint) {
        System.out.println("[LOG] Попытка авторизации: " + joinPoint.getSignature());
    }

    @AfterReturning(pointcut = "execution(* org.example.auth.AuthService.authenticate(..))", returning = "result")
    public void logAfterAuth(Object result) {
        System.out.println("[LOG] Результат авторизации: " + result);
    }

    @Before("execution(* org.example.menu.*MenuStrategy.showMenu(..))")
    public void logMenuOpen(JoinPoint joinPoint) {
        System.out.println("[LOG] Открыто меню: " + joinPoint.getTarget().getClass().getSimpleName());
    }

    @Before("execution(* org.example.services.EquipmentConfigService.changeConfig(..)) && args(newConfig)")
    public void logChangeConfig(String newConfig) {
        System.out.println("[LOG] Запрос на изменение конфигурации. Новое значение: " + newConfig);
    }

    @Before("execution(* org.example.auth.AuthService.addUser(..))")
    public void logAddUser() {
        System.out.println("[LOG] Добавление нового пользователя");
    }
}


