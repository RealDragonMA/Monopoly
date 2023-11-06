package fr.dupercorp;

import fr.dupercorp.cases.Rue;
import fr.dupercorp.enums.Couleurs;

import java.util.ArrayList;

public class Quartier {

    private ArrayList<Rue> rues;
    private Couleurs couleur;

    public Quartier(ArrayList<Rue> rues, Couleurs couleur) {
        this.rues = rues;
        this.couleur = couleur;
    }

    public ArrayList<Rue> getRues() {
        return rues;
    }

    public Couleurs getCouleur() {
        return couleur;
    }
}
