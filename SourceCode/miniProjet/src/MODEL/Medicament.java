
package MODEL;


public class Medicament {

    public int getIdM() {
        return IdM;
    }

    public void setIdM(int IdM) {
        this.IdM = IdM;
    }

    public String getIdMed() {
        return IdMed;
    }

    public void setIdMed(String IdMed) {
        this.IdMed = IdMed;
    }

    public String getNomMed() {
        return NomMed;
    }

    public void setNomMed(String NomMed) {
        this.NomMed = NomMed;
    }
    
    private int IdM;
    private String IdMed;
    private String NomMed;
    
    public Medicament(){
        super();
    }
     public Medicament(String IdMed, String NomMed){
         this.IdMed=IdMed;
         this.NomMed=NomMed;
     }
    	
    
}
