/**
 * Classe Quadrilatère
 * @author Maxime Blaise
 *
 */
public class Quadrilatere extends Polygone {

	/**
	 * Constructeur vide permettant de créer un quadrilatère quelconque.
	 */
	public Quadrilatere() {
		super();
	}
	
	/**
	 * Méthode qui retourne le nombre de points nécessaires
	 * à la saisie d'un quadrilatère.
	 * @return Type : int (NbPoints)
	 */
	public int nbPoints() 
	{
		return 4;
	}

}
