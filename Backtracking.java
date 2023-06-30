package src.TPEspecial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Backtracking<T> {
	
	private ArrayList<Arco<T>> redSubterraneo;
	private int longitudRedSubterraneo;
	private HashMap<T,Boolean> visitadas;
	
	public Backtracking(){
		this.redSubterraneo = new ArrayList<Arco<T>>();
		this.longitudRedSubterraneo = Integer.MAX_VALUE;
		this.visitadas = new HashMap<>();
	}
	
	public void resolverBacktraking(GrafoDirigido<T> grafo) {
		ArrayList<Arco<T>> arcos= new ArrayList<>(); 
		ArrayList<Arco<T>> solucion= new ArrayList<>();
		Iterator<Arco<T>> arcosGrafo = grafo.obtenerArcos();
		Iterator<T> estaciones = grafo.obtenerVertices();
		while(arcosGrafo.hasNext()){
			Arco<T> arco = arcosGrafo.next();
			arcos.add(arco);
		}
		while(estaciones.hasNext()) {
			T estacion = estaciones.next();
			visitadas.put(estacion, true);
		}
		
		backtracking(arcos,0,solucion);
	}

	
	public void backtracking(ArrayList<Arco<T>> arcos, int metrosDeRedActualEnConstruccion, ArrayList<Arco<T>> solucionEnConstruccion){	
		if(arcos.isEmpty()){
			
			if(!solucionEnConstruccion.isEmpty()) {
				if(metrosDeRedActualEnConstruccion<=longitudRedSubterraneo){
					longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
					redSubterraneo.clear();
					redSubterraneo.addAll(solucionEnConstruccion);
			}
			}
		}
		else{//agrego a solucion
			for(int i =0; i<arcos.size(); i++){
				Arco<T> arcoSiguiente = arcos.get(i);
				T estacionSiguiente = arcoSiguiente.getVerticeDestino();
					if(!visitadas.get(estacionSiguiente) ) {
						visitadas.put(estacionSiguiente, false);
						arcos.remove(arcoSiguiente);
						solucionEnConstruccion.add(arcoSiguiente);
						metrosDeRedActualEnConstruccion += arcoSiguiente.getEtiqueta();
					}
					if(!poda(metrosDeRedActualEnConstruccion)){
						backtracking(arcos, metrosDeRedActualEnConstruccion, solucionEnConstruccion);

					}
					metrosDeRedActualEnConstruccion -= arcoSiguiente.getEtiqueta();
					solucionEnConstruccion.remove(arcoSiguiente);
					visitadas.put(estacionSiguiente, true);
					arcos.add(arcoSiguiente);
				

			}
		}
	}
	
	
	public boolean poda(int sumaCaminoHastaAhora){
		return sumaCaminoHastaAhora >= longitudRedSubterraneo;
	}

	public ArrayList<Arco<T>> getRedSubterraneo(){
		return redSubterraneo;
	}

	public int getLongitudRedSubterraneo() {
		return longitudRedSubterraneo;
	}
	



}
