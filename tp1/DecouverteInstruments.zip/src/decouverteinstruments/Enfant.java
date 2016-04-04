/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decouverteinstruments;
import java.util.HashSet;

public class Enfant implements java.io.Serializable {
	private String nomEnfant;
        private HashSet<JourSeance> joursSeance;
        
        public Enfant(String nom){
            this.nomEnfant = nom;
            this.joursSeance = new HashSet<>();
        }

    public String getNomEnfant() {
        return nomEnfant;
    }

    public HashSet<JourSeance> getJoursSeance() {
        return joursSeance;
    }

    private void setNomEnfant(String nomEnfant) {
        this.nomEnfant = nomEnfant;
    }

    private void setJoursSeance(HashSet<JourSeance> joursSeance) {
        this.joursSeance = joursSeance;
    }
      
    private void addJoursSeance(JourSeance joursSeance) {
        this.getJoursSeance().add(joursSeance);
    }    
    
    public void Inscrire(JourSeance joursSeance) {
        this.addJoursSeance(joursSeance);
    }
    
    public void Affiche() {
        System.out.println(this.getNomEnfant());
    }
    
    public void Exception() {
        if (this == null) {
            throw new NullPointerException();
        }
    }
        
}
 

