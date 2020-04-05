package atm.poc.ProjectPoC.dao;

import atm.poc.ProjectPoC.exception.AccountNotFound;
import atm.poc.ProjectPoC.exception.InvalidAccountName;
import atm.poc.ProjectPoC.model.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("StubAccount")
public class StubAccountDAO implements AccountDAO {

    private static final Logger log = LoggerFactory.getLogger(StubAccountDAO.class);
    private List<Account> accounts = new ArrayList<>();
    {
        accounts.add(new Account(1,"John Doe", 240.34d,4500d,374.39d));
        accounts.add(new Account(2,"Jane Doe", 244.34d,4750d,434.39d));
    }

    @Override
    public Account getAccount(String accountName) throws AccountNotFound {
        log.info("Searching for account name {}", accountName);
        Account acc = accounts.stream().filter(account->account.getName().equals(accountName)).findFirst().orElse(null);
        if (acc != null)
        {
            log.info("Account with name {} found.",accountName);
            return acc;
        }
        log.warn("No account found by name {}.",accountName);
        throw new AccountNotFound(accountName);
    }


    @Override
    public double withdrawFromAccount(Account account,String accountName, double amount) throws InvalidAccountName {
        double available = 0d;
        double amountLeft = 0d;
        switch (accountName) {
            case "deposit":
                available = account.getDepositAccount();
                if (available - amount < 0) {
                    log.warn("Not enough money to withdraw {}", amount);
                    return -1;
                }
                amountLeft = available - amount;
                account.setDepositAccount(amountLeft);
                return amountLeft;
            case "current":
                available = account.getCurrentAccount();
                if (available - amount < 0) {
                    log.warn("Not enough money to withdraw {}", amount);
                    return -1;
                }
                amountLeft = available - amount;
                account.setCurrentAccount(amountLeft);
                return amountLeft;
            case "credit":
                available = account.getCreditAccount();
                if (available - amount < 0) {
                    log.warn("Not enough money to withdraw {}", amount);
                    return -1;
                }
                amountLeft = available - amount;
                account.setCreditAccount(amountLeft);
                return amountLeft;
            default:
                log.warn("Invalid account name selected {}", accountName);
                throw new InvalidAccountName(accountName);
        }

    }

    @Override
    public double addFundsToAccount(Account account,String accountName, double amount) throws InvalidAccountName {
        double available = 0d;
        double amountLeft = 0d;

        switch (accountName) {
            case "deposit":
                available = account.getDepositAccount();
                amountLeft = available + amount;
                account.setDepositAccount(amountLeft);
                return amountLeft;
            case "current":
                available = account.getCurrentAccount();
                amountLeft = available + amount;
                account.setCurrentAccount(amountLeft);
                return amountLeft;
            case "credit":
                available = account.getCreditAccount();
                amountLeft = available + amount;
                account.setCreditAccount(amountLeft);
                return amountLeft;
            default:
                throw new InvalidAccountName(accountName);
        }


    }
}
