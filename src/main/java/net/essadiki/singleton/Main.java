package net.essadiki.singleton;

import net.essadiki.singleton.model.*;
import net.essadiki.singleton.repository.*;
import net.essadiki.singleton.util.JsonSerializer;

public class Main {

    public static void main(String[] args) {

        AccountRepository repository1 =
                AccountRepositoryImpl.getInstance();

        AccountRepository repository2 =
                AccountRepositoryImpl.getInstance();

        BankAccount account1 = new BankAccount(
                1L,
                "MAD",
                15000,
                AccountType.CURRENT_ACCOUNT,
                AccountStatus.ACTIVATED
        );

        BankAccount account2 = new BankAccount(
                2L,
                "MAD",
                25000,
                AccountType.SAVING_ACCOUNT,
                AccountStatus.CREATED
        );

        repository1.save(account1);
        repository2.save(account2);

        System.out.println("===== TEST SINGLETON =====");

        System.out.println("Repository 1 : " + repository1);
        System.out.println("Repository 2 : " + repository2);

        System.out.println("Meme instance : "
                + (repository1 == repository2));

        System.out.println("\n===== LISTE DES COMPTES =====");

        System.out.println(
                JsonSerializer.toJson(repository1.findAll())
        );

        System.out.println("\n===== RECHERCHE PAR ID =====");

        System.out.println(
                JsonSerializer.toJson(repository2.findById(1L))
        );
    }
}