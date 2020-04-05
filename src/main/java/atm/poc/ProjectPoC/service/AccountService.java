package atm.poc.ProjectPoC.service;

import atm.poc.ProjectPoC.converter.AccountConverter;
import atm.poc.ProjectPoC.dao.AccountDAO;
import atm.poc.ProjectPoC.exception.AccountNotFound;
import atm.poc.ProjectPoC.exception.InvalidAccountName;
import atm.poc.ProjectPoC.model.Account;
import atm.poc.ProjectPoC.model.AccountDTO;
import atm.poc.ProjectPoC.model.AccountType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private static final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    @Qualifier("StubAccount")
    private AccountDAO accountDAO;

    public AccountDTO displayAccountInfo(String accountName) throws AccountNotFound {
        Account account = accountDAO.getAccount(accountName);
        log.info("Hello {}.",account.toString());
        return AccountConverter.convertAccountToDTO(account);
    }

    public void withdrawFunds(String accountName, AccountType accountType, double amount) throws AccountNotFound, InvalidAccountName {
        Account account = accountDAO.getAccount(accountName);
        double leftValue = accountDAO.withdrawFromAccount(account, accountType.getType(),amount);
        log.info("Hello {}, funds left on {}: {}",accountName, accountType.getType(), leftValue);
    }

    public void addFunds(String accountName, AccountType accountType, double amount) throws AccountNotFound, InvalidAccountName {
        Account account = accountDAO.getAccount(accountName);
        double leftValue = accountDAO.addFundsToAccount(account, accountType.getType(),amount);
        log.info("Hello {}, funds added to {}. New balance: {}",accountName, accountType.getType(), leftValue);
    }
}
