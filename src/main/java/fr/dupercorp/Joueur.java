package fr.dupercorp;

import fr.dupercorp.abstracts.Case;
import fr.dupercorp.abstracts.Propriete;
import fr.dupercorp.enums.Pions;
import fr.dupercorp.utils.CC;
import fr.dupercorp.utils.Choice;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Joueur {

    @Getter
    private final String name;
    @Getter
    private final Pions pion;
    @Getter
    private final Monopoly monopoly;
    @Getter
    @Setter
    private int argent;
    @Getter
    @Setter
    private Case position;
    @Getter
    private final ArrayList<Propriete> proprietes;

    public Joueur(String name, Pions pion, Monopoly monopoly) {
        this.name = name;
        this.pion = pion;
        this.monopoly = monopoly;
        this.argent = 1500;
        this.position = monopoly.getPlateau().getCaseDepart();
        this.proprietes = new ArrayList<>();
    }

    public void jouerTour(Des des) {
        CC.clear();
        System.out.println("==================================================");
        System.out.println("C'est au tour de " + CC.YELLOW + getName() + CC.RESET);
        System.out.println("Vous êtes sur la case " + CC.GREEN + getPosition().getNom() + CC.RESET);
        System.out.println("Vous avez " + CC.YELLOW + getArgent() + "€" + CC.RESET);
        Choice choices = new Choice("Que voulez vous faire ?")
                .response("Lancer les dés", (data) -> {
                    // On demande au joueur combien il veut faire au dé, on triche
                    // en lui donnant le choix entre 1 et 6
                    AtomicInteger avancement = new AtomicInteger();
                    new Choice("Combien voulez vous faire ?")
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .response("", avancement::set)
                            .run();
                    // On avance le joueur
                    avancer(avancement.get());
                    System.out.println(getName() + " avance de " + avancement.get() + " cases et se retrouve sur " + getPosition().getNom());
                    getPosition().joueurArrive(this);
                });

        if (!getProprietes().isEmpty()) {
            choices.response("Voir mes propriétés", (data) -> {
                System.out.println("Vous avez " + getProprietes().size() + " propriétés:");
                for (Propriete propriete : getProprietes()) {
                    System.out.println("  - " + propriete.getNom());
                }
                System.out.println("==================================================");
                choices.run();
            });
        }

        choices.response("Ne rien faire", (data) -> {

        }).run();
    }

    public void avancer(int pas) {
        for (int i = 0; i < pas; i++) setPosition(getPosition().getSuivante());
    }

    public void payerBanque(int somme) {
        setArgent(argent - somme);
    }

    public boolean proposerAchat(Propriete propriete) {
        AtomicBoolean res = new AtomicBoolean(false);
        new Choice("Voulez vous acheter la propriété, elle coutera " + CC.YELLOW + propriete.getPrix() + "€" + CC.RESET)
            .response("Acheter", (data) -> {
                res.set(true);
            })
            .response("Ne pas acheter", (data) -> {
                System.out.println("Vous n'avez pas acheté la propriété");
            }).run();
        return res.get();
    }

    public void ajoutPropriete(Propriete propriete) {
        proprietes.add(propriete);
    }

    public void finirLeTour() {
        System.out.println("Votre tour est fini");
    }

    public void recoisArgent(int somme) {
        setArgent(argent + somme);
    }

    public void donneArgent(int somme) {
        setArgent(argent - somme);
    }

    public void payerJoueur(Joueur joueur, int somme) {
        this.donneArgent(somme);
        joueur.recoisArgent(somme);
    }


}
