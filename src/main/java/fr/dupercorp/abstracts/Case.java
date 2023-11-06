package fr.dupercorp.abstracts;

import fr.dupercorp.Joueur;

public abstract class Case {

    private String nom;
    private int place;

    public abstract void joueurArrive(Joueur joueur);

    public Case getSuivante(){
        return null;
    }

}
