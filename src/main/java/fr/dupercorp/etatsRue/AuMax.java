package fr.dupercorp.etatsRue;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.cases.Rue;

public class AuMax extends EtatRue {
    public AuMax(Rue rue) {
        super(rue);
    }

    @Override
    public void acheterMaison(Joueur joueur) {

    }

    @Override
    public void payerLoyer(Joueur joueur) {
        joueur.payerJoueur(getRue().getProprietaire(), getRue().getLoyerCourant());
    }

    @Override
    public void joueurArrive(Joueur joueur) {

    }
}
