package fr.dupercorp.abstracts;
import lombok.Getter;
import lombok.Setter;
import fr.dupercorp.Joueur;

public abstract class Case {

    @Getter private String nom;
    @Getter @Setter private Case suivante;

    public Case(String nom){
        this.nom = nom;
    }

    public abstract void joueurArrive(Joueur joueur);

}
