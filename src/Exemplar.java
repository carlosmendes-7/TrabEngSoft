
public class Exemplar {
	private String id;
	private Emprestimo emprestimo;
	
	public Exemplar(String id) {
		this.id = id;
		this.emprestimo = null;
	}
	
	public String getId() {
		return id;
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	
}
