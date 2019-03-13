/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafiskbilletautomat;

import javax.swing.JFrame;

/**
 *
 * @author Adam OG MADS
 */
public class GrafiskBilletAutomat {
    
	public static void main(String[] arg)
	{
		MitJPanel panel = new MitJPanel();        // opret panelet

		JFrame vindue = new JFrame("Billet Automaten");    // opret et vindue på skærmen
		vindue.add( panel );                          // vis panelet i vinduet

		vindue.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // reagér på luk
		vindue.pack();                       // sæt vinduets størrelse
		vindue.setResizable(false);
		vindue.setVisible(true);                      // åbn vinduet
	  
	}

}
