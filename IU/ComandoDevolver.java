import java.util.ArrayList;

public class ComandoDevolver extends Comando {
	private BibliotecaFachada biblio = BibliotecaFachada.getInstance();
	@Override
	public String executar(ArrayList<String> args) {
		biblio.devolver(args.get(0), args.get(1));
		return null;
	}

}
