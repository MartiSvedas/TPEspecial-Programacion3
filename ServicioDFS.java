package src.TPEspecial;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

public class ServicioDFS<T> {
	private Grafo<T> grafo ;
	private HashMap<T, String> colores;
	
	public ServicioDFS(Grafo<T> g) {
		this.grafo=g;
		this.colores= new HashMap<>();
	}
	
	public List<T> dfsForest(){
		Iterator<T> it = this.grafo.obtenerVertices();
		List<T> tree = new ArrayList<T>();
		while(it.hasNext()) {
			T vertice = it.next();
			colores.put(vertice, "blanco");
		}
		it = this.grafo.obtenerVertices();
		while(it.hasNext()) {
			T vertice = it.next();
			if( colores.get(vertice)=="blanco") {
			tree.addAll(dfs_Visit(vertice));
			}
		}
		return tree;
	}
	
	private List<T> dfs_Visit(T v){
		colores.put(v, "amarillo");
		Iterator<T> it = this.grafo.obtenerAdyacentes(v);
		List<T> resultado = new ArrayList<T>();
		resultado.add(v);
		while(it.hasNext()) {
			T ady=it.next();	
			if(colores.get(ady).equals("blanco")) {
				resultado.addAll(dfs_Visit(ady));
		}
		}
		colores.put(v, "negro");	
		return resultado;
	}
	

}
