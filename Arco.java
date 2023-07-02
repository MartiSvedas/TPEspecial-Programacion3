package src.TPEspecial;


public class Arco<T> {
	private T verticeOrigen;
	private T verticeDestino;
	private Integer etiqueta;
	
	public Arco(T verticeOrigen, T verticeDestino, Integer etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta ;
	}
	
	public T getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public T getVerticeDestino() {
		return verticeDestino;
	}
	public Integer getEtiqueta() {
		return etiqueta;
	}
	
	public boolean equals(Arco<T> a) {
		return (
				(a.getEtiqueta().equals(this.getEtiqueta()) && a.getEtiqueta().equals(this.getEtiqueta())) 
				|| 
				(a.getEtiqueta().equals(this.getEtiqueta()) && a.getEtiqueta().equals(this.getEtiqueta())));
	}

		
	public String toString() {
		return  "[ "+ verticeOrigen +", "+ verticeDestino +" ]";
	}


}
