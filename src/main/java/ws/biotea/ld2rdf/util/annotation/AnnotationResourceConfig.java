package ws.biotea.ld2rdf.util.annotation;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import ws.biotea.ld2rdf.util.ResourceConfig;
import ws.biotea.ld2rdf.util.Conversion;

public class AnnotationResourceConfig {
	private static Logger logger = Logger.getLogger(AnnotationResourceConfig.class);
	private static ResourceBundle apikey = ResourceBundle.getBundle("apikey");
    
  //GO    
    public static boolean getWiiGO() {
    	return ResourceConfig.getBooleanProperty("whatizit.GO");
    }
    //CHEBI
    public static boolean getWiiCHEBI() {
    	return ResourceConfig.getBooleanProperty("whatizit.CHEBI");    	
    }
    //Virtual ids
    public static String[] getNCBOAnnotatorIncludeOnly() {    
    	return ResourceConfig.getCommaSeparatedProperty("ncbo.annotator.include.only");    	
    }
    public static String[] getNCBOAnnotatorExclude() {    	
    	return ResourceConfig.getCommaSeparatedProperty("ncbo.annotator.exclude");
    }

    //WII
    public static String getWSDLLocation() {
        return (ResourceConfig.getProperty("whatizit.wsdl.dir"));
    }
    //NCBO Annotator
    public static String getNCBOServiceURL(){
    	return (ResourceConfig.getProperty("ncbo.service.url"));
    }
    
    public static String getNCBOAnnotatorURL(){
    	return (ResourceConfig.getProperty("ncbo.annotator.url"));
    }
    
    public static String getNCBOAPIKey(){
    	try {
            return apikey.getString("ncbo.apikey");
        } catch (Exception e) {
        	logger.warn("---WARNING configuration---: " + e.getMessage());
            return ("");
        }
    }
    public static String getNCBOStopwords(){
    	return (ResourceConfig.getProperty("ncbo.stopwords"));
    }
  //AgroPortal Annotator
    public static String getAgroPortalServiceURL(){
    	return (ResourceConfig.getProperty("agroportal.service.url"));
    }
    
    public static String getAgroPortalAnnotatorURL(){
    	return (ResourceConfig.getProperty("agroportal.annotator.url"));
    }
    
    public static String getAgroPortalAPIKey(){
    	try {
            return apikey.getString("agroportal.apikey");
        } catch (Exception e) {
        	logger.warn("---WARNING configuration---: " + e.getMessage());
            return ("");
        }
    }
    public static String getAgroPortalStopwords(){
    	return (ResourceConfig.getProperty("agroportal.stopwords"));
    }
    //Whatizit annotator
    public static String getWhatizitAnnotatorURL(){
    	return (ResourceConfig.getProperty("whatizit.annotator.url"));
    }
    
    public static String getWhatizitStopwords(){
    	return (ResourceConfig.getProperty("whatizit.stopwords"));
    }
    //CMA Annotator
    public static String getCMAAnnotationService() {
    	return (ResourceConfig.getProperty("cma.annotator"));
	}

    public static boolean keepStartEnd() {
    	String str = ResourceConfig.getProperty("keep.start.end");
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
    
    //caching
    public static boolean getAnnotationCaching(Annotator annotator) {
    	String str = ResourceConfig.getProperty("cache.annotation." + annotator.getName());
    	String path = AnnotationResourceConfig.getAnnotationCachingPath(annotator);
    	return (str.length() == 0) ? false 
			: (path.length() == 0) ? false : Boolean.parseBoolean(str);   	
    }
    
    public static String getAnnotationCachingPath(Annotator annotator) {
    	return ResourceConfig.getProperty("cache.annotation." + annotator.getName() + "." + ResourceConfig.getDatasetPrefix() + ".path");
    }
    
  //saving annotations
    public static boolean getAnnotationSaving(Annotator annotator) {
    	String str = ResourceConfig.getProperty("save.annotation." + annotator.getName());
    	String path = AnnotationResourceConfig.getAnnotationSavingPath(annotator);
    	return (str.length() == 0) ? false 
			: (path.length() == 0) ? false : Boolean.parseBoolean(str);   	
    }
    
    public static boolean getAnnotationSavingReplace(Annotator annotator) {
    	String str = ResourceConfig.getProperty("save.annotation." + annotator.getName() + ".replace");
    	return Boolean.parseBoolean(str);
    }
    
    public static String getAnnotationSavingPath(Annotator annotator) {
    	return ResourceConfig.getProperty("save.annotation." + annotator.getName() + "." + ResourceConfig.getDatasetPrefix() + ".path");
    }
    
    public static String getBaseURLAnnotations(String base) {
		if (ResourceConfig.getUseBio2RDF(base)) {
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:annotation{0}_";
		} else {
			return ResourceConfig.getBioteaURL(base) + "annotation{0}/" + ResourceConfig.getDatasetPrefix() + "_resource/";//{0} should be replaced by the annotator
		}
    }    
    
    public static String getBaseURLAnnotator(String base, String annotator) {
    	String[] params = {annotator};
		return Conversion.replaceParameter(getBaseURLAnnotations(base), params);//GlobalPmc.BASE_URL + "PMC" + pmcId;// + ".rdf";
    }
}
