package edu.unlam.tpa.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import edu.unlam.tpa.Direccion;
import edu.unlam.tpa.Fruta;
import edu.unlam.tpa.Mapa;
import edu.unlam.tpa.Partida;
import edu.unlam.tpa.Posicion;
import edu.unlam.tpa.Snake;

public class TestJuego {
	
	Snake snake;
	
	@Test
	public void seMueveCabeza() {
		snake = new Snake(0, 0, Direccion.DERECHA);
		snake.moverse();
		
		ArrayList<Posicion> cuerpo = new ArrayList<>();
		cuerpo.add(new Posicion(0, 1));
		
		assertEquals(cuerpo, snake.getCuerpo());
	}
	
	@Test
	public void crece() {
		snake = new Snake(0, 0, Direccion.DERECHA);
		
		snake.crecer();
		snake.crecer();
		snake.crecer();
		
		ArrayList<Posicion> cuerpo = new ArrayList<>();
		cuerpo.add(0, new Posicion(0, 0));
		cuerpo.add(0, new Posicion(0, 1));
		cuerpo.add(0, new Posicion(0, 2));
		cuerpo.add(0, new Posicion(0, 3));	//kbza
		
		assertEquals(cuerpo, snake.getCuerpo());
	}
		
	@Test
	public void seMueveCuerpo() {
		snake = new Snake(0, 0, Direccion.DERECHA);
		
		snake.crecer();
		snake.crecer();
		snake.crecer();
		snake.moverse();
		snake.cambiarDireccion(Direccion.ABAJO);
		snake.moverse();
		
		ArrayList<Posicion> cuerpo = new ArrayList<>();
		cuerpo.add(0, new Posicion(0, 2));
		cuerpo.add(0, new Posicion(0, 3));
		cuerpo.add(0, new Posicion(0, 4));
		cuerpo.add(0, new Posicion(1, 4));	//kbza
		
		assertEquals(cuerpo, snake.getCuerpo());
	}
	
	Mapa mapa;
	Partida partida;
	
	@Test
	public void muereBordeArriba() {
		snake = new Snake(0, 0, Direccion.DERECHA);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		
		partida.actualizarPartida();
		snake.cambiarDireccion(Direccion.ARRIBA);
		partida.actualizarPartida();
		
		assertEquals(false, snake.estaViva());
	}
	
	@Test
	public void muereBordeIzquierdo() {
		snake = new Snake(2, 0, Direccion.ABAJO);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		
		partida.actualizarPartida();
		snake.cambiarDireccion(Direccion.IZQUIERDA);
		partida.actualizarPartida();
		
		assertEquals(false, snake.estaViva());
	}
	
	@Test
	public void muereBordeAbajo() {
		snake = new Snake(9, 1, Direccion.DERECHA);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		
		partida.actualizarPartida();
		snake.cambiarDireccion(Direccion.ABAJO);
		partida.actualizarPartida();
		
		assertEquals(false, snake.estaViva());
	}
	
	@Test
	public void muereBordeDerecho() {
		snake = new Snake(9, 3, Direccion.ABAJO);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		
		partida.actualizarPartida();
		snake.cambiarDireccion(Direccion.DERECHA);
		partida.actualizarPartida();
		
		assertEquals(false, snake.estaViva());
	}
	
	Fruta fruta;
	@Test
	public void comeYcrece() {
		snake = new Snake(0, 0, Direccion.DERECHA);
		fruta = new Fruta(0, 2);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		partida.addFruta(fruta);
		
		partida.actualizarPartida();
		partida.actualizarPartida();
		
		ArrayList<Posicion> cuerpo = new ArrayList<>();
		cuerpo.add(0, new Posicion(0, 1));
		cuerpo.add(0, new Posicion(0, 2));	//kbza
		assertEquals(cuerpo, snake.getCuerpo());
	}
	
	@Test
	public void chocaConsigoMisma() {
		snake = new Snake(3, 3, Direccion.DERECHA);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		
		snake.crecer();
		snake.crecer();
		snake.crecer();
		snake.cambiarDireccion(Direccion.ABAJO);
		partida.actualizarPartida();
		snake.cambiarDireccion(Direccion.IZQUIERDA);
		partida.actualizarPartida();
		snake.cambiarDireccion(Direccion.ARRIBA);
		assertEquals(true, snake.estaViva());
		partida.actualizarPartida();
		assertEquals(false, snake.estaViva());
	}
	
	Snake snake2;
	@Test
	public void chocanCabezas() {
		snake = new Snake(0, 1, Direccion.DERECHA);
		snake2 = new Snake(0, 5, Direccion.IZQUIERDA);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		partida.addSnake(snake2);
		
		partida.actualizarPartida();
		assertEquals(true, snake.estaViva());
		assertEquals(true, snake2.estaViva());
		partida.actualizarPartida();
		assertEquals(false, snake.estaViva());
		assertEquals(false, snake2.estaViva());
	}
	
	@Test
	public void casiChocanmuereUnaDelasDos() {
		snake = new Snake(0, 1, Direccion.DERECHA);
		snake2 = new Snake(0, 5, Direccion.IZQUIERDA);
		partida = new Partida(new Mapa(10, 10));
		partida.addSnake(snake);
		partida.addSnake(snake2);
		
		snake.crecer();
		partida.actualizarPartida();
		assertEquals(true, snake.estaViva());
		assertEquals(true, snake2.estaViva());
		snake.cambiarDireccion(Direccion.ABAJO);
		partida.actualizarPartida();
		assertEquals(true, snake.estaViva());
		assertEquals(false, snake2.estaViva());
	}
		
}
