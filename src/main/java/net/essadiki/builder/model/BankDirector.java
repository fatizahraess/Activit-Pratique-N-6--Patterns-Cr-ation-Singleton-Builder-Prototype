package net.essadiki.builder.model;

public class BankDirector {

    public BankAccount createCurrentAccount(Long id) {

        return BankAccount.builder()
                .id(id)
                .currency("MAD")
                .balance(5000)
                .type(AccountType.CURRENT_ACCOUNT)
                .status(AccountStatus.ACTIVATED)
                .build();
    }

    public BankAccount createSavingAccount(Long id) {

        return BankAccount.builder()
                .id(id)
                .currency("MAD")
                .balance(10000)
                .type(AccountType.SAVING_ACCOUNT)
                .status(AccountStatus.CREATED)
                .build();
    }
}