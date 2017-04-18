package ws.biotea.ld2rdf.rdfGeneration.jats; 

import ws.biotea.ld2rdf.util.ResourceConfig;
import ws.biotea.ld2rdf.util.Conversion;

public class GlobalArticleConfig {
	private String uriStyle;	
	private String articleID;
	//Software agent
	public final static String RDF4PMC_AGENT = ResourceConfig.BIOTEA_RDFIZATOR;
	//others
	public final static String listOfAuthorsEditorsAndTranslators = "listOfAuthorsEditorsAndTranslators";	
	public final static String listOfEditorsAndTranslators = "listOfEditorsAndTranslators";	
	public final static String listOfEditors = "listOfEditors";
	public final static String listOfTranslators= "listOfTranslators";
	public final static String listOfAuthors = "listOfAuthors";
	// Additional URIs, fixed
	public final static String pmcURI = "http://www.ncbi.nlm.nih.gov/pmc/articles/PMC"; 	
	public final static String NLM_JOURNAL_CATALOG = "http://www.ncbi.nlm.nih.gov/nlmcatalog?term=";
	public final static String pubMedURI = "http://www.ncbi.nlm.nih.gov/pubmed/";
	public final static String doiURI = "http://dx.doi.org/";	
	
    //patterns
    public String PUBMED_DOCUMENT;
    public String DOI_DOCUMENT;
    public String PMC_DOCUMENT;
    public String CHEM_STRUCT_FIG_LINK;
    public String INLINE_FORM_FIG_LINK;
	public String BASE_URL_ISSUE;
	public String BASE_URL_JOURNAL_ISSN;
	public String BASE_URL_JOURNAL_NAME;
	public String BASE_URL_PUBLISHER_ID;
	public String BASE_URL_PUBLISHER_NAME;
	public String BASE_URL_PERSON_PMC;
	public String BASE_URL_PERSON_PUBMED;
	public String BASE_URL_PERSON_DOI;
	public String BASE_URL_ORGANIZATION_PMC;
	public String BASE_URL_GROUP_PMC;
	public String BASE_URL_ORGANIZATION_PUBMED;
	//final String BASE_URL_GROUP_PUBMED;
	public String BASE_URL_ORGANIZATION_DOI;
	//final String BASE_URL_GROUP_DOI;
	public String BASE_URL_REF;
	public String BASE_URL_OTHER;
	public String BASE_URL_PROCEEDINGS_PMC;
	public String BASE_URL_CONFERENCE_PMC;
	public String BASE_URL_PROCEEDINGS_PUBMED;
	public String BASE_URL_CONFERENCE_PUBMED;
	public String BASE_URL_PROCEEDINGS_DOI;
	public String BASE_URL_CONFERENCE_DOI;
	public String BASE_URL_LIST_PMC;
	public String BASE_URL_LIST_PUBMED;
	public String BASE_URL_LIST_DOI;
	public String BASE_URL_SECTION;
	public String BASE_URL_EXT_FIGURE;
	public String BASE_URL_EXT_TABLE;
	public String BASE_URL_REF_LIST;
	public String BASE_URL_APPENDIX;
	public String BASE_URL_PARAGRAPH;
	
	/**
	 * Private constructor. 
	 */
	public GlobalArticleConfig(String base, String id) {
		this.articleID = id;
		if (ResourceConfig.getUseBio2RDF(base)) {
			this.uriStyle = ResourceConfig.bio2rdf;
		} else {
			this.uriStyle = "Biotea";
		}
		this.initPatterns(base);
		this.initStaticPatterns(base);
	}
	/**
	 * @return the uriStyle
	 */
	public String getUriStyle() {
		return uriStyle;
	}
	
	public String getPmcUri() {
		return GlobalArticleConfig.pmcURI + this.articleID;
	}
	
	public String getPubMedUri() {
		return GlobalArticleConfig.pubMedURI + this.articleID;
	}
	
	public static String getArticleRdfUri(String base, String pmcId) {
		if (ResourceConfig.getUseBio2RDF(base)) {
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + ":" + pmcId;
		} else {
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "doc/" + ResourceConfig.getDatasetPrefix() + "/" + pmcId;
		}		
	}
	
	public static String getArticleParagraphRdfUri(String base, String articleID, String sectionParagraph) {
		String[] secAndPara= sectionParagraph.split("_");
		if (secAndPara.length != 2) {
			secAndPara = new String[2];
			secAndPara[0] = sectionParagraph;
			secAndPara[1] = sectionParagraph;
		}
		if (ResourceConfig.getUseBio2RDF(base)) {
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_paragraph_" + secAndPara[0] + "_para_" + secAndPara[1]; //section-name:para-id					
		} else {
			return ResourceConfig.getBioteaURL(base) + "paragraph/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/" + secAndPara[0] + ":para_" + secAndPara[1]; //section-name:para-id
		}		
	}
	
	public static String getArticleUriBase(String base) {
		if (ResourceConfig.getUseBio2RDF(base)) {
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + ":";
		} else {
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "doc/" + ResourceConfig.getDatasetPrefix() + "/";
		}		
	}
	
	public static String getArticleIdFromRdfUri(String base, String uri) {
		if (ResourceConfig.getUseBio2RDF(base)) {
			return uri.substring(uri.lastIndexOf(':') + 1);
		} else {
			return uri.substring(uri.lastIndexOf('/') + 1);
		}		
	}
	
	public static String getBaseURLAO(String base) {
		//annotations
		if (ResourceConfig.getUseBio2RDF(base)) {			
			return ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:annotation{0}_";//{0} should be replaced by the annotator + "/pubmedOpenAccess/rdf_ao/";
		} else {
			return ResourceConfig.getBioteaURL(base) + "annotation{0}/" + ResourceConfig.getDatasetPrefix() + "_resource/";//{0} should be replaced by the annotator + "/pubmedOpenAccess/rdf_ao/";
		}
	}
	
	public String getAnnotationArticleRdfUri(String base, String annotator) {		
		String[] params = {annotator};
		return Conversion.replaceParameter(getBaseURLAO(base), params) + articleID + "/";//GlobalArticleConfig.BASE_URL + "PMC" + pmcId;// + ".rdf";
	}	
	
	private void initStaticPatterns(String base) {
		if (ResourceConfig.getUseBio2RDF(base)) {
			//documents
			PUBMED_DOCUMENT = ResourceConfig.getBioteaURL(base) + "pubmed:";
			DOI_DOCUMENT = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:doi_";
			//JOURNAL (independent, and can be mapped to journal list in NIH)
			BASE_URL_JOURNAL_ISSN = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:journal_issn_";
			BASE_URL_JOURNAL_NAME = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:journal_name_";
			BASE_URL_ISSUE = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:journal_{0}_{1}_issue_"; //then issn:<id>/<issue_id> or name:<journal_name>/<issue_id>
			//PUBLISHER (independent but we cannot map it to a URL)
			BASE_URL_PUBLISHER_ID = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:publisher_" + ResourceConfig.getDatasetPrefix() + "_internal_id_";
			BASE_URL_PUBLISHER_NAME = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:publisher_name_";
			//PERSONS (we do not disambiguate so keep them as related to the document)
			BASE_URL_PERSON_PUBMED = ResourceConfig.getBioteaURL(base) + "pubmed_resource:{0}_person_name_";
			BASE_URL_PERSON_DOI = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:doi_{0}_person_name_";
			//ORGANIZATION & GROUP (we do not disambiguate so keep them as related to the document)
			BASE_URL_ORGANIZATION_PUBMED = ResourceConfig.getBioteaURL(base) + "pubmed_resource:{0}_organization_name_";
			BASE_URL_ORGANIZATION_DOI = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:doi_{0}_organization_name_";
			//REFERENCES without DOI or pubmedid
			//Lists
			BASE_URL_LIST_PUBMED = ResourceConfig.getBioteaURL(base) + "pubmed_resource:{1}_{0}_list1"; //{0} list type, {1} pubmedid
			BASE_URL_LIST_DOI = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:doi_{1}_{0}_list1" ; //{0} list type, {1} doi
			//Proceedings (we do not disambiguate so keep them as related to the document)
			BASE_URL_PROCEEDINGS_PUBMED = ResourceConfig.getBioteaURL(base) + "pubmed_resource:{0}_proceedings_title_";
			BASE_URL_PROCEEDINGS_DOI = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:doi_{0}_proceedings_title_";
			BASE_URL_CONFERENCE_PUBMED = ResourceConfig.getBioteaURL(base) + "pubmed_resource:{0}_conference_name_";
			BASE_URL_CONFERENCE_DOI = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:doi_{0}_conference_name_";			
		} else {
			//documents
			PUBMED_DOCUMENT = ResourceConfig.getBioteaURL(base) + "pubmeddoc/pubmed/";
			DOI_DOCUMENT = ResourceConfig.getBioteaURL(base) + "doidoc/doi/";
			//JOURNAL (independent, and can be mapped to journal list in NIH)
			BASE_URL_JOURNAL_ISSN = ResourceConfig.getBioteaURL(base) + "journal/issn/";
			BASE_URL_JOURNAL_NAME = ResourceConfig.getBioteaURL(base) + "journal/name/";
			BASE_URL_ISSUE = ResourceConfig.getBioteaURL(base) + "issue/journal_resource/{0}:{1}/issue_"; //then issn:<id>/<issue_id> or name:<journal_name>/<issue_id>
			//PUBLISHER (independent but we cannot map it to a URL)
			BASE_URL_PUBLISHER_ID = ResourceConfig.getBioteaURL(base) + "publisher/" + ResourceConfig.getDatasetPrefix() + "_internal_id/";
			BASE_URL_PUBLISHER_NAME = ResourceConfig.getBioteaURL(base) + "publisher/name/";
			//PERSONS (we do not disambiguate so keep them as related to the document)
			BASE_URL_PERSON_PUBMED = ResourceConfig.getBioteaURL(base) + "person/pubmeddoc_resource/{0}/name/";
			BASE_URL_PERSON_DOI = ResourceConfig.getBioteaURL(base) + "person/doidoc_resource/{0}/name/";
			//ORGANIZATION & GROUP (we do not disambiguate so keep them as related to the document)
			BASE_URL_ORGANIZATION_PUBMED = ResourceConfig.getBioteaURL(base) + "organization/pubmeddoc_resource/{0}/name/";
			//BASE_URL_GROUP_PUBMED = ResourceConfig.getBioteaURL(base) + "group/pubmeddoc_resource/{0}/id/"; //then <org_name>_<group_id>
			BASE_URL_ORGANIZATION_DOI = ResourceConfig.getBioteaURL(base) + "organization/doidoc_resource/{0}/name/";
			//BASE_URL_GROUP_DOI = ResourceConfig.getBioteaURL(base) + "group/doidoc_resource/{0}/id/"; //then <org_name>_<group_id>
			//REFERENCES without DOI or pubmedid
			//Lists
			BASE_URL_LIST_PUBMED = ResourceConfig.getBioteaURL(base) + "{0}/pubmeddoc_resource/{1}/list1"; //{0} list type, {1} pubmedid
			BASE_URL_LIST_DOI = ResourceConfig.getBioteaURL(base) + "{0}/doidoc_resource/{1}/list1" ; //{0} list type, {1} doi
			//Proceedings (we do not disambiguate so keep them as related to the document)
			BASE_URL_PROCEEDINGS_PUBMED = ResourceConfig.getBioteaURL(base) + "proceedings/pubmeddoc_resource/{0}/title/";
			BASE_URL_PROCEEDINGS_DOI = ResourceConfig.getBioteaURL(base) + "proceedings/doidoc_resource/{0}/title/";
			BASE_URL_CONFERENCE_PUBMED = ResourceConfig.getBioteaURL(base) + "conference/pubmeddoc_resource/{0}/name/";
			BASE_URL_CONFERENCE_DOI = ResourceConfig.getBioteaURL(base) + "conference/doidoc_resource/{0}/name/";			
		}
	}
	private void initPatterns(String base) {
		if (this.uriStyle.equalsIgnoreCase(ResourceConfig.bio2rdf)) {
			//documents
			PMC_DOCUMENT = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + ":" + articleID;				
			//PERSONS (we do not disambiguate so keep them as related to the document)
			BASE_URL_PERSON_PMC = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_person_name_";
			//ORGANIZATION & GROUP (we do not disambiguate so keep them as related to the document)
			BASE_URL_ORGANIZATION_PMC = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_organization_name_";
			BASE_URL_GROUP_PMC = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_group_id_"; //then <org_name>_<group_id>
			//REFERENCES without DOI or pubmedid
			BASE_URL_REF = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_reference_";
			//Lists
			BASE_URL_REF_LIST = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_{0}_{1}_list1"; // {0} type of list, {1} ref id, for references without DOI or pubmedid
			BASE_URL_LIST_PMC = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_{0}_list{1}"; //{0} list type
			//Proceedings (we do not disambiguate so keep them as related to the document)
			BASE_URL_PROCEEDINGS_PMC = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_proceedings_title_";
			BASE_URL_CONFERENCE_PMC = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_conference_name_";
			//Sections
			BASE_URL_SECTION = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_section_";
			BASE_URL_PARAGRAPH = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_paragraph_{0}_para_"; //section-name:para-id
			BASE_URL_APPENDIX = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_appendix_"; //TODO
			//External figures and tables
			BASE_URL_EXT_FIGURE = GlobalArticleConfig.pmcURI + articleID + "/figure/";
			BASE_URL_EXT_TABLE = GlobalArticleConfig.pmcURI + articleID + "/table/";
			INLINE_FORM_FIG_LINK = GlobalArticleConfig.pmcURI + articleID + "/bin/";
			CHEM_STRUCT_FIG_LINK = "http://www.ncbi.nlm.nih.gov/core/lw/2.0/html/tileshop_pmc/tileshop_pmc_inline.html?p=PMC3&id=" + articleID + "_";
			BASE_URL_OTHER = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "_resource:" + articleID + "_other_";
		} else {
			//documents
			PMC_DOCUMENT = ResourceConfig.getBioteaURL(base) + ResourceConfig.getDatasetPrefix() + "doc/" + ResourceConfig.getDatasetPrefix() + "/" + articleID;
			//PERSONS (we do not disambiguate so keep them as related to the document)
			BASE_URL_PERSON_PMC = ResourceConfig.getBioteaURL(base) + "person/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/name/";
			//ORGANIZATION & GROUP (we do not disambiguate so keep them as related to the document)
			BASE_URL_ORGANIZATION_PMC = ResourceConfig.getBioteaURL(base) + "organization/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/name/";
			BASE_URL_GROUP_PMC = ResourceConfig.getBioteaURL(base) + "group/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/id/"; //then <org_name>_<group_id>
			//REFERENCES without DOI or pubmedid
			BASE_URL_REF = ResourceConfig.getBioteaURL(base) + "reference/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/";
			//Lists
			BASE_URL_REF_LIST = ResourceConfig.getBioteaURL(base) + "{0}/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/{1}:list1"; // {0} type of list, {1} ref id, for references without DOI or pubmedid
			BASE_URL_LIST_PMC = ResourceConfig.getBioteaURL(base) + "{0}/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/list{1}"; //{0} list type
			//Proceedings (we do not disambiguate so keep them as related to the document)
			BASE_URL_PROCEEDINGS_PMC = ResourceConfig.getBioteaURL(base) + "proceedings/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/title/";
			BASE_URL_CONFERENCE_PMC = ResourceConfig.getBioteaURL(base) + "conference/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/name/";
			//Sections
			BASE_URL_SECTION = ResourceConfig.getBioteaURL(base) + "section/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/";
			BASE_URL_PARAGRAPH = ResourceConfig.getBioteaURL(base) + "paragraph/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/{0}:para_"; //section-name:para-id
			BASE_URL_APPENDIX = ResourceConfig.getBioteaURL(base) + "appendix/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/"; //TODO
			//External figures and tables
			BASE_URL_EXT_FIGURE = GlobalArticleConfig.pmcURI + articleID + "/figure/";
			BASE_URL_EXT_TABLE = GlobalArticleConfig.pmcURI + articleID + "/table/";
			INLINE_FORM_FIG_LINK = GlobalArticleConfig.pmcURI + articleID + "/bin/";
			CHEM_STRUCT_FIG_LINK = "http://www.ncbi.nlm.nih.gov/core/lw/2.0/html/tileshop_pmc/tileshop_pmc_inline.html?p=PMC3&id=" + articleID + "_";
			BASE_URL_OTHER = ResourceConfig.getBioteaURL(base) + "section/" + ResourceConfig.getDatasetPrefix() + "doc_resource/" + articleID + "/other_";
		}		
	}
}
