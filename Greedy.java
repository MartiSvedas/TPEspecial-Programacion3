package src.TPEspecial;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
		
	public ArrayList<T> aplicarGreedy(Grafo<T> g) {
		 ArrayList<T> visitados =new ArrayList<>();//estaciones visitadas
		 ArrayList<T> estaciones = new ArrayList<>();//vertices del grafo
		Iterator<T> it = g.obtenerVertices();
		while(it.hasNext()) {
			T estacion = it.next();
			estaciones.add(estacion);
		}
		T estacion = estaciones.get(0);
		while(visitados.size()!=estaciones.size()) {
			//selecciono el arco de menor valor
			Arco<T> arcoMinimo=seleccionar(g.obtenerArcos(estacion));
			//Si la estacion todavia no fue visitada
				if(!visitados.contains(estacion)) {
				//agrego la estacion a visitados
					visitados.add(estacion);
				//agrego el arcoMinimo al arreglo de redSubterraneo
					redSubterraneo.add(arcoMinimo);
				//Si tiene estaciones siguientes
				if(arcoMinimo!=null && arcoMinimo.getVerticeDestino()!=null) { 
					//selecciono la estacion destino del arcoMinimo obtenido 
					estacion=arcoMinimo.getVerticeDestino();
					//sumo el valor de la etiqueta del arcominimo a suma
					suma+=arcoMinimo.getEtiqueta();
				
				}
				}
				contadorGreedy++;
		
		}
		return visitados;
			
		
		
	}

	private Arco<T> seleccionar(Iterator<Arco<T>> it){ //obtengo el arco de menor peso
		Arco<T> arcoMenor = null;
		int menorDistancia = Integer.MAX_VALUE;
		while(it.hasNext()) {
			Arco<T> arco = it.next();
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
