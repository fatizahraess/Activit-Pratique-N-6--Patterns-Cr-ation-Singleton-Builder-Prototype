package net.essadiki.builder.repository;

import net.essadiki.builder.model.BankAccount;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AccountRepositoryImpl implements AccountRepository {

    private final Map<Long, BankAccount> accounts =
            new LinkedHashMap<>();

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