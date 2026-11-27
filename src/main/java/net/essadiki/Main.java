package net.essadiki;

import net.essadiki.prototype.model.*;
import net.essadiki.prototype.util.JsonSerializer;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                "Ahmed",
                "ahmed@gmail.com"
        );

        BankAccount original = new BankAccount(
                1L,
                "MAD",
                15000,
                AccountType.CURRENT_ACCOUNT,
                AccountStatus.ACTIVATED,
                customer
        );

        System.out.println("===== COMPTE ORIGINAL =====");

        System.out.println(JsonSerializer.toJson(original));

        // Clonage superficiel

        System.out.println("\n===== SHALLOW COPY =====");

        BankAccount shallowCopy = original.clone();

        shallowCopy.setId(2L);
        shallowCopy.setBalance(25000);

        System.out.println("\nCompte clone :");

        System.out.println(
                JsonSerializer.toJson(shallowCopy)
        );

        System.out.println("\nMeme compte : "
                + (original == shallowCopy));

        System.out.println("Meme client : "
                + (original.getCustomer()
                == shallowCopy.getCustomer()));

        shallowCopy.getCustomer().setName("Youssef");

        System.out.println("\nClient original : "
                + original.getCustomer().getName());

        System.out.println("Client clone : "
                + shallowCopy.getCustomer().getName());

        // Clonage profond

        System.out.println("\n===== DEEP COPY =====");

        BankAccount deepCopy = original.deepClone();

        deepCopy.setId(3L);
        deepCopy.setBalance(50000);
        deepCopy.getCustomer().setName("Omar");
        deepCopy.getCustomer().setEmail("omar@gmail.com");

        System.out.println("\nCompte clone :");

        System.out.println(
                JsonSerializer.toJson(deepCopy)
        );

        System.out.println("\nMeme compte : "
                + (original == deepCopy));

        System.out.println("Meme client : "
                + (original.getCustomer()
                == deepCopy.getCustomer()));

        System.out.println("\nClient original : "
                + original.getCustomer().getName());

        System.out.println("Client clone : "
                + deepCopy.getCustomer().getName());

        // Comparaison finale

        System.out.println("\n===== COMPARAISON FINALE =====");

        System.out.println("\nOriginal :");
        System.out.println(JsonSerializer.toJson(original));

        System.out.println("\nShallow Copy :");
        System.out.println(JsonSerializer.toJson(shallowCopy));

        System.out.println("\nDeep Copy :");
        System.out.println(JsonSerializer.toJson(deepCopy));
    }
}