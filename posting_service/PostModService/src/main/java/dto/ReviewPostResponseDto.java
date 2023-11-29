package dto;

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
