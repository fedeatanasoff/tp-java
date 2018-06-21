package arboles;

public class Nodo<Integer> {
	int info;
	Nodo<Integer> izq;
	Nodo<Integer> der;
	
	public Nodo(int elem) {
		this.info = elem;
	}

	@Override
	public String toString() {
		return ""+ info + "";
	}


}
