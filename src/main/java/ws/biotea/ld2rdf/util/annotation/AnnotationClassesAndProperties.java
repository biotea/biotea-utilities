package ws.biotea.ld2rdf.util.annotation;

public enum AnnotationClassesAndProperties {
	UMLS_HAS_STY(BioOntologyConfig.getNS("UMLS"), BioOntologyConfig.getURL("UMLS"), "hasSTY"),
	UMLS_CUI(BioOntologyConfig.getNS("UMLS"), BioOntologyConfig.getURL("UMLS"), "cui"),
	UMLS_TUI(BioOntologyConfig.getNS("UMLS"), BioOntologyConfig.getURL("UMLS"), "tui"),
	UMLS_STY(BioOntologyConfig.getNS("UMLS"), BioOntologyConfig.getURL("UMLS"), "sty");

	String value;
	String ns;
	String url;
	private AnnotationClassesAndProperties(String ns, String url, String value) {
		this.value = value;
		this.ns = ns;
		this.url = url;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}	

	public String getNSValue() {
		return this.ns + ":" + this.value;
	}
	public String getURLValue() {
		return this.url + this.value;
	}
}
