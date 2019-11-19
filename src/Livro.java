import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Livro extends Observavel{
	private String id;
	private String titulo;
	private String editora;
	private String autor;
	private String edicao;
	private String ano;
	private List<Reserva> reservas = new LinkedList<Reserva>();
	private List<Exemplar> exemplares = new ArrayList<Exemplar>();
	
	public Livro(String id, String titulo, String editora, String autor, String edicao, String ano) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.editora = editora;
		this.autor = autor;
		this.edicao = edicao;
		this.ano = ano;
	}
	
	public void addExemplar(Exemplar ex) {
		exemplares.add(ex);
	}

	public String getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public int getQtdReservas() {
		return reservas.size();
	}
	
	@Override
	public String toString() {
		final String fimDeLinha = System.getProperty("line.separator");
		
		String string = "Titulo: " + getTitulo() + "." + fimDeLinha;
		
		string += "Livro tem " + reservas.size() + " reservas." + fimDeLinha;
		if(!reservas.isEmpty())
			string += "Reservado por:" + fimDeLinha;
		Iterator<Reserva> res = reservas.iterator();
		while(res.hasNext()) {
			string += "\t" + res.next().getUser().getNome() + fimDeLinha;
		}
		
		string += "Exemplares: " + fimDeLinha;
		if(exemplares.isEmpty())
			string += "\tNão há exemplares deste livro na biblioteca!";
		Iterator<Exemplar> ex = exemplares.iterator();
		while(ex.hasNext()) {
			Exemplar exemplar = ex.next();
			string += "\tCodigo: " + exemplar.getId() + fimDeLinha;
			if(exemplar.getEmprestimo() == null)
				string += "\t\tExemplar disponível." + fimDeLinha;
			else {
				string += "\t\tEmprestado para : " + exemplar.getEmprestimo().getUser().getNome() + "." + fimDeLinha;
				string += "\t\tEmprestimo realizado em: " + exemplar.getEmprestimo().getDataEmprestimo() + fimDeLinha;
				string += "\t\tA ser devolvido em: " + exemplar.getEmprestimo().getDataDevolucaoDevida() + fimDeLinha;
			}
		}
		return string;
	}

	public boolean existeExemplarNaoReservado() {
		return exemplares.size() > reservas.size();
	}

	public Exemplar getExemplarDisponivel() {
		Iterator<Exemplar> it = exemplares.iterator();
		while(it.hasNext()) {
			Exemplar exemplar = it.next();
			if(exemplar.getEmprestimo() == null)
				return exemplar;
		}
		return null;
	}
	
	public Exemplar getExemplarEmprestado(Emprestimo emp) {
		Iterator<Exemplar> it = exemplares.iterator();
		while(it.hasNext()) {
			Exemplar exemplar = it.next();
			if(exemplar.getEmprestimo() == emp)
				return exemplar;
		}
		return null;
	}

	public void emprestarExemplar(Exemplar exemplar, Emprestimo emprestimo) {
		exemplar.setEmprestimo(emprestimo);
	}
	
	public void devolucaoExemplarEmprestado(Exemplar exemplar) {
		Emprestimo emprestimo = null;
		exemplar.setEmprestimo(emprestimo);
	}
	
	public void addReserva(Reserva res) {
		reservas.add(res);
		if (this.getQtdReservas() > 2) {
			this.notificarObservadores();
		}
	}
	
	public void removeReserva(Reserva res) {
		reservas.remove(res);
	}
}
