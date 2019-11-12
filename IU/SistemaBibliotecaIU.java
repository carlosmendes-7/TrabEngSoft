import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaBibliotecaIU {

	public static void main(String[] args) throws IOException {
		HashMap<String,Comando> comandos = new HashMap<String, Comando>();
		comandos.put("emp", new ComandoEmprestar());
		comandos.put("dev", new ComandoDevolver());
		comandos.put("res", new ComandoReservar());
		comandos.put("obs", new ComandoObservar());
		comandos.put("liv", new ComandoConsultarLivro());
		comandos.put("usu", new ComandoConsultarUsuario());
		comandos.put("ntf", new ComandoConsultarNotificacoesProfessor());
		
        Scanner s = null;

        try {
            s = new Scanner(System.in);

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
	}

}
