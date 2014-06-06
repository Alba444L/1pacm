/* CLASE PADRE DE LA QUE DERIVARÁN LOS OBJETOS DEL TABLERO
 * DEFINIMOS ATRIBUTOS BÁSICOS A TODOS LOS OBJETOS.
 * Creado por: Javier Rodríguez Soler.
 * 1º DAM FLORIDA.
 * 06/06/2014
 */

import java.awt.Image;


public class objetosJuego {

	
	private Image imagen;  //Imagen del objeto.
	private int x,y;  // Posición x e y del objeto en pantalla.
	private boolean activo; //Si el objeto se encuentra activo o no.
	
	
	public Image getImagen()
	{
		
		return imagen;
		
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setActivo(boolean activo)
	{
		this.activo= activo;
	}
	
	public boolean getActivo()
	{
		return activo;
	}
	
	
	public objetosJuego() {
		// TODO Auto-generated constructor stub
	}

}
