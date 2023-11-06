package fr.dupercorp.cases;

import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.enums.Batiments;

import java.util.ArrayList;

public class Rue extends Propriete {

    private EtatRue etatRue;
    private ArrayList<Batiments> batiments;

    @Override
    public void joueurArrive(Joueur joueur) {

    }

    @Override
    public void acheter(Joueur joueur) {

    }

    public EtatRue getEtatRue() {
        return etatRue;
    }

    public void setEtatRue(EtatRue etatRue) {
        this.etatRue = etatRue;
    }

}
