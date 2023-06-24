package src.TPEspecial;

import java.util.Iterator;


public interface Grafo<T> {
	public void agregarVertice(T verticeId);
	
	public void borrarVertice(T verticeId);
	
	public void agregarArco(T verticeId1, T verticeId2, int etiqueta);
	
	public void borrarArco(T verticeId1, T verticeId2);
	
	public boolean contieneVertice(T verticeId);
	
	public boolean existeArco(T verticeId1, T verticeId2);
	
	public Arco<T> obtenerArco(T verticeId1, T verticeId2);
	
	public int cantidadVertices();
	
	public int cantidadArcos();
	
	public Iterator<T> obtenerVertices();
	
	public Iterator<T> obtenerAdyacentes(T verticeId);
	
	public Iterator<Arco<T>> obtenerArcos();
	
	public Iterator<Arco<T>> obtenerArcos(T verticeId);
}
