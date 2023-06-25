package src.TPEspecial;

import java.util.ArrayList;
import java.util.Iterator;

public class Greedy<T> {
	private int suma;
	private int contadorGreedy;
	private ArrayList<Arco<T>> redSubterraneo;
	
	public Greedy() {
		this.suma=0;
		this.contadorGreedy=0;
		this.redSubterraneo= new ArrayList<>();

	}
		
	public void aplicarGreedy(GrafoNoDirigido<T> g) {
		 ArrayList<T> visitados =new ArrayList<>();//estaciones visitadas
		Iterator<T> it = g.obtenerVertices();
		T estacionInicial =it.next();
		visitados.add(estacionInicial);
		
		ArrayList<Arco<T>> arcosPendientes = new ArrayList<>();
		arcosPendientes.addAll(obtenerArcos(g.obtenerArcos(estacionInicial)));
		
		while(!contieneTodasLasEstaciones(visitados, g)) {
			Arco<T> arcoMinimo = seleccionar(arcosPendientes);
			T estacionDestino=arcoMinimo.getVerticeDestino();
			arcosPendientes.remove(arcoMinimo);
			
			if(!visitados.contains(estacionDestino) ) {
				visitados.add(estacionDestino);
				arcosPendientes.addAll(obtenerArcos(g.obtenerArcos(estacionDestino)));
				this.redSubterraneo.add(arcoMinimo);
				this.suma+=arcoMinimo.getEtiqueta();
				this.contadorGreedy++;
			}
		}
	}
	
	private boolean contieneTodasLasEstaciones(ArrayList<T> visitados, Grafo<T> g) {
		Iterator<T> it = g.obtenerVertices();
		while(it.hasNext()) {
			T vertice = it.next();
			if(!visitados.contains(vertice)) {
				return false;
			}
		}
		return true;
	}
	
	private ArrayList<Arco<T>> obtenerArcos(Iterator<Arco<T>> it){ 
		ArrayList<Arco<T>> arcos = new ArrayList<>();
		while(it.hasNext()) {
			Arco<T> arco = it.next();
			arcos.add(arco);
		}
		return arcos;
	}
	
	private Arco<T> seleccionar(ArrayList<Arco<T>> ar){ //obtengo el arco de menor peso
		Arco<T> arcoMenor = null;
		int menorDistancia = Integer.MAX_VALUE;
		for(Arco<T> arco : ar) {
			if(arco.getEtiqueta()< menorDistancia) {
				menorDistancia = arco.getEtiqueta();
				arcoMenor=arco;
			}
		} return arcoMenor;
	}
	
	public ArrayList<Arco<T>> getRedSubterraneos() {
		return redSubterraneo;
	}

	public int getSuma() {
		return suma;
	}

	public int getContadorGreedy() {
		return contadorGreedy;
	}

}
