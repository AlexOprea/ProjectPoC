package atm.poc.ProjectPoC.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO {
    private int id;
    private String name;
    private Double currentAccount;
    private Double creditAccount;
    private Double depositAccount;

    public AccountDTO(@JsonProperty("id") int id,
                      @JsonProperty("name") String name,
                      @JsonProperty("currentAccount") Double currentAccount,
                      @JsonProperty("creditAccount") Double creditAccount,
                      @JsonProperty("depositAccount") Double depositAccount)
    {
        this.id = id;
        this.name = name;
        this.currentAccount = currentAccount;
        this.creditAccount = creditAccount;
        this.depositAccount = depositAccount;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentAccount() {
        return currentAccount;
    }

    public Double getCreditAccount() {
        return creditAccount;
    }

    public Double getDepositAccount() {
        return depositAccount;
    }

    public int getId() {
        return id;
    }
}
