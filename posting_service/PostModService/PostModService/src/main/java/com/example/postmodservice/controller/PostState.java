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

// Concrete states
@Component
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

@Component
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

@Component
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

@Component
 class PostContext {
    private PostState currentState;
    private final VisibleState visibleState;
    private final HiddenState hiddenState;
    private final FlaggedState flaggedState;
    private String postId;

    @Autowired
    public PostContext(VisibleState visible, HiddenState hidden, FlaggedState flagged) {
        this.visibleState = visible;
        this.hiddenState = hidden;
        this.flaggedState = flagged;
        this.currentState = visibleState; // default state
    }

    public void setState(PostState state) {
        this.currentState = state;
    }

    public void hide() {
        currentState.hide(this);
    }

    public void flag() {
        currentState.flag(this);
    }

    public void makeVisible() {
        currentState.makeVisible(this);
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public PostState getVisibleState() {
        return visibleState;
    }

    public PostState getHiddenState() {
        return hiddenState;
    }

    public PostState getFlaggedState() {
        return flaggedState;
    }
}
