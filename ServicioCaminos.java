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
	
	public ServicioCaminos(Grafo<T> g ,int origen, int destino, int lim) {
		this.grafo = g;
		this.origen=origen;
		this.destino=destino;
		this.lim=lim;
		this.visitado= new HashMap<>();
	}
	
	public List<List<Integer>> caminos(){
		
	}
}
