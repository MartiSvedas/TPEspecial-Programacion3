package src.TPEspecial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
//Las autoridades de una ciudad deciden construir una red de subterráneos para resolver los constantes
//problemas de tráfico. La ciudad ya cuenta con N estaciones construidas, pero todavía no tienen ningún
//túnel que conecte ningún par de estaciones entre sí.
//La red de subterráneos que se construya debe incluir a todas las estaciones (es decir, que de cualquier
//estación H pueda llegar a cualquier otra estación J, ya sea de manera directa o atravesando otras
//estaciones). Sin embargo, debido al acotado presupuesto, las autoridades desean construir la menor
//cantidad de metros de túnel posibles. Para esto han calculado cuantos metros de túnel serían
//necesarios para conectar de manera directa cada par de estaciones existentes.
public class Greedy<T> {
	private int suma;
	private int contadorGreedy;
	private ArrayList<Arco<T>> redSubterraneo;
	
	public Greedy() {
		this.suma=0;
		this.contadorGreedy=0;
		this.redSubterraneo= new ArrayList<>();

	}
		
	public void aplicarGreedy(Grafo<T> g) {
		 ArrayList<T> visitados =new ArrayList<>();//estaciones visitadas
		Iterator<T> it = g.obtenerVertices();
		T estacionInicial =it.next();
		visitados.add(estacionInicial);
		
		ArrayList<Arco<T>> arcosPendientes = new ArrayList<>();
		arcosPendientes.addAll(obtenerArcos(g.obtenerArcos(estacionInicial)));
		
		while(visitados.size()<=g.cantidadVertices()) {
			Arco<T> arcoMinimo = seleccionar(arcosPendientes);
			T estacionOrigen=arcoMinimo.getVerticeOrigen();
			T estacionDestino=arcoMinimo.getVerticeDestino();
			arcosPendientes.remove(arcoMinimo);
			
			if(visitados.contains(estacionOrigen)&&!visitados.contains(estacionDestino) ) {
				visitados.add(estacionDestino);
				redSubterraneo.add(arcoMinimo);
				arcosPendientes.addAll(obtenerArcos(g.obtenerArcos(estacionDestino)));
				suma+=arcoMinimo.getEtiqueta();
				
			}
			contadorGreedy++;
		}
		
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

}
