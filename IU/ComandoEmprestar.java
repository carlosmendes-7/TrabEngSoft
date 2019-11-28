import java.util.ArrayList;

public class ComandoEmprestar extends Comando {
	private BibliotecaFachada biblio = BibliotecaFachada.getInstance();
	@Override
	public String executar(ArrayList<String> args) {
		biblio.emprestar(args.get(0), args.get(1));
		return null;
	}

}
