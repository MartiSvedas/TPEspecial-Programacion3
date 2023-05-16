package TPEspecial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import TPEspecial.Arco;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, ArrayList<Arco<T>>> CompGrafo;

	public GrafoDirigido() {
		this.CompGrafo =new HashMap<Integer,ArrayList<Arco<T>>>();	
	}
	
	public int numVertices() {
		return CompGrafo.size();
	}
	
	@Override
	public void agregarVertice(int verticeId) {
		CompGrafo.putIfAbsent(verticeId, new ArrayList<Arco<T>>());
	}

	@Override
	public void borrarVertice(int verticeId) {
		for(Arco<T> a: CompGrafo.get(verticeId)) {
			if(a.getVerticeDestino()==verticeId) {
				CompGrafo.get(verticeId).remove(a);
		}
	}
		CompGrafo.remove(verticeId);
	}
	
	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, etiqueta);
			if(CompGrafo.containsKey(verticeId1)) {
				CompGrafo.get(verticeId1).add(a);
			}
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, null);
		if(CompGrafo.containsKey(verticeId1)) {
			for(Arco<T> ar:CompGrafo.get(verticeId1)) {
				if(a.equals(ar)) {
					CompGrafo.get(verticeId1).remove(ar);
				}
			}
		}	

	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return CompGrafo.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		boolean existe=false;
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, null);
		for(Arco<T> ar: CompGrafo.get(verticeId1)) {
			if(a.equals(ar)) {
				existe=true;
			}else {
				existe=false;
			}
		}
		return existe;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		Arco<T> a = new Arco<T>(verticeId1, verticeId2, null);
		Arco<T> arc=null;
		if(CompGrafo.containsKey(verticeId1)) {
			for(Arco<T> ar: CompGrafo.get(verticeId1)) {
				if(ar.equals(a)) {
					 ar=a;
				}
			}
			return a;
		}
		else {
			return arc;
		}
		}


	@Override
	public int cantidadVertices() {
		return CompGrafo.keySet().size();
	}

	@Override
	public int cantidadArcos() {
		int cantidad=0;
		for(Entry<Integer,ArrayList<Arco<T>>> key : CompGrafo.entrySet()) {
			for(int i=0; i<key.getValue().size();i++) {
				cantidad++;
			}
		}return cantidad;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		return CompGrafo.keySet().iterator();
	}
	

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		ArrayList<Arco<T>> arcos=new ArrayList<>();
		for(Entry<Integer, ArrayList<Arco<T>>> key : CompGrafo.entrySet()) {
			arcos.addAll(key.getValue());
		}
		return arcos.iterator();
	}


	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		ArrayList<Integer> ady = new ArrayList<>();
		if(CompGrafo.containsKey(verticeId)) {
			for(Arco<T> arcos : CompGrafo.get(verticeId)) {
				ady.add(arcos.getVerticeDestino());
			}
			}
		return ady.iterator();

	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		ArrayList<Arco<T>> values = CompGrafo.get(verticeId);
		return values.iterator();	
	}

	
}
