package dto;


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

