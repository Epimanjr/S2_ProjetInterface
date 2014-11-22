/**
 * Classe Point
 * @author Maxime Blaise
 *
 */
public class Point {
	/**
	 * Abscisse du point
	 */
	private int x;
	
	/**
	 * Ordonnée du point
	 */
	private int y;
	
	/**
	 * Constructeur de la classe "Point"
	 * @param abs
	 * @param ord
	 */
	public Point(int abs, int ord)
	{
		this.x=abs;
		this.y=ord;
	}
	
	/**
	 * Méthode qui calcule la distance entre deux points
	 * @param p2 deuxième point
	 * @return d la distance (double)
	 */
	public double distance(Point p2)
	{
		double d=0;
		
		double differenceX = (double)(Math.abs(this.rendreX()-p2.rendreX()));
		double differenceY = (double)(Math.abs(this.rendreY()-p2.rendreY()));
		
		d=Math.sqrt(differenceX*differenceX + differenceY*differenceY);
		return d;
	}
	
	/**
	 * Méthode qui retourne l'attribut x
	 * @return x
	 */
	public int rendreX() 
	{
		return this.x;
	}
	
	/**
	 * Méthode qui retourne l'attribut y
	 * @return y
	 */
	public int rendreY() 
	{
		return this.y;
	}
	
	/**
	 * Méthode qui permet de translater un point.
	 * @param dx 
	 * @param dy 
	 */
	public void translation(int dx, int dy)
	{
		this.x += dx;
		this.y += dy;
	}

}
