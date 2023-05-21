package TPEspecial;

import java.util.List;

public class Main {
	public static <T> void main(String[]args) {
		
		GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		grafo.agregarVertice(6);


		grafo.agregarArco(1, 4, null);
		grafo.agregarArco(1, 3, null);
		grafo.agregarArco(4, 2 ,null);
		grafo.agregarArco(3, 2, null);
		grafo.agregarArco(5, 2, null);
		grafo.agregarArco(5, 6, null);

		
//		grafo.borrarVertice(1);
		
		System.out.println(grafo.cantidadVertices());
		System.out.println(grafo.cantidadArcos());
		System.out.println(grafo.existeArco(1, 2));
		
		ServicioBFS<Integer> BFS = new ServicioBFS<Integer>(grafo);
		ServicioDFS<Integer> DFS = new ServicioDFS<Integer>(grafo);
		ServicioCaminos<Integer> Camino = new ServicioCaminos<Integer>(grafo,1,2,3);

		System.out.println("Arco tree DFS " + DFS.dfsForest());
		System.out.println("Arco Tree BFS " + BFS.bfsForest());
		System.out.println(Camino.caminos());

	}
}
