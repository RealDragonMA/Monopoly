package fr.dupercorp.abstracts;

import fr.dupercorp.Joueur;
import fr.dupercorp.Quartier;
import fr.dupercorp.interfaces.Observer;
import fr.dupercorp.interfaces.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public abstract class Propriete extends Case implements Subject {

    @Getter
    private int prix;
    @Getter
    private final int loyer;
    @Getter
    @Setter
    private int loyerCourant;
    @Getter
    private final ArrayList<Integer> loyers;
    @Getter
    @Setter
    private Joueur proprietaire;

    @Getter
    private final ArrayList<Observer> observers;


    public Propriete(String nom, int loyer, int... loyers) {
        super(nom);
        this.loyer = loyer;
        this.loyerCourant = loyer;
        this.loyers = new ArrayList<>();
        this.observers = new ArrayList<>();
        for (int j : loyers) this.loyers.add(j);
    }


    public abstract void acheter(Joueur joueur);

    public abstract void update(Quartier quartier);

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Joueur joueur) {
        for (Observer o : observers) {
            o.update();
        }
    }


}
