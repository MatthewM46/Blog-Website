package com.example.postmodservice.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentContext {
    private CommentState currentState;
    private final VisibleState commentVisibleState;
    private final HiddenState commentHiddenState;
    private final FlaggedState commentFlaggedState;
    private String commentId;


    @Autowired
    public CommentContext(
            VisibleState commentVisibleState,
            HiddenState commentHiddenState,
            FlaggedState commentFlaggedState
    ) {
        this.commentVisibleState = commentVisibleState;
        this.commentHiddenState = commentHiddenState;
        this.commentFlaggedState = commentFlaggedState;
        this.currentState = (CommentState) commentVisibleState; // default state
    }

    public void setState(CommentState state) {
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

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public VisibleState getCommentVisibleState() {
        return commentVisibleState;
    }

    public HiddenState getCommentHiddenState() {
        return commentHiddenState;
    }

    public FlaggedState getCommentFlaggedState() {
        return commentFlaggedState;
    }

    public CommentState getCurrentState() {
        return currentState;
    }


}