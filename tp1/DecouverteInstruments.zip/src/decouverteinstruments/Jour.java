/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decouverteinstruments;

/**
 *
 * @author culeta
 */
public enum Jour {
    mercredi("mercredi"),
    vendredi("vendredi"),
    samedi("samedi");
    
    private String nomJour = " ";
    Jour (String n) {
        nomJour = n;
    }
}
