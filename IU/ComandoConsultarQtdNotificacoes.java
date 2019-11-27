import java.util.ArrayList;

public class ComandoConsultarQtdNotificacoes extends Comando {
	private BibliotecaFachada biblio = BibliotecaFachada.getInstance();
	@Override
	public String executar(ArrayList<String> args) {
		biblio.consultarQtdNotificacoes(args.get(0));
		return null;
	}

}
