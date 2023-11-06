package fr.dupercorp;

public class Des {

    private int de1;
    private int de2;

    public Des(){
        this.de1 = 0;
        this.de2 = 0;
    }

    public int lancerDes(){
        this.de1 = (int) (Math.random() * 6) + 1;
        this.de2 = (int) (Math.random() * 6) + 1;
        return this.de1 + this.de2;
    }

}
