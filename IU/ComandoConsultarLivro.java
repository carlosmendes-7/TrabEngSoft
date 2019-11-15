import java.util.ArrayList;

public class ComandoConsultarLivro extends Comando {

	@Override
	public String executar(ArrayList<String> args, BibliotecaFachada biblio) {
		biblio.consultarLivro(args.get(0));
		return null;
	}

}
