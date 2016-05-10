package ws.biotea.ld2rdf.util.annotation;  

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public enum AnnotationOntologyPrefix {
	//AO
	AO_CORE("http://purl.org/ao/core/", "ao"), 
	AO_TYPES("http://purl.org/ao/types/", "aot"), 
	AO_SELECTORS("http://purl.org/ao/selectors/", "aos"), 
	AO_ANNOTEA("http://purl.org/ao/annotea/", "aoa"), 
	AO_FOAF("http://purl.org/ao/foaf/", "aof"), 
	PAV("http://purl.org/pav/", "pav"), //http://purl.org/swan/pav/provenance/
	;
	
	private String url;
	private String ns;
	
	private AnnotationOntologyPrefix(String url, String ns) {
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
	public static AnnotationOntologyPrefix getByNS(String ns) throws NoSuchElementException {
		for (AnnotationOntologyPrefix prefix: AnnotationOntologyPrefix.values()) {
			if (prefix.getNS().equals(ns)) {
				return prefix;
			}
		}
		throw new NoSuchElementException("The prefix with NS " + ns + " cannot be resolved.");
	}
	public static String convertToNSAndTerm(String uri) throws NoSuchElementException {
		for (AnnotationOntologyPrefix prefix: AnnotationOntologyPrefix.values()) {
			if (uri.startsWith(prefix.getURL())) {
				String term = uri.substring(prefix.getURL().length());
				return prefix.getNS() + ":" + term;
			}
		}
		throw new NoSuchElementException("The prefix for a URI " + uri + " cannot be resolved.");
	}

	public static String toIdentifiersOrg(String uri) {
		try {
			String[] values = uri.split(":");
			if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("CHEBI"))) {
				return "http://identifiers.org/obo.chebi/CHEBI:" + values[1];
			} else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("GO"))) {
				return "http://identifiers.org/obo.go/GO:" + values[1];
			} else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("UNIPROT"))) {
				return "http://identifiers.org/uniprot/" + values[1];
			} else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("OMIM"))) {
				if (values[1].startsWith("MTHU")) {
					return null;
				}
				return "http://identifiers.org/omim/" + values[1];
			} /*else if (values[0].equals(Prefix.FMA.getNS())) {
				return "http://identifiers.org/obo.fma/FMA:" + values[1];
			} *//*else if (values[0].equals(Prefix.ICD9.getNS())) {
				return "http://identifiers.org/icd/" + values[1];
			} */else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("ICD10"))) {
				return "http://identifiers.org/icd/" + values[1];
			} else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("OBI"))) {
				return "http://identifiers.org/obo.obi/OBI_" + values[1];
			} /*else if (values[0].equals(Prefix.NCIt.getNS())) {
				return "http://identifiers.org/ncit/" + values[1];
			} */else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("NCBITaxon"))) {
				return "http://identifiers.org/taxonomy/" + values[1];
			} else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("UNIPROT_TAXONOMY"))) {
                return "http://identifiers.org/taxonomy:" + values[1];
            }		
			return null;
		} catch (Exception e) {
			return null;
		}
	}

    public static String toBio2RDFOrg(String uri) {
        try {
            String[] values = uri.split(":");
            if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("CHEBI"))) {
                return "http://bio2rdf.org/chebi:" + values[1];
            } else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("GO"))) {
                return "http://bio2rdf.org/go:" + values[1];
            } else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("UNIPROT"))) {
                return "http://bio2rdf.org/uniprot:" + values[1];
            } else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("OMIM"))) {
                if (values[1].startsWith("MTHU")) {
                    return null;
                }
                return "http://bio2rdf.org/omim:" + values[1];
            } else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("mesh"))) {
                return "http://bio2rdf.org/mesh:" + values[1];
            } else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("NCIt"))) {
				return "http://bio2rdf.org/ncithesaurus:" + values[1];
			} else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("NCBITaxon"))) {
                return "http://bio2rdf.org/taxonomy:" + values[1];
            } else if (values[0].toLowerCase().equals(BioOntologyConfig.getNS("UNIPROT_TAXONOMY"))) {
                return "http://bio2rdf.org/taxonomy:" + values[1];
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public static String getCUI(String uri) {    	
        try {
            if (uri.startsWith(BioOntologyConfig.getURL("UMLS"))) {
            	return uri.substring(BioOntologyConfig.getURL("UMLS").length());
            } else {
            	return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static String prefixes_AO() {		
		return 
			AnnotationOntologyPrefix.AO_CORE.getPrefix() + AnnotationOntologyPrefix.AO_TYPES.getPrefix() +
			AnnotationOntologyPrefix.AO_SELECTORS.getPrefix() + AnnotationOntologyPrefix.AO_ANNOTEA.getPrefix() +
			AnnotationOntologyPrefix.AO_FOAF.getPrefix() + AnnotationOntologyPrefix.PAV.getPrefix() +
			BioOntologyConfig.getPrefix("UMLS")
			;
	}
    
	public static Map<String, String> prefixesMap_AO() {	
		Map<String, String> map = new HashMap<String, String>();
		map.put(AnnotationOntologyPrefix.AO_CORE.getNS(), AnnotationOntologyPrefix.AO_CORE.getURL());
		map.put(AnnotationOntologyPrefix.AO_TYPES.getNS(), AnnotationOntologyPrefix.AO_TYPES.getURL());
		map.put(AnnotationOntologyPrefix.AO_SELECTORS.getNS(), AnnotationOntologyPrefix.AO_SELECTORS.getURL());
		map.put(AnnotationOntologyPrefix.AO_ANNOTEA.getNS(), AnnotationOntologyPrefix.AO_ANNOTEA.getURL());
		map.put(AnnotationOntologyPrefix.AO_FOAF.getNS(), AnnotationOntologyPrefix.AO_FOAF.getURL());
		map.put(AnnotationOntologyPrefix.PAV.getNS(), AnnotationOntologyPrefix.PAV.getURL());
		if (BioOntologyConfig.getPrefix("UMLS").length() != 0) {
			map.put(BioOntologyConfig.getNS("UMLS"), BioOntologyConfig.getURL("UMLS"));
		}
		//map.put(Prefix.SCIENCE_COMMONS.getNS(), Prefix.SCIENCE_COMMONS.getURL());
		return map;
	}
}
