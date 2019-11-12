
public class Professor implements TipoUsuario {

	@Override
	public boolean podePegarEmprestado(Usuario user, Livro livro) {
		final String fimDeLinha = System.getProperty("line.separator");
		if(user.devendoEmAtraso()) {
			System.out.println("Não foi possivel realizar emprestimo: usuario deve livro em atraso!" + fimDeLinha);
			return false;
		}
		return true;
	}

	@Override
	public int getTempoEmprestimo() {
		return 7;
	}

}
