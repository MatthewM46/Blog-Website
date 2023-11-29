package dto;

public class PostResponseDto {
    private String postId;

    public PostResponseDto(String postId) {
        this.postId = postId;
    }

    public String getPostId() {
        return postId;
    }
}
