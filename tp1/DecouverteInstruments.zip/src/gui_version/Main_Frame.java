/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui_version;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author nourik
 */
public class Main_Frame extends JFrame{
    private JPanel panel_main, panel_center, panel_right, panel_c_south, panel_c_north;
    private JTextPane textpane;
    private JButton but1, but2;
    private JScrollPane scrollpane;
    private JComboBox combobox;
    private JRadioButton rb1, rb2, rb3, rb4, rb5;
    
    public Main_Frame() {
        super();
        this.setTitle("");
        this.setSize(new Dimension(500,350));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(this.buildPanel());
    }
    
    public JPanel buildPanel(){
        panel_main = new JPanel(new BorderLayout());
        panel_center = new JPanel(new BorderLayout()); panel_right = new JPanel(new BorderLayout());
        panel_center.setPreferredSize(new Dimension(350,0)); panel_right.setPreferredSize(new Dimension(150,0));
        
        panel_c_north = new JPanel(new BorderLayout()); panel_c_south = new JPanel(new BorderLayout());
        panel_center.add(panel_c_north, BorderLayout.NORTH); panel_center.add(panel_c_south, BorderLayout.SOUTH); 
        
        combobox = new JComboBox(); combobox.setPreferredSize(new Dimension(90,50));
        but2 = new JButton("Affichez"); but2.setPreferredSize(new Dimension(70,50));
        panel_c_south.add(combobox, BorderLayout.WEST); panel_c_south.add(but2, BorderLayout.EAST);
        
        
                
        
        panel_main.add(panel_center, BorderLayout.CENTER); panel_main.add(panel_right, BorderLayout.EAST);
        return panel_main;
    }
    
}
