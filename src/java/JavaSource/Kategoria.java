package JavaSource;

public class Kategoria {    
    public final int ID;
    private String nev;
    private String leiras;

    public Kategoria(int ID, String nev, String leiras) {
        this.ID = ID;
        this.nev = nev;
        this.leiras = leiras;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

}
