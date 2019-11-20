import java.util.ArrayList;

public class ComandoConsultarUsuario extends Comando {

	@Override
	public String executar(ArrayList<String> args, BibliotecaFachada biblio) {
		biblio.consultarUsuario(args.get(0));
		return null;
	}

}
