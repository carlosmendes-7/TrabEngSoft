
public class AcompanhadorDeNotificacoes extends Usuario implements Observador {
	private int qtdNotificacoes;

	public AcompanhadorDeNotificacoes(String id, String nome, TipoUsuario tipo) {
		super(id, nome, tipo);
		qtdNotificacoes = 0;
	}

	@Override
	public void atualizar(Observavel obs) {
		++qtdNotificacoes;
	}

	public int getQtdNotificacoes() {
		return qtdNotificacoes;
	}

}
