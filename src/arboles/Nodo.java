package arboles;

public class Nodo {
	Integer info, altura;
	Nodo hi, hd;
	
	public Nodo(int valor) {
		this.info = valor;
		this.altura= 0;
		this.hi = null;
		this.hd = null;
	}

	@Override
	public String toString() {
		return "" + info + "";
	}


}
