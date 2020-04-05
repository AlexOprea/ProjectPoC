package atm.poc.ProjectPoC.model;

public class Account {

    private int id;
    private String name;
    private Double currentAccount;
    private Double creditAccount;
    private Double depositAccount;

    @Override
    public String toString() {
        return String.format("%s. Your balance is: current account %f, credit account %f, deposit account %d",name,currentAccount,creditAccount,depositAccount);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account(int id, String name, Double currentAccount, Double creditAccount, Double depositAccount)
    {
        this.id=id;
        this.name=name;
        this.currentAccount = currentAccount;
        this.creditAccount = creditAccount;
        this.depositAccount = depositAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(Double currentAccount) {
        this.currentAccount = currentAccount;
    }

    public Double getCreditAccount() {
        return creditAccount;
    }

    public void setCreditAccount(Double creditAccount) {
        this.creditAccount = creditAccount;
    }

    public Double getDepositAccount() {
        return depositAccount;
    }

    public void setDepositAccount(Double depositAccount) {
        this.depositAccount = depositAccount;
    }
}
