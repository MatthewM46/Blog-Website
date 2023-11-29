package dto;

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
