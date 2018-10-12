package edu.unlam.tpa;

import java.util.ArrayList;

public class Mapa {
	private int cantFil;
	private int cantCol;
	private ArrayList<Snake> snakes;
	private ArrayList<Fruta> frutas;
	
	public Mapa(int fil, int col) {
		this.cantFil = fil;
		this.cantCol = col;
		this.snakes = new ArrayList<>();
		this.frutas = new ArrayList<>();
	}
	
	public void addSnake(Snake snake) {
		this.snakes.add(snake);
	}
	
	public void addFruta(Fruta fruta) {
		this.frutas.add(fruta);
	}
	
	public boolean estaFueraDelMapa(Posicion pos) {
		if(pos.getX() < 0 || pos.getX() >= this.cantFil || pos.getY() < 0 || pos.getY() >= this.cantCol) {
			return true;
		}
		return false;
	}
	
	public Snake hayVibora(Posicion pos) {
		for(Snake snake : snakes) {
			if(snake.estasAhi(pos))
				return snake;
		}
		return null;
	}
	
	public Fruta hayFruta(Posicion pos) {
		for(Fruta fruta : frutas) {
			if(fruta.estasAhi(pos))
				return fruta;
		}
		return null;
	}

	public int getFil() {
		return cantFil;
	}

	public int getCol() {
		return cantCol;
	}
	
}
