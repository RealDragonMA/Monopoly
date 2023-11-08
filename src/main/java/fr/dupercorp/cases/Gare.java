package fr.dupercorp.cases;

import fr.dupercorp.Joueur;
import fr.dupercorp.Quartier;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.utils.CC;

import java.util.concurrent.atomic.AtomicInteger;

public class Gare extends Propriete {

    public Gare(String nom, int loyer, int... loyers) {
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
                System.out.println(CC.GREEN + "Vous avez acheté la gare " + getNom() + CC.RESET);
                notifyObservers(joueur);
            }
        } else if (getProprietaire() != joueur) {
            joueur.donneArgent(getLoyerCourant());
            getProprietaire().recoisArgent(getLoyerCourant());
        }
    }

    @Override
    public void update(Quartier quartier) {
        if (getProprietaire() == null){
            setLoyerCourant(getLoyers().get(0));
        }else{
            AtomicInteger nbSame = new AtomicInteger();
            quartier.getProprietes().forEach(elem->{
               if (elem.getProprietaire() == getProprietaire()){
                     nbSame.addAndGet(1);
               }
            });
            setLoyerCourant(getLoyers().get(nbSame.get()));
        }
    }
}
