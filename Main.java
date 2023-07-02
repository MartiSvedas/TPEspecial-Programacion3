package src.TPEspecial;


public class Main {
	public static <T> void main(String[]args) {
	
	GrafoNoDirigido<Integer> grafo = new GrafoNoDirigido<Integer>();
	
		String path = "/home/martu/eclipse-workspace/Programacion3/src/src/TPEspecial/Dataset/dataset3.txt";
		CSVReader<Integer> reader = new CSVReader<Integer>(path);
		reader.read(grafo);
		
		Greedy<Integer> greedy = new Greedy<Integer>();
		Timer timerGreedy = new Timer();
		timerGreedy.start();
		greedy.aplicarGreedy(grafo);
		double tiempo= timerGreedy.stop();
		System.out.println("Greedy");
		System.out.println(greedy.getRedSubterraneos());
		System.out.println(greedy.getSuma() + " kms");
		System.out.println(greedy.getContadorGreedy() + " metrica" );
		System.out.println("El tiempo en greedy es: "+tiempo);

//		GrafoDirigido<Integer> grafo1 = new GrafoDirigido<Integer>();
//
//		CSVReader<Integer> reader1 = new CSVReader<Integer>(path);
//		reader1.read(grafo1);
		
//		Backtracking<Integer> backtracking = new Backtracking<>();
//		Back<Integer> backtrackingNew = new Back<>();
//
//		backtrackingNew.resolverBacktraking(grafo);
//		System.out.println("Mi red de subte queda: "+backtrackingNew.getRedSubterraneo());
//		System.out.println("La longitud red de subte queda: "+backtrackingNew.getLongitudRedSubterraneo());

	}
}
