package ws.biotea.ld2rdf.util;

import java.util.Calendar;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class ResourceConfig {
	private static ResourceBundle res = ResourceBundle.getBundle("config");
	private static Logger logger = Logger.getLogger(ResourceConfig.class);
	
    /*
     * Biotea URIs
     */
    public final static String BIOTEA_RDFIZATOR = "http://biotea.github.io/agent/biotea_serializer";
    /*
     * URI for other datasets linked to
     */
    public static final String IDENTIFIERS_ORG_PUBMED = "http://identifiers.org/pubmed/";
    public static final String LINKED_LIFE_DATA = "http://linkedlifedata.com/resource/pubmed/id/";
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
    
    public static String[] getConfigSuffixes() {
    	return ResourceConfig.getCommaSeparatedProperty("config.suffixes");
    }
    //Configuration for multiple production
    public static String getConfigBase(String suffix) {
		try {
            return res.getString("config.base." + suffix);
        } catch (Exception e) {
    		return ("linkingdata.io");
        }
    }    
    public static String getConfigDataset(String suffix) {
		try {			
            String dataset = res.getString("config.dataset." + suffix);
            return ResourceConfig.getBioteaURL(ResourceConfig.getConfigBase(suffix)) + dataset;
        } catch (Exception e) {
        	Calendar cal = Calendar.getInstance();
    		return ("linkingdata_dataset:linkingdata-pmc-" + (cal.get(Calendar.MONTH)+1) + cal.get(Calendar.YEAR));
        }
    }    
    public static boolean getConfigSections(String suffix) {
		return getBooleanProperty("config.sections." + suffix);
    }    
    public static boolean getConfigReferences(String suffix) {
		return getBooleanProperty("config.references." + suffix);
    }    
    public static String getConfigMapping(String suffix) {
    	return getProperty("config.mapping." + suffix);
    }
    public static String[] getConfigSameAs(String suffix) {
    	return ResourceConfig.getCommaSeparatedProperty("config.sameAs." + suffix);
    }
    //Mapping file
    public static String getMappingFile() {
    	return getProperty("mapping.propFile");
    }
    
    //Other URLS
    public static String getPubMedURL(){
    	return (ResourceConfig.getProperty("pubmed.url"));
    }
    
    public static String getDOIURL(){
    	return (ResourceConfig.getProperty("doi.url"));
    }
    
    //Base, base URL and dataset    
    public static String getBioteaBase(String base) {
    	if (base != null) {
    		return base;
    	} else {
    		try {
                return res.getString("biotea.base");
            } catch (Exception e) {
        		return ("linkingdata.io");
            }
    	}        
    }
    public static String getBioteaURL(String base) {
		return "http://" + ResourceConfig.getBioteaBase(base) + "/";
	}
    
    public static String getBioteaDatasetURL(String base, String dataset){
    	//public final static String BIOTEA_DATASET = ResourceConfig.BIOTEA_URL + ResourceConfig.getDataset();
    	if (dataset != null) {
    		return ResourceConfig.getBioteaURL(base) + dataset;
    	} else {
    		try {
    			return ResourceConfig.getBioteaURL(base) + res.getString("biotea.dataset");
            } catch (Exception e) {
            	return ResourceConfig.getBioteaURL(base) +  
        			("biotea_dataset:biotea-pmc-" + Conversion.calendarToString(Calendar.getInstance(), '-'));
            }
    	}
    }
    public static boolean getUseBio2RDF(String base) {
		return ResourceConfig.getBioteaBase(base).equals("bio2rdf.org");
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
    public static String getDocRdfUri(String base, String docId) {
		if (ResourceConfig.getUseBio2RDF(base)) {
			//documents
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + ":" + docId;
		} else {
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "doc/" + 
				ResourceConfig.getDatasetPrefix() + "/" + docId;
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