package atm.poc.ProjectPoC.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FundsDTO {
    @JsonFormat
    private String accountName;
    @JsonFormat
    private double funds;
    @JsonFormat
    private String accountType;

    public FundsDTO()
    {

    }

    public FundsDTO(@JsonProperty String accountName,
                    @JsonProperty String accountType,
                    @JsonProperty double funds)
    {
        this.accountName = accountName;
        this.accountType = accountType;
        this.funds = funds;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getFunds() {
        return funds;
    }

    public String getAccountType() {
        return accountType;
    }
}
