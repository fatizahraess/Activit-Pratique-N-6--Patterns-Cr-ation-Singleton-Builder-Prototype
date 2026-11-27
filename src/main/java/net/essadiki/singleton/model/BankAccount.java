package net.essadiki.singleton.model;

public class BankAccount {

    private Long id;
    private String currency;
    private double balance;
    private AccountType type;
    private AccountStatus status;

    public BankAccount() {
    }

    public BankAccount(Long id, String currency,
                       double balance, AccountType type,
                       AccountStatus status) {
        this.id = id;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }
}