/**
 * Classe Triangle
 * @author Maxime Blaise
 *
 */
public class Triangle extends Polygone {

	/**
	 * Constructeur vide permettant de construire un triangle aléatoire.
	 */
	public Triangle() {
		super();
	}
	
	/**
	 * Méthode qui retourne le nombre de points nécessaires
	 * à la création d'un triangle
	 * @return Type : int (Nombre de points)
	 */
	public int nbPoints() 
	{
		return 3;
	}
	
	public int nbClics() {
		return 3;
	}

}
