import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
		comandos.put("ntf", new ComandoConsultarQtdNotificacoes());
		
        System.out.println("####### SEJA BEM VINDO AO SISTEMA DA BIBLIOTECA ######\n");
        System.out.println("Escolha um dos serviços abaixo:");
        System.out.println("Emprestar Livro - ('emp codigoDoUsuario codigoDoLivro')");
        System.out.println("Devolver Livro - ('dev codigoDoUsuario codigoDoLivro')");
        System.out.println("Reservar Livro - ('res codigoDoUsuario codigoDoLivro')");
        System.out.println("Observar Livro - ('obs codigoDoUsuario codigoDoLivro')");
        System.out.println("Consultar Livro - ('liv codigoDoLivro')");
        System.out.println("Consultar Usuário - ('usu codigoDoUsuario')");
        System.out.println("Consultar quantidade de Notificações - ('nft codigoDoUsuario')");
        
        Scanner string = new Scanner(System.in);
        String servico;
        do {
            servico = string.next();
    		if (servico.equals("emp")) {
        		ArrayList<String> arg = new ArrayList<String>();
        		Comando emp = comandos.get(servico);
      		
        		arg.add(string.next());
        		arg.add(string.next());
        		emp.executar(arg);
        	}
        	else if (servico.equals("dev")) {
        		ArrayList<String> arg = new ArrayList<String>();
        		Comando dev = comandos.get(servico);
      		
        		arg.add(string.next());
        		arg.add(string.next());
        		dev.executar(arg);
        	}
        	else if (servico.equals("res")) {
        		ArrayList<String> arg = new ArrayList<String>();
        		Comando res = comandos.get(servico);
      		
        		arg.add(string.next());
        		arg.add(string.next());
        		res.executar(arg);
        	}
           	else if (servico.equals("obs")) {
        		ArrayList<String> arg = new ArrayList<String>();
        		Comando obs = comandos.get(servico);
      		
        		arg.add(string.next());
        		arg.add(string.next());
        		obs.executar(arg);
        	}
           	else if (servico.equals("liv")) {
        		ArrayList<String> arg = new ArrayList<String>();
        		Comando liv = comandos.get(servico);
        		
        		arg.add(string.next());
        		liv.executar(arg);
           	}
           	else if (servico.equals("usu")) {
        		ArrayList<String> arg = new ArrayList<String>();
        		Comando usu = comandos.get(servico);
        		
        		arg.add(string.next());
        		usu.executar(arg);
           	}
           	else if (servico.equals("nft")) {
        		ArrayList<String> arg = new ArrayList<String>();
        		Comando nft = comandos.get(servico);
        		
        		arg.add(string.next());
        		nft.executar(arg);
           	}
           	else if (servico.equals("sair")) {
           		System.out.println("Encerrando sistema da Biblioteca...");
           	}
           	else System.out.println("Escolha um comando válido, ou digite 'sair' para finalizar");
        } while (!servico.equals("sair"));
        
        string.close();
	}
}
