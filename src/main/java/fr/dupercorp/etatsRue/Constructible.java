package fr.dupercorp.etatsRue;

import fr.dupercorp.Batiment;
import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.cases.Rue;
import fr.dupercorp.enums.Batiments;

public class Constructible extends EtatRue {
    public Constructible(Rue rue) {
        super(rue);
    }

    @Override
    public void acheterMaison(Joueur joueur) {
        Batiment maison = new Batiment(Batiments.MAISON);
        if (joueur == getRue().getProprietaire()) {
            joueur.payerBanque(maison.getPrix());
        }
        getRue().addBatiment(maison);
        getRue().notifyObservers(joueur);
    }

    @Override
    public void payerLoyer(Joueur joueur) {
        joueur.payerJoueur(getRue().getProprietaire(), getRue().getLoyerCourant());
    }

    @Override
    public void joueurArrive(Joueur joueur) {
        System.out.println(getRue().getNom() + " appartient à " + getRue().getProprietaire().getName() + ", vous payer " + getRue().getLoyerCourant() + "€ de loyer");
        System.out.println("Il possède " + getRue().getBatiments().size() + " batiments");
        payerLoyer(joueur);
    }
}
