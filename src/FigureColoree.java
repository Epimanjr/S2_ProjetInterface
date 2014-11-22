import java.awt.Color;
import java.awt.Graphics;

/**
 * Classe FigureColoree
 * @author Maxime Blaise
 *
 */
public abstract class FigureColoree {
	/**
	 * Tableau des points de la figure
	 */
	protected Point[] tab_mem;
	
	/**
	 * Attribut qui donne la couleur de la figure
	 */
	protected Color couleur;
	
	/**
	 * Attribut qui indique si la figure est sélectionné
	 */
	private boolean selected;
	
	/**
	 * Constructeur vide. Initialise les attributs "selected" et "couleur", 
	 * ainsi que le tableau de mémorisation.
	 */
	public FigureColoree() 
	{
		tab_mem=new Point[this.nbPoints()];
		selected=false;
		couleur=Color.red; // I find that green is a beautiful color.
	}
	
	/**
	 * Si la figure est sélectionnée, on affiche des petits
	 * carrés autour des points de la figure.
	 * @param g
	 */
	public void affiche(Graphics g)
	{
		if(selected)
		{
			g.setColor(Color.black);
			for(int i=0;i<tab_mem.length;i++)
			{
				g.fillRect(tab_mem[i].rendreX()-2, tab_mem[i].rendreY()-2, 4, 4);
			}
			g.setColor(couleur);
		}
	}
	
	/**
	 * Permet de changer la couleur de la figure
	 * @param c de type Color
	 */
	public void changeCouleur(Color c) {
		this.couleur=c;
	}
	
	/**
	 * Pour désélectionner la figure.
	 */
	public void deSelectionne() {
		this.selected=false;
	}
	
	/**
	 * Méthode permettant de modifier l'attribut tab_mem
	 * @param ps Type : Point[] (Tableau de point)
	 */
	public abstract void modifierPoints(Point[] ps);
	
	/**
	 * Méthode qui retourne le nombre de clics nécessaires 
	 * à la création de la figure concernée
	 * @return Type : int (nbClics)
	 */
	public abstract int nbClics();
	
	/**
	 * Méthode qui retourne le nombre de points nécessaires 
	 * à la création de la figure concernée
	 * @return Type : int (nbPoints)
	 */
	public abstract int nbPoints();
	
	/**
	 * Pour sélectionner la figure.
	 */
	public void selectionne() 
	{
		this.selected=true;
	}
	
	/**
	 * Méthode qui effectue une translation de la figure.
	 * @param dx
	 * @param dy
	 */
	public void translation(int dx, int dy)
	{
		// Parcours du tableau des points de mémorisation
		for(int i=0;i<tab_mem.length;i++)
		{
			tab_mem[i].translation(dx, dy);
		}
	}
	
	/**
	 * Méthode abstraite.
	 * @param x Abscisse du point
	 * @param y Ordonnée du point
	 * @return
	 */
	public abstract boolean estDedans(int x, int y);
}
