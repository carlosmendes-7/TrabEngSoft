import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BibliotecaFachada {
	private static BibliotecaFachada instancia;
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Livro> livros = new ArrayList<Livro>();
	private Exemplar Exemplar ;
	
	private BibliotecaFachada() {
		usuarios.add(new Usuario("123", "João da Silva", new Graduacao()));
		usuarios.add(new Usuario("456", "Luiz Fernando Rodrigues", new PosGraduacao()));
		usuarios.add(new Usuario("789", "Pedro Paulo", new Graduacao()));
		usuarios.add(new AcompanhadorDeNotificacoes("100", "Carlos Lucena", new Professor()));
		
		livros.add(new Livro("100", "Engenharia de Software", "AddisonWesley", "Ian Sommervile", "6a", "2000"));
		livros.add(new Livro("101", "UML – Guia do Usuário", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson",
				"7a", "2000"));
		livros.add(new Livro("200", "Code Complete", "MicrosoftPress", "Steve McConnell", "2a", "2014"));
		livros.add(new Livro("201", "Agile Software Development, Principles, Patterns, and Practices",
				"PrenticeHall", "Robert Martin", "1a", "2002"));
		livros.add(new Livro("300", "Refactoring: Improving the Design of Existing Code", 
				"AddisonWesleyProfessional", "Martin Fowler", "1a", "1999"));
		livros.add(new Livro("301", "Software Metrics: A Rigorous and Practical Approach",
				"CRC Press", "Norman Fenton, James Bieman", "3a", "2014"));
		livros.add(new Livro("400", "Design Patterns: Elements of Reusable Object-Oriented Software",
				"AddisonWesleyProfessional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1a", "1994"));
		livros.add(new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language",
				"AddisonWesleyProfessional", "Martin Fowler", "3a", "2003"));
		
		getLivroByID("100").addExemplar(new Exemplar("01"));
		getLivroByID("100").addExemplar(new Exemplar("02"));
		getLivroByID("101").addExemplar(new Exemplar("03"));
		getLivroByID("200").addExemplar(new Exemplar("04"));
		getLivroByID("201").addExemplar(new Exemplar("05"));
		getLivroByID("300").addExemplar(new Exemplar("06"));
		getLivroByID("300").addExemplar(new Exemplar("07"));
		getLivroByID("400").addExemplar(new Exemplar("08"));
		getLivroByID("400").addExemplar(new Exemplar("09"));
	}
	
	private Usuario getUserByID(String idUser) {
		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()) {
			Usuario user = it.next();
			if(idUser.equals(user.getId()))
				return user;
		}
		return null;
	}
	
	private Livro getLivroByID(String idLivro) {
		Iterator<Livro> it = livros.iterator();
		while(it.hasNext()) {
			Livro livro = it.next();
			if(idLivro.equals(livro.getId()))
				return livro;
		}
		return null;
	}
	
	public static BibliotecaFachada getInstance() {
		if(instancia == null) {
			instancia = new BibliotecaFachada();
		}
		return instancia;
	}
	
	public void emprestar(String idUser, String idLivro) {
		final String fimDeLinha = System.getProperty("line.separator");
		Usuario user = getUserByID(idUser);
		Livro livro = getLivroByID(idLivro);
		Exemplar exemplar = livro.getExemplarDisponivel();
		if(exemplar == null) {
			System.out.println("Não foi possivel realizar emprestimo: não há exemplar disponível!" + fimDeLinha);
			return;
		}
		if(user.podePegarEmprestado(livro)) {
			Emprestimo emprestimo = user.efetuarEmprestimo(livro);
			livro.emprestarExemplar(exemplar, emprestimo);
		}
	}
	
	public void devolver(String idUser, String idLivro) {
		final String fimDeLinha = System.getProperty("line.separator");		
		Usuario user = getUserByID(idUser);
		Livro livro = getLivroByID(idLivro);
		Emprestimo emp = user.getEmprestimoDoLivro(livro);
		if (emp == null) {
			System.out.println("Não foi possivel devolver o livro: Este livro não foi emprestado para este usuário!" + fimDeLinha);
		}
		else {
		//emp.setDataDevolucaoEfetiva(new Date());
			user.efetuarDevolucao(emp);
			livro.devolucaoExemplarEmprestado(livro.getExemplarEmprestado(emp));			
			System.out.println("O usuário "+user.getNome()+" devolveu o livro "+livro.getTitulo() + fimDeLinha);
		}
	}
	
	public void reservar(String idUser, String idLivro) {
		Usuario user = getUserByID(idUser);
		Livro livro = getLivroByID(idLivro);
		//TODO
	}
	
	public void observar(String idUser, String idLivro) {
		Usuario user = getUserByID(idUser);
		Livro livro = getLivroByID(idLivro);
		//TODO
	}
	
	public void consultarLivro(String idLivro) {
		Livro livro = getLivroByID(idLivro);
		System.out.println(livro);
	}
	
	public void consultarUsuario(String idUser) {
		Usuario user = getUserByID(idUser);
		//TODO
	}
	
	public void consultarQtdNotificacoes(String idUser) {
		Usuario user = getUserByID(idUser);
		if(user instanceof AcompanhadorDeNotificacoes)
			System.out.println("Usuario foi notificado " + ((AcompanhadorDeNotificacoes) user).getQtdNotificacoes() + "vezes.");
		else
			System.out.println("Usuario não possui prerrogativa de acompanhar notificacoes!");
	}
}
