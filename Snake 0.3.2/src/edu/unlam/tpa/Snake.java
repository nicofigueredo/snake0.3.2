package edu.unlam.tpa;

import java.util.ArrayList;

public class Snake {
	
	private ArrayList<Posicion> cuerpo;
	private Direccion dir;
	private boolean viva;
	
	public Snake(int x, int y, Direccion dir) {
		this.cuerpo = new ArrayList<Posicion>();
		this.cuerpo.add(new Posicion(x, y));
		this.dir = dir;
		this.viva = true;
	}
	
	public void moverse() {
		if(!viva)
			return;
		Posicion aux = getNextPos();
		for(int i = 0; i < this.cuerpo.size(); i++) {
			aux = cuerpo.get(i).moverYavisar(aux); 
		}
	}
	
	public void crecer() {
		if(!viva)
			return;
		Posicion aux = getNextPos();
		this.cuerpo.add(0, aux);
	}
	
	public void morirse() {
		this.viva = false;
	}
	
	public void cambiarDireccion(Direccion dir) {
		if(!viva)
			return;
		switch(this.dir) {
			case ARRIBA:
				if(dir != Direccion.ABAJO && dir != Direccion.ARRIBA)
					this.dir = dir;
				break;
			case ABAJO:
				if(dir != Direccion.ARRIBA && dir != Direccion.ABAJO)
					this.dir = dir;
				break;
			case IZQUIERDA:
				if(dir != Direccion.DERECHA && dir != Direccion.IZQUIERDA)
					this.dir = dir;
				break;
			case DERECHA:
				if(dir != Direccion.IZQUIERDA && dir != Direccion.DERECHA)
					this.dir = dir;
				break;
		}
	}
	
	public Posicion getCabezaPos() {
		return cuerpo.get(0);
	}
	
	public ArrayList<Posicion> getCuerpo() {
		return cuerpo;
	}
	
	public boolean estaViva() {
		return viva;
	}
	
	public Posicion getNextPos() {
		Posicion nextPos = new Posicion(cuerpo.get(0));
		nextPos.mover(this.dir);
		return nextPos;
	}
	
	public boolean estasAhi(Posicion pos) {
		for(Posicion segmento : cuerpo) {
			if(segmento.equals(pos))
				return true;
		}
		return false;
	}
	
	public boolean laCabezaEstaAhi(Posicion pos) {
		return cuerpo.get(0).equals(pos);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cuerpo == null) ? 0 : cuerpo.hashCode());
		result = prime * result + ((dir == null) ? 0 : dir.hashCode());
		result = prime * result + (viva ? 1231 : 1237);
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
		Snake other = (Snake) obj;
		if (cuerpo == null) {
			if (other.cuerpo != null)
				return false;
		} else if (!cuerpo.equals(other.cuerpo))
			return false;
		if (dir != other.dir)
			return false;
		if (viva != other.viva)
			return false;
		return true;
	}
	

	
}
