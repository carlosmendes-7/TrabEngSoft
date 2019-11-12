import java.util.Date;

public class Emprestimo {
	private Usuario user;
	private Livro livro;
	private Date dataEmprestimo;
	private Date dataDevolucaoDevida;
	private Date dataDevolucaoEfetiva;
	
	public Emprestimo(Usuario user, Livro livro, Date dataEmprestimo, Date dataDevolucaoDevida) {
		this.user = user;
		this.livro = livro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoDevida = dataDevolucaoDevida;
		this.dataDevolucaoEfetiva = null;
	}
	public Usuario getUser() {
		return user;
	}
	public Livro getLivro() {
		return livro;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public Date getDataDevolucaoDevida() {
		return dataDevolucaoDevida;
	}
	
	public Date getDataDevolucaoEfetiva() {
		return dataDevolucaoEfetiva;
	}
	public void setDataDevolucaoEfetiva(Date dataDevolucaoEfetiva) {
		this.dataDevolucaoEfetiva = dataDevolucaoEfetiva;
	}
}
