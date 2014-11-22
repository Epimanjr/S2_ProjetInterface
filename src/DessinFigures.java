import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Classe DessinFigures
 * @author Maxime Blaise
 */
public class DessinFigures extends JPanel{
	
	private DessinFigures.ManipulateurFormes mf;
	/**
	 * Tableau de figures - Jusqu'à 100 figures.
	 */
	public ArrayList<FigureColoree> figures;
	
	/**
	 * Nombre de figures.
	 */
	private int nbf;
	
	/**
	 * Indice de la figure sélectionnée.
	 * -1 si aucune figure.
	 */
	public int sel;

	/**
	 * Constructeur vide qui initialise les attributs nbf et sel.
	 * Puis nous créeons un tableau de 100 FigureColoree.
	 */
	public DessinFigures() {
		this.nbf=0;
		this.sel=-1;
		this.figures=new ArrayList<FigureColoree>();
	}
	
	/**
	 * Méthode qui ajoute une nouvelle figure.
	 * @param fc Type : FigureCOloree
	 */
	public void ajoute(FigureColoree fc)
	{
		if(fc!=null)
		{
			this.figures.add(nbf,fc);
			//if(sel!=-1) this.figures.get(sel).deSelectionne();
			//sel=nbf;
			//fc.selectionne();
			nbf++;
		}
		repaint();
	}
	
	public void supprime() {
		if(sel!=-1) {
			FigureColoree fc2 = figures.get(sel);
			fc2.deSelectionne();
			figures.remove(sel);
		}
		sel=-1;
		nbf--;
		repaint();
	}
	
	public void supprimeTout() {
		if(sel!=-1) {
			FigureColoree fc2 = figures.get(sel);
			fc2.deSelectionne();
		}
		figures.clear();
		repaint();
		nbf=0;
		sel=-1;
	}
	
	/**
	 * Méthode qui retourne le nombre de figures.
	 * @return nbf
	 */
	public int nbFigures() 
	{
		return nbf;
	}
	
	public void setNbf(int n) {
		this.nbf=n;
	}
	
	
	/**
	 * Méthode qui retourne la figure sélectionnée.
	 * @return FigureColoree
	 */
	public FigureColoree figureSelection()
	{
		if(sel!=-1)
			return this.figures.get(sel);
		return null;
	} 
	
	/**
	 * Méthode qui sélectionne la prochaine figure.
	 */
	public void selectionProchaineFigure()
	{
		this.figures.get(sel).deSelectionne();
		if(this.sel==0)	sel=nbf-1;
		else sel--;
		FigureColoree fcRecup = this.figures.get(sel);
		while(fcRecup == null) {
			if(this.sel==0)	sel=nbf-1;
			else sel--;
			fcRecup = this.figures.get(sel);
		}
			this.figures.get(sel).selectionne();
		repaint();
	}
	
	/**
	 * Cette méthode permet de redessiner toutes les figures du dessin.
	 * @param g Type : Graphics
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		/* 
		 * 
		 * A COMPLETER AVEC ITERATOR !
		 */
		
		ListIterator<FigureColoree> it = this.figures.listIterator();
		while(it.hasNext()) {
			it.next().affiche(g);
		}
		
		this.setBackground(Color.white);

		// Récuperer le contour du Panel et dessiner un rectangle
	}
	
	/**
	 * Cette méthode permet un tracé à la souris.
	 * @param c
	 */
	 
	public void trace(Color c) {
		Graphics cg = this.getGraphics();
		cg.setColor(c);
		TraceurForce tf=new TraceurForce(cg);
		this.addMouseListener(tf);
		this.addMouseMotionListener(tf);
	}
	
	/**
	 * Méthode qui active les manipulations par la souris.
	 */
	public void activeManipulationsSouris(JLabel jl) {
		ManipulateurFormes mf = new ManipulateurFormes(jl);
		this.addMouseListener(mf);
		this.addMouseMotionListener(mf);
	}
	
	/**
	 * Cette méthode permet de fabriquer des figures géométriques à l'aide de la souris.
	 * Utilisation des évènements.
	 * @param fc
	 * @param bColorConfirm 
	 * @param bColor 
	 */
	public void construit(FigureColoree fc, JLabel jl, JButton bColor, JButton bColorConfirm) {
		FabricantFigures ff = new FabricantFigures(fc, jl, bColor, bColorConfirm);
		this.addMouseListener(ff);
	}
	
	private class ManipulateurFormes implements MouseListener,MouseMotionListener {
		
		/**
		 * Attributs de type int, pour stocker des coordonnées.
		 */
		private int last_x, last_y;
		
		private JLabel labelFigure;
		
		public ManipulateurFormes(JLabel jl) {
			this.labelFigure=jl;
		}
		
		public String figureSelectionnee(FigureColoree fc) {
			if(fc instanceof Carre) return "carre";
			if(fc instanceof Rectangle) return "rectangle";
			if(fc instanceof Triangle) return "triangle";
			if(fc instanceof Quadrilatere) return "quadrilatere";
			if(fc instanceof Cercle) return "cercle";
			if(fc instanceof Losange) return "Losange";
			if(fc instanceof Trapeze) return "trapeze";
			
			return "null";
		}

		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			if(SwingUtilities.isLeftMouseButton(e)) {
				last_x=e.getX();
				last_y=e.getY();
				if(sel!=-1) {
					figureSelection().deSelectionne();
					((DessinFigures)(e.getSource())).sel=-1;
				}
				
				ListIterator<FigureColoree> it = figures.listIterator();
				int i=0;
				while(it.hasNext()) {
					FigureColoree fc1 = it.next();
					if(fc1.estDedans(last_x, last_y)) {
						fc1.selectionne();
						((DessinFigures)(e.getSource())).sel=i;
					}
					i++;
				}
				
				/* for(int i=0;i<nbf;i++) {
					if (((DessinFigures)(e.getSource())).figures.get(i).estDedans(last_x, last_y)) {
						figures.get(i).selectionne();
						((DessinFigures)(e.getSource())).sel=i;
					}
				} */
				repaint();
				String s = figureSelectionnee(figureSelection());
				if(s.equals("null")) {
					this.labelFigure.setText("Vous n'avez rien selectionne");
				} else {
					this.labelFigure.setText("Vous avez selectionne un "+s);
				}
			}
			else if(SwingUtilities.isRightMouseButton(e)) {
				((JComponent)(e.getSource())).removeMouseListener(this);
				((JComponent)(e.getSource())).removeMouseMotionListener(this);
				((JComponent)(e.getSource())).repaint();
			}
		}
		public void mouseReleased(MouseEvent e) {}

		public void mouseDragged(MouseEvent e) {
			int diffX = e.getX()-last_x;
			int diffY = e.getY()-last_y;
			if(sel!=-1) figures.get(sel).translation(diffX, diffY);
			repaint();
			last_x=e.getX();
			last_y=e.getY();
		}
		public void mouseMoved(MouseEvent e) {}
		
	}
}
