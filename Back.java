package src.TPEspecial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Back<T> {
			
			private ArrayList<Arco<T>> redSubterraneo;
			public int longitudRedSubterraneo;

			private HashMap<T,Boolean> visitados= new HashMap<>();
			
			public Back(){
				this.redSubterraneo = new ArrayList<>();
				longitudRedSubterraneo = Integer.MAX_VALUE; /*Esto es un número muy, muy grande*/
				this.visitados = new HashMap<>();
			}
			
			public void resolverBacktraking(GrafoNoDirigido<T> grafo) {
				ArrayList<Arco<T>> solucion= new ArrayList<>();
				Iterator<T> estaciones = grafo.obtenerVertices();

				backtracking(grafo,estaciones.next(),0,solucion);
			}
			
			//poda: si el camino que llevo es mas largo que el camino parcial tengo guardado como más corto podo toda esa rama.
			public boolean poda(int sumaCaminoHastaAhora){
				return sumaCaminoHastaAhora >= longitudRedSubterraneo;
			}
			
			public void backtracking(GrafoNoDirigido<T> grafo, T estacionActual, int metrosDeRedActualEnConstruccion, ArrayList<Arco<T>> solucionEnConstruccion){
				
				if(grafo.cantidadArcos() == solucionEnConstruccion.size() || visiteTodasLasEstaciones(visitados)){
					
					if(metrosDeRedActualEnConstruccion<=longitudRedSubterraneo){
						
						longitudRedSubterraneo = metrosDeRedActualEnConstruccion;
						redSubterraneo.clear();
						redSubterraneo.addAll(solucionEnConstruccion);
					}
				}

				else{
					Iterator<T> iteradorDeEstaciones = grafo.obtenerAdyacentes(estacionActual);
					while(iteradorDeEstaciones.hasNext()){

						T estacionSiguiente = iteradorDeEstaciones.next();
						visitados.put(estacionActual, true);
						if(!solucionEnConstruccion.contains( grafo.obtenerArco(estacionActual,estacionSiguiente))){
							Arco<T> tunelEntreLasEstaciones = grafo.obtenerArco(estacionActual,estacionSiguiente); 
							int longitudDelTunel = tunelEntreLasEstaciones.getEtiqueta();
							

								solucionEnConstruccion.add(tunelEntreLasEstaciones);
								metrosDeRedActualEnConstruccion += longitudDelTunel;
								
								if(!poda(metrosDeRedActualEnConstruccion)){
								backtracking(grafo, estacionSiguiente, metrosDeRedActualEnConstruccion, solucionEnConstruccion);
								}

					            visitados.put(estacionActual, false);
								metrosDeRedActualEnConstruccion -= longitudDelTunel;
								solucionEnConstruccion.remove(tunelEntreLasEstaciones);
								
							}	
						}
					
				}
			}
			
			public boolean visiteTodasLasEstaciones(HashMap<T,Boolean> visitados) {
				return visitados.values().stream().filter(v -> v.equals(true)).count() == visitados.keySet().size()-1;
			}

			//metodo que devuelve el arraylist de red de subterraneo
			public ArrayList<Arco<T>> getRedSubterraneo(){
				return redSubterraneo;
			}

			public int getLongitudRedSubterraneo() {
				return longitudRedSubterraneo;
			}
			
			



		
}
