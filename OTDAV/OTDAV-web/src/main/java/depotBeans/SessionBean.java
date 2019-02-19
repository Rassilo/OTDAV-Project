package depotBeans;
import Entities.Deposant;

public class SessionBean {
	
	private static Deposant currentDeposant=null;

	public static Deposant getCurrentDeposant() {
			return currentDeposant;
	}

	public static void setCurrentDeposant(Deposant deposant) {
		SessionBean.currentDeposant = deposant;
	}
	
	public static boolean isConnected() {
		return currentDeposant != null;
	}
	
}
