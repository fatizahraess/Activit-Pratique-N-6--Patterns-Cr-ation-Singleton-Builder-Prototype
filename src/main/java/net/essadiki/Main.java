package net.essadiki;
import net.essadiki.builder.model.*;
import net.essadiki.builder.repository.*;
import net.essadiki.builder.util.JsonSerializer;

public class Main {

    public static void main(String[] args) {

        AccountRepository repository =
                new AccountRepositoryImpl();

        System.out.println("===== TEST BUILDER =====");

        // Construction personnalisee avec Builder
        BankAccount account1 = BankAccount.builder()
                .id(1L)
                .currency("EUR")
                .balance(15000)
                .type(AccountType.CURRENT_ACCOUNT)
                .status(AccountStatus.ACTIVATED)
                .build();

        System.out.println("\nCompte personnalise :");
        System.out.println(JsonSerializer.toJson(account1));

        // Construction avec des valeurs par defaut
        BankAccount account2 = BankAccount.builder()
                .id(2L)
                .build();

        System.out.println("\nCompte par defaut :");
        System.out.println(JsonSerializer.toJson(account2));

        // Construction avec Director
        BankDirector director = new BankDirector();

        BankAccount account3 =
                director.createCurrentAccount(3L);

        BankAccount account4 =
                director.createSavingAccount(4L);

        System.out.println("\n===== TEST DIRECTOR =====");

        System.out.println("\nCompte courant :");
        System.out.println(JsonSerializer.toJson(account3));

        System.out.println("\nCompte epargne :");
        System.out.println(JsonSerializer.toJson(account4));

        // Enregistrement des comptes
        repository.save(account1);
        repository.save(account2);
        repository.save(account3);
        repository.save(account4);

        System.out.println("\n===== LISTE DES COMPTES =====");

        System.out.println(
                JsonSerializer.toJson(repository.findAll())
        );

        // Test de validation
        System.out.println("\n===== TEST VALIDATION =====");

        try {
            BankAccount.builder().build();
        } catch (IllegalStateException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}