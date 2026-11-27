package net.essadiki.prototype.model;

public class BankAccount implements Cloneable {

    private Long id;
    private String currency;
    private double balance;
    private AccountType type;
    private AccountStatus status;
    private Customer customer;

    public BankAccount(Long id, String currency,
                       double balance, AccountType type,
                       AccountStatus status, Customer customer) {

        this.id = id;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
        this.status = status;
        this.customer = customer;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Shallow Copy
    @Override
    public BankAccount clone() {
        try {
            return (BankAccount) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    // Deep Copy
    public BankAccount deepClone() {

        BankAccount clonedAccount = this.clone();

        if (this.customer != null) {
            clonedAccount.customer = this.customer.clone();
        }

        return clonedAccount;
    }
}