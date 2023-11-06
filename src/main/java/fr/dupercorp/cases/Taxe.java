package fr.dupercorp.cases;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.Case;

public class Taxe extends Case {

    private int taxe;

    public Taxe(String nom, int taxe) {
        super(nom);
        this.taxe = taxe;
    }

    @Override
    public void joueurArrive(Joueur joueur) {

    }
}
