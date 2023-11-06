package fr.dupercorp.cases;

import fr.dupercorp.Batiment;
import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.enums.Batiments;

import java.util.ArrayList;

public class Rue extends Propriete {

    private EtatRue etatRue;
    private ArrayList<Batiment> batiments;

    public Rue(String nom, int loyer, int... loyers) {
        super(nom, loyer, loyers);
    }

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

    public void addBatiment(Batiment batiment){
        batiments.add(batiment);
    }

}
