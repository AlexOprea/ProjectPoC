package atm.poc.ProjectPoC.exception;

public class InvalidAmount extends Exception{
    public InvalidAmount()
    {
        super("Invalid amount requested. You can not withdraw/deposit negative amount.");
    }
}
