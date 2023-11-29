package com.example.postmodservice.controller;

import org.springframework.stereotype.Component;

// Concrete states
@Component
public
class VisibleState implements PostState {
    @Override
    public void hide(PostContext context) {
        context.setState(context.getHiddenState());
    }

    @Override
    public void flag(PostContext context) {
        context.setState(context.getFlaggedState());
    }

    @Override
    public void makeVisible(PostContext context) {
        // Post is already visible
    }
}
