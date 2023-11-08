package fr.dupercorp.etatsRue;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.cases.Rue;
import fr.dupercorp.utils.CC;

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

    @Override
    public void joueurArrive(Joueur joueur) {
        boolean achat = joueur.proposerAchat(getRue());
        if (achat) {
            joueur.payerBanque(getRue().getPrix());
            joueur.ajoutPropriete(getRue());
            getRue().setProprietaire(joueur);
            getRue().setEtatRue(new Achetee(getRue()));
            getRue().setLoyerCourant(getRue().getLoyers().get(2));
            System.out.println(CC.GREEN + "Vous avez acheté la rue " + getRue().getNom() + CC.RESET);
            //appel methode notify de la class abstraite de Subject
        }
    }
}
