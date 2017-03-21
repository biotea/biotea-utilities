package ws.biotea.ld2rdf.util.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import ws.biotea.ld2rdf.util.ResourceConfig;

public class MappingConfig {
	private static Logger logger = Logger.getLogger(MappingConfig.class);
	
	public static ResourceBundle initResourceBundle(String base) {
		if (ResourceConfig.getUseBio2RDF(base)) {
			return ResourceBundle.getBundle("bio2rdf_mappings");			
		} else {
			try {
				return ResourceBundle.getBundle(ResourceConfig.getMappingFile());				
			} catch (Exception e) {
				return ResourceBundle.getBundle("default_mappings");				
			}
		}
	} 
	
	public static List<Namespace> getAllNamespaces(String base) {
		List<Namespace> lst = new ArrayList<Namespace>();
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.OWL.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.OWL.getURL()));
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getURL()));
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.RDFS.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.RDFS.getURL()));
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.XSP.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.XSP.getURL()));		
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getURL()));
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.VOID.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.VOID.getURL()));
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.SIO.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.SIO.getURL()));
		lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.WIKI_DATA.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.WIKI_DATA.getURL()));
		try {
			ResourceBundle res = initResourceBundle(base);
			String[] bases = res.getString("bases").split(",");
			for (int i = 0; i < bases.length; i +=2) {
				lst.add(new Namespace(bases[i], bases[i+1]));
			}
		} catch (Exception e) {
			logger.warn("Namespaces not properly configured");
		}
		return lst;
	}
	
	public static String getIdentifier(String base) {
		try {
			ResourceBundle res = initResourceBundle(base);
			return res.getString("dtp.identifier");
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getClass(String base, String namespace, String className) {
		try {
			ResourceBundle res = initResourceBundle(base);
			return res.getString("class." + namespace + "." + className);
		} catch (Exception e) {
			return ws.biotea.ld2rdf.util.OntologyPrefix.RDFS.getURL() + "Resource";
		}
	}
	
	public static String getObjectProperty(String base, String namespace, String opName) {
		try {
			ResourceBundle res = initResourceBundle(base);
			return res.getString("op." + namespace + "." + opName);
		} catch (Exception e) {
			logger.warn("Object property not properly configured: " + namespace + ":" + opName);
			return null;
		}
	}
	
	public static DatatypeProperty getDatatypeProperty(String base, String namespace, String dtpName) {
		try {
			ResourceBundle res = initResourceBundle(base);
			return new DatatypeProperty(res.getString("dtp." + namespace + "." + dtpName));			
		} catch (Exception e) {
			logger.warn("Datatype property not properly configured: " + namespace + ":" + dtpName);
			return null;
		}
	}
}
