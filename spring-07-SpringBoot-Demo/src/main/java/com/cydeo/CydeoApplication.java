package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CydeoApplication {

    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Stanislav");
        comment.setText("Hello World");

        ApplicationContext container = SpringApplication.run(CydeoApplication.class, args);
       // SpringApplication.run(CydeoApplication.class,args);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);

        commentService.printConfigData();

        commentService.printDBConfig();
    }

}
