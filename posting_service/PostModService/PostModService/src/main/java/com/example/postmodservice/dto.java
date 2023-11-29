package com.example.postmodservice;



public class PostRequestDto {
    private String postId;
    private String content;
    private String userId;
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
}

public class PostResponseDto {
    private String postId;

    public PostResponseDto(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }
}

public class CommentRequestDto {

    private String postId;


    private String userId;


    private String content;

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
}

public class CommentResponseDto {
    private String commentId;

    public CommentResponseDto(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentId() {
        return commentId;
    }
}

public class ReviewPostResponseDto {
    private String postId;
    private String content;

    public ReviewPostResponseDto(String postId, String content) {
        this.postId = postId;
        this.content = content;
    }

    public String getPostId() {
        return postId;
    }

    public String getContent() {
        return content;
    }
}

public class ReviewRequestDto {
    
    private String decision;


    private String moderatorId;

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getModeratorId() {
        return moderatorId;
    }

    public void setModeratorId(String moderatorId) {
        this.moderatorId = moderatorId;
    }
}

public class ReviewResponseDto {
    private boolean success;
    private String message;

    public ReviewResponseDto(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}

public class IncrementResponseDto {
    private boolean success;
    private int count;

    public IncrementResponseDto(boolean success, int count) {
        this.success = success;
        this.count = count;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getCount() {
        return count;
    }
}
