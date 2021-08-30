
package MODEL;


public class Ordonnace {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosologie() {
        return Posologie;
    }

    public void setPosologie(String Posologie) {
        this.Posologie = Posologie;
    }

    public int getQte() {
        return Qte;
    }

    public void setQte(int Qte) {
        this.Qte = Qte;
    }

    public int getIdMed() {
        return IdMed;
    }

    public void setIdMed(int IdMed) {
        this.IdMed = IdMed;
    }
    private int id;
    private String Posologie;
    private int Qte;
    private int IdMed;
    
     public Ordonnace(){
        super();
    }
    	
}

