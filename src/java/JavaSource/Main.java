package JavaSource;



public class Main {
    public static Modell modell = new Modell(new Adatbazis(
        "jdbc:sqlserver://localhost:1433;"
            + "databaseName=webaruhaz;"
            + "user=B;" 
            + "password=B;"
    ));
    
      
}
