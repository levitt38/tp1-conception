/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decouverteinstruments;

public class JourSeance {
    private Jour jour;
    private Enfant enfant;
    private Instrument instrument;
    
    
    public JourSeance(Jour jour, Enfant enfant, Instrument instrument) {
        this.jour = jour;
        this.enfant = enfant;
        this.instrument = instrument;
    }

    public Jour getJour() {
        return jour;
    }

    public Enfant getEnfant() {
        return enfant;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    private void setJour(Jour jour) {
        this.jour = jour;
    }

    private void setEnfant(Enfant enfant) {
        this.enfant = enfant;
    }

    private void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }
    
    
    
    
    
    
    
    
}
