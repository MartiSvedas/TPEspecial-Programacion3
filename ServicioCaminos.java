package TPEspecial;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class ServicioCaminos<T> {
	private Grafo<T> grafo;
	private int origen;
	private int destino;
	private int lim;
	private HashMap <Arco<T>,Boolean> visitado;
	private HashMap <Integer, String> colores;
	
	public ServicioCaminos(Grafo<T> g ,int origen, int destino, int lim) {
		this.grafo = g;
		this.origen=origen;
		this.destino=destino;
		this.lim=lim;
		this.visitado= new HashMap<>();
	}
	
//	Caminos: dado un origen, un destino y un límite “lim” retorna todos los caminos que, partiendo del
//	vértice origen, llega al vértice de destino sin pasar por más de “lim” arcos. Aclaración importante: en
//	un camino no se puede pasar 2 veces por el mismo arco
	
	public List<List<Integer>> caminos(){
		Iterator <Integer> vertices = this.grafo.obtenerVertices();
		Iterator<Arco<T>> arcos = this.grafo.obtenerArcos();
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		while(vertices.hasNext()) {
			Integer vertice = vertices.next();
			colores.put(vertice,"blanco");
		}while(arcos.hasNext()) {
			Arco<T> arco = arcos.next();
			visitado.put(arco, false);
		}
		resultado.addAll(buscarCaminos(this.origen));
		return resultado;
	}
	
	private List<List<Integer>> buscarCaminos(Integer v){
		colores.put(v, "amarillo");
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		int cantidad =0;
		Iterator<Integer> it = this.grafo.obtenerAdyacentes(v);
		while(it.hasNext()) {
			Integer ady = it.next();
			if(ady!=this.destino) {
				Iterator<Arco<T>> arcos = this.grafo.obtenerArcos();
				Arco<T> arco = arcos.next();
					
				}
			}
		}
		
	}
}
