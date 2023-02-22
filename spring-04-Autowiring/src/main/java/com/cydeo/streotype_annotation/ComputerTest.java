package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.config.PcConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        ApplicationContext container = new AnnotationConfigApplicationContext(PcConfig.class);

        PC thePc = container.getBean(PC.class);

        System.out.println(thePc.getTheCase().getDimensions().getDepth());
        System.out.println(thePc);
    }
}
