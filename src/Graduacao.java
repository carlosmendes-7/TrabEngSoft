
public class Graduacao extends NivelAluno {

	@Override
	public int getTempoEmprestimo() {
		return 3;
	}

	@Override
	public int getQtdMaxEmprestimos() {
		return 3;
	}

}
