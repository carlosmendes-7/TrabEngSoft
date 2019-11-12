import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Usuario {
	private String id;
	private String nome;
	private TipoUsuario tipo;
	private List<Reserva> reservas = new LinkedList<Reserva>();
	private List<Emprestimo> emprestimosAtuais = new LinkedList<Emprestimo>();
	private List<Emprestimo> historico = new ArrayList<Emprestimo>();
	
	public Usuario(String id, String nome, TipoUsuario tipo) {
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public boolean podePegarEmprestado(Livro livro) {
		return tipo.podePegarEmprestado(this, livro);
	}

	public boolean devendoEmAtraso() {
		Iterator<Emprestimo> emp = emprestimosAtuais.iterator();
		while(emp.hasNext()) {
			if(emp.next().getDataDevolucaoDevida().before(new Date()));
				return true;
		}
		return false;
	}

	public int getQtdEmprestimosAtuais() {
		return emprestimosAtuais.size();
	}

	public Emprestimo getEmprestimoDoLivro(Livro livro) {
		Iterator<Emprestimo> emp = emprestimosAtuais.iterator();
		while(emp.hasNext()) {
			Emprestimo emprestimo = emp.next();
			if(emprestimo.getLivro() == livro) {
				return emprestimo;
			}
		}
		return null;
	}

	public boolean temReservaPara(Livro livro) {
		Iterator<Reserva> res = reservas.iterator();
		while(res.hasNext()) {
			Reserva reserva = res.next();
			if(reserva.getLivro() == livro)
				return true;
		}
		return false;
	}

	public Emprestimo efetuarEmprestimo(Livro livro) {
		Iterator<Reserva> res = reservas.iterator();
		while(res.hasNext()) {
			Reserva reserva = res.next();
			if(livro == reserva.getLivro()) {
				reservas.remove(reserva);
				break;
			}		
		}
		Emprestimo emprestimo = new Emprestimo(this, livro, 
		return null;
	}
	
	

}