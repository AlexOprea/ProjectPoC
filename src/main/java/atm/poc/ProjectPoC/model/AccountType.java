package atm.poc.ProjectPoC.model;

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
}
