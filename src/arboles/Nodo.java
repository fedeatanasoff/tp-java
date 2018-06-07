package arboles;

public class Nodo {
	int info;
	Nodo izq;
	Nodo der;
	
	public Nodo(int elem) {
		this.info = elem;
	}

	@Override
	public String toString() {
		return "Nodo [info=" + info + "]";
	}	

}
