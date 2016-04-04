/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decouverteinstruments;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author goulian
 */
public class DonneesUtilitaire {
    
    // Fichier de sérialisation
	private static final String DB_FILE = "src/ateliers.db";
    
    /**
     * Met à jour du fichier de sérialisation
     * @return 
     */
    public static boolean updateDB(Appli ff) {
        return saveDB(ff);
    }

    
   /**
    * Sauvegarde du fichier de sérialisation
    * @return 
    */
	
    private static boolean saveDB(Appli ff) {
        File file;
        boolean success = true;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;            
        
        file = new File(DB_FILE);
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(ff.getInstruments());
            oos.writeObject(ff.getEnfants());
        }
        catch (Exception e) {
            System.out.println("SAVE" + e);
            success = false;
        }
        finally {
                if (oos != null) { 
                    try { oos.close(); }
                    catch(IOException e) {}
                }
                
                if (fos != null) { 
                    try { fos.close(); }
                    catch(IOException e) {}
                }
            
        }
        
        return success;
    }
    
    /**
     * Chargement des données à partir d'un fichier de sérialisation
     * @return 
     */
    public static boolean loadDB(Appli ff) {
        boolean success = true;
        File file = new File(DB_FILE);
        
        if (file.exists()) {
            FileInputStream fis = null;
            ObjectInputStream ois = null;            

            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);
                
                ff.setInstruments( (HashMap<String, Instrument>) ois.readObject());
                ff.setEnfants( (HashMap<String, Enfant>) ois.readObject());

            }             
            catch(Exception e) {
                System.out.println("LOAD" + e);
                success = false;
            }
            finally {
                if (ois != null) { 
                    try { ois.close(); }
                    catch(IOException e) {}
                }
                
                if (fis != null) { 
                    try { fis.close(); }
                    catch(IOException e) {}
                }
            }
        } else { success = false; }
        
        return success;
    }

    
    
}
