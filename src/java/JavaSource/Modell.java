package JavaSource;

import java.util.ArrayList;

public class Modell {
    public final Adatbazis ADATBAZIS;
    private final ArrayList<Termek> TERMEKEK ;
    private final ArrayList<Kategoria> KATEGORIAK;
    private final ArrayList<String> TELEPULESEK ;

    public Modell(Adatbazis adatbazis) {
        ADATBAZIS = adatbazis;
        TERMEKEK = adatbazis.termekekBetoltese();
        KATEGORIAK = adatbazis.kategoriakBetoltese();
        TELEPULESEK = adatbazis.telepulesekBetoltese();
    }
    
    // termek hozzadasa a modellhez és a fájlhoz
    public void termekHozzadasa(String telepules, String nev, String kategoria, String leiras, int ar, String kep, int mennyiseg) {
        int kategoriaID =  getKategoriaIdByNev(kategoria);
        
        //az id-t az adatbázis adja
        int id = ADATBAZIS.termekHozzadasa(telepules, nev, leiras, kategoriaID, ar, kep, mennyiseg);

        if (id > 0) {
            Termek ujTermek = new Termek(id, telepules, nev, leiras, kategoriaID, ar, kep, mennyiseg);
            TERMEKEK.add(ujTermek);
        }
    }

    //adott id-vel rendelkező elem törlése
    public void termekTorlese(int id) {
        Termek termek = getTermekById(id);
        
        if(termek != null){
            TERMEKEK.remove(termek);
            ADATBAZIS.termekTorlese(id);
        }
    }

    //egy termék árának megváltoztatása
    public void arvaltoztatas(int id, double szazalek) {
        Termek termek = getTermekById(id);
        
        if(termek != null){
            termek.szazalekosArvaltoztatas(szazalek);
            ADATBAZIS.arvaltoztatas(id,termek.getAr());
        }
    }

    //összes ár megváltoztatása
    public void arvaltoztatas(double szazalek) {
        TERMEKEK.forEach((termek) -> { arvaltoztatas(termek.ID, szazalek); });
    }

    //termék visszaadása az ID-je alalpján
    public Termek getTermekById(int id) {
        for (Termek termek : TERMEKEK) {
            if (termek.ID == id) {
                return termek;
            }
        }
        return null;
    }

    // GETTERS
    public ArrayList<String> getKategoriakNev() {
        ArrayList<String> kategoriak = new ArrayList<>();
        
        KATEGORIAK.forEach((kategoria) -> { kategoriak.add(kategoria.getNev());});
        return kategoriak;
    }
    
    public int getKategoriaIdByNev(String nev){
        for (Kategoria kategoria : KATEGORIAK) {
            if(kategoria.getNev().equals(nev)){
                return kategoria.ID;
            }
        }
        return -1;
    }

    public String getKategoriaNevByID(int id){
        for (Kategoria kategoria : KATEGORIAK) {
            if(kategoria.ID == id){
                return kategoria.getNev();
            }
        }
        return null;
    }
    
     public ArrayList<Kategoria> getKategoriak() {
        return KATEGORIAK;
    }
    
    public ArrayList<Termek> getTermekek() {
        return TERMEKEK;
    }

    public ArrayList<String> getTelepulesek() {
        return TELEPULESEK;
    }
    
    public boolean termekLetezik(int id){
       return getTermekById(id) != null;
    }
    
    public static String URL(String s){
        return s
            .toLowerCase()
            .replace(" ", "%")
            .replace("á", "a")
            .replace("é", "e")
            .replace("ó", "o")
            .replace("ö", "o")
            .replace("ő", "o")
            .replace("ú", "u")
            .replace("ü", "u")
            .replace("ű", "u");
    }
}
