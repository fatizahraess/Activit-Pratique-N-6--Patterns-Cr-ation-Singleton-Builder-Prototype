package net.essadiki.builder.repository;

import net.essadiki.builder.model.BankAccount;

import java.util.List;

public interface AccountRepository {

    void save(BankAccount account);

    List<BankAccount> findAll();

    BankAccount findById(Long id);
}