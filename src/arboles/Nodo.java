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

	public Integer getAltura() {
		return altura;
	}

	public void setAltura(Integer altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "valor: " + info + " altura: "+ altura+ "\n";
	}


}
