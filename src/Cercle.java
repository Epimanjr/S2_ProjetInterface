import java.awt.Graphics;

/**
 * 
 * @author Maxime Blaise
 * @version 3.0
 */
public class Cercle extends ConiqueCentree {
	
	/**
	 * Attribut rayon, qui définit le rayon du cercle.
	 */
	private double rayon;
	
	/**
	 * Constructeur vide : Construit un cercle en prennant un centre et un rayon aléatoire.
	 */
	public Cercle() {
		super();
	}
	
	/**
	 * Cette méthode affiche un cercle.
	 * @param g Type : Graphics
	 */
	public void affiche(Graphics g) {
		g.setColor(couleur);
		int rayon = (int)(this.rendreRayon());
		g.fillOval(tab_mem[3].rendreX(), tab_mem[2].rendreY(), 2*rayon, 2*rayon);
		super.affiche(g);
	}
	
	/**
	 * Méthode qui permet de modifier les points du cercle.
	 * @param tab_saisie Type : Point[] (Tableau de points).
	 */
	public void modifierPoints(Point[] tab_saisie) {
		tab_mem[0]=tab_saisie[0];
		tab_mem[1]=tab_saisie[1];
		this.rayon = this.rendreRayon();
		int rayonI = (int)(this.rayon); // Afin de simplifier l'écriture.
		tab_mem[2]=new Point(tab_mem[0].rendreX(),tab_mem[0].rendreY()-rayonI);
		tab_mem[3]=new Point(tab_mem[0].rendreX()-rayonI,tab_mem[0].rendreY());
		tab_mem[4]=new Point(tab_mem[0].rendreX(),tab_mem[0].rendreY()+rayonI);
		
		/* la ligne suivante permet de modifier le point de mémorisation
		   afin d'optimiser l'affichage de la séléction. */
		tab_mem[1]=new Point(tab_mem[0].rendreX()+rayonI,tab_mem[0].rendreY());
	}
	
	/**
	 * Méthode qui retourne le nombre de clics nécessaires à la construction d'un cercle.
	 */
	public int nbClics() {
		return 2;
	}
	
	/**
	 * M�thode qui retourne le nombre de poitns n�cesaires � la construction d'un cercle.
	 * Dans cette version, le cercle contient 5 points de m�morisation, 
	 * pour une meilleure visibilit�.
	 */
	public int nbPoints() {
		return 5; 
		/* On pourrait retourner 2, mais pour optimiser l'affichage de la sélection, 
		   on prendra 5 points de m�morisation */
	}
	
	/**
	 * Méthode qui calcule le rayon d'un cercle, 
	 * c'est-à-dire la distance entre le centre un autre point de mémorisation.
	 * @return Type : Double <=> Rayon du cercle.
	 */
	public double rendreRayon() {
		return tab_mem[0].distance(tab_mem[1]);
	}
	
	/**
	 * Méthode permettant la translation de tous les points de mémorisation d'un cercle.
	 * @param dx type int, translation en abscisse
	 * @param dy type int, translation en ordonnée
	 */
	public void translation(int dx, int dy) {
		for(int i=0;i<tab_mem.length;i++) {
			tab_mem[i].translation(dx, dy);
		}
	}
	
	/**
	 * Si le point est dans le cercle, cette méthode retourne vrai, sinon faux.
	 * @param x Abcisse du point.
	 * @param y Ordonnée du point.
	 * @return booléen.
	 */
	public boolean estDedans(int x, int y) {
		Point p = new Point(x,y);
		
		double distance = p.distance(tab_mem[0]);
		double rayon=this.rendreRayon();
		
		if(distance<rayon) 
			return true;
		else 
			return false;
	}
	
	/**
	 * Méthode qui permet de modifier un point de mémorisation du Cercle.
	 * @param dx Translation sur l'axe des abscisses
	 * @param dy Translation sur l'axe des ordonnées
	 * @param indice Indice du point de mémorisation
	 */
	public void transformation(int dx, int dy, int indice) {
		tab_mem[indice].translation(dx, dy);
	}
}