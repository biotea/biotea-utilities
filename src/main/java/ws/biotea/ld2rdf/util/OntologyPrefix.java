package ws.biotea.ld2rdf.util;  

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum OntologyPrefix {
	//OWL
	OWL("http://www.w3.org/2002/07/owl#", "owl"),
	//PROV
	PROV("http://www.w3.org/ns/prov#", "prov"),
	//FOAF
	FOAF("http://xmlns.com/foaf/0.1/", "foaf"), 
	XSP("http://www.owl-ontologies.com/2005/08/07/xsp.owl#", "xsp"),	
	//Biotea
	BIOTEA("http://www.biotea.ws/ontology/ao_biotea.owl#", "biotea"), 
	//RDF
	RDF("http://www.w3.org/1999/02/22-rdf-syntax-ns#", "rdf"), 
	RDFS("http://www.w3.org/2000/01/rdf-schema#", "rdfs"),	
	//VOID
	VOID("http://rdfs.org/ns/void#", "void"),
	//DC
	DCTERMS("http://purl.org/dc/terms/", "dcterms"),
	DC("http://purl.org/dc/elements/1.1/", "dc"),
	;
	
	private String url;
	private String ns;
	
	private OntologyPrefix(String url, String ns) {
		this.url = url;
		this.ns = ns;
	}
	public String getURL() {
		return (this.url);
	}
	public String getNS() {
		return (this.ns);
	}
	public String getPrefix() {
		return "PREFIX " + this.ns + ":<" + this.url + "> ";
	}
	public static OntologyPrefix getByNS(String ns) throws NoSuchElementException {
		for (OntologyPrefix prefix: OntologyPrefix.values()) {
			if (prefix.getNS().equals(ns)) {
				return prefix;
			}
		}
		throw new NoSuchElementException("The prefix with NS " + ns + " cannot be resolved.");
	}
	public static String convertToNSAndTerm(String uri) throws NoSuchElementException {
		for (OntologyPrefix prefix: OntologyPrefix.values()) {
			if (uri.startsWith(prefix.getURL())) {
				String term = uri.substring(prefix.getURL().length());
				return prefix.getNS() + ":" + term;
			}
		}
		throw new NoSuchElementException("The prefix for a URI " + uri + " cannot be resolved.");
	}
    

	public static String prefixes_RDF() {		
		return OntologyPrefix.BIOTEA.getPrefix() + OntologyPrefix.FOAF.getPrefix() +
			OntologyPrefix.RDF.getPrefix() + OntologyPrefix.RDFS.getPrefix() +   
			OntologyPrefix.PROV.getPrefix() + OntologyPrefix.OWL.getPrefix()
			;
	}
	public static Map<String, String> prefixesMap_RDF() {	
		Map<String, String> map = new HashMap<String, String>();
		map.put(OntologyPrefix.BIOTEA.getNS(), OntologyPrefix.BIOTEA.getURL());
		map.put(OntologyPrefix.FOAF.getNS(), OntologyPrefix.FOAF.getURL());
		map.put(OntologyPrefix.RDF.getNS(), OntologyPrefix.RDF.getURL());
		map.put(OntologyPrefix.RDFS.getNS(), OntologyPrefix.RDFS.getURL());
		map.put(OntologyPrefix.DCTERMS.getNS(), OntologyPrefix.DCTERMS.getURL());
		map.put(OntologyPrefix.XSP.getNS(), OntologyPrefix.XSP.getURL());
		map.put(OntologyPrefix.PROV.getNS(), OntologyPrefix.PROV.getURL());
		map.put(OntologyPrefix.OWL.getNS(), OntologyPrefix.OWL.getURL());
		map.put(OntologyPrefix.VOID.getNS(), OntologyPrefix.VOID.getURL());
		return map;
	}
	public static Map<String, String> mergePrefixes(Map<String, String> one, Map<String, String> two) {
		Map<String, String> merge = new HashMap<String, String>();		
		for (String key: one.keySet()) {
			merge.put(key, one.get(key));
		}
		for (String key: two.keySet()) {
			merge.put(key, two.get(key));
		}
		return merge;
	}
}
