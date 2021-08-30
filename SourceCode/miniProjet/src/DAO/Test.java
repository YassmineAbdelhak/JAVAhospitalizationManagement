
package DAO;
import DAO.MedicamentDAO;
import MODEL.Medicament;

import DAO.OrdonnanceDAO;
import MODEL.Ordonnace;

public class Test {
      public static void main(String[] args) {
      
          Medicament M1 =new Medicament();
                
		M1.setIdMed("ZERTTt");
		M1.setNomMed("fvlgkbk");
          Medicament M2 =new Medicament();
                
		M2.setIdMed("aaaaaA");
		M2.setNomMed("ffffBB");
          
           Medicament M3 =new Medicament();  
           
                M3.setIdMed("tttt");
                M3.setNomMed("gkglk");
                M3.setIdMed("aaaaaA");
           
           Ordonnace O1 = new Ordonnace();
                
                O1.setPosologie("abababa");
                O1.setQte(2);
                O1.setIdMed(1);
            
           Ordonnace O2 = new Ordonnace();
                
                O2.setPosologie("lllllmlml");
                O2.setQte(1);
                O2.setIdMed(2);
                O2.setId(1);
                       
          MedicamentDAO M1DAO = new MedicamentDAO();
          
          //M1DAO.AjouterMedicament(M1);
          //M1DAO.AjouterMedicament(M2);
          //M1DAO.SupprimerMedicament("ZERTTt");
         // M1DAO.ModifierMedicament(M3);
          //M1DAO.AfficherListeMedicament();
          //sM1DAO.RechercherMedicament("aaaaaA");
          
          OrdonnanceDAO O1DAO = new OrdonnanceDAO();
          
          //O1DAO.ModifierLigneOrdonnance(O2);
          //O1DAO.SupprimerLineOrdonnance(4);
          //O1DAO.EffacerTout();
          //O1DAO.AjouterLigneOrdonnace(O1);
          //O1DAO.AjouterLigneOrdonnace(O2);
          
          
      
      }
    
}
