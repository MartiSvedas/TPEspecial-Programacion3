package src.TPEspecial;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import src.TPEspecial.Arco;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Arco<T>>> compGrafo;
	private int cantArcos;

	public GrafoDirigido() {
		this.compGrafo =new HashMap<Integer,ArrayList<Arco<T>>>();	
		cantArcos=0;
	}

	//Complejidad: O(1) 
	public void agregarVertice(int verticeId) {
		compGrafo.putIfAbsent(verticeId, new ArrayList<Arco<T>>());
	}

	//Complejidad: O(m)  m->cantidad de arcos
	public void borrarVertice(int verticeId) {
		for(Arco<T> a: compGrafo.get(verticeId)) {
			if(a.getVerticeDestino()==verticeId || a.getVerticeOrigen()==verticeId) {
				compGrafo.get(verticeId).remove(a);
		}
	}
		compGrafo.remove(verticeId);
	}
	
	//Complejidad: O(1) 
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
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
	public void borrarArco(int verticeId1, int verticeId2) {
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
	public boolean contieneVertice(int verticeId) {
		return compGrafo.containsKey(verticeId);
	}

	//Complejidad : O(m) m-> cantidad de arcos
	public boolean existeArco(int verticeId1, int verticeId2) {
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
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, null);
		if(compGrafo.containsKey(verticeId1)) {
			ArrayList<Arco<T>>arcos =compGrafo.get(verticeId1);
			for(Arco<T> arco : arcos) {
				if(arco.equals(a)) {
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
	public Iterator<Integer> obtenerVertices() {
		return compGrafo.keySet().iterator();
	}
	

	//Complejidad : O(n+m) n->cantidad de vertices m-> cantidad de arcos
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos=new ArrayList<>();
		for(Entry<Integer, ArrayList<Arco<T>>> key : compGrafo.entrySet()) {
			arcos.addAll(key.getValue());
		}
		return arcos.iterator();
	}


	//Complejidad : O(m) m-> cantidad de arcos
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> ady = new ArrayList<>();
		if(compGrafo.containsKey(verticeId)) {
			for(Arco<T> arcos : compGrafo.get(verticeId)) {
				ady.add(arcos.getVerticeDestino());
			}
			}
		return ady.iterator();

	}

	//Complejidad : O(1)
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> values = compGrafo.get(verticeId);
		return values.iterator();	
	}

	
}
