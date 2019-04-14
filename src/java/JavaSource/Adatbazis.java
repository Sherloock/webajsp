package JavaSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Adatbazis {

    public Connection kapcsolat;

    public Adatbazis(String url) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  // driver betöltése
            kapcsolat = DriverManager.getConnection(url);

        } catch (ClassNotFoundException | SQLException ex) {
            hibaUzenet("Kapcsolat létrehozása sikertelen!\nDetails: " + ex.getMessage());
        }
    }

    //////////////////////////////////////////////// adatok betöltése az adatbázisból //////////////////////////////////////////////// 
    
    public ArrayList<Termek> termekekBetoltese() {
        ArrayList<Termek> termekek = new ArrayList<>();
        
        try {
            ResultSet rs =  kapcsolat.prepareStatement("SELECT * FROM termek").executeQuery();

            while (rs.next()) {
                Termek termek = new Termek(
                        rs.getInt("id"),
                        rs.getString("telepules"),
                        rs.getString("nev"),
                        rs.getString("leiras"),
                        rs.getInt("kategoria_id"),
                        rs.getInt("ar"),
                        rs.getString("kep"),
                        rs.getInt("mennyiseg")
                );
                termekek.add(termek);
            }

        } catch (SQLException ex) {
            hibaUzenet("Termékek betöltése sikertelen!\nDetails: " + ex.getMessage());
        }
        return termekek;
    }

    public ArrayList<String> telepulesekBetoltese() {
        ArrayList<String> telepulesek = new ArrayList<>();
        
        try {            
            ResultSet rs =  kapcsolat.prepareStatement("SELECT * FROM telepules").executeQuery();
            
            while (rs.next()) {
                telepulesek.add(rs.getString("nev"));
            }

        } catch (SQLException ex) {
            hibaUzenet("Települések betöltése sikertelen!\nDetails: " + ex.getMessage());
        }
        
        return telepulesek;
    }

    public ArrayList<Kategoria> kategoriakBetoltese() {
        ArrayList<Kategoria> kategoriak = new ArrayList<>();
        
        try {                    
            ResultSet rs = kapcsolat.prepareStatement("SELECT * FROM kategoria").executeQuery();
            
            while (rs.next()) {
                Kategoria kategoria = new Kategoria(
                        rs.getInt("id"),
                        rs.getString("nev"),
                        rs.getString("leiras")
                );
                kategoriak.add(kategoria);
            }

        } catch (SQLException ex) {
            hibaUzenet("Kategóriák betöltése sikertelen!\nDetails: " + ex.getMessage());
        }
        
        return kategoriak;
    }

    //////////////////////////////////////////////// ab müveletek //////////////////////////////////////////////// 
    
      public int termekHozzadasa(String telepules, String nev, String leiras, int kategoriaId, int ar, String kep, int mennyiseg) {
       try {
            PreparedStatement ps = kapcsolat.prepareStatement("INSERT INTO termek VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, kategoriaId);
            ps.setString(2, nev);
            ps.setString(3, leiras);
            ps.setInt(4, ar);
            ps.setInt(5, mennyiseg);
            ps.setString(6, kep);
            ps.setString(7, telepules);
            
            ps.executeUpdate();
            
            ResultSet generatedKeys = ps.getGeneratedKeys();
            
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
            else {
               hibaUzenet("Ismeretlen hiba! Termék hozzáadása sikertelen!"); //na ide nem kéne eljutni
               return -1;
            }

        } catch (SQLException ex) {
            hibaUzenet("Termék hozzáadása sikertelen!\nDetails: " + ex.getMessage());
            return -1;
        }
    }

    public void termekTorlese(int id) {
        try {
            PreparedStatement ps = kapcsolat.prepareStatement("DELETE FROM termek WHERE id = ?");
            
            ps.setInt(1, id);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            hibaUzenet("Termék törlése sikertelen! ID" + id + "\nDetails: " + ex.getMessage());
        }
    }
    
    public void arvaltoztatas(int id, int ujAr) {
        try {            
            PreparedStatement ps = kapcsolat.prepareStatement("UPDATE termek SET ar = ? WHERE id = ?");
            
            ps.setInt(1, ujAr);
            ps.setInt(2, id);
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            hibaUzenet("Termék árának megváltoztatása sikertelen! ID" + id + "\nDetails: " + ex.getMessage());
        }
    }
    
    private void hibaUzenet(String hibauzenet) {
        //??
    }



}
