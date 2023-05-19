package TPEspecial;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

public class ServicioDFS<T> {
	private Grafo<Integer> grafo ;
	private HashMap<Integer, String> colores;
	
	public ServicioDFS(Grafo<Integer> g) {
		this.grafo=g;
		this.colores= new HashMap<>();
	}
	
	public List<Integer> dfsForest(){
		Iterator<Integer> it = this.grafo.obtenerVertices();
		List<Integer> tree = new ArrayList<Integer>();
		while(it.hasNext()) {
			Integer vertice = it.next();
			colores.put(vertice, "blanco");
		}
		it = this.grafo.obtenerVertices();
		while(it.hasNext()) {
			Integer vertice = it.next();
			if( colores.get(vertice)=="blanco") {
			tree.addAll(dfs_Visit(vertice));
			}
		}
		return tree;
	}
	
	private List<Integer> dfs_Visit(Integer v){
		colores.put(v, "amarillo");
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(v);
		List<Integer> resultado = new ArrayList<Integer>();
		resultado.add(v);
		while(it.hasNext()) {
			Integer ady=it.next();	
			if(colores.get(ady).equals("blanco")) {
				resultado.addAll(dfs_Visit(ady));
		}
		}
		colores.put(v, "negro");	
		return resultado;
	}
	

}
