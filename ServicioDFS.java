package TPEspecial;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

public class ServicioDFS {
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
		}while(it.hasNext()|| tree.isEmpty()) {	
			tree.addAll(dfs_Visit(it.next()));
		}
		return tree;
	}
	
	private List<Integer> dfs_Visit(Integer v){
		colores.put(v, "amarillo");
	}
}
