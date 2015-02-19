package es.ucm.fdi.espacios.business.domain;

public enum TipoEspacioEnum {
	AULA("aula"), SALA("sala"), AUDITORIO("auditorio");
	
	private String description;
	
	private TipoEspacioEnum(String description){
		this.setDescription(description);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return description;
	}
}
