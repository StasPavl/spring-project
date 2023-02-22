package com.cydeo.stereotype_annotation;

import com.cydeo.stereotype_annotation.config.PcConfig;
import com.cydeo.stereotype_annotation.monitorfactory.Monitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(PcConfig.class);

        Monitor theMonitor = container.getBean(Monitor.class);
        Monitor theMonitor1 = container.getBean("acerMonitor", Monitor.class);

        System.out.println(theMonitor.getSize());
        System.out.println(theMonitor1.getSize());
    }
}
