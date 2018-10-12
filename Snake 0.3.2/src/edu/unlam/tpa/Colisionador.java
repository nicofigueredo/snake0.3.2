package edu.unlam.tpa;

public class Colisionador {

	public Colisionador() {
	}
	
	public void verConflicto(Mapa mapa, Snake snake) {
		Posicion nextPos = snake.getNextPos();
		Snake snAux;
		Fruta frAux;
		
		if(mapa.estaFueraDelMapa(nextPos))
			snake.morirse();
		else if((snAux = mapa.hayVibora(nextPos)) != null)
			resolverConflicto(snake, snAux);
		else if((frAux = mapa.hayFruta(nextPos)) != null)
			resolverConflicto(snake, frAux);
		else
			snake.moverse();
	}
	
	public void resolverConflicto(Snake sn1, Snake sn2) {
		if(sn2.laCabezaEstaAhi(sn1.getNextPos())) {
			sn1.morirse();
			sn2.morirse();
		}
		else
			sn1.morirse();
	}
	
	public void resolverConflicto(Snake sn, Fruta fr) {
		sn.crecer();
	}
	
}
