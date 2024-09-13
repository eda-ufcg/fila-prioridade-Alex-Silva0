public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.last = -1;
		this.head = -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		Pair p = new Pair(elemento, prioridade);
		if (this.head == -1 && this.last == -1) {
			this.head = 0;
		}
		
		this.last = (this.last + 1) % this.fila.length;
		
		this.fila[this.last] = p;
		for (int i = this.last - 1; i >= 0; i--) {
			if (this.fila[i + 1].getPrioridade() < this.fila[i].getPrioridade()) {
				break;
			}
			Pair aux = this.fila[i + 1];
			this.fila[i + 1] = this.fila[i];
			this.fila[i] = aux;
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		String element = this.fila[this.head].getElemento();
		head = (this.head + 1) % this.fila.length;
		return element;
	}

}
