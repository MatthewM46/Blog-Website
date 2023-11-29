
package com.example.postmodservice.controller;

import java.util.Date;
import java.util.UUID;
import com.example.postmodservice.controller.PostContext;


public class Post {
    private String id;
    private String userId;
    private String content;
    private Date creationDate;
    private PostContext postContext; // Add PostContext

    public Post() {
        // Generate a unique identifier for this post
        this.id = UUID.randomUUID().toString();
        this.creationDate = new Date();
        this.postContext = new PostContext(new VisibleState(), new HiddenState(), new FlaggedState()); // Initialize PostContext
    }

    private boolean isVisible;
    private boolean isFlagged;

    // Delegate methods to PostContext
    public void hide() {
        postContext.hide();
    }

    public void flag() {
        postContext.flag();
    }

    public void makeVisible() {
        postContext.makeVisible();
    }

    // Getters for PostContext states
    public boolean isVisible() {
        return postContext.isVisible();
    }

    public boolean isFlagged() {
        return postContext.isFlagged();
    }

    // Getters and setters for other fields
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    // Method to set PostContext
    public void setPostContext(PostContext context) {
        this.postContext = context;
    }

    // Getter for PostContext
    public PostContext getPostContext() {
        return postContext;
    }

    public VisibleState getVisibleState() {
        return (VisibleState) postContext.getVisibleState();
    }

    public HiddenState getHiddenState() {
        return (HiddenState) postContext.getHiddenState();
    }

    public FlaggedState getFlaggedState() {
        return (FlaggedState) postContext.getFlaggedState();

    }


    public void setFlagged(boolean b) {
        postContext.flag();
    }

    public void setVisible(boolean b) {
        postContext.makeVisible();
    }
}

    // No setter for creationDate since it's set in the constructor
