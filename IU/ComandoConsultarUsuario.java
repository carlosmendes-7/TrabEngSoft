import java.util.ArrayList;

public class ComandoConsultarUsuario extends Comando {
	private BibliotecaFachada biblio = BibliotecaFachada.getInstance();
	@Override
	public String executar(ArrayList<String> args) {
		biblio.consultarUsuario(args.get(0));
		return null;
	}

}
