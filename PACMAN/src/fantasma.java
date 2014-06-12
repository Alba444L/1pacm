import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class fantasma {

	private int x, y; // Variables donde se alamcena la posición del fantasma
						// x,y
	private Image imagen;
	private int width; // Ancho.
	private int height; // Alto.
	private int direccion; // 1 izquierda 2 Arriba 3 Derecha 4 Abajo.
	private boolean activo; // Para determinar si se encuentra activo.
	private boolean comestible; // Para determinar si el fantasma es comestible.

	public Image getImagen() {
		return imagen;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean getComestible() {
		return comestible;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public boolean getActivo() {
		return activo;
	}

	public fantasma() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource(
				"/ghost_red.png"));
		imagen = ii.getImage();
		x = 220;
		y = 388;
		width = imagen.getWidth(null);
		height = imagen.getHeight(null);
		direccion = 3;
		comestible = true;
		activo = true;
	}

	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}

	public int getDireccion() {
		return direccion;
	}

	public void moverDerecha() {
		x = x + 1;
	}

	public void moverIzquierda() {
		x = x - 1;
	}

	public void moverAbajo() {
		y = y + 1;

	}

	public void moverArriba() {
		y = y - 1;
	}

	public void busquedaPacman(int pacmanX, int pacmanY) {
		if (pacmanY == y && pacmanX > x)
		{
			direccion = 3;
		}
		if (pacmanY>y && pacmanX == x)
		{
			direccion = 4;
		}
		if (pacmanY == y && pacmanX<x)
		{
			direccion = 1;
		}
	}

	// Método para determinar la posición de los bordes de gráficos en la
	// posición que se le pasa.
	public Rectangle getBounds(int x, int y) {
		return new Rectangle(x, y, width, height);
	}

}
