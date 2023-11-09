package fr.dupercorp.etatsRue;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.cases.Rue;

public class Achetee extends EtatRue {

    public Achetee(Rue rue) {
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
        joueur.payerJoueur(getRue().getProprietaire(), getRue().getLoyerCourant());
    }

    @Override
    public void joueurArrive(Joueur joueur) {
        System.out.println(getRue().getNom() + " appartient à " + getRue().getProprietaire().getName() + ", vous payer " + getRue().getLoyerCourant() + "€ de loyer");
        payerLoyer(joueur);
    }
}
