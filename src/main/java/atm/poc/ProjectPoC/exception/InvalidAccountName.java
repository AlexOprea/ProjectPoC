package atm.poc.ProjectPoC.exception;

public class InvalidAccountName extends Exception {
    public InvalidAccountName(String accountName)
    {
        super(String.format("Invalid account name %s",accountName));
    }
}
