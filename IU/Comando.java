import java.util.ArrayList;

public abstract class Comando {
	public abstract String executar(ArrayList<String> args, BibliotecaFachada biblio);
}
