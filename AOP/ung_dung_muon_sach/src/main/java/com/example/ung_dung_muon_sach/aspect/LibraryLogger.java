package com.example.ung_dung_muon_sach.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LibraryLogger {
    private int visitCount = 0;

    @Before("execution(* com.example.ung_dung_muon_sach.controller.*.*(..))")
    public void logVisit(JoinPoint jp) {
        visitCount++;
        System.out.println("[VISIT] " + jp.getSignature().toShortString() + " | Total visits: " + visitCount);
    }

    @AfterReturning("execution(* com.example.ung_dung_muon_sach.service.BookService.borrowBook(..)) || execution(* com.example.ung_dung_muon_sach.service.BookService.returnBook(..))")
    public void logBookChange(JoinPoint jp) {
        System.out.println("[BOOK CHANGE] " + jp.getSignature().getName() + " executed");
    }

    @AfterThrowing(pointcut = "execution(* com.example.ung_dung_muon_sach.service.BookService.*(..))", throwing = "ex")
    public void logException(JoinPoint jp, Throwable ex) {
        System.err.println("[ERROR] " + jp.getSignature().getName() + " threw: " + ex.getMessage());
    }
}
