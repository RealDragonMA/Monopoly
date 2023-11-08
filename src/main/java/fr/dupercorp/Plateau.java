package fr.dupercorp;

import fr.dupercorp.abstracts.Case;
import fr.dupercorp.cases.*;
import fr.dupercorp.enums.Couleurs;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class Plateau {

    @Getter
    @Setter
    private Case caseDepart;
    @Getter
    private final ArrayList<Quartier> quartiers;

    public Plateau() {
        this.quartiers = new ArrayList<>();
        initPlateau();
    }

    public void initPlateau() {

        // Instanciation de toutes les cases du Monopoly classique avec les loyers initiaux

        // Cases "Rue"
        Rue rueDeLaPaix = new Rue("Rue de la Paix",350, 35, 175, 500, 1100, 1300, 1500);
        Rue avenueDesChampsElysees = new Rue("Avenue des Champs-Élysées", 350, 35, 175, 500, 1100, 1300, 1500);
        Rue rueHenriMartin = new Rue("Rue Henri-Martin", 60, 2, 10, 30, 90, 160, 250);
        Rue boulevardMalesherbes = new Rue("Boulevard Malesherbes", 80, 4, 20, 60, 180, 320, 450);
        Rue avenueMatignon = new Rue("Avenue Matignon", 80, 4, 20, 60, 180, 320, 450);
        Rue faubourgSaintHonore = new Rue("Faubourg Saint-Honoré", 100, 6, 30, 90, 270, 400, 550);
        Rue placeDeLaBourse = new Rue("Place de la Bourse", 100, 6, 30, 90, 270, 400, 550);
        Rue rueLaFayette = new Rue("Rue La Fayette", 120, 8, 40, 100, 300, 450, 600);
        Rue avenueFoch = new Rue("Avenue Foch", 300, 26, 130, 390, 900, 1100, 1275);
        Rue boulevardCapucines = new Rue("Boulevard des capucines", 320, 28, 150, 450, 1000, 1200, 1400);
        Rue rueDeCourcelles = new Rue("Rue de Courcelles", 180, 14, 70, 200, 550, 750, 950);
        Rue rueDeVaugirard = new Rue("Rue de Vaugirard", 180, 14, 70, 200, 550, 750, 950);
        Rue avenueDeNeuilly = new Rue("Avenue de Neuilly", 200, 16, 80, 220, 600, 800, 1000);
        Rue rueDeParadis = new Rue("Rue de Paradis", 220, 18, 90, 250, 700, 875, 1050);
        Rue avenueDeLaRepublique = new Rue("Avenue de la République", 220, 18, 90, 250, 700, 875, 1050);
        Rue rueLecourbe = new Rue("Rue Lecourbe", 240, 20, 100, 300, 750, 925, 1100);
        Rue boulevardDeBelleville = new Rue("Boulevard de Belleville", 240, 20, 100, 300, 750, 925, 1100);
        Rue avenueMozart = new Rue("Avenue Mozart", 260, 22, 110, 330, 800, 975, 1150);
        Rue boulevardSaintMichel = new Rue("Boulevard Saint-Michel", 260, 22, 110, 330, 800, 975, 1150);
        Rue avenueVauban = new Rue("Avenue Vauban", 300, 26, 130, 390, 900, 1100, 1275);
        Rue avenueDeBreteuil = new Rue("Avenue de Breteuil", 300, 26, 130, 390, 900, 1100, 1275);
        // Cartes "Chance" et "Communaute"
        Chance chance1 = new Chance("Chance");
        Chance chance2 = new Chance("Chance");
        Chance chance3 = new Chance("Chance");
        Communaute communaute1 = new Communaute("Caisse de communauté");
        Communaute communaute2 = new Communaute("Caisse de communauté");
        Communaute communaute3 = new Communaute("Caisse de communauté");

        // Case "Départ"
        Depart depart = new Depart();

        // Gares
        Gare gareDuNord = new Gare("Gare du Nord", 200, 25, 50, 100, 200);
        Gare gareDeLyon = new Gare("Gare de Lyon", 200, 25, 50, 100, 200);
        Gare gareSaintLazare = new Gare("Gare Saint-Lazare", 200, 25, 50, 100, 200);
        Gare gareMontparnasse = new Gare("Gare Montparnasse", 200, 25, 50, 100, 200);

        // Case "Parc Gratuit" et "Prison"
        Parc parcGratuit = new Parc("Parc Gratuit");
        Prison prison = new Prison("Prison");
        Prison prisonGo = new Prison("En allez prison");

        // Services (Compagnie d'électricité et Compagnie des eaux)
        Service compagnieElectricite = new Service("Compagnie d'électricité", 150, 4, 10);
        Service compagnieEaux = new Service("Compagnie des eaux", 150, 4, 10);

        // Taxes
        Taxe impotsRevenu = new Taxe("Impôts sur le Revenu", 200);
        Taxe taxeDeLuxe = new Taxe("Taxe de Luxe", 75);

        depart.setSuivante(boulevardDeBelleville);
        boulevardDeBelleville.setSuivante(communaute1);
        communaute1.setSuivante(rueLecourbe);
        rueLecourbe.setSuivante(impotsRevenu);
        impotsRevenu.setSuivante(gareMontparnasse);
        gareMontparnasse.setSuivante(rueDeVaugirard);
        rueDeVaugirard.setSuivante(chance1);
        chance1.setSuivante(rueDeCourcelles);
        rueDeCourcelles.setSuivante(avenueDeLaRepublique);
        avenueDeLaRepublique.setSuivante(prison);
        prison.setSuivante(boulevardDeBelleville);
        boulevardDeBelleville.setSuivante(compagnieElectricite);
        compagnieElectricite.setSuivante(avenueDeNeuilly);
        avenueDeNeuilly.setSuivante(rueDeParadis);
        rueDeParadis.setSuivante(gareDeLyon);
        gareDeLyon.setSuivante(avenueMozart);
        avenueMozart.setSuivante(communaute2);
        communaute2.setSuivante(boulevardSaintMichel);
        boulevardSaintMichel.setSuivante(avenueVauban);
        avenueVauban.setSuivante(parcGratuit);
        parcGratuit.setSuivante(avenueMatignon);
        avenueMatignon.setSuivante(chance2);
        chance2.setSuivante(boulevardMalesherbes);
        boulevardMalesherbes.setSuivante(rueHenriMartin);
        rueHenriMartin.setSuivante(gareDuNord);
        gareDuNord.setSuivante(faubourgSaintHonore);
        faubourgSaintHonore.setSuivante(placeDeLaBourse);
        placeDeLaBourse.setSuivante(compagnieEaux);
        compagnieEaux.setSuivante(rueLaFayette);
        rueLaFayette.setSuivante(prisonGo);
        prisonGo.setSuivante(avenueDeBreteuil);
        avenueDeBreteuil.setSuivante(avenueFoch);
        avenueFoch.setSuivante(communaute3);
        communaute3.setSuivante(boulevardCapucines);
        boulevardCapucines.setSuivante(gareSaintLazare);
        gareSaintLazare.setSuivante(chance3);
        chance3.setSuivante(avenueDesChampsElysees);
        avenueDesChampsElysees.setSuivante(taxeDeLuxe);
        taxeDeLuxe.setSuivante(rueDeLaPaix);
        rueDeLaPaix.setSuivante(depart);

        // Ajout des quartiers
        Quartier bleuFonce = new Quartier(Couleurs.BLEU_FONCE, rueDeLaPaix, avenueDesChampsElysees);
        Quartier rouge = new Quartier(Couleurs.ROUGE, rueHenriMartin, boulevardMalesherbes, avenueMatignon);
        Quartier rose = new Quartier(Couleurs.ROSE, rueDeParadis, avenueDeNeuilly, boulevardDeBelleville);
        Quartier orange = new Quartier(Couleurs.ORANGE, avenueMozart, boulevardSaintMichel, avenueVauban);
        Quartier jaune = new Quartier(Couleurs.JAUNE, faubourgSaintHonore, placeDeLaBourse, rueLaFayette);
        Quartier vert = new Quartier(Couleurs.VERT, avenueDeBreteuil, avenueFoch, boulevardCapucines);
        Quartier bleuCiel = new Quartier(Couleurs.BLEU_CIEL, rueDeCourcelles, rueDeVaugirard, avenueDeLaRepublique);
        Quartier marron = new Quartier(Couleurs.MARRON, boulevardDeBelleville, rueLecourbe);

        quartiers.add(bleuFonce);
        quartiers.add(rouge);
        quartiers.add(rose);
        quartiers.add(orange);
        quartiers.add(jaune);
        quartiers.add(vert);
        quartiers.add(bleuCiel);
        quartiers.add(marron);

        setCaseDepart(depart);

    }

}
