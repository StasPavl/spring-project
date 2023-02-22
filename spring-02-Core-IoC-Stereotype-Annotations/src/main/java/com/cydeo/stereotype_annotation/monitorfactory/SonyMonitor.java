package com.cydeo.stereotype_annotation.monitorfactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonyMonitor extends Monitor{

    public SonyMonitor() {
        super("25 inch beast", "Sony", 26);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");
    }
}
