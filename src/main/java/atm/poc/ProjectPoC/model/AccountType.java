package atm.poc.ProjectPoC.model;

import java.util.Arrays;

public enum AccountType {
    CREDIT("credit"),
    DEPOSIT("deposit"),
    CURRENT("current");
    private String type;

    private AccountType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }

    public static AccountType getAccountType(String accountType)
    {
        return Arrays.stream(AccountType.values()).filter(val->val.getType().equals(accountType)).findFirst().orElse(null);
    }
}
