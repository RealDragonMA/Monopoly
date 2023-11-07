package fr.dupercorp;

import fr.dupercorp.enums.Pions;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Monopoly {

    @Getter private ArrayList<Joueur> joueurs;
    @Getter @Setter private Joueur joueurCourant;
    @Getter private Des des;
    @Getter private Plateau plateau;

    public Monopoly(){
        this.joueurs = new ArrayList<>();
        this.des = new Des();
        this.plateau = new Plateau();
    }

    public static void main(String[] args) {
        Monopoly monopoly = new Monopoly();
        monopoly.lancerPartie();
    }

    public void lancerPartie(){
        plateau.initPlateau();
        Joueur mathis = new Joueur("Mathis", Pions.DE_A_COUDRE, this);
        Joueur antoine = new Joueur("Antoine", Pions.CHAT, this);
        Joueur christine = new Joueur("Christine", Pions.CHAPEAU_HAUT_DE_FORME, this);
        joueurs.add(mathis);
        joueurs.add(antoine);
        joueurs.add(christine);
        joueurCourant = mathis;
        while(!partieFinie()) jouer();
    }

    public boolean partieFinie(){
        return false;
    }

    public void jouer(){
        joueurCourant.jouerTour(des);
        setJoueurCourant(getJoueurs().get((getJoueurs().indexOf(getJoueurCourant()) + 1) % getJoueurs().size()));
    }

}