import java.util.Date;

public class Reserva {
	private Date data;
	private Livro livro;
	private Usuario user;
	
	public Reserva(Date data, Livro livro, Usuario user) {
		this.data = data;
		this.livro = livro;
		this.user = user;
	}
	public Date getData() {
		return data;
	}
	public Livro getLivro() {
		return livro;
	}
	public Usuario getUser() {
		return user;
	}
	
	
}
