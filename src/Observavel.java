import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class Observavel {
	private List<Observador> observadores = new LinkedList<Observador>();
	
	public Observavel() {}
	
	public void registrarObservador(Observador obs) {
		observadores.add(obs);
	}
	
	public void removerObservador(Observador obs) {
		observadores.remove(obs);
	}
	
	protected void notificarObservadores() {
		Iterator<Observador> it = observadores.iterator();
		while(it.hasNext()) {
			Observador ob = it.next();
			ob.atualizar(this);
		}
	}

}
