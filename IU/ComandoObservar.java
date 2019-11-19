import java.util.ArrayList;

public class ComandoObservar extends Comando {

	@Override
	public String executar(ArrayList<String> args, BibliotecaFachada biblio) {
		biblio.emprestar(args.get(0), args.get(1));
		return null;
	}

}
