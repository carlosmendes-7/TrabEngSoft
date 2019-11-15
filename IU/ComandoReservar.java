import java.util.ArrayList;

public class ComandoReservar extends Comando {

	@Override
	public String executar(ArrayList<String> args, BibliotecaFachada biblio) {
		biblio.reservar(args.get(0), args.get(1));
		return null;
	}

}
