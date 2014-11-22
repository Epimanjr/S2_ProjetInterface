import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Ptero
 *
 */
public class APropos extends JFrame {
	
	/**
	 * Constructeur permettant la création d'une fenêtre avec les informations.
	 */
	public APropos() {
		this.setTitle("A Propos du Projet_V4");
		this.setPreferredSize(new Dimension(640,680));
		this.setResizable(false);
		this.setLocation(280,60);
		this.setIconImage(new ImageIcon(this.getClass().getResource("icon.png")).getImage());
		this.setAlwaysOnTop(true); // Permet de laisser toujours la fenetre au premier plan.		
		JPanel mainPan = new JPanel();
		this.setContentPane(mainPan);
		
		JLabel label = new JLabel("");
		String s="";
		
		s+="<html> <font size=\"+2\">À PROPOS ! (Version actuelle : 4.0) </font> <br><br>" + 
				"<p> À venir très prochainement : <br>->[AJOUTE!] Menu de sélection des couleurs<br>-> Capacité d'enregistrer vos dessins<br>-> [AJOUTE!] Intégration d'autres figures géométriques<br>-> Ajout des figures géométriques à N côtés.</p><br><br> " +
				"<p> Version actuelle : <br><font size=\"+1\">NOUVEAUTE : Gestion de sauvegarde par ArrayList !</font> <br><br>-> Ajout du boutton \"Construire!\" pour éviter les confusions du fonctionnement <br>" +
				"-> Ajout du boutton \"Effacer\" qui permet de supprimer la figure sélectionnée<br>-> Ajout du boutton \"Tout Effacer\" qu permet de vider entièrement l'écran<br>" +
				"-> Ajout d'un menu complet d'aide, pour faciliter la compréhension<br>-> Ajout de texte intermédiaires facilitant les constructions</p><br><br>" +
				"<p>Version 3.0 : <br>-> Création de l'interface graphique TOTALE, pu besoin de la console pour utiliser le logiciel." +
				"<br>-> Correction de quelques bugs de la V2, notamment problème de sauvegarde (si le nombre de figures > 100)</p><br>" +
				"<p>Version 2.0 : <br>-> Première apparition de l'interface graphique : Aucun composant. (console)" +
				"<br>-> Ajout du tracé à main levée. <br>-> Possibilité de translater les figures avec la souris</p><br>"+
				
				"<p>Version 1.0 : <br>-> Programme entièrement en console. <br> -> Possibilité de construire quelques figures géométriques de base, aléatoirement<br>"+
				"-> Possibilité de translater la figure, et de changer sa couleur (toujours à l'aide de la console)</p><br><br><br><br>"+
				"<p><a href=\"mailto:maxime.blaise@outlook.fr\">Contact : maxime.blaise@outlook.fr</a><br>"+
				"©Maxime Blaise, 2013<br>" +
				"Remerciement à Antoine Dautreville pour le logo.</html>";
		
		label.setText(s);
		this.getContentPane().add(label);
		this.getContentPane().setBackground(new Color(200,200,255));
		this.pack();
		this.setVisible(true);
	}
}
