package TPEspecial;


public class Arco<T> {
	private Integer verticeOrigen;
	private Integer verticeDestino;
	private T etiqueta;
	
	public Arco(Integer verticeOrigen, Integer verticeDestino, T etiqueta) {
		this.verticeOrigen = verticeOrigen;
		this.verticeDestino = verticeDestino;
		this.etiqueta = etiqueta ;
	}
	
	public Integer getVerticeOrigen() {
		return verticeOrigen;
	}
	
	public Integer getVerticeDestino() {
		return verticeDestino;
	}
	public T getEtiqueta() {
		return etiqueta;
	}
	
	public boolean equals(Arco<T> a) {
		if(a.verticeOrigen==this.verticeOrigen && a.getVerticeDestino()==this.getVerticeDestino()) {
			return true;
		}else {
			return false;
		}
	}
		
	public String toString() {
		return "El vertice origen es [ vertice origen = " + verticeOrigen + "] El vertice destino del arco es [ vertice destino = " + verticeDestino + " ]";
	}
}
