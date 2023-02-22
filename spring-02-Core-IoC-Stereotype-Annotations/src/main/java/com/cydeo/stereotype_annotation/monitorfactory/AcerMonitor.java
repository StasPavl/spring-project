package com.cydeo.stereotype_annotation.monitorfactory;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component

public class AcerMonitor extends Monitor {

    public AcerMonitor() {
        super("25 inch beast", "Acer", 25);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Acer");
    }


}
