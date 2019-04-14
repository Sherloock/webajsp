package JavaSource;

public class Termek {

    public final int ID;
    private String telepules;
    private String nev;
    private int kategoriaID;
    private String leiras;
    private int ar;
    private String kep;
    private int mennyiseg;

    //ab konstruktor idvel
    Termek(int ID, String telepules, String nev, String leiras, int kategoria, int ar, String kep, int mennyiseg) {
        this.ID = ID;
        this.telepules = telepules;
        this.nev = nev;
        this.kategoriaID = kategoria;
        this.leiras = leiras;
        setAr(ar);
        this.kep = kep;
        setMennyiseg(mennyiseg);
    }

    public void szazalekosArvaltoztatas(double szazalek){
        ar *= (1+szazalek);
        setAr(ar);
    }

    @Override
    public String toString() {
        return "Termek{" + "ID=" + ID + ", telepules=" + telepules + ", nev=" + nev + ", "
                + "kategoria=" + kategoriaID + ", leiras=" + leiras + ", ar=" + ar + ", kep=" + kep + '}';
    }

    ////////////////////////////////////////// getters  //////////////////////////////////////////
    
    public String getTelepules() {
        return telepules;
    }

    public String getNev() {
        return nev;
    }

    public int getKategoriaID() {
        return kategoriaID;
    }

    public String getLeiras() {
        return leiras;
    }

    public int getAr() {
        return ar;
    }

    public String getKep() {
        return kep;
    }
    
    public int getMennyiseg() {
        return mennyiseg;
    }
    
    ////////////////////////////////////////// setters //////////////////////////////////////////


    public void setTelepules(String telepules) {
        this.telepules = telepules;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setKategoriaID(int kategoria) {
        this.kategoriaID = kategoria;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public final void setAr(int ar) {
        this.ar = Math.max(1, ar);
    }

    public void setKep(String kep) {
        this.kep = kep;
    }

    public void setMennyiseg(int mennyiseg) {
        this.mennyiseg = Math.max(0, mennyiseg);
    }
}
