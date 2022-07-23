package cat.solar.api.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	private DateUtils() {}
	
	public static Date zeroTime( final Date date )
	{
	    return DateUtils.setTime( date, 0, 0, 0, 0 );
	}

	public static Date setTime( final Date date, final int hourOfDay, final int minute, final int second, final int ms )
	{
	    final GregorianCalendar gc = new GregorianCalendar();
	    gc.setTime( date );
	    gc.set( Calendar.HOUR_OF_DAY, hourOfDay );
	    gc.set( Calendar.MINUTE, minute );
	    gc.set( Calendar.SECOND, second );
	    gc.set( Calendar.MILLISECOND, ms );
	    return gc.getTime();
	}
	
	public static Date setDay( final Date date, final int dayOfMonth, final int month, final int year )
	{
	    final GregorianCalendar gc = new GregorianCalendar();
	    gc.setTime( date );
	    gc.set( Calendar.DAY_OF_MONTH, dayOfMonth );
	    gc.set( Calendar.MONTH, month );
	    gc.set( Calendar.YEAR, year );
	    return gc.getTime();
	}

	public static Date addOneDay(Date start) {
		return addMilis(start, (1000 * 60 * 60 * 24));
	}
	
	public static Date addMilis(Date start, long milis) {
		return new Date(start.getTime() + milis);
	}
	
}
