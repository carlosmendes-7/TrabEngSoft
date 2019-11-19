import java.util.ArrayList;

public class ComandoDevolver extends Comando {

	@Override
	public String executar(ArrayList<String> args, BibliotecaFachada biblio) {
		biblio.devolver(args.get(0), args.get(1));
		return null;
	}

}
