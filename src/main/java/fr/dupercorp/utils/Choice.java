package fr.dupercorp.utils;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Choice {
    private String prompt;
    private List<String> optionsString = new ArrayList<>();
    private List<Consumer<Integer>> options = new ArrayList();

    public Choice(String prompt) {
        this.prompt = prompt;
    }

    public Choice response(String option, Consumer<Integer> action) {
        options.add(action);
        optionsString.add(option);
        return this;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice < 1 || choice >= options.size()+1) {
            System.out.println(prompt);
            for (int i = 0; i < optionsString.size(); i++) {
                System.out.println((i+1) + " - " + optionsString.get(i));
            }
            System.out.println("==================================================");
            System.out.print("Votre choix : ");
            choice = scanner.nextInt();
        }
        options.get(choice-1).accept(choice+1); // Passer l'indice de l'option sélectionnée
    }
}
