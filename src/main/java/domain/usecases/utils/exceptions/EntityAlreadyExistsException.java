package domain.usecases.utils.exceptions;

public class EntityAlreadyExistsException extends Exception{
    public EntityAlreadyExistsException(String message){
        super(message);
    }
}
