import java.util.ArrayList;

public class ComandoObservar extends Comando {
	private BibliotecaFachada biblio = BibliotecaFachada.getInstance();
	@Override
	public String executar(ArrayList<String> args) {
		biblio.observar(args.get(0), args.get(1));
		return null;
	}

}
