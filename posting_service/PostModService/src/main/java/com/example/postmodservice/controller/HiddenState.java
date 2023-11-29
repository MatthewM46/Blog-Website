package com.example.postmodservice.controller;

import org.springframework.stereotype.Component;

@Component
public
class HiddenState implements PostState {
    @Override
    public void hide(PostContext context) {
        // Post is already hidden
    }

    @Override
    public void flag(PostContext context) {
        context.setState(context.getFlaggedState());
    }

    @Override
    public void makeVisible(PostContext context) {
        context.setState(context.getVisibleState());
    }
}
