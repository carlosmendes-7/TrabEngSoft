import java.util.ArrayList;

public class ComandoReservar extends Comando {
	private BibliotecaFachada biblio = BibliotecaFachada.getInstance();
	public String executar(ArrayList<String> args) {
		biblio.reservar(args.get(0), args.get(1));
		return null;
	}

}
