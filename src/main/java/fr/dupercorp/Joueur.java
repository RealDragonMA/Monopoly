package fr.dupercorp;

import fr.dupercorp.abstracts.Case;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.enums.Pions;
import fr.dupercorp.utils.Choice;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class Joueur {

    @Getter private final String name;
    @Getter private final Pions pion;
    @Getter private final Monopoly monopoly;
    @Getter @Setter private int argent;
    @Getter @Setter private Case position;
    @Getter private ArrayList<Propriete> proprietes;

    public Joueur(String name, Pions pion, Monopoly monopoly) {
        this.name = name;
        this.pion = pion;
        this.monopoly = monopoly;
        this.argent = 1500;
        this.position = monopoly.getPlateau().getCaseDepart();
    }

    public void jouerTour(Des des){
        int lancer = des.lancerDes();
        avancer(lancer);
        getPosition().joueurArrive(this);
    }

    public void avancer(int pas){
        for(int i = 0; i < pas; i++) setPosition(getPosition().getSuivante());
    }

    public void payerBanque(int somme){
        setArgent(argent-somme);
    }

    public boolean proposerAchat(Propriete propriete){
        AtomicBoolean res = new AtomicBoolean(false);
        new Choice("Voulez vous acheter la propriété " )
                .response("1 - Acheter", () -> {
                    res.set(true);
                })
                .response("2 - Ne pas acheter", () -> {
                    System.out.println("Vous n'avez pas acheté la propriété");
                }).run();
        return res.get();
    }

    public void ajoutPropriete(Propriete propriete){
        proprietes.add(propriete);
    }

    public void finirLeTour(){
        System.out.println("Votre tour est fini");
    }

    public void recoisArgent(int somme){
        setArgent(argent+somme);
    }
    public void donneArgent(int somme){
        setArgent(argent-somme);
    }

    public void payerJoueur(Joueur joueur, int somme){
        this.donneArgent(somme);
        joueur.recoisArgent(somme);
    }


}
