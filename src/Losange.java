/**
 * 
 * @author Maxime Blaise
 *
 */
public class Losange extends Quadrilatere {
	
	/**
	 * Constructeur vide qui contruit un losange.
	 */
	public Losange() 
	{
		super();
	}
	
	/**
	 * Méthode qui modifie le losange
	 * @param tab_saisie Tableau qui contient des nouveaux points.
	 */
	public void modifierPoints(Point[] tab_saisie)
	{
		tab_mem[0]=tab_saisie[0];
		tab_mem[1]=tab_saisie[1];
		int x0=tab_mem[0].rendreX(),y0=tab_mem[0].rendreY();
		int x1=tab_mem[1].rendreX(),y1=tab_mem[1].rendreY();
		int diagoX=2*(int)(Math.abs(tab_mem[0].rendreX()-tab_mem[1].rendreX()));
		int diagoY=2*(int)(Math.abs(tab_mem[0].rendreY()-tab_mem[1].rendreY()));
		if(x1>x0) {
			tab_mem[2]=new Point(tab_mem[0].rendreX()+diagoX,tab_mem[0].rendreY());
			if(y1>y0)
				tab_mem[3]=new Point(tab_mem[1].rendreX(),tab_mem[1].rendreY()-diagoY);
			else 
				tab_mem[3]=new Point(tab_mem[1].rendreX(),tab_mem[1].rendreY()+diagoY);
		}
		else {
			tab_mem[3]=new Point(tab_mem[1].rendreX()+diagoX,tab_mem[1].rendreY());
			if(y0>y1) 
				tab_mem[2]=new Point(tab_mem[0].rendreX(),tab_mem[0].rendreY()-diagoY);
			else
				tab_mem[2]=new Point(tab_mem[0].rendreX(),tab_mem[0].rendreY()+diagoY);
		}
	}
	
	/**
	 * Méthode qui retourne le nombre de clics nécessaire
	 * à la création d'un losange.
	 * @return Type int (nbClics)
	 */
	public int nbClics() {
		return 2;
	}
}