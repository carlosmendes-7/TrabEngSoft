import java.util.ArrayList;
import java.util.Calendar;
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
			Emprestimo atual = emp.next();
			if((atual.getDataDevolucaoDevida()).before(new Date())) {
				return true;
			}
		}
		return false;
	}

	public int getQtdEmprestimosAtuais() {
		return emprestimosAtuais.size();
	}
	
	public int getQtdReservas() {
		return reservas.size();
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
			if(livro == reserva.getLivro())
				return true;
		}
		return false;
	}

	public Emprestimo efetuarEmprestimo(Livro livro) {
		deletarReservaPara(livro);
		//TODO: criar emprestimo com data de devolucao baseada na qtd de dias do TipoUsuario
		Emprestimo emprestimo = new Emprestimo(this, livro, new Date(), dataEntrega(new Date(), tipo.getTempoEmprestimo()));
		emprestimosAtuais.add(emprestimo);
		return emprestimo;
	}
	
	 public Date dataEntrega(Date dt, int entrega) {
		 Calendar calendario = Calendar.getInstance();
		 calendario.setTime(dt); 
		 calendario.add(Calendar.DATE, entrega);
		 calendario.set(Calendar.HOUR_OF_DAY, 23);
		 dt =  calendario.getTime();
		 return dt;
	 }
	 
	 public void efetuarDevolucao(Emprestimo emprestimo) {
			Iterator<Emprestimo> empAtuais = emprestimosAtuais.iterator();
			while(empAtuais.hasNext()) {
				Emprestimo emp = empAtuais.next();
				if(emprestimo == emp) {
					emprestimosAtuais.remove(emprestimo);
					break;
				}		
			}
	 }
	 
	 public Reserva efetuarReserva(Livro livro) {
			if (reservas.size()<3) {
				Reserva res = new Reserva(new Date(), livro, this);
				reservas.add(res);
				return res;
			}
		return null;
	 }
	 
	 public void deletarReservaPara(Livro livro) {
			Iterator<Reserva> res = reservas.iterator();
			while(res.hasNext()) {
				Reserva reserva = res.next();
				if(livro == reserva.getLivro()) {
					reservas.remove(reserva);
					break;
				}		
			}
	 }
	 
	 

}
