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
	
	public List<Integer> BFS() {
		List<Integer> arbol = new ArrayList<Integer>();
		Iterator<Integer> it= this.grafo.obtenerVertices();
		this.lista = new ArrayList<>();
		while(it.hasNext()) {
			Integer vertice = it.next();
			visitado.put(vertice, false);
		}
		while(it.hasNext()) {
			if(visitado.containsValue(false)) {
				List<Integer> Arbol = BFS_Visit(it.next());
			}
		}
		return arbol;
		
	}
	
	private List<Integer> BFS_Visit(Integer v) {
		List<Integer> resultado = new ArrayList<Integer>();
		visitado.put(v, true);
		this.lista.add(v);
		while(!lista.isEmpty()) {
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(lista.get(0));
			lista.remove(lista.get(0));
			while(it.hasNext()) {
				Integer ady = it.next();
				if(visitado.get(ady).equals(false)) {
					visitado.put(ady, true);
					lista.add(ady);
					
				}
			
		}
		}
		return lista;
	}
	
	
}
