import java.awt.Graphics;
import java.awt.Polygon;

/**
 * Classe Polygone 
 * @author Maxime Blaise
 *
 */
public abstract class Polygone extends FigureColoree {
	
	private Polygon p;
	
	/**
	 * Constructeur vide permettant de créer un polygone aléatoire.
	 */
	public Polygone() 
	{
		super();
	}
	
	/**
	 * Méthode qui affiche un polynome.
	 * @param g 
	 */
	public void affiche(Graphics g)
	{
		p = new Polygon();
		for(int i=0;i<tab_mem.length;i++)
		{
			p.addPoint(tab_mem[i].rendreX(), tab_mem[i].rendreY());
		}
		g.setColor(couleur);
		g.fillPolygon(p);
		super.affiche(g);
	}
	
	/**
	 * Méthode qui retourne le nombre de clics nécessaires
	 * à la saisie d'un polygone.
	 * @return Type : int (NbClics)
	 */
	public int nbClics()
	{
		return 4;
	}
	
	/**
	 * Méthode qui retourne le nombre de points nécessaires
	 * à la saisie d'un polygone.
	 * @return Type : int (NbPoints)
	 */
	public int nbPoints()
	{
		return 4;
	}
	
	/**
	 * Méthode qui modifie le polygone
	 * @param tab_saisie Tableau qui contient des nouveaux points.
	 */
	public void modifierPoints(Point[] tab_saisie)
	{
		if(tab_saisie != null)
			if(tab_saisie.length==this.nbPoints())
				this.tab_mem = tab_saisie;
	}
	
	public boolean estDedans(int x, int y) {
		return p.contains(x,y);
	}

}
