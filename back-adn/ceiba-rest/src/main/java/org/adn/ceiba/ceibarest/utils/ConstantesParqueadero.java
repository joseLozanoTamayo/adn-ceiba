package org.adn.ceiba.ceibarest.utils;

import java.util.Calendar;
import java.util.Date;

public final class ConstantesParqueadero {
	
	
	private ConstantesParqueadero() {}

	public static String ASIGNADO = "ASIGNADO";
	
	public static Integer DIA_HORAS = 24;
	
	public static Long CERO = 0L;
	
	public static Long UNO = 1L;

	public static String DIA_SEMANA(){
		
		String[] dias={"DO","LU","MA", "MI","JU","VI","SA"};
		Date hoy = new Date();
		int numeroDia = 0;
		Calendar cal= Calendar.getInstance();
		cal.setTime(hoy);
		numeroDia = cal.get(Calendar.DAY_OF_WEEK);
		return dias[numeroDia - 1];
	}

}
