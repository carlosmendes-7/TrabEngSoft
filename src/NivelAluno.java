
public abstract class NivelAluno implements TipoUsuario {

	@Override
	public boolean podePegarEmprestado(Usuario user, Livro livro) {
		final String fimDeLinha = System.getProperty("line.separator");
		if(user.devendoEmAtraso()) {
			System.out.println("Não foi possivel realizar emprestimo: usuario deve livro em atraso!" + fimDeLinha);
			return false;
		}
		if(user.getQtdEmprestimosAtuais() >= getQtdMaxEmprestimos()) {
			System.out.println("Não foi possivel realizar emprestimo: usuario chegou à quantidade limite de "
					+ "emprestimos simultaneos!" + fimDeLinha);
			return false;
		}
		if(user.getEmprestimoDoLivro(livro) != null) {
			System.out.println("Não foi possivel realizar emprestimo: usuario já possui um emprestimo "
					+ "deste livro!" + fimDeLinha);
			return false;
		}
		if(!user.temReservaPara(livro) && !livro.existeExemplarNaoReservado()) {
			System.out.println("Não foi possivel realizar emprestimo: todos os exemplares estão reservados "
					+ "e usuario não possui reserva!" + fimDeLinha);
			return false;
		}
		return true;
	}

	@Override
	public abstract int getTempoEmprestimo();
	
	public abstract int getQtdMaxEmprestimos();

}
