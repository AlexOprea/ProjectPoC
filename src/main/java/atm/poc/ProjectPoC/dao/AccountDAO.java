package atm.poc.ProjectPoC.dao;

import atm.poc.ProjectPoC.exception.AccountNotFound;
import atm.poc.ProjectPoC.exception.InvalidAccountName;
import atm.poc.ProjectPoC.model.Account;

public interface AccountDAO {

    Account getAccount(String accountName) throws AccountNotFound;
    double withdrawFromAccount(Account account, String accountName, double amount) throws InvalidAccountName;
    double addFundsToAccount(Account account, String accountName, double amount) throws InvalidAccountName;
}
