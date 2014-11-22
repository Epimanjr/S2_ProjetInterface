// ENCODING WITH UTF-8

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * @author Maxime Blaise
 * @version 4.0
 */
public class Fenetre extends JFrame {
	
	/**
	 * Attribut dessin, qui représente le Panel sur lequel on va construire
	 * et manipuler des figures.
	 */
	private DessinFigures dessin;
	
	/**
	 * Constructeur de la classe Fenetre, permettant l'initialisation de la fenêtre
	 * avec le titre et les dimensions.
	 * @param s Titre de la fenetre
	 * @param w Largeur de la fenetre
	 * @param h Hauteur de la fenetre
	 */
	public Fenetre(String s, int w, int h) {
		// Création de la fenetre
		JFrame fenetre = new JFrame();
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Création du JPanel de base (le container)
		JPanel jPanelFond = new JPanel();
		jPanelFond.setLayout(new BorderLayout());
		
		// Création des Panels dessin et panneauxChoix
		this.dessin = new DessinFigures();
		this.dessin.setPreferredSize(new Dimension(w,h));
		PanneauChoix pc = new PanneauChoix();
		
		// Caractéristiques de la fenêtre
		fenetre.setTitle(s);
		fenetre.setContentPane(jPanelFond);
		fenetre.getContentPane().add(pc,BorderLayout.NORTH);
		fenetre.getContentPane().add(this.dessin,BorderLayout.CENTER);
		fenetre.setResizable(false);
		fenetre.setIconImage(new ImageIcon(this.getClass().getResource("icon.png")).getImage());
		fenetre.setLocation(600,300);
		fenetre.pack();
		fenetre.setVisible(true);
		
	}
	
	/**
	 * Méthode principale
	 * @param args
	 */
	public static void main(String[] args) {
		new Fenetre("Projet Interfaces Graphiques - V4",640,480);
	}
	
	public class PanneauChoix extends JPanel {
		
		/**
		 * Figure à construire
		 */
		private FigureColoree fc = null;
		private final JButton help = new JButton("Aide ?");
		private final JButton aPropos = new JButton("A Propos");
		private final JButton bEffacer = new JButton("Effacer");
		private final JButton bToutEffacer = new JButton("Tout effacer");
		private final JLabel jl = new JLabel("En attentes d'instructions ...");
		// Création des trois boutons radio
		private final JRadioButton[] jrb = { new JRadioButton("Nouvelle Figure") ,
									 new JRadioButton("Trace à main levée") ,
								   	 new JRadioButton("Manipulations") };
		private final JComboBox<String> jcbFigures =  new JComboBox<String>( new String[]{
				"Carré", "Cercle", "Losange", "Quadrilatère", 
				"Rectangle", "Trapeze", "Triangle"} );
		private final JButton bColor = new JButton("Color");
		private final JButton bColorConfirm = new JButton("Apply Color");
		private final JColorChooser jcc = new JColorChooser(Color.RED);
		private final JButton bConfirm = new JButton("Construire!");
		// Création des deux panels
		private final JPanel pHaut = new JPanel();
		private final JPanel pBas = new JPanel();
		final JLabel justSpace1 = new JLabel("                                          ");
		final JLabel justSpace2 = new JLabel("                      ");
		
		/**
		 * Constructeur de la classe PanneauChoix :
		 * Création de tous les boutons.
		 */
		public PanneauChoix() { 
	
			addActionListenerForHelp();
			addActionListenerForAPropos();
			addActionListenerForEffacer();
			addActionListenerForToutEffacer();
			addActionListererForBConfirm();
			AddActionListenerForRadioButton();
			AddActionListenerForBColor();
			
			jcbFigures.setEnabled(false);
			
			// Ajout de ces trois derniers dans un groupe
			ButtonGroup bg = new ButtonGroup();
			for(JRadioButton j : jrb) bg.add(j);

			AddComponentPanelHaut();
			AddComponentPanelBas();
						
			JPanel pLabel = new JPanel();
			pLabel.add(jl);
			
			// Ajout d'un Layout au panel this, puis ajout des deux Panel au panel principal (this)
			this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
			this.add(pHaut);
			this.add(pBas);
			this.add(pLabel);
		}
		
		
		private void AddComponentPanelBas() {
			// Ajout des deux combobox a ce panel	
			pBas.add(jcbFigures);
			pBas.add(bColor);
			pBas.add(bConfirm);
			pBas.add(bEffacer);
			pBas.add(bToutEffacer);
		}


		private void AddComponentPanelHaut() {
			// Ajout des trois boutons radio a ce panel
			pHaut.add(justSpace1);
			for(JRadioButton j : jrb)  pHaut.add(j);
			pHaut.add(justSpace2);
			pHaut.add(help);
			pHaut.add(aPropos);
		}


		private void AddActionListenerForBColorConfirm(final JFrame fColor) {
			bColorConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(jrb[1].isSelected()) {
						removeListener();
						dessin.trace(jcc.getColor());
					}
					if(jrb[2].isSelected()) {
						if(!dessin.figures.isEmpty())
							dessin.figures.get(dessin.sel).changeCouleur(jcc.getColor());
						dessin.repaint();
					}
					fColor.setVisible(false);
				}
			});
		}


		private void AddActionListenerForBColor() {
			bColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					final JFrame fColor = new JFrame();
					fColor.setTitle("Sélection de couleur");
					
					JPanel fColorPan = new JPanel();
					fColorPan.add(jcc);
					fColor.setContentPane(fColorPan);
					fColor.getContentPane().add(bColorConfirm);
					AddActionListenerForBColorConfirm(fColor);
					
					fColor.setResizable(false);
					fColor.pack();
					fColor.setVisible(true);
				}
			});
		}


		private void AddActionListenerForRadioButton() {
			/* Création des événements */
			ActionListener[] al = new ActionListener[3];
			addActionListenerForRadioButton1(al[0]);
			addActionListenerForRadioButton2(al[1]);
			addActionListenerForRadioButton3(al[2]);

		}


		private void addActionListenerForRadioButton3(ActionListener al) {
			// Evènement pour le boutton "Manipulation"
						al = new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								removeListener(); // On enlève tous les Listener du Panel dessin
								jl.setText("Manipulation de figures.");
								jcbFigures.setEnabled(false);
				
								bConfirm.setEnabled(false);
								dessin.activeManipulationsSouris(jl);
							}
						};
						jrb[2].addActionListener(al);
		}


		private void addActionListenerForRadioButton2(ActionListener al) {
			// Evénement pour le boutton "Trace a main levée"
						al = new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								removeListener(); // On enlève tous les Listener du Panel dessin
								//int i = ((JComboBox)(e.getSource())).getSelectedIndex();
								bColor.setEnabled(true);
								bColorConfirm.setEnabled(true);
								jcbFigures.setEnabled(false);
								bConfirm.setEnabled(false);
								bEffacer.setEnabled(true);
								bToutEffacer.setEnabled(true);
								jl.setText("Clic gauche tenu pour dessiner, clic droit pour finir.");
								dessin.trace(jcc.getColor());
							}
						};
						jrb[1].addActionListener(al);
		}


		private void addActionListenerForRadioButton1(ActionListener al) {
			al = new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					removeListener(); // On enlève tous les Listener du Panel dessin
					bEffacer.setEnabled(true);
					bConfirm.setEnabled(true);
					bToutEffacer.setEnabled(true);
					jcbFigures.setEnabled(true); 
				}
			};
			jrb[0].addActionListener(al);
		}


		public void addActionListererForBConfirm() {
			bConfirm.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bColor.setEnabled(false);
					bColorConfirm.setEnabled(false);
					
					fc=creeFigure(jcbFigures.getSelectedIndex());
					//fc.changeCouleur(determineColor(jcb[1].getSelectedIndex()));
					fc.changeCouleur(jcc.getColor());
					
					jl.setText("Cliquez sur les "+fc.nbClics()+" qui définissent la figure.");
					dessin.construit(fc, jl, bColor,bColorConfirm);
					repaint();
					
					bEffacer.setEnabled(true);
					bToutEffacer.setEnabled(true);
				}
			});
			bConfirm.setEnabled(false);
		}


		private void addActionListenerForToutEffacer() {
			bToutEffacer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dessin.supprimeTout();
					bEffacer.setEnabled(false);
					bToutEffacer.setEnabled(false);
					
					if(jrb[1].isSelected()) {
						dessin.trace(jcc.getColor());
						bEffacer.setEnabled(true);
						bToutEffacer.setEnabled(true);
					}
				}	
			});
		}


		private void addActionListenerForEffacer() {
			bEffacer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!dessin.figures.isEmpty())  {
						dessin.supprime();
					} 
					
					if(dessin.figures.isEmpty()) {
						removeListener();
						bEffacer.setEnabled(false);
						bToutEffacer.setEnabled(false);
					}
					
					if(jrb[1].isSelected()) {
						dessin.trace(jcc.getColor());
						bEffacer.setEnabled(true);
						bToutEffacer.setEnabled(true);
					}
					dessin.repaint();
				}	
			});
		}


		public void addActionListenerForAPropos() {
			aPropos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new APropos();
					
				}
			});
		}


		public void addActionListenerForHelp() {
			help.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new Aide();
					
				}
			});	
		}


		/**
		 * Méthode permettant d'enlever tous les Listeners present.
		 */
		public void removeListener()  {
			MouseListener[] tab1 = (MouseListener[])(dessin.getListeners(MouseListener.class));
			MouseMotionListener[] tab2 = (MouseMotionListener[])(dessin.getListeners(MouseMotionListener.class));
			for(int i=0;i<tab1.length;i++) dessin.removeMouseListener(tab1[i]);
			for(int i=0;i<tab2.length;i++) dessin.removeMouseMotionListener(tab2[i]);
		}
		
		/**
		 * Détermine et creer une nouvelle figure en fonction de l'index
		 * @param index
		 * @return FigureColoree
		 */
		public FigureColoree creeFigure(int index) {
			switch(index) {
			case 0:
				fc=new Carre();
				break;
			case 1:
				fc=new Cercle();
				break;
			case 2:
				fc=new Losange();
				break;
			case 3:
				fc=new Quadrilatere();
				break;
			case 4:
				fc=new Rectangle();
				break;
			case 5:
				fc=new Trapeze();
				break;
			case 6:
				fc=new Triangle();
				break;
			}
			
			return fc;
		}
		
		
	}
}
