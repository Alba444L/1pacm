/* CLASE pacman.java CLASE QUE DEFINE AL PERSONAJE PRINCIPAL.
 * DISPONE TODOS LOS MÉTODOS QUE AFECTAN AL PERSONAJE PRINCIPAL.
 * Creado por: Javier Rodríguez Soler.
 * 1º DAM FLORIDA.
 * 09/06/2014
 */
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;


public class pacman {

	
	//Definición de atributos.
	
	
	private int puntuacion;
	private int x;
	private int y;
	private Image imagen;
	private int width;
	private int height;
	private int posAX;
	private int posAY;
	private int direccion; //1 izquierda 2 Arriba 3 Derecha 4 Abajo.
	private boolean boca; //Para controlar el estado de la boca.
	
	
	public void move() {
		System.out.println(x+" "+ " "+y);
		
		
		//Comprobamos si salimos por la derecha y lo colocamos a la izquierda.
		if (x>670 &&  y >310){
			setX(1);
			setY(314);
		
		}
		
		//Comprobamos si salimos por la izquierda y lo colocamos a la derecha.
		
		if (x<1 &&  y >310){
			setX(670);
			setY(314);
		
		}
		
		
		switch (direccion)
		{
		case 1:{
			x= x-1;
			break;
		}
		case 2:
		{
			y=y-1;
			break;
		}
		case 3:
		{
			x=x+1;
			break;
		}
		case 4:
		{
			y=y+1;
			break;
		}
		
		}
		
		
		
		
		
	}
	
	public pacman() {
		ImageIcon ii = new ImageIcon(this.getClass().getResource("/pacman_right.png"));
		imagen = ii.getImage();
		x = 320;
		y = 384;
		width = imagen.getWidth(null);
		height = imagen.getHeight(null);
		direccion = 3;
		puntuacion = 0;
		boca = true ;//La boca se encuentra abierta.
		// TODO Auto-generated constructor stub
	}
	
	//Método para establecer el grafico del personaje
	public void setGrafico(int direccion)
	{
		
		
		switch(direccion)
		{
		case 1: {
			
			if (!boca){
			ImageIcon ii = new ImageIcon (this.getClass().getResource("/pacman_left.png"));
			imagen = ii.getImage();
			this.boca = true;
			} else
			{
				ImageIcon ii = new ImageIcon (this.getClass().getResource("/pacman_closed.png"));
				imagen = ii.getImage();
				this.boca = false;
			 
			}
			
			
			break;
		}
		
		case 2 : {
			

			if (!boca){
				ImageIcon ii = new ImageIcon(this.getClass().getResource("/pacman_up.png"));
				imagen = ii.getImage();
			this.boca = true;
			} else
			{
				ImageIcon ii = new ImageIcon (this.getClass().getResource("/pacman_closed.png"));
				imagen = ii.getImage();
				this.boca = false;
			 
			}
			
			break;
		}
		case 3: {
			if (!boca){
				ImageIcon ii = new ImageIcon(this.getClass().getResource("/pacman_right.png"));
				imagen = ii.getImage();
			this.boca = true;
			} else
			{
				ImageIcon ii = new ImageIcon (this.getClass().getResource("/pacman_closed.png"));
				imagen = ii.getImage();
				this.boca = false;
			 
			}
			
			break;
			
		}
		
		case 4: {
			
			if (!boca){
				ImageIcon ii = new ImageIcon(this.getClass().getResource("/pacman_down.png"));
				imagen = ii.getImage();	
			this.boca = true;
			} else
			{
				ImageIcon ii = new ImageIcon (this.getClass().getResource("/pacman_closed.png"));
				imagen = ii.getImage();
				this.boca = false;
			 
			}
			
			break;
			
		}
		default :{
			ImageIcon ii = new ImageIcon (this.getClass().getResource("/pacman_right.png"));
			imagen = ii.getImage();
		}
		
		}
		
			
	
	}
	
	public void setPuntuacion(int puntos)
	{
		puntuacion = puntuacion + puntos;
		System.out.println(puntuacion);
		
	}
	
	public int getPuntuacion()
	{
		return puntuacion;
		
	}
	
	public int getX(){
		return x;
	}
	
	// Devuelve la posici�n Y.
		public int getY() {
			return y;
		}
		
		public void setX(int x){
			this.x = x;
		}
		
		public void setY(int y){
			this.y= y;
		}
		
		// Devuelve la imagen.
		public Image getImage() {
			return imagen;
		}
		
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT) {
			
				direccion = 1;
				setGrafico(direccion);
				
			
			}
			if (key == KeyEvent.VK_RIGHT) {
				
				direccion = 3;
				setGrafico(direccion);
				
				
			}
			if (key == KeyEvent.VK_UP) {
				direccion = 2;
				setGrafico(direccion);
				
				
			}
			if (key == KeyEvent.VK_DOWN) {
				direccion = 4;
				setGrafico(direccion);
			
				
			}

		}

		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (key == KeyEvent.VK_LEFT) {
				direccion = 0;
				
			}
			if (key == KeyEvent.VK_RIGHT) {
				direccion = 0;
			
			}
			if (key == KeyEvent.VK_UP) {
				direccion=0;
				
			}
			if (key == KeyEvent.VK_DOWN) {
				direccion = 0;
			
			}

		}
		

		public int getDireccion()
		{
			return direccion;
		}
		
		
		//Método para determinar la posición de los bordes de gráficos en la posición que se le pasa.
		public Rectangle getBounds(int x, int y){
			return new Rectangle(x,y,width,height);
		}

}
