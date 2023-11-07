package fr.dupercorp;

import fr.dupercorp.abstracts.Case;
import fr.dupercorp.abstracts.Observer;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.cases.Rue;
import fr.dupercorp.enums.Couleurs;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Quartier extends Observer {

    @Getter private ArrayList<Propriete> proprietes;
    @Getter private Couleurs couleur;

    public Quartier(Couleurs couleur, Propriete... proprietes) {
        this.couleur = couleur;
        this.proprietes = new ArrayList<>();
        this.proprietes.addAll(List.of(proprietes));
    }

    @Override
    public void update() {

    }
}
