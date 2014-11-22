/**
 * 
 * @author Maxime Blaise
 *
 */
public class Trapeze extends Quadrilatere {
	
	/**
	 * Constructeur vide qui initialise à partir d'un point aléatoire.
	 */
	public Trapeze() {
		super();
	}
	
	/**
	 * Méthode qui retourne le nombre de clics nécessaire
	 * à la création d'un rectangle.
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
		tab_mem[1]=new Point(tab_mem[0].rendreX()+(int)(Math.random()*100+100),tab_mem[0].rendreY());
		int recup = (int)(Math.random()*50+50);
		tab_mem[2]=new Point(tab_mem[1].rendreX()+recup,tab_mem[1].rendreY()+(int)(Math.random()*100+20));
		tab_mem[3]=new Point(tab_mem[0].rendreX()-recup,tab_mem[2].rendreY());
	}
}
