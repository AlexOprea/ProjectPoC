package atm.poc.ProjectPoC.converter;

import atm.poc.ProjectPoC.model.Account;
import atm.poc.ProjectPoC.model.AccountDTO;

public class AccountConverter {

    public static AccountDTO convertAccountToDTO(Account account)
    {
        return new AccountDTO(account.getId(),account.getName(), account.getCurrentAccount(), account.getCreditAccount(), account.getDepositAccount());
    }

    public static Account convertDTOToAccount(AccountDTO accountDTO)
    {
        return new Account(accountDTO.getId(), accountDTO.getName(), accountDTO.getCurrentAccount(), accountDTO.getCreditAccount(), accountDTO.getDepositAccount());
    }
}
