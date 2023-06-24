package src.TPEspecial;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


//Caminos: dado un origen, un destino y un límite “lim” retorna todos los caminos que, partiendo del
//vértice origen, llega al vértice de destino sin pasar por más de “lim” arcos. Aclaración importante: en
//un camino no se puede pasar 2 veces por el mismo arco
public class ServicioCaminos<T> {
	private Grafo<T> grafo;
	private int origen;
	private int destino;
	private int lim;
	private HashMap <Integer, String> colores;
	
	public ServicioCaminos(Grafo<T> g ,int origen, int destino, int lim) {
		this.grafo = g;
		this.origen=origen;
		this.destino=destino;
		this.lim=lim;
		this.colores= new HashMap<>();

	}

	
	public List<List<Integer>> caminos(){
		Iterator <Integer> vertices = this.grafo.obtenerVertices();
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();	

		while(vertices.hasNext()) {
			Integer vertice = vertices.next();
			colores.put(vertice,"blanco");
		}
		
		vertices = this.grafo.obtenerVertices();
		while(vertices.hasNext()) {
			Integer ver  = vertices.next();
			if(ver==this.origen) {
				resultado.addAll(buscarCaminos(this.origen,0,new ArrayList<>()));
			}
		}
		
		return resultado;
	}
	

	private List<List<Integer>> buscarCaminos(Integer v, int cantidad, List<Arco<T>> arcosVisitados){
		List<List<Integer>> resultado = new ArrayList<List<Integer>>();
		colores.put(v, "amarillo");
		cantidad ++;

		if(v.equals(this.destino)) {
			ArrayList<Integer> unicoCamino = new ArrayList<>();
			unicoCamino.add(v);
			resultado.add(unicoCamino);
			
		}else {
			Iterator<Arco<T>> arcos =this.grafo.obtenerArcos(v);
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(v);
			
			while(it.hasNext()) {
				Integer ady = it.next();
				Arco<T> arco = arcos.next();
				
				if( cantidad <= lim  && !arcosVisitados.contains(arco)) {
	                List<Arco<T>> nuevosArcosVisitados = new ArrayList<>(arcosVisitados);
	                nuevosArcosVisitados.add(arco);
					List<List<Integer>> caminosParciales = new ArrayList<List<Integer>>();
					caminosParciales.addAll(buscarCaminos(ady, cantidad, nuevosArcosVisitados));	
					
				for(List<Integer> caminoParcial : caminosParciales) {
					List<Integer> nuevoCamino = new ArrayList<>(caminoParcial);
					nuevoCamino.add(0, v);
					resultado.add(nuevoCamino);
					}
					}
				
				}
			
			}
		colores.put(v, "blanco");
		return resultado;
		
		
}

}
