package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

        System.out.println("Creating Container");
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        System.out.println("Retrieving the Beans");

        Monitor myMonitor = container.getBean(Monitor.class);
        Case myCase = container.getBean(Case.class);
        Motherboard myMotherboard = container.getBean(Motherboard.class);

        PC myPc = new PC(myCase,myMonitor,myMotherboard);
        myPc.powerUp();

        System.out.println("Multiple Objects");
        Monitor theMonitor = container.getBean("acer", Monitor.class);//CUSTOM BEAN NAME
        Monitor theMonitor1 = container.getBean("monitorSony", Monitor.class); //DEFAULT BEAN NAME
        Monitor themonitor2 = container.getBean(Monitor.class);//@Primary



    }
}
