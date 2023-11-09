package fr.dupercorp.cases;

import fr.dupercorp.Joueur;
import fr.dupercorp.Quartier;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.utils.CC;
import lombok.Getter;
import lombok.Setter;

public class Service extends Propriete {

    @Getter
    @Setter
    private int multiplicateur;

    public Service(String nom, int loyer, int... loyers) {
        super(nom, loyer, loyers);
    }

    @Override
    public void joueurArrive(Joueur joueur) {
        if (getProprietaire() == null) {
            boolean achat = joueur.proposerAchat(this);
            if (achat) {
                joueur.payerBanque(getPrix());
                joueur.ajoutPropriete(this);
                setProprietaire(joueur);
                setLoyerCourant(getLoyer());
                System.out.println(CC.GREEN + "Vous avez acheté le service " + getNom() + CC.RESET);
                notifyObservers(joueur);
            }
        } else if (getProprietaire() != joueur) {
            // On lance les dés, si le propriétaire n'a qu'un service, on multiplie par 4, sinon par 10
            int des = joueur.getMonopoly().getDes().lancerDes();
            int loyer = getLoyerCourant() * des;
            joueur.payerJoueur(getProprietaire(), loyer);
            System.out.println(getNom() + " appartient à " + getProprietaire().getName());
            System.out.println("Vous lancez les dés et vous faites ... " + des + ", vous payer " + getLoyerCourant() + "*" + des + "=" + loyer + "€ de loyer");
        }
    }

    @Override
    public void update(Quartier quartier) {
        if (quartier.getProprietaire() == getProprietaire()) {
            setLoyerCourant(getLoyers().get(1));
        } else {
            setLoyerCourant(getLoyers().get(0));
        }
    }
}
