package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class CommentService {

    private final CommentRepository commentRepository;
    private final CommentNotificationProxy commentNotificationProxy;
    private final AppConfigData data;
    private final DBConfigData dbData;

    public CommentService(CommentRepository commentRepository, @Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy, AppConfigData data, DBConfigData dbData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.data = data;
        this.dbData = dbData;
    }

    public void publishComment(Comment comment){
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }

    public void printConfigData(){

        System.out.println(data.getUserName());
        System.out.println(data.getUrl());
        System.out.println(data.getPassword());
    }

    public void printDBConfig(){
        System.out.println(dbData.getUsername());
        System.out.println(dbData.getPassword());
        System.out.println(dbData.getType());
    }


}
