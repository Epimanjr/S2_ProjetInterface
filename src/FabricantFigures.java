import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 * Classe FabricantFigures
 * @author Maxime Blaise
 *
 */
public class FabricantFigures implements MouseListener {
	
	/**
	 * Attribut qui représente la figure en cours de fabrication.
	 */
	private FigureColoree figure_en_cours_de_fabrication;
	
	/**
	 * Attribut qui comte le nombre de points cliqués.
	 */
	private int nb_points_cliques;
	
	/**
	 * Attribut qui représente les points correspondant aux clics de souris.
	 */
	private Point[] points_cliques;
	
	private JLabel labelCount;
	
	private JButton b1;
	private JButton b2;
	
	/**
	 * Constructeur vide initialisant les trois attributs.
	 * @param fc
	 * @param bColorConfirm 
	 * @param bColor 
	 */
	public FabricantFigures(FigureColoree fc, JLabel jl, JButton bColor, JButton bColorConfirm) {
		this.figure_en_cours_de_fabrication = fc;
		this.nb_points_cliques=0;
		this.points_cliques=new Point[fc.nbClics()];
		this.labelCount=jl;
		this.b1=bColor;
		this.b2=bColorConfirm;
	}
	
	/**
	 * C'est grace à cette méthode que l'utilisateur pourra cliquer et créer des formes géométriques.
	 */
	public void mousePressed(MouseEvent e) {
		this.points_cliques[nb_points_cliques]=new Point(e.getX(),e.getY());
		this.nb_points_cliques++;
		this.labelCount.setText(""+this.nb_points_cliques+" points cliques.");
		
		// Une fois atteint le nombre de clics voulu
		if(this.nb_points_cliques==this.figure_en_cours_de_fabrication.nbClics()) {
			this.figure_en_cours_de_fabrication.modifierPoints(this.points_cliques);
			((JComponent)(e.getSource())).removeMouseListener(this);
			((DessinFigures)(e.getSource())).ajoute(this.figure_en_cours_de_fabrication);
			this.labelCount.setText(""+this.nb_points_cliques+" points cliques."+" -->Figure construire avec succes !<--");
			this.b1.setEnabled(true);
			this.b2.setEnabled(true);
		}
	}
	
	// Methode a� redefinir, mais on ne les utilise pas.
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
}
