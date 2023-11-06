package fr.dupercorp;

import fr.dupercorp.abstracts.Case;
import fr.dupercorp.cases.Rue;
import fr.dupercorp.enums.Couleurs;

import java.util.ArrayList;
import java.util.List;

public class Quartier {

    private ArrayList<Case> cases;
    private Couleurs couleur;

    public Quartier(Couleurs couleur, Case... cases) {
        this.couleur = couleur;
        this.cases = new ArrayList<>();
        this.cases.addAll(List.of(cases));
    }

    public ArrayList<Case> getCases() {
        return cases;
    }

    public Couleurs getCouleur() {
        return couleur;
    }
}
