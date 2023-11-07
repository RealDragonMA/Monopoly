package fr.dupercorp.abstracts;

import fr.dupercorp.Joueur;
import lombok.Getter;
import lombok.Setter;

public abstract class Case {

    @Getter
    private final String nom;
    @Getter
    @Setter
    private Case suivante;

    public Case(String nom) {
        this.nom = nom;
    }

    public abstract void joueurArrive(Joueur joueur);

}
