package com.example.postmodservice.controller;

import java.util.Date;
import java.util.UUID;
public class Comment {
    private String id;
    private String postId;
    private String userId;
    private String content;
    private Date creationDate;
    private CommentContext commentContext;

    public Comment() {
        // Generate a unique identifier for this comment
        this.id = UUID.randomUUID().toString();
        this.creationDate = new Date();
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    private boolean isVisible;
    private boolean isFlagged;

    // ... Existing constructor ...

    // Getters and setters for state fields
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean isVisible) {
        this.isVisible = isVisible;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean isFlagged) {
        this.isFlagged = isFlagged;
    }

    // Setters based on CommentContext
    public void setStateFromContext(CommentContext context) {
        if (context.getCurrentState() instanceof CommentVisibleState) {
            isVisible = true;
            isFlagged = false;
        } else if (context.getCurrentState() instanceof CommentHiddenState) {
            isVisible = false;
        } else if (context.getCurrentState() instanceof CommentFlaggedState) {
            isFlagged = true;
        }
    }

    // Update CommentContext based on current state
    public void updateContext(CommentContext context) {
        if (isVisible) {
            context.setState((CommentState) context.getCommentVisibleState());
        } else if (isFlagged) {
            context.setState((CommentState) context.getCommentFlaggedState());
        } else {
            context.setState((CommentState) context.getCommentHiddenState());
        }
    }
    public void setCommentContext(CommentContext commentContext) {
        this.commentContext = commentContext;
    }

    // No setter for creationDate since it's set in the constructor
}