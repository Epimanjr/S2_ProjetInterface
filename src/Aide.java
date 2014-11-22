 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author Ptero
 *
 */
public class Aide extends JFrame {

	/**
	 * Constructeur vide permettant la création d'une nouvelle fenêtre d'aide
	 */
	public Aide() {
		this.setTitle("Aide et support Projet_V4");
		this.setPreferredSize(new Dimension(640,480));
		this.setResizable(false);
		this.setLocation(280,60);
		this.setIconImage(new ImageIcon(this.getClass().getResource("icon.png")).getImage());
		this.setAlwaysOnTop(true); // Permet de laisser toujours la fenetre au premier plan.
		
		JPanel mainPan = new JPanel();
		this.setContentPane(mainPan);
		mainPan.setLayout(new BorderLayout());
		
		JPanel pan0 = new JPanel();
		final JLabel labelTexte = new JLabel("");
		
		JPanel pButton = new JPanel();
		pButton.setLayout(new BoxLayout(pButton,BoxLayout.LINE_AXIS));
		JButton[] but = { new JButton("         1. Aide pour construire            "), 
							new JButton("         2. Aide pour tracé            "), 
							new JButton("         3. Aide pour manipuler            ") };

		ActionListener[] al = new ActionListener[3];
		al[0] = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = completePan1();
				labelTexte.setText(s);
			}
		};
		
		al[1] = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = completePan2();
				labelTexte.setText(s);
			}
		};
		
		al[2] = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = completePan3();
				labelTexte.setText(s);
			}
		};
		
		for(int i=0;i<3;i++) {
			but[i].addActionListener(al[i]);
			pButton.add(but[i]);
		}
		
		String s="";
		s=completePan0();
		labelTexte.setText(s);
		
		pan0.add(labelTexte);
		pan0.setBackground(new Color(200,200,255));
		mainPan.add(pButton,BorderLayout.NORTH);
		pButton.setBackground(new Color(150,150,150));
		mainPan.add(pan0,BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Complète le label de la page d'accueil de l'aide
	 * @return texte du label
	 */
	private String completePan0() {
		String s="";
	
		s+="<html> <font size=\"+2\">Bienvenue dans l'assistant d'aide du Projet (V4.0)</font> <br><br><br>" +
               " <p><br><br> Afin de trouver la réponse à vos questions, <br>veuillez cliquez sur un des trois boutons ci-dessus.</p><br><br>"+
                "<p>Boutton 1 -> Si vous n'arrivez pas à construire une figure correctement.<br><br>   </p>" +
                "<p>Boutton 2 -> Si vous n'arrivez pas à faire un tracé à main levée.    <br><br></p>" +
                "<p>Boutton 3 -> Si vous n'arrivez pas à manipuler une figure.  </p><br><br><br><br><br><br><br><br>" +
                "<p><a href=\"mailto:maxime.blaise@outlook.fr\">Contact : maxime.blaise@outlook.fr</a><br> " +
                "<p>©Maxime Blaise, 2013</p></html>";
		return s;
	}
	
	/**
	 * Complète le label si le premier bouton est cliqué.
	 * @return texte du label
	 */
	private String completePan1() {
		String s="";
		
		s+="<html> <font size=\"+2\">Page d'aide de construction d'une figure colorée</font> <br><br><br>" + 
			"<p>Etape 1 : vérifier que la case \"Nouvelle figure\" soit cochée. (si non, cochez la) </p><br><br> " +
			"<p>Etape 2 : changer la figure en question, ou la couleur à l'aide des deux menus déroulants.   </p><br><br>" +
			"<p>Etape 3 : Cliquez sur le boutton \"Construire!\" puis effectuer les clics nécessaires dans la zone de dessin prévue. </p><br><br><br>" +
			"<p>  NORMALEMENT, vous devriez avoir aucun soucis pour créer des figures géométriques !    </p></html>";
		return s;
	}
	
	/**
	 * Complète le label si le deuxième bouton est cliqué.
	 * @return texte du label
	 */
	private String completePan2() {
		String s="";
		
		s+="<html> <font size=\"+2\">Page d'aide d'un tracé à main levée</font> <br><br><br>" + 
				"<p>Etape 1 : vérifier que la case \"Tracé à main levée\" soit cochée. (si non, cochez la) </p><br><br> " +
				"<p>Etape 2 : si vous le souhaitez, vous pouvez changer la couleur de ce tracé. (menu déroulant)   </p><br><br>" +
				"<p>Etape 3 : avec la souris, restez appuyé sur le clic gauche et dessinez. </p><br>" +
				"<p>  NOTE : Ne pas oublier d'appuyer sur ApplyColor, quand vous voulez changer la couleur.  </p><br><br>" +
				"<p>  NORMALEMENT, vous devriez avoir aucun soucis pour dessiner !   </p></html>";
		
		return s;
	}
	
	
	/**
	 * Complète le label si le troisième bouton est cliqué.
	 * @return texte du label
	 */
	private String completePan3() {
		String s="";
		
		s+="<html> <font size=\"+2\">Page d'aide de manipulations de figures</font> <br><br><br>" + 
				"<p>Etape 1 : vérifier que la case \"Manipulations\" soit cochée. (si non, cochez la) </p><br><br> " +
				"<p>Etape 2 : pour manipuler une quelconque figure, il faut la sélectionné en cliquant dessus (vous serez guidé).   </p><br><br>" +
				"<p>Etape 3 : vous pouvez changer la couleur de cette figure, ou bien la déplacer. </p><br>" +
				"<p>  NOTE : Ne pas oublier d'appuyer sur ApplyColor, quand vous voulez changer la couleur.  </p><br><br>" +
				"<p>  NORMALEMENT, vous devriez avoir aucun soucis pour manipiuler des figures géométriques !    </p></html>";
		return s;
	}
	
	
	
	
}
