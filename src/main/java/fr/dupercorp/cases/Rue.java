package fr.dupercorp.cases;

import fr.dupercorp.Batiment;
import fr.dupercorp.Joueur;
import fr.dupercorp.Quartier;
import fr.dupercorp.abstracts.EtatRue;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.etatsRue.Achetee;
import fr.dupercorp.etatsRue.AuMax;
import fr.dupercorp.etatsRue.Constructible;
import fr.dupercorp.etatsRue.Libre;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Rue extends Propriete {

    @Getter
    @Setter
    private EtatRue etatRue;
    @Getter
    private final ArrayList<Batiment> batiments;

    public Rue(String nom, int loyer, int... loyers) {
        super(nom, loyer, loyers);
        this.batiments = new ArrayList<>();
        etatRue = new Libre(this);
    }

    @Override
    public void joueurArrive(Joueur joueur) {
        etatRue.joueurArrive(joueur);
    }

    @Override
    public void acheter(Joueur joueur) {

    }

    @Override
    public void update(Quartier quartier) {
        //si il y a un proprietaire au quartier alors rue au moins constructible
        if (quartier.getProprietaire() != null) {
            this.setEtatRue(new Constructible(this));
            this.setLoyerCourant(this.getLoyers().get(2));
            if (getBatiments().size() == 5){
                this.setEtatRue(new AuMax(this));
                this.setLoyerCourant(this.getLoyers().get(getLoyers().size()-1));
            }
        } else if (this.getProprietaire() != null) {
            this.setEtatRue(new Libre(this));
            this.setLoyerCourant(this.getLoyers().get(1));
        }else{
            this.setEtatRue(new Achetee(this));
            this.setLoyerCourant(this.getLoyers().get(0));
        }
    }

    public void addBatiment(Batiment batiment) {
        batiments.add(batiment);
    }

    public void setProprietaire(Joueur joueur) {
        super.setProprietaire(joueur);
    }
}
