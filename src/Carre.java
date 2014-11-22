/**
 * Classe Carre
 * @author Maxime Blaise
 * @version 3.0
 */
public class Carre extends Rectangle {

	/**
	 * Constructeur vide.
	 */
	public Carre() {
		super();
	}
	
	/**
	 * Méthode qui retourne le nombre de clics nécessaire
	 * à la création d'un carré.
	 * @return Type int (nbClics)
	 */
	public int nbClics() {
		return 1;
	}
	
	/**
	 * Méthode qui modifie le rectangle
	 * @param tab_saisie Tableau qui contient des nouveaux points.
	 */
	public void modifierPoints(Point[] tab_saisie)
	{
		tab_mem[0]=tab_saisie[0];
		tab_mem[1]=new Point(tab_mem[0].rendreX()+60,tab_mem[0].rendreY());
		tab_mem[2]=new Point(tab_mem[0].rendreX()+60,tab_mem[0].rendreY()+60);
		tab_mem[3]=new Point(tab_mem[0].rendreX(),tab_mem[0].rendreY()+60);
	}

}
