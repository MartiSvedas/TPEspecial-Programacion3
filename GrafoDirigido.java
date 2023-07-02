package src.TPEspecial;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import src.TPEspecial.Arco;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<T, ArrayList<Arco<T>>> compGrafo;
	private int cantArcos;

	public GrafoDirigido() {
		this.compGrafo =new HashMap<T,ArrayList<Arco<T>>>();	
		cantArcos=0;
	}

	//Complejidad: O(1) 
	public void agregarVertice(T verticeId) {
		compGrafo.putIfAbsent(verticeId, new ArrayList<Arco<T>>());
	}

	//Complejidad: O(m)  m->cantidad de arcos
	public void borrarVertice(T verticeId) {
		for(Arco<T> a: compGrafo.get(verticeId)) {
			if(a.getVerticeDestino()==verticeId && a.getVerticeOrigen()==verticeId) {
				compGrafo.get(verticeId).remove(a);
		}
	}
		compGrafo.remove(verticeId);
	}
	
	//Complejidad: O(1) 
	public void agregarArco(T verticeId1, T verticeId2, int etiqueta) {
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
			if(compGrafo.containsKey(verticeId1)) {
				ArrayList<Arco<T>>arcos =compGrafo.get(verticeId1);
				if(!arcos.contains(a) && a.getVerticeDestino()==verticeId2) {
				compGrafo.get(verticeId1).add(a);
				}
			}
			cantArcos++;
	}

	//Complejidad : O(m) m-> cantidad de arcos
	public void borrarArco(T verticeId1, T verticeId2) {
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, null);
		if(compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>>arcos =compGrafo.get(verticeId1);
			Iterator<Arco<T>> iterator = arcos.iterator();
			while(iterator.hasNext()) {
				Arco<T> arco= iterator.next();
				if(a.equals(arco)) {
				iterator.remove();	
				}
			}
		}	
		cantArcos--;

	}

	//Complejidad : O(1) 
	public boolean contieneVertice(T verticeId) {
		return compGrafo.containsKey(verticeId);
	}

	//Complejidad : O(m) m-> cantidad de arcos
	public boolean existeArco(T verticeId1, T verticeId2) {
		boolean existe=false;
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, null);
		for(Arco<T> ar: compGrafo.get(verticeId1)) {
			if(a.equals(ar)) {
				existe=true;
			}else {
				existe=false;
			}
		}
		return existe;
	}

	//Complejidad : O(m ) m-> cantidad de arcos 
	public Arco<T> obtenerArco(T verticeId1, T verticeId2) {
		if(compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>>arcos =compGrafo.get(verticeId1);
			for(Arco<T> arco : arcos) {
				if(arco.getVerticeDestino().equals(verticeId2)) { //FIXME FIXME para que ande tambien en GND
					return arco;
				}
			}
		}
		return null;
		}


	//Complejidad: O(1)
	public int cantidadVertices() {
		return compGrafo.keySet().size();
	}

	//Complejidad : O(1) 
	public int cantidadArcos() {
		return cantArcos;
	}

	//Complejidad: O(1)  
	public Iterator<T> obtenerVertices() {
		return compGrafo.keySet().iterator();
	}
	

	//Complejidad : O(n+m) n->cantidad de vertices m-> cantidad de arcos
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos=new ArrayList<>();
		for(Entry<T, ArrayList<Arco<T>>> key : compGrafo.entrySet()) {
			arcos.addAll(key.getValue());
		}
		return arcos.iterator();
	}


	//Complejidad : O(m) m-> cantidad de arcos
	public Iterator<T> obtenerAdyacentes(T verticeId) {
		ArrayList<T> ady = new ArrayList<>();
		if(compGrafo.containsKey(verticeId)) {
			for(Arco<T> arcos : compGrafo.get(verticeId)) {
				ady.add(arcos.getVerticeDestino());
			}
			}
		return ady.iterator();

	}

	//Complejidad : O(1)
	public Iterator<Arco<T>> obtenerArcos(T verticeId) {
		ArrayList<Arco<T>> values = compGrafo.get(verticeId);
		return values.iterator();	
	}

	
}
