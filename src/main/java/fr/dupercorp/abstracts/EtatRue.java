package fr.dupercorp.abstracts;

import fr.dupercorp.Joueur;
import fr.dupercorp.cases.Rue;
import lombok.Getter;
public abstract class EtatRue {

    @Getter private Rue rue;

    public EtatRue(Rue rue) {
        this.rue = rue;
    }

    public abstract void acheterMaison(Joueur joueur);
    public abstract void acheterRue(Joueur joueur);
    public abstract void payerLoyer(Joueur joueur);
    public abstract void joueurArrive(Joueur joueur);

}
