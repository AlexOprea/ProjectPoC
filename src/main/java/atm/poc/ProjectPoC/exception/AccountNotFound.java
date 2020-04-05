package atm.poc.ProjectPoC.exception;

public class AccountNotFound extends Exception {
    public AccountNotFound(String accountName)
    {
        super(String.format("Account not found by name %s.",accountName));
    }
}
