package TPEspecial;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.Iterator;

public class ServicioBFS<T> {
	private Grafo<T> grafo;
	private HashMap <Integer, Boolean> visitado;
	private ArrayList<Integer> lista;
	
	public ServicioBFS(Grafo<T> g) {
		this.grafo=g;
		this.visitado=new HashMap<>();
		this.lista= new ArrayList<>();
	}
	
	public List<Integer> bfsForest() {
		List<Integer> tree = new ArrayList<Integer>();
		Iterator<Integer> it= this.grafo.obtenerVertices();
		List<Integer> vertices = new ArrayList<Integer>();
		this.lista.clear();
		while(it.hasNext()) {
			Integer vertice = it.next();
			visitado.put(vertice, false);
			vertices.addAll(visitado.keySet());
		}while(it.hasNext() || tree.isEmpty()) {
			if(visitado.containsValue(false)) {
				tree.addAll(bfs_Visit(vertices.get(0)));
			}
		}
		return tree;
		
	}
	
	private List<Integer> bfs_Visit(Integer v) {
		List<Integer> resultado =new ArrayList<Integer>();
		visitado.put(v, true);
		resultado.add(v);
		this.lista.add(v);
		while(!lista.isEmpty()) {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(lista.get(0));
			lista.remove(lista.get(0));
			while(it.hasNext()) {
				Integer ady = it.next();
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
