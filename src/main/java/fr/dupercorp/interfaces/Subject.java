package fr.dupercorp.interfaces;

import fr.dupercorp.Joueur;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObservers(Joueur joueur);
}