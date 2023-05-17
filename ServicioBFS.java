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
		List<Integer> bosque = new ArrayList<Integer>();
		Iterator<Integer> it= this.grafo.obtenerVertices();
		this.lista = new ArrayList<>();
		while(it.hasNext()) {
			Integer vertice = it.next();
			visitado.put(vertice, false);
		}
		while(it.hasNext() || bosque.isEmpty()) {
			if(visitado.containsValue(false)) {
				Integer v = it.next();
				bosque.addAll(BFS_Visit(v));
			}
		}
		return bosque;
		
	}
	
	private List<Integer> BFS_Visit(Integer v) {
		List<Integer> resultado =new ArrayList<Integer>();
		visitado.put(v, true);
		this.lista.add(v);
		while(!lista.isEmpty()) {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(lista.get(0));
			lista.remove(lista.get(0));
			while(it.hasNext()) {
				Integer ady = it.next();
				if(visitado.get(ady).equals(false)) {
					resultado.add(ady);
					visitado.put(ady, true);
					lista.add(ady);
					
				}
			
		}
		}
		return resultado;
	}
	

	
	
}
