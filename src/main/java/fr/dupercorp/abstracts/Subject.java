package fr.dupercorp.abstracts;

import fr.dupercorp.Joueur;
import lombok.Getter;

import java.util.ArrayList;

public abstract class Subject {

    @Getter  private ArrayList<Observer> observers;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public abstract void attach(Observer observer);
    public abstract void detach(Observer observer);
    public abstract void notifyObservers(Joueur joueur);

}