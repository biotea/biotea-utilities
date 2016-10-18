package ws.biotea.ld2rdf.util.mapping;

import ws.biotea.ld2rdf.exception.RDFModelIOException;

/**
 * Datatype property that might be reify to a class plus a datatype property
 * In mapping.properties look like 
 * Reify to class and keep it simple as identifier
 * dtp.dcterms.identifier=TRUE,object property URL,class name URL,datatype URL,TRUE,datatype URL
 * Reify to class
 * dtp.dcterms.identifier=TRUE,object property URL,class name URL,datatype URL
 * Keep it as datatype
 * dtp.dcterms.identifier=datatype URL
 */
public class DatatypeProperty {
	private boolean reified;
	private String opName;
	private String className;
	private String dtpName;
	
	public DatatypeProperty(String str) throws RDFModelIOException {
		String[] parts = str.split(",");
		if (parts.length == 1) {
			this.reified = false;
			this.dtpName = parts[0];
		} else if (parts.length == 4) {
			this.reified = true;
			this.opName = parts[1];
			this.className = parts[2];
			this.dtpName = parts[3];
		} else {
			throw new RDFModelIOException("Datatype not properly specified");
		}
	}

	/**
	 * @return the reified
	 */
	public boolean isReified() {
		return reified;
	}

	/**
	 * @param reify the reified to set
	 */
	public void setReified(boolean reified) {
		this.reified = reified;
	}

	/**
	 * @return the opName
	 */
	public String getOpName() {
		return opName;
	}

	/**
	 * @param opName the opName to set
	 */
	public void setOpName(String opName) {
		this.opName = opName;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * @return the dtpName
	 */
	public String getDtpName() {
		return dtpName;
	}

	/**
	 * @param dtpName the dtpName to set
	 */
	public void setDtpName(String dtpName) {
		this.dtpName = dtpName;
	}	
}
