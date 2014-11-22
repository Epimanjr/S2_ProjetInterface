/**
 * Classe Rectangle
 * @author Maxime Blaise
 *
 */
public class Rectangle extends Quadrilatere {
	/**
	 * Constructeur vide permettant de construire 
	 * un rectangle aléatoire à partir de deux points aléatoires.
	 */
	public Rectangle() {
		super();
	}
	
	/**
	 * Méthode qui retourne le nombre de clics nécessaire
	 * à la création d'un rectangle.
	 * @return Type int (nbClics)
	 */
	public int nbClics() {
		return 2;
	}
	
	/**
	 * Méthode qui modifie le rectangle
	 * @param tab_saisie Tableau qui contient des nouveaux points.
	 */
	public void modifierPoints(Point[] tab_saisie)
	{
		tab_mem[0]=tab_saisie[0];
		tab_mem[2]=tab_saisie[1];
		tab_mem[1]=new Point(tab_mem[0].rendreX(),tab_mem[2].rendreY());
		tab_mem[3]=new Point(tab_mem[2].rendreX(),tab_mem[0].rendreY());
	}
}