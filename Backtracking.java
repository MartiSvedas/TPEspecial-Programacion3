package src.TPEspecial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Backtracking<T> {
	
	private ArrayList<Arco<T>> redSubterraneo;
	private int longitudRedSubterraneo;
	
	public Backtracking(){
		this.redSubterraneo = new ArrayList<Arco<T>>();
		this.longitudRedSubterraneo = Integer.MAX_VALUE;
	}
	
	public void resolverBacktraking(Grafo<T> grafo) {
		ArrayList<Arco<T>> arcos= new ArrayList<>(); 
		ArrayList<Arco<T>> solucion= new ArrayList<>();
		HashMap<T,Boolean> visitados= new HashMap<>();
		Iterator<Arco<T>> arcosGrafo = grafo.obtenerArcos();
		Iterator<T> estaciones = grafo.obtenerVertices();
		while(arcosGrafo.hasNext()){
			Arco<T> arco = arcosGrafo.next();
			arcos.add(arco);
		}
		while(estaciones.hasNext()) {
			T estacion = estaciones.next();
			visitados.put(estacion, false);
		}
		backtracking(arcos,0,solucion,visitados);
	}

	
	public void backtracking(ArrayList<Arco<T>> arcos, int metrosDeRedActualEnConstruccion, ArrayList<Arco<T>> solucionEnConstruccion, HashMap<T,Boolean> visitados){	
		
		if(arcos.isEmpty() || visiteTodasLasEstaciones(visitados) ){
		
			if(!solucionEnConstruccion.isEmpty()) {
				if(metrosDeRedActualEnConstruccion<=longitudRedSubterraneo){
					
					longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
					redSubterraneo.clear();
					redSubterraneo.addAll(solucionEnConstruccion);
			}
			}
		}
		else {//agrego a solucion
		         for (int i = 0; i < arcos.size(); i++) {
		            Arco<T> arcoSiguiente = arcos.get(i);
		            T estacionSiguiente = arcoSiguiente.getVerticeDestino();
		            
		            if(!visitados.get(estacionSiguiente)) {
		            visitados.put(estacionSiguiente, true);
		            arcos.remove(arcoSiguiente);
		            solucionEnConstruccion.add(arcoSiguiente);
		            metrosDeRedActualEnConstruccion += arcoSiguiente.getEtiqueta();

		            if (!poda(metrosDeRedActualEnConstruccion)) {
		               backtracking(arcos, metrosDeRedActualEnConstruccion, solucionEnConstruccion, visitados);

		            }
		            if (poda(metrosDeRedActualEnConstruccion)) {
		            	
			            metrosDeRedActualEnConstruccion -= arcoSiguiente.getEtiqueta();
			            solucionEnConstruccion.remove(arcoSiguiente);
		               visitados.put(estacionSiguiente, false);
		               arcos.add(arcoSiguiente);
		               //no agrego a solucion
		               arcoSiguiente = arcos.get(i);
		               estacionSiguiente = arcoSiguiente.getVerticeDestino();
		               visitados.put(estacionSiguiente, true);
		               arcos.remove(arcoSiguiente);
		               visitados.put(estacionSiguiente, false);
		               arcos.add(arcoSiguiente);
		               break;
		            }
			}
		         }
		}
	}
	
	public boolean visiteTodasLasEstaciones(HashMap<T,Boolean> visitados) {
		return visitados.values().stream().filter(v -> v.equals(true)).count() == visitados.keySet().size()-1;
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
