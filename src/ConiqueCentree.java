/**
 * Classe ConiqueCentree
 * @author Maxime Blaise
 * @version 3.0
 */
public abstract class ConiqueCentree extends FigureColoree {
	/**
	 * Centre : Centre de la conique centrée
	 */
	protected Point centre;
	
	/**
	 * Constructeur vide : initialise l'attribut centre aléatoirement.
	 */
	public ConiqueCentree() {
		// Centre initialisé de manière aléatoire
		this.centre=new Point(((int)(Math.random()*600)),((int)(Math.random()*600)));
	}
	
	/**
	 * Méthode qui retourne le centre de la conique centrée.
	 * @return Type : Point (l'attribut centre).
	 */
	public Point rendreCentre() {
		return this.centre;
	}
		
}