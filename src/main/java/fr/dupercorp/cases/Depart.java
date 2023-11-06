package fr.dupercorp.cases;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.Case;

public class Depart extends Case {


    public Depart() {
        super("Départ");
    }

    @Override
    public void joueurArrive(Joueur joueur) {
        System.out.println("Le joueur " + joueur.getName() + " est arrivé sur la case départ");
    }
}
