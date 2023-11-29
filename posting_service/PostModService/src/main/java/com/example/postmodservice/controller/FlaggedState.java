package com.example.postmodservice.controller;

import org.springframework.stereotype.Component;

@Component
public
class FlaggedState implements PostState {
    @Override
    public void hide(PostContext context) {
        context.setState(context.getHiddenState());
    }

    @Override
    public void flag(PostContext context) {
        // Post is already flagged
    }

    @Override
    public void makeVisible(PostContext context) {
        context.setState(context.getVisibleState());
    }
}
