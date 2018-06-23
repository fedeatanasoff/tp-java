package arboles;

public class Nodo {
	Integer info;
	Nodo izq;
	Nodo der;
	
	public Nodo(int elem) {
		this.info = elem;
	}

	@Override
	public String toString() {
		return ""+ info + "";
	}


}
