package fr.dupercorp.utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Choice {
    private String prompt;
    private List<Runnable> options = new ArrayList<>();

    public Choice(String prompt) {
        this.prompt = prompt;
    }

    public Choice response(String option, Runnable action) {
        options.add(action);
        return this;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + "Option " + (i + 1));
        }

        int userInput;

        try {
            userInput = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Réponse invalide. Veuillez entrer un numéro valide.");
            scanner.close();
            return;
        }

        if (userInput >= 1 && userInput <= options.size()) {
            Runnable action = options.get(userInput - 1);
            action.run();
        } else {
            System.out.println("Réponse invalide. Veuillez sélectionner un numéro valide.");
        }

        scanner.close();
    }

    public static void main(String[] args) {
        Choice choice = new Choice("Que voulez-vous faire ?");
        choice.response("Acheter", () -> {
            System.out.println("Vous avez choisi d'acheter.");
            // Placez votre logique pour l'achat ici
        }).response("Rien faire", () -> {
            System.out.println("Vous avez choisi de ne rien faire.");
            // Placez votre logique pour ne rien faire ici
        });

        choice.run();
    }
}
