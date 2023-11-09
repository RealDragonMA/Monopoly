package fr.dupercorp;

import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.enums.Couleurs;
import fr.dupercorp.interfaces.Observer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Quartier implements Observer {

    @Getter
    private final ArrayList<Propriete> proprietes;
    @Getter
    private final Couleurs couleur;
    @Getter
    @Setter
    private Joueur proprietaire;

    public Quartier(Couleurs couleur, Propriete... proprietes) {
        this.couleur = couleur;
        this.proprietes = new ArrayList<>();
        this.proprietes.addAll(List.of(proprietes));
        proprietaire = null;
    }

    //Le quartier check toutes ses propriétés pour voir si elles sont toutes possédées par le même joueur
    //Si oui, alors le joueur possède le quartier
    @Override
    public void update() {
        System.out.printf("Update du quartier %s%n", couleur);
        if (proprietes.isEmpty()) return; //Si le quartier n'a pas de propriété, alors il n'a pas de propriétaire
        System.out.println("Le quartier a des propriétés");
        Joueur proprio = proprietes.get(0).getProprietaire();
        boolean possede = true;
        for (Propriete p : proprietes) {
            if (p.getProprietaire() != proprio) {
                possede = false;
                break;
            }
        }
        if (possede) {
            setProprietaire(proprio);
        }
        for (Propriete p : proprietes) {
            p.update(this);
        }
    }
}
