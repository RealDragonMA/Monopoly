package fr.dupercorp.cases;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.Propriete;

public class Service extends Propriete {

    public Service(String nom, int loyer, int ...loyers) {
        super(nom, loyer, loyers);
    }

    @Override
    public void joueurArrive(Joueur joueur) {

    }

    @Override
    public void acheter(Joueur joueur) {

    }

}
