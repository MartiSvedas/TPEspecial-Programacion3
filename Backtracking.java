package src.TPEspecial;

import java.util.ArrayList;
import java.util.Iterator;


public class Backtracking<T> {
	
	//arrayList de soluciones
	private ArrayList<T> redSubterraneo;
	public int longitudRedSubterraneo;
	
	public Backtracking(){
		this.redSubterraneo = new ArrayList<>();
		longitudRedSubterraneo = Integer.MAX_VALUE; /*Esto es un número muy, muy grande*/
	}
	
	public void resolverBacktraking(GrafoNoDirigido<T> grafo) {
		ArrayList<T> solucion= new ArrayList<>();
		Iterator<T> it = grafo.obtenerVertices();
		T estacionInicial =it.next();
		backtracking(grafo, estacionInicial,0,solucion);

		
	}
	
	//poda: si el camino que llevo es mas largo que el camino parcial tengo guardado como más corto podo toda esa rama.
	public boolean poda(int sumaCaminoHastaAhora){
		return sumaCaminoHastaAhora >= longitudRedSubterraneo;
	}
	
	//metodo void backtracking que agrega elementos a la redsubterraneo
	public boolean backtracking(GrafoNoDirigido<T> grafo, T estacionActual, int metrosDeRedActualEnConstruccion, ArrayList<T> solucionEnConstruccion){

		//boolean result = false;
		//if llegue a la solucion return true
		if(grafo.cantidadVertices() == solucionEnConstruccion.size()){
			//terminé
			return true;
		}
		
		//else hago todo lo demás
		else{

			//traigo toda la lista de adyacentes de la estación en la que estoy
			Iterator<T> iteradorDeEstaciones = grafo.obtenerAdyacentes(estacionActual);
			while(iteradorDeEstaciones.hasNext()){

				//elijo una siguiente
				T estacionSiguiente = iteradorDeEstaciones.next();
				//si no tengo ese arco en la solucion me fijo si se puede agregar
				if(!solucionEnConstruccion.contains(estacionSiguiente)){
					Arco<T> tunelEntreLasEstaciones = grafo.obtenerArco(estacionActual, estacionSiguiente);
					int longitudDelTunel = tunelEntreLasEstaciones.getEtiqueta();
					//si no lo podo lo agrego a la solucion potencial
					if(!poda(metrosDeRedActualEnConstruccion+longitudDelTunel)){
						solucionEnConstruccion.add(estacionSiguiente);
						//sumo ese arco a mi suma solucion parcial
						metrosDeRedActualEnConstruccion += longitudDelTunel;
						boolean result = backtracking(grafo, estacionSiguiente, metrosDeRedActualEnConstruccion, solucionEnConstruccion);
						if (result){
							if(metrosDeRedActualEnConstruccion<=longitudRedSubterraneo){
//									//actualizo mejorRedHastaAhora
								longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
//									//mi red se vuelve la potencial: redSubterraneo = solucionPotencialEnConstruccion;
//									redSubterraneo = solucionEnConstruccion;
//									//creo que hay que hacer redSubte.clear y después redSubte addAll
								redSubterraneo.clear();
								redSubterraneo.addAll(solucionEnConstruccion);
//								redSubterraneo = new ArrayList<>(solucionEnConstruccion);
					
							}
						}
						solucionEnConstruccion.remove(estacionSiguiente);
						metrosDeRedActualEnConstruccion -= longitudDelTunel;

					}	
				}
			} /*cierro while*/
			return false;
		}
	}

	//metodo que devuelve el arraylist de red de subterraneo
	public ArrayList<T> getRedSubterraneo(){
		return redSubterraneo;
	}
	

	

}
