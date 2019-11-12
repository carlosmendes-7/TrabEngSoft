
public abstract class NivelAluno implements TipoUsuario {

	@Override
	public boolean podePegarEmprestado(Usuario user, Livro livro) {
		final String fimDeLinha = System.getProperty("line.separator");
		if(user.devendoEmAtraso()) {
			System.out.println("N�o foi possivel realizar emprestimo: usuario deve livro em atraso!" + fimDeLinha);
			return false;
		}
		if(user.getQtdEmprestimosAtuais() >= getQtdMaxEmprestimos()) {
			System.out.println("N�o foi possivel realizar emprestimo: usuario chegou � quantidade limite de "
					+ "emprestimos simultaneos!" + fimDeLinha);
			return false;
		}
		if(user.getEmprestimoDoLivro(livro) != null) {
			System.out.println("N�o foi possivel realizar emprestimo: usuario j� possui um emprestimo "
					+ "deste livro!" + fimDeLinha);
			return false;
		}
		if(!user.temReservaPara(livro) && !livro.existeExemplarNaoReservado()) {
			System.out.println("N�o foi possivel realizar emprestimo: todos os exemplares est�o reservados "
					+ "e usuario n�o possui reserva!" + fimDeLinha);
			return false;
		}
		return true;
	}

	@Override
	public abstract int getTempoEmprestimo();
	
	public abstract int getQtdMaxEmprestimos();

}
