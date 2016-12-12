package ws.biotea.ld2rdf.util;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ResourceConfig {
	private static ResourceBundle res = ResourceBundle.getBundle("config");
	private static Logger logger = Logger.getLogger(ResourceConfig.class);
    
    /*
     * Biotea URIs
     */
    public final static String BIOTEA_URL = "http://" + ResourceConfig.getBioteaBase() + "/";
    public final static String BIOTEA_RDFIZATOR = ResourceConfig.BIOTEA_URL + "agent/biotea_serializer/";
  	public final static String BIOTEA_DATASET = ResourceConfig.BIOTEA_URL + ResourceConfig.getDataset();
    /*
     * URI for other datasets linked to
     */
    public static final String IDENTIFIERS_ORG_PUBMED = "http://identifiers.org/pubmed/";
    public static final String IDENTIFIERS_ORG_PAGE_PUBMED = "http://info.identifiers.org/pubmed/";
    public static final String BIO2RDF_PUBMED = "http://bio2rdf.org/pubmed:";
    /*
     * RDF type property
     */    
    public static final String OP_RDF_TYPE = OntologyPrefix.RDF.getURL() + "type";
    /*
     * Others
     */
    public static final String bio2rdf = "Bio2RDF";
	public static final String CHAR_NOT_ALLOWED = "[^A-Za-z0-9]";
	public final static String ISO_ENCODING = "ISO-8859-1";
	public final static String UTF_ENCODING = "UTF-8";
	public final static String NO_STRING = "";
	public static final boolean USE_BIO2RDF;
	static {
		if (ResourceConfig.getBioteaBase().equals("bio2rdf.org")) {
			USE_BIO2RDF = true;
		} else {
			USE_BIO2RDF = false;
		}
	}

    public static String getProperty(String prop) {
        try {
            return res.getString(prop);
        } catch (Exception e) {
        	logger.warn("---WARNING configuration---: " + e.getMessage());
            return ("");
        }
    }
    
    public static boolean getBooleanProperty(String property) {
    	try {
    		if (res.getString(property).equals("true")) {
    			return true;
    		}
    		return false;
    	} catch (Exception e) {
    		return false;
    	}
    }
    
    public static String[] getCommaSeparatedProperty(String property) {    	
    	try {
    		return res.getString(property).split(",");    		
    	} catch (Exception e) {
    		return null;
    	}
    }
    
    //Mapping file
    public static String getMappingFile() {
    	return getProperty("mapping.propFile");
    }
    
    //BASE    
    public static String getBioteaBase() {
        try {
            return res.getString("biotea.base");
        } catch (Exception e) {
            return ("biotea.ws");
        }
    }
    
    //Other URLS
    public static String getPubMedURL(){
    	return (ResourceConfig.getProperty("pubmed.url"));
    }
    
    public static String getDOIURL(){
    	return (ResourceConfig.getProperty("doi.url"));
    }
    
    //Dataset
    public static String getDataset(){
    	return (ResourceConfig.getProperty("biotea.dataset"));
    }
    public static String getDatasetPrefix(){
    	return (ResourceConfig.getProperty("biotea.dataset.prefix"));
    }
    public static String getIdTag(){
    	return (ResourceConfig.getProperty("biotea.idTag"));
    }
    //File name prefixes
    public static String getTitleAbstractPrefix(){
    	return (ResourceConfig.getProperty("biotea.prefix.ta"));
    }
    public static String getFullTextPrefix(){
    	return (ResourceConfig.getProperty("biotea.prefix.ft"));
    }
    //Bio or not
    public static boolean withBio() {
    	String str = ResourceConfig.getProperty("biotea.withBio");
    	if (str.length() == 0) {
    		return false;
    	} else {
    		try {
    			return Boolean.valueOf(str).booleanValue();
    		} catch (Exception e) {
    			return false;
    		}
    	}
    }
    //Document URI
    public static String getDocRdfUri(String docId) {
		if (ResourceConfig.USE_BIO2RDF) {
			//documents
			return ResourceConfig.BIOTEA_URL + ResourceConfig.getDatasetPrefix() + ":" + docId;
		} else {
			return ResourceConfig.BIOTEA_URL + ResourceConfig.getDatasetPrefix() + "doc/" + ResourceConfig.getDatasetPrefix() + "/" + docId;
		}		
	}
    //Save selectors
    /**
     * It should return config property keep.selector but the current code does not support it, thus it is always false.
     * @return
     */
    public static boolean getKeepSelector() {    	
    	return getBooleanProperty("keep.selector");
    }
}