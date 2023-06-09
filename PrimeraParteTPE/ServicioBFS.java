package src.TPEspecial;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

public class ServicioBFS<T> {
	private Grafo<T> grafo;
	private HashMap <T, Boolean> visitado;
	private ArrayList<T> lista;
	
	public ServicioBFS(Grafo<T> g) {
		this.grafo=g;
		this.visitado=new HashMap<>();
		this.lista= new ArrayList<>();
	}
	
	public List<T> bfsForest() {
		List<T> tree = new ArrayList<T>();
		Iterator<T> it= this.grafo.obtenerVertices();
		this.lista.clear();
		while(it.hasNext()) {
			T vertice = it.next();
			visitado.put(vertice, false);
		}
		it = this.grafo.obtenerVertices();
		while(it.hasNext()) {
			T vertice = it.next();
			if(visitado.get(vertice)==false) {
				tree.addAll(bfs_Visit(vertice));
		}
		}
		return tree;
		
	}
	
	private List<T> bfs_Visit(T v) {
		List<T> resultado =new ArrayList<T>();
		visitado.put(v, true);
		resultado.add(v);
		this.lista.add(v);
		while(!lista.isEmpty()) {
			Iterator<T> it = this.grafo.obtenerAdyacentes(lista.get(0));
			lista.remove(lista.get(0));
			while(it.hasNext()) {
				T ady = it.next();
				if(visitado.get(ady).equals(false)) {
					resultado.add(ady);
					visitado.put(ady, true);
					this.lista.add(ady);
				}
			
		}
		}
		return resultado;
		
	}
	

	
	
}
