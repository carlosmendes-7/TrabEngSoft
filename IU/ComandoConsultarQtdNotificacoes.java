import java.util.ArrayList;

public class ComandoConsultarQtdNotificacoes extends Comando {

	@Override
	public String executar(ArrayList<String> args, BibliotecaFachada biblio) {
		biblio.consultarQtdNotificacoes(args.get(0));
		return null;
	}

}
