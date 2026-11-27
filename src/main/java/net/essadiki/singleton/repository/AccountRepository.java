package net.essadiki.singleton.repository;

import net.essadiki.singleton.model.BankAccount;

import java.util.List;

public interface AccountRepository {

    void save(BankAccount account);

    List<BankAccount> findAll();

    BankAccount findById(Long id);
}