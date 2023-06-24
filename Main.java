package src.TPEspecial;


public class Main {
	public static <T> void main(String[]args) {
	
	//Segunda parte TPE
		GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<Integer>();

		String path = "/home/martu/eclipse-workspace/Programacion3/src/src/TPEspecial/Dataset/dataset1.txt";
		CSVReader<Integer> reader = new CSVReader<Integer>(path);
		reader.read(grafo);
		Greedy<Integer> greedy = new Greedy<Integer>();
		greedy.aplicarGreedy(grafo);
		System.out.println("Greedy");
		System.out.println(greedy.getRedSubterraneos());
		System.out.println(greedy.getSuma() + " kms");
		System.out.println( greedy.getContadorGreedy() + " metrica" );


	}
}
