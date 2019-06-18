package depotBeans;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	
	public static Date addYearsFromNow(int n){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR,n);
        return c.getTime();
    }
  
	public static int diffDates(Date dateBegin, Date dateEnd){
	    Calendar cal = new GregorianCalendar();
	    cal.setTime(dateBegin);
	    Calendar cal2 = new GregorianCalendar();
	    cal2.setTime(dateEnd);
	    System.out.println(cal.getTime().toString()+"  , "+cal2.getTime().toString() );
	    int days = (int) Duration.between(cal.toInstant(), cal2.toInstant()).toDays();
	    return  days;
	}
	
}
