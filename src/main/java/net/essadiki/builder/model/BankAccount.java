package net.essadiki.builder.model;

public class BankAccount {

    private final Long id;
    private final String currency;
    private final double balance;
    private final AccountType type;
    private final AccountStatus status;

    private BankAccount(BankAccountBuilder builder) {
        this.id = builder.id;
        this.currency = builder.currency;
        this.balance = builder.balance;
        this.type = builder.type;
        this.status = builder.status;
    }

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public double getBalance() {
        return balance;
    }

    public AccountType getType() {
        return type;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public static BankAccountBuilder builder() {
        return new BankAccountBuilder();
    }

    public static class BankAccountBuilder {

        private Long id;
        private String currency = "MAD";
        private double balance = 0;
        private AccountType type = AccountType.CURRENT_ACCOUNT;
        private AccountStatus status = AccountStatus.CREATED;

        public BankAccountBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public BankAccountBuilder currency(String currency) {
            this.currency = currency;
            return this;
        }

        public BankAccountBuilder balance(double balance) {
            this.balance = balance;
            return this;
        }

        public BankAccountBuilder type(AccountType type) {
            this.type = type;
            return this;
        }

        public BankAccountBuilder status(AccountStatus status) {
            this.status = status;
            return this;
        }

        public BankAccount build() {

            if (id == null) {
                throw new IllegalStateException(
                        "L'identifiant est obligatoire"
                );
            }

            return new BankAccount(this);
        }
    }
}