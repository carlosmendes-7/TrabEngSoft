
public interface TipoUsuario {
	public boolean podePegarEmprestado(Usuario user, Livro livro);
	public int getTempoEmprestimo();
}
