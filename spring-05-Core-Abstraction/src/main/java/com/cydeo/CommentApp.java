package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment = new Comment();
        comment.setAuthor("Stanislav");
        comment.setText("Hello World");

        ApplicationContext container = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService commentService = container.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}
