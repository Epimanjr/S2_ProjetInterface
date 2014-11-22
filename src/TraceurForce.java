import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 * Classe TraceurForme
 * @author Maxime Blaise
 *
 */
public class TraceurForce implements MouseListener, MouseMotionListener {
	
	/**
	 * Attribut de type Graphics
	 */
	private Graphics g;
	/**
	 * Attributs de type int, pour stocker des coordonnées.
	 */
	private int last_x, last_y;
	
	/**
	 * Constructeur prennant un paramètre de type Graphics
	 * @param gr
	 */
	public TraceurForce(Graphics gr) {
		this.g=gr;
	}
	
	public void mouseDragged(MouseEvent e) {
		g.drawLine(last_x,last_y,e.getX(),e.getY());
		last_x=e.getX();
		last_y=e.getY();
	}

	public void mousePressed(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)) {
			last_x=e.getX();
			last_y=e.getY();
		}
		else if(SwingUtilities.isRightMouseButton(e)) {
			((JComponent)(e.getSource())).removeMouseListener(this);
			((JComponent)(e.getSource())).removeMouseMotionListener(this);
			((JComponent)(e.getSource())).repaint();
		}
	}

	/**
	 * Méthodes non utilisé, mais doivent être redéfini.
	 */
	public void mouseReleased(MouseEvent e) {
	}
	
	public void mouseMoved(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
}
