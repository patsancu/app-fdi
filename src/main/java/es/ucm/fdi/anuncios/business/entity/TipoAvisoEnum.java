package es.ucm.fdi.anuncios.business.entity;

public enum TipoAvisoEnum {
	URL("Enlace"), ADJUNTO("Adjunto"), HTML("Contenido HTML");
	
	private String description;
	
	private TipoAvisoEnum(String description) {
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
