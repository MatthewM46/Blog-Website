package dto;

public class CommentResponseDto {
    private String commentId;

    public CommentResponseDto(String commentId) {
        this.commentId = commentId;
    }

    public String getCommentId() {
        return commentId;
    }
}
