package dto;

public class CommentCreateRequest {
    private String postId;
    private String userId;
    private String content;

    public CommentCreateRequest(String postId, String userId, String content) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
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
}