package fr.dupercorp.abstracts;

import fr.dupercorp.Joueur;
import fr.dupercorp.Quartier;
import fr.dupercorp.interfaces.Observer;
import fr.dupercorp.interfaces.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

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
        this.prix = loyer;
        this.loyer = loyers[0];
        this.loyerCourant = loyers[0];
        this.loyers = new ArrayList<>();
        this.observers = new ArrayList<>();
        for (int j : loyers) this.loyers.add(j);
    }

    public abstract void update(Quartier quartier);

    @Override
    public void attach(Observer observer) {
        if(observer == null) throw new NullPointerException("Observer cannot be null");
        if(!observers.contains(observer)) observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Joueur joueur) {
        System.out.printf("Notifying %d observers%n", observers.size());
        for (Observer o : observers) {
            System.out.printf("Notifying %s%n", o.getClass().getSimpleName());
            o.update();
        }
    }


}
