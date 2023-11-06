package fr.dupercorp;

import fr.dupercorp.enums.Batiments;
import lombok.Getter;
public class Batiment {

    private Batiments type;
    @Getter private int prix;

    Batiment(Batiments type){
        this.type = type;
        switch (type){
            case Batiments.HOTEL :
                prix = 400;
                break;
            case Batiments.MAISON:
                prix = 200;
                break;
            default:
                prix = -1;
                break;
        }
    }

}
