package com.example.postmodservice.controller;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// State interface
public interface PostState {
    void hide(PostContext context);
    void flag(PostContext context);
    void makeVisible(PostContext context);
}

