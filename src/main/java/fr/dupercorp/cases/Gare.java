package fr.dupercorp.cases;

import fr.dupercorp.Joueur;
import fr.dupercorp.Quartier;
import fr.dupercorp.abstracts.Propriete;

public class Gare extends Propriete {

    public Gare(String nom, int loyer, int ...loyers) {
        super(nom, loyer, loyers);
    }

    @Override
    public void joueurArrive(Joueur joueur) {

    }

    @Override
    public void acheter(Joueur joueur) {

    }

    @Override
    public void update(Quartier quartier) {

    }
}
