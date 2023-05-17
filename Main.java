package TPEspecial;

public class Main {
	public static <T> void main(String[]args) {
		
		GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		
		grafo.agregarArco(1, 2, null);
		grafo.agregarArco(1, 3, null);
		grafo.agregarArco(2, 4, null);
		grafo.agregarArco(3, 2, null);
		
//		grafo.borrarVertice(1);
		
		System.out.println(grafo.cantidadVertices());
		System.out.println(grafo.cantidadArcos());
		System.out.println(grafo.existeArco(3, 2));
		
		ServicioBFS<Integer> BFS = new ServicioBFS<Integer>(grafo);
		
		System.out.println(BFS.bfsForest());

	}
}
