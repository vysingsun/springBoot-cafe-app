package vysing.sun.cafeapp.exception;

public class DrinkNotFoundException extends RuntimeException{
    public DrinkNotFoundException(String message){
        super(message);
    }
}
