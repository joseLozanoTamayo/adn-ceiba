package org.adn.ceiba.ceibarest.utils;

/**
 * 
 * @author jose.lozano
 *
 */
public enum EstadoServicioErrorEnum {
	
	ERROR_VALIDACION(1), 
	ERROR_CONEXION(2),
	ERROR_FILE(4),
	ERROR_URL(5);
	
	private int value;
	public int getCode(){return this.value;};
	
	private EstadoServicioErrorEnum(int value){this.value = value;}
	
	public static EstadoServicioErrorEnum fromValue(Integer v) {
		for(EstadoServicioErrorEnum c: EstadoServicioErrorEnum.values()) {
			if(c.value == v.intValue())
				return c;
		}
		throw new IllegalArgumentException("CONTRIBUYENTE_ESTADO: " + v);
	}
}
