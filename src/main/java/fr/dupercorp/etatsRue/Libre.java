package fr.dupercorp.etatsRue;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.cases.Rue;

public class Libre extends EtatRue {

    public Libre(Rue rue) {
        super(rue);
    }

    @Override
    public void acheterMaison(Joueur joueur) {

    }

    @Override
    public void acheterRue(Joueur joueur) {

    }

    @Override
    public void payerLoyer(Joueur joueur) {

    }
}
