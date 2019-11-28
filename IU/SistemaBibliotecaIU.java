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
        System.out.println("Consultar quantidade de Notificações - ('ntf codigoDoUsuario')");
        
        Scanner string = new Scanner(System.in);
        String servico = string.next();
        while (!servico.equals("sair")){
            Comando emp = comandos.get(servico);
            
            ArrayList<String> arg = new ArrayList<String>();
            
            Scanner argumentos = new Scanner(string.nextLine());
            while(argumentos.hasNext()) {
            	arg.add(argumentos.next());
            }
            argumentos.close();
            
            emp.executar(arg);
            servico = string.next();
    	 }
        
        string.close();
	}
}
