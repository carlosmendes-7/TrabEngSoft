import java.util.ArrayList;

public class ComandoConsultarLivro extends Comando {
	private BibliotecaFachada biblio = BibliotecaFachada.getInstance();
	@Override
	public String executar(ArrayList<String> args) {
		biblio.consultarLivro(args.get(0));
		return null;
	}

}
