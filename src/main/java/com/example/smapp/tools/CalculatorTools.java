package com.example.smapp.tools;


import dev.langchain4j.agent.tool.Tool;
import org.springframework.stereotype.Component;

@Component
public class CalculatorTools {

    @Tool
    double sum(double a,double b){
        System.out.println("调用加法运算");
        return a+b;
    }
    @Tool
    double square(double x){
        System.out.println("调用平方根运算");
        return Math.sqrt(x);
    }
}
