package ws.biotea.ld2rdf.util.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import ws.biotea.ld2rdf.util.ResourceConfig;

public class MappingConfig {
	private static Logger logger = Logger.getLogger(MappingConfig.class);
	private static ResourceBundle res;	
	static {
		if (ResourceConfig.USE_BIO2RDF) {
			res = ResourceBundle.getBundle("bio2rdf_mappings");
			logger.info("USING Bio2RDF mapping");
		} else {
			try {
				res = ResourceBundle.getBundle(ResourceConfig.getMappingFile());
				logger.info("USING provided mapping " + ResourceConfig.getMappingFile());
			} catch (Exception e) {
				res = ResourceBundle.getBundle("default_mappings");
				logger.info("USING default mapping (the provided one was not found!)");
			}
		}
	}	
	
	private static List<Namespace> lst; 
	
	public static List<Namespace> getAllNamespaces() {
		if (MappingConfig.lst == null) {
			MappingConfig.lst = new ArrayList<Namespace>();
			MappingConfig.lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.OWL.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.OWL.getURL()));
			MappingConfig.lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getURL()));
			MappingConfig.lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.RDFS.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.RDFS.getURL()));
			MappingConfig.lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.XSP.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.XSP.getURL()));		
			MappingConfig.lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.RDF.getURL()));
			MappingConfig.lst.add(new Namespace(ws.biotea.ld2rdf.util.OntologyPrefix.VOID.getNS(), ws.biotea.ld2rdf.util.OntologyPrefix.VOID.getURL()));
			
			try {
				String[] bases = res.getString("bases").split(",");
				for (int i = 0; i < bases.length; i +=2) {
					MappingConfig.lst.add(new Namespace(bases[i], bases[i+1]));
				}
			} catch (Exception e) {
				logger.warn("Namespaces not properly configured");
			}
				
		}
		return MappingConfig.lst;
	}
	
	public static String getIdentifier() {
		try {
			return res.getString("dtp.identifier");
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String getClass(String namespace, String className) {
		try {
			return res.getString("class." + namespace + "." + className);
		} catch (Exception e) {
			return ws.biotea.ld2rdf.util.OntologyPrefix.RDFS.getURL() + "Resource";
		}
	}
	
	public static String getObjectProperty(String namespace, String opName) {
		try {
			return res.getString("op." + namespace + "." + opName);
		} catch (Exception e) {
			logger.warn("Object property not properly configured: " + namespace + ":" + opName);
			return null;
		}
	}
	
	public static DatatypeProperty getDatatypeProperty(String namespace, String dtpName) {
		try {
			return new DatatypeProperty(res.getString("dtp." + namespace + "." + dtpName));			
		} catch (Exception e) {
			logger.warn("Datatype property not properly configured: " + namespace + ":" + dtpName);
			return null;
		}
	}
}
