package net.essadiki.singleton.repository;

import net.essadiki.singleton.model.BankAccount;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {

    private static final AccountRepositoryImpl instance =
            new AccountRepositoryImpl();

    private final Map<Long, BankAccount> accounts =
            new LinkedHashMap<>();

    private AccountRepositoryImpl() {
    }

    public static AccountRepositoryImpl getInstance() {
        return instance;
    }

    @Override
    public void save(BankAccount account) {
        accounts.put(account.getId(), account);
    }

    @Override
    public List<BankAccount> findAll() {
        return new ArrayList<>(accounts.values());
    }

    @Override
    public BankAccount findById(Long id) {
        return accounts.get(id);
    }
}