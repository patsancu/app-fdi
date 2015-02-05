package es.ucm.fdi.anuncios.business.domain;

public enum PrioridadesAvisoEnum {
	NORMAL("Normal"), IMPORTANTE("Importante");
	
	private String description;
	
	private PrioridadesAvisoEnum(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getValue() {
		return name();
	}
	
	@Override
	public String toString() {
		return description;
	}
}
