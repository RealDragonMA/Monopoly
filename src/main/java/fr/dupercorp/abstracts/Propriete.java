package fr.dupercorp.abstracts;
import lombok.Getter;
import lombok.Setter;
import fr.dupercorp.Joueur;
import java.util.ArrayList;

public abstract class Propriete extends Case {

    @Getter private int prix;
    @Getter private int loyer;
    @Getter private int loyerCourant;
    @Getter private ArrayList<Integer> loyers;
    @Getter private Joueur proprietaire;

    public Propriete(String nom, int loyer, int... loyers) {
        super(nom);
        this.loyer = loyer;
        this.loyerCourant = loyer;
        this.loyers = new ArrayList<>();
        for (int j : loyers) this.loyers.add(j);
    }


    public abstract void acheter(Joueur joueur);



}
