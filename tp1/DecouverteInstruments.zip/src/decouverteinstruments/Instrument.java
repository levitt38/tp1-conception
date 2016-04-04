package decouverteinstruments;


import java.io.Serializable;
import java.util.HashSet;

public class Instrument implements java.io.Serializable {
	private String nomInstrument;
        private HashSet<JourSeance> joursSeance;
        
        
        public Instrument(String nom ){
            this.nomInstrument = nom;
            joursSeance = new HashSet<>();
        }

    public String getNomInstrument() {
        return nomInstrument;
    }

    public HashSet<JourSeance> getJoursSeance() {
        return joursSeance;
    }

    private void setNomInstrument(String nomInstrument) {
        this.nomInstrument = nomInstrument;
    }

    private void setJoursSeance(HashSet joursSeance) {
        this.joursSeance = joursSeance;
    }
    
    private void addJoursSeance (JourSeance jourSeance){
        this.getJoursSeance().add(jourSeance);
    }
    
    public void Inscrire(JourSeance jourSeance){
        this.addJoursSeance(jourSeance);
    }
        
    public void Affiche() {
        System.out.println(this.getNomInstrument());
    }    
        
    public void Exception() {
        if (this == null) {
            throw new NullPointerException();
        }
    }
        
}
