package com.example.postmodservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public
class PostContext {
    private PostState currentState;
    private final VisibleState visibleState;
    private final HiddenState hiddenState;
    private final FlaggedState flaggedState;
    private String postId;
    private boolean isVisible;
    private boolean isFlagged;

    @Autowired
    public PostContext(VisibleState visible, HiddenState hidden, FlaggedState flagged) {
        this.visibleState = visible;
        this.hiddenState = hidden;
        this.flaggedState = flagged;
        this.currentState = visibleState; // default state
        this.isVisible = true; // Assuming default visibility is true
        this.isFlagged = false; // Assuming default flagged status is false
    }

    public void hide() {
        currentState.hide(this);
        this.isVisible = false;
    }

    public void flag() {
        currentState.flag(this);
        this.isFlagged = true;
    }

    public void makeVisible() {
        currentState.makeVisible(this);
        this.isVisible = true;
    }

    // Getters and Setters
    public boolean isVisible() {
        return isVisible;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void setState(PostState state) {
        this.currentState = state;
    }

    public PostState getCurrentState() {
        return currentState;
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
