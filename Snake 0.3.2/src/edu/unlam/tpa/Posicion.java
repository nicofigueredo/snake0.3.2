package edu.unlam.tpa;

public class Posicion {
	private int x;
	private int y;
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}	
	
	public Posicion(Posicion pos) {
		this.x = pos.x;
		this.y = pos.y;
	}
	
	public Posicion moverYavisar(Posicion pos) {
		Posicion aux = new Posicion(this);
		this.x = pos.x;
		this.y = pos.y;
		return aux;
	}
	
	public void mover(Direccion dir) {
		switch(dir) {
		case ARRIBA:
			this.x--;
			break;
		case ABAJO:
			this.x++;
			break;
		case DERECHA:
			this.y++;
			break;
		case IZQUIERDA:
			this.y--;
			break;
		}
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "" + this.x + " " + this.y; 
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
	
	
	
}
