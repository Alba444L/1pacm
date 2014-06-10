/* CLASE Tablero.java Controlador del juego.
 * Creado por: Javier Rodríguez Soler.
 * 1º DAM FLORIDA.
 * 09/06/2014
 * ver: 1
 */


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Tablero extends JPanel implements ActionListener{

	private Timer timer;
	private objetosJuego[][] mapa = new objetosJuego[29][29];
	private pacman _pacman;
	private fantasma _fantasma;

	// DefiniciON del nivel.
	int[][] map = {
			// 0 - empty panel
			// 1 - a wall
			// 2 - regular pill
			// 3 - mighty pill
			// 4 - super pill
			// -1 - cage gate
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2,
					2, 2, 2, 2, 2, 1 },
			{ 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2,
					1, 1, 1, 1, 2, 1 },
			{ 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2,
					1, 1, 1, 1, 3, 1 },
			{ 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2,
					1, 1, 1, 1, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
					2, 2, 2, 2, 2, 1 },
			{ 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2,
					1, 1, 1, 1, 2, 1 },
			{ 1, 2, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2,
					1, 1, 1, 1, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2,
					2, 2, 2, 2, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 2,
					1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2,
					1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 2, 1, 1, 0, 1, 1, 1, -1, -1, 1, 1, 1, 0, 1, 1,
					2, 1, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 2,
					1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 2,
					0, 0, 0, 0, 0, 0 }, // PORTAL
			{ 1, 1, 1, 1, 1, 1, 2, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 2,
					1, 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 1, 2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2,
					1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 1, 2, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 2,
					1, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 2, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 2,
					1, 1, 1, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2,
					2, 2, 2, 2, 2, 1 },
			{ 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2,
					1, 1, 1, 1, 2, 1 },
			{ 1, 3, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 2,
					1, 1, 1, 1, 3, 1 },
			{ 1, 2, 2, 2, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
					1, 1, 2, 2, 2, 1 },
			{ 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2,
					1, 1, 2, 1, 1, 1 },
			{ 1, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2,
					1, 1, 2, 1, 1, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 1, 2,
					2, 2, 2, 2, 2, 1 },
			{ 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 2, 1 },
			{ 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 2, 1 },
			{ 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2,
					2, 2, 2, 2, 2, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
					1, 1, 1, 1, 1, 1 },

	};
	
	private class TAdopter extends KeyAdapter {

		public void keyReleased(KeyEvent e) {
		_pacman.keyReleased(e);
		}

		public void keyPressed(KeyEvent e) {
			_pacman.keyPressed(e);

		}
	}
	
	
	public Tablero() {
		
		setSize(new Dimension(610, 630));

		addKeyListener(new TAdopter());
		setFocusable(true);
		setBackground(Color.black);
		setDoubleBuffered(true);
		setSize(new Dimension(610, 630));

	    cargaMapa();
		_pacman = new pacman();
	    _fantasma = new fantasma();
		timer = new Timer(3, this);
		timer.start();
	}
	
	
	
	//CONTROL DEL MOVIMIENTO DE PACMAN EN FUNCIÓN DE SI PUEDE O NO PUEDE.
	public void actionPerformed(ActionEvent e) {

		
		switch(_pacman.getDireccion())
		{
		case 1:
		{
		if (!verificarObjeto(_pacman.getX()-1,_pacman.getY())){  
		
		_pacman.move();
		}break;
		}
		case 2:
		{
			if (!verificarObjeto(_pacman.getX(),_pacman.getY()-1))
			{
				_pacman.move();
			}
			break;
					
		}
		case 3:
		{
			if (!verificarObjeto(_pacman.getX()+1, _pacman.getY()))
			{
				_pacman.move();
			}
			break;
		}
		case 4:
		{
			if (!verificarObjeto(_pacman.getX(),_pacman.getY()+1))
			{
				_pacman.move();
			}
			break;
		}
		
		}
		
	
    colisionPersonajes();
	repaint();

}

	
	//MÉTODO PRINCIPAL DE DIBUJO EN PANTALLA.
	public void paint (Graphics g)
	{
		super.paint(g); //SOBRESCRIBIMOS EL CONTEXTO GRÁFICO.
		Graphics2D g2d = (Graphics2D) g; //LO CONVERTIMOS EN TIPO 2D.
		Toolkit.getDefaultToolkit().sync(); //MÉTODO PARA SINCRONIZAR.
		

		try {
			for (int columna = 0; columna < mapa.length; columna++) {
				for (int fila = 0; fila < mapa.length - 1; fila++) {

					if (mapa[columna][fila].clase != 0
							&& mapa[columna][fila].getActivo() == true) {

						g2d.drawImage(mapa[columna][fila].getImagen(),
								fila * 24, columna * 24, this);
					}

				}
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		
		//DIBUJAMOS A PACMAN EN EL TABLERO.
		g2d.drawImage(_pacman.getImage(), _pacman.getX(), _pacman.getY(), this);
		
		
		// COMPROBAMOS SI EL FANTASMA SE ENCUENTRA ACTIVO.
		if (_fantasma.getActivo() == true) {
		//DIBUJAMOS A FANTASMA EN EL TABLERO.
		g2d.drawImage(_fantasma.getImagen(), _fantasma.getX(), _fantasma.getY(), this);
		}
		}
	
	
	
	//MÉTODO PARA COMPROBAR SI PACMAN SE PUEDE MOVER.
	public boolean verificarObjeto(int x, int y)
	{
		Rectangle r1 = _pacman.getBounds(x,y);
		
		for (int columna =0; columna< mapa.length; columna++)
		{
			for (int fila=0; fila<mapa.length -1;fila++)
			{
				Rectangle r2 = mapa[columna][fila].getBounds();
				
				//verificamos que es pared.
				if (r1.intersects(r2) && mapa[columna][fila].getClase()==1){
					return true;
				}
				//verificamos que es punto y si es así se lo come.
				if (r1.intersects(r2) && mapa[columna][fila].getClase()==2 && mapa[columna][fila].getActivo()==true){
				      mapa[columna][fila].setActivo(false);
				      _pacman.setPuntuacion(10); //Sumamos los puntos del puntito.
				}
				
				
			}
		}
		
		return false;
				
	}
	
	
	//Método para determinar si colisionan los personajes.
	
	public void colisionPersonajes()
	{
	  Rectangle r1 =_pacman.getBounds(_pacman.getX(), _pacman.getY());
	  Rectangle r2 = _fantasma.getBounds(_fantasma.getX(), _fantasma.getY());
	  
	  if (r1.intersects(r2) && _fantasma.getComestible() == true)
	  {
		  _fantasma.setActivo(false);
	  }
			  
	}
	
	
	
	// MÉTODO PARA LA CARGA DEL MAPA.
	public void cargaMapa() {
		try {
			for (int columna = 0; columna < map.length; columna++) {
				for (int fila = 0; fila < map.length - 1; fila++) {

					if (map[columna][fila] == 0 || map[columna][fila] == -1) {
						mapa[columna][fila] = new objetosJuego();
					} else if (map[columna][fila] == 1) {
						mapa[columna][fila] = new muro_Obj(fila * 24,
								columna * 24);
					} else if (map[columna][fila] == 2) {
						mapa[columna][fila] = new punto_Obj(fila * 24,
								columna * 24);
					} else if (map[columna][fila] == 3) {
						mapa[columna][fila] = new superPunto_Obj(fila * 24,
								columna * 24);
					}

				}
			}
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}
	}

}
