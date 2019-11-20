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
		 dt = calendario.getTime();
		 return dt;
	 }
	 
	 public void efetuarDevolucao(Emprestimo emprestimo) {
		emprestimo.setDataDevolucaoEfetiva(new Date());
		historico.add(emprestimo);
		emprestimosAtuais.remove(emprestimo);
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

	@Override
	public String toString() {
		final String fimDeLinha = System.getProperty("line.separator");
		
		String string = "Nome: " + getNome() + "." + fimDeLinha;
		
		string += "Usuario possui " +  emprestimosAtuais.size() + " emprestimo(s) corrente(s)." + fimDeLinha;
		if(!emprestimosAtuais.isEmpty())
			string += "Emprestimos correntes:" + fimDeLinha;
		Iterator<Emprestimo> emp = emprestimosAtuais.iterator();
		while(emp.hasNext()) {
			Emprestimo atual = emp.next();
			string += "\tTitulo do livro: " + atual.getLivro().getTitulo() + fimDeLinha;
			string += "\tData do emprestimo: " + atual.getDataEmprestimo() + fimDeLinha;
			string += "\tDevolucao devida para: " + atual.getDataDevolucaoDevida() + fimDeLinha + fimDeLinha;
		}
		
		string += "Usuario realizou " +  historico.size() + " emprestimo(s) passado(s)." + fimDeLinha;
		if(!historico.isEmpty())
			string += "Emprestimos finalizados:" + fimDeLinha;
		Iterator<Emprestimo> his = historico.iterator();
		while(his.hasNext()) {
			Emprestimo pass = his.next();
			string += "\tTitulo do livro: " + pass.getLivro().getTitulo() + fimDeLinha;
			string += "\tData do emprestimo: " + pass.getDataEmprestimo() + fimDeLinha;
			string += "\tDevolucao realizada em: " + pass.getDataDevolucaoEfetiva() + fimDeLinha + fimDeLinha;
		}
		
		string += "Usuario tem " +  reservas.size() + " reserva(s) em seu nome." + fimDeLinha;
		if(!reservas.isEmpty())
			string += "Reservas:" + fimDeLinha;
		Iterator<Reserva> res = reservas.iterator();
		while(res.hasNext()) {
			Reserva reserva = res.next();
			string += "\tTitulo do livro: " + reserva.getLivro().getTitulo() + fimDeLinha;
			string += "\tData de solicitacao: " + reserva.getData() + fimDeLinha + fimDeLinha;
		}
		return string;
	}
	 
	 

}
