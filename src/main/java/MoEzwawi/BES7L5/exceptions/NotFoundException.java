package MoEzwawi.BES7L5.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(long id) {
        super("Element id "+id+"not found");
    }
}
