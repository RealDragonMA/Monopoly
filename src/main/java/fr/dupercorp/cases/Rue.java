package fr.dupercorp.cases;

import fr.dupercorp.Batiment;
import fr.dupercorp.Joueur;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.enums.Batiments;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Rue extends Propriete {

    @Getter @Setter private EtatRue etatRue;
    private ArrayList<Batiment> batiments;

    public Rue(String nom, int loyer, int... loyers) {
        super(nom, loyer, loyers);
        this.batiments = new ArrayList<>();
    }

    @Override
    public void joueurArrive(Joueur joueur) {
    }

    @Override
    public void acheter(Joueur joueur) {

    }

    public void addBatiment(Batiment batiment){
        batiments.add(batiment);
    }

}
