package ws.biotea.ld2rdf.util.annotation;

public enum Annotator {
	CMA("cma", "CMAParser", "ws.biotea.ld2rdf.annotation.parser", AnnotationResourceConfig.getCMAAnnotationService())
	,NCBO("ncbo", "NCBOParser", "ws.biotea.ld2rdf.annotation.parser", AnnotationResourceConfig.getNCBOAnnotatorURL())
	,AGROPORTAL("agroportal", "AgroPortalParser", "ws.biotea.ld2rdf.annotation.parser", AnnotationResourceConfig.getAgroPortalAnnotatorURL())
	;
	
	String name;
	String parserClass;
	String classLocation;
	String serviceURI;
	
	private Annotator(String name, String parser, String classLocation, String uri) {
		this.name = name;
		this.parserClass = parser;
		this.classLocation = classLocation;
		this.serviceURI = uri;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the parser.
	 */
	public String getParserClass() {
		return this.parserClass;
	}

	/**
	 * @return the classLocation.
	 */
	public String getClassLocation() {
		return classLocation;
	}

	/**
	 * @return the uri
	 */
	public String getServiceURI() {
		return serviceURI;
	}		
	
	public String getClassFullName() {
		return this.getClassLocation() + "." + this.getParserClass(); 
	}
}
