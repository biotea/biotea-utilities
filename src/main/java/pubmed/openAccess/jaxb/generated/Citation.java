//
// This file was pubmed.openAccess.jaxb.generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.06.04 at 07:58:30 PM BST 
//


package pubmed.openAccess.jaxb.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}person-group"/>
 *           &lt;element ref="{}collab"/>
 *         &lt;/choice>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}article-title"/>
 *           &lt;element ref="{}trans-title"/>
 *         &lt;/choice>
 *         &lt;element ref="{}source" minOccurs="0"/>
 *         &lt;element ref="{}patent" minOccurs="0"/>
 *         &lt;element ref="{}trans-source" minOccurs="0"/>
 *         &lt;element ref="{}year" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;sequence>
 *             &lt;element ref="{}month" minOccurs="0"/>
 *             &lt;element ref="{}day" minOccurs="0"/>
 *             &lt;element ref="{}time-stamp" minOccurs="0"/>
 *           &lt;/sequence>
 *           &lt;element ref="{}season" minOccurs="0"/>
 *         &lt;/choice>
 *         &lt;element ref="{}access-date" minOccurs="0"/>
 *         &lt;element ref="{}volume" minOccurs="0"/>
 *         &lt;element ref="{}edition" minOccurs="0"/>
 *         &lt;element ref="{}conf-name" minOccurs="0"/>
 *         &lt;element ref="{}conf-date" minOccurs="0"/>
 *         &lt;element ref="{}conf-loc" minOccurs="0"/>
 *         &lt;choice maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}issue"/>
 *           &lt;element ref="{}supplement"/>
 *         &lt;/choice>
 *         &lt;element ref="{}publisher-loc" minOccurs="0"/>
 *         &lt;element ref="{}publisher-name" minOccurs="0"/>
 *         &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *           &lt;element ref="{}fpage" minOccurs="0"/>
 *           &lt;element ref="{}lpage" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;element ref="{}page-count" minOccurs="0"/>
 *         &lt;element ref="{}series" minOccurs="0"/>
 *         &lt;element ref="{}comment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}pub-id" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}annotation" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="publication-type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="publisher-type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="publication-format" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute ref="{http://www.w3.org/1999/xlink}type"/>
 *       &lt;attribute ref="{http://www.w3.org/1999/xlink}href"/>
 *       &lt;attribute ref="{http://www.w3.org/1999/xlink}role"/>
 *       &lt;attribute ref="{http://www.w3.org/1999/xlink}title"/>
 *       &lt;attribute ref="{http://www.w3.org/1999/xlink}show"/>
 *       &lt;attribute ref="{http://www.w3.org/1999/xlink}actuate"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personGroupsAndCollabs",
    "articleTitlesAndTransTitles",
    "source",
    "patent",
    "transSource",
    "year",
    "season",
    "month",
    "day",
    "timeStamp",
    "accessDate",
    "volume",
    "edition",
    "confName",
    "confDate",
    "confLoc",
    "issuesAndSupplements",
    "publisherLoc",
    "publisherName",
    "fpagesAndLpages",
    "pageCount",
    "series",
    "comments",
    "pubIds",
    "annotation"
})
@XmlRootElement(name = "citation")
public class Citation implements GenericCitation {

    @XmlElements({
        @XmlElement(name = "collab", type = Collab.class),
        @XmlElement(name = "person-group", type = PersonGroup.class)
    })
    protected List<Object> personGroupsAndCollabs;
    @XmlElements({
        @XmlElement(name = "article-title", type = ArticleTitle.class),
        @XmlElement(name = "trans-title", type = TransTitle.class)
    })
    protected List<Object> articleTitlesAndTransTitles;
    protected Source source;
    protected Patent patent;
    @XmlElement(name = "trans-source")
    protected TransSource transSource;
    protected Year year;
    protected Season season;
    protected Month month;
    protected Day day;
    @XmlElement(name = "time-stamp")
    protected TimeStamp timeStamp;
    @XmlElement(name = "access-date")
    protected AccessDate accessDate;
    protected Volume volume;
    protected Edition edition;
    @XmlElement(name = "conf-name")
    protected ConfName confName;
    @XmlElement(name = "conf-date")
    protected ConfDate confDate;
    @XmlElement(name = "conf-loc")
    protected ConfLoc confLoc;
    @XmlElements({
        @XmlElement(name = "issue", type = Issue.class),
        @XmlElement(name = "supplement", type = Supplement.class)
    })
    protected List<Object> issuesAndSupplements;
    @XmlElement(name = "publisher-loc")
    protected PublisherLoc publisherLoc;
    @XmlElement(name = "publisher-name")
    protected PublisherName publisherName;
    @XmlElements({
        @XmlElement(name = "fpage", type = Fpage.class),
        @XmlElement(name = "lpage", type = Lpage.class)
    })
    protected List<Object> fpagesAndLpages;
    @XmlElement(name = "page-count")
    protected PageCount pageCount;
    protected Series series;
    @XmlElement(name = "comment")
    protected List<Comment> comments;
    @XmlElement(name = "pub-id")
    protected List<PubId> pubIds;
    protected Annotation annotation;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "publication-type")
    @XmlSchemaType(name = "anySimpleType")
    protected String publicationType;
    @XmlAttribute(name = "citation-type")
    @XmlSchemaType(name = "anySimpleType")
    protected String citationType;
    @XmlAttribute(name = "publisher-type")
    @XmlSchemaType(name = "anySimpleType")
    protected String publisherType;
    @XmlAttribute(name = "publication-format")
    @XmlSchemaType(name = "anySimpleType")
    protected String publicationFormat;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlSchemaType(name = "anySimpleType")
    protected String href;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlSchemaType(name = "anySimpleType")
    protected String role;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlSchemaType(name = "anySimpleType")
    protected String title;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String show;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String actuate;

    /**
     * Gets the value of the personGroupsAndCollabs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personGroupsAndCollabs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonGroupsAndCollabs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Collab }
     * {@link PersonGroup }
     * 
     * 
     */
    public List<Object> getPersonGroupsAndCollabs() {
        if (personGroupsAndCollabs == null) {
            personGroupsAndCollabs = new ArrayList<Object>();
        }
        return this.personGroupsAndCollabs;
    }

    /**
     * Gets the value of the articleTitlesAndTransTitles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the articleTitlesAndTransTitles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArticleTitlesAndTransTitles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ArticleTitle }
     * {@link TransTitle }
     * 
     * 
     */
    public List<Object> getArticleTitlesAndTransTitles() {
        if (articleTitlesAndTransTitles == null) {
            articleTitlesAndTransTitles = new ArrayList<Object>();
        }
        return this.articleTitlesAndTransTitles;
    }

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link Source }
     *     
     */
    public Source getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link Source }
     *     
     */
    public void setSource(Source value) {
        this.source = value;
    }

    /**
     * Gets the value of the patent property.
     * 
     * @return
     *     possible object is
     *     {@link Patent }
     *     
     */
    public Patent getPatent() {
        return patent;
    }

    /**
     * Sets the value of the patent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Patent }
     *     
     */
    public void setPatent(Patent value) {
        this.patent = value;
    }

    /**
     * Gets the value of the transSource property.
     * 
     * @return
     *     possible object is
     *     {@link TransSource }
     *     
     */
    public TransSource getTransSource() {
        return transSource;
    }

    /**
     * Sets the value of the transSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link TransSource }
     *     
     */
    public void setTransSource(TransSource value) {
        this.transSource = value;
    }

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Year }
     *     
     */
    public Year getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Year }
     *     
     */
    public void setYear(Year value) {
        this.year = value;
    }

    /**
     * Gets the value of the season property.
     * 
     * @return
     *     possible object is
     *     {@link Season }
     *     
     */
    public Season getSeason() {
        return season;
    }

    /**
     * Sets the value of the season property.
     * 
     * @param value
     *     allowed object is
     *     {@link Season }
     *     
     */
    public void setSeason(Season value) {
        this.season = value;
    }

    /**
     * Gets the value of the month property.
     * 
     * @return
     *     possible object is
     *     {@link Month }
     *     
     */
    public Month getMonth() {
        return month;
    }

    /**
     * Sets the value of the month property.
     * 
     * @param value
     *     allowed object is
     *     {@link Month }
     *     
     */
    public void setMonth(Month value) {
        this.month = value;
    }

    /**
     * Gets the value of the day property.
     * 
     * @return
     *     possible object is
     *     {@link Day }
     *     
     */
    public Day getDay() {
        return day;
    }

    /**
     * Sets the value of the day property.
     * 
     * @param value
     *     allowed object is
     *     {@link Day }
     *     
     */
    public void setDay(Day value) {
        this.day = value;
    }

    /**
     * Gets the value of the timeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link TimeStamp }
     *     
     */
    public TimeStamp getTimeStamp() {
        return timeStamp;
    }

    /**
     * Sets the value of the timeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeStamp }
     *     
     */
    public void setTimeStamp(TimeStamp value) {
        this.timeStamp = value;
    }

    /**
     * Gets the value of the accessDate property.
     * 
     * @return
     *     possible object is
     *     {@link AccessDate }
     *     
     */
    public AccessDate getAccessDate() {
        return accessDate;
    }

    /**
     * Sets the value of the accessDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link AccessDate }
     *     
     */
    public void setAccessDate(AccessDate value) {
        this.accessDate = value;
    }

    /**
     * Gets the value of the volume property.
     * 
     * @return
     *     possible object is
     *     {@link Volume }
     *     
     */
    public Volume getVolume() {
        return volume;
    }

    /**
     * Sets the value of the volume property.
     * 
     * @param value
     *     allowed object is
     *     {@link Volume }
     *     
     */
    public void setVolume(Volume value) {
        this.volume = value;
    }

    /**
     * Gets the value of the edition property.
     * 
     * @return
     *     possible object is
     *     {@link Edition }
     *     
     */
    public Edition getEdition() {
        return edition;
    }

    /**
     * Sets the value of the edition property.
     * 
     * @param value
     *     allowed object is
     *     {@link Edition }
     *     
     */
    public void setEdition(Edition value) {
        this.edition = value;
    }

    /**
     * Gets the value of the confName property.
     * 
     * @return
     *     possible object is
     *     {@link ConfName }
     *     
     */
    public ConfName getConfName() {
        return confName;
    }

    /**
     * Sets the value of the confName property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfName }
     *     
     */
    public void setConfName(ConfName value) {
        this.confName = value;
    }

    /**
     * Gets the value of the confDate property.
     * 
     * @return
     *     possible object is
     *     {@link ConfDate }
     *     
     */
    public ConfDate getConfDate() {
        return confDate;
    }

    /**
     * Sets the value of the confDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfDate }
     *     
     */
    public void setConfDate(ConfDate value) {
        this.confDate = value;
    }

    /**
     * Gets the value of the confLoc property.
     * 
     * @return
     *     possible object is
     *     {@link ConfLoc }
     *     
     */
    public ConfLoc getConfLoc() {
        return confLoc;
    }

    /**
     * Sets the value of the confLoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfLoc }
     *     
     */
    public void setConfLoc(ConfLoc value) {
        this.confLoc = value;
    }

    /**
     * Gets the value of the issuesAndSupplements property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the issuesAndSupplements property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIssuesAndSupplements().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Issue }
     * {@link Supplement }
     * 
     * 
     */
    public List<Object> getIssuesAndSupplements() {
        if (issuesAndSupplements == null) {
            issuesAndSupplements = new ArrayList<Object>();
        }
        return this.issuesAndSupplements;
    }

    /**
     * Gets the value of the publisherLoc property.
     * 
     * @return
     *     possible object is
     *     {@link PublisherLoc }
     *     
     */
    public PublisherLoc getPublisherLoc() {
        return publisherLoc;
    }

    /**
     * Sets the value of the publisherLoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublisherLoc }
     *     
     */
    public void setPublisherLoc(PublisherLoc value) {
        this.publisherLoc = value;
    }

    /**
     * Gets the value of the publisherName property.
     * 
     * @return
     *     possible object is
     *     {@link PublisherName }
     *     
     */
    public PublisherName getPublisherName() {
        return publisherName;
    }

    /**
     * Sets the value of the publisherName property.
     * 
     * @param value
     *     allowed object is
     *     {@link PublisherName }
     *     
     */
    public void setPublisherName(PublisherName value) {
        this.publisherName = value;
    }

    /**
     * Gets the value of the fpagesAndLpages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fpagesAndLpages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFpagesAndLpages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Fpage }
     * {@link Lpage }
     * 
     * 
     */
    public List<Object> getFpagesAndLpages() {
        if (fpagesAndLpages == null) {
            fpagesAndLpages = new ArrayList<Object>();
        }
        return this.fpagesAndLpages;
    }

    /**
     * Gets the value of the pageCount property.
     * 
     * @return
     *     possible object is
     *     {@link PageCount }
     *     
     */
    public PageCount getPageCount() {
        return pageCount;
    }

    /**
     * Sets the value of the pageCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link PageCount }
     *     
     */
    public void setPageCount(PageCount value) {
        this.pageCount = value;
    }

    /**
     * Gets the value of the series property.
     * 
     * @return
     *     possible object is
     *     {@link Series }
     *     
     */
    public Series getSeries() {
        return series;
    }

    /**
     * Sets the value of the series property.
     * 
     * @param value
     *     allowed object is
     *     {@link Series }
     *     
     */
    public void setSeries(Series value) {
        this.series = value;
    }

    /**
     * Gets the value of the comments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Comment }
     * 
     * 
     */
    public List<Comment> getComments() {
        if (comments == null) {
            comments = new ArrayList<Comment>();
        }
        return this.comments;
    }

    /**
     * Gets the value of the pubIds property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pubIds property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPubIds().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PubId }
     * 
     * 
     */
    public List<PubId> getPubIds() {
        if (pubIds == null) {
            pubIds = new ArrayList<PubId>();
        }
        return this.pubIds;
    }

    /**
     * Gets the value of the annotation property.
     * 
     * @return
     *     possible object is
     *     {@link Annotation }
     *     
     */
    public Annotation getAnnotation() {
        return annotation;
    }

    /**
     * Sets the value of the annotation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Annotation }
     *     
     */
    public void setAnnotation(Annotation value) {
        this.annotation = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the publicationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationType() {
        return publicationType;
    }
    
    /**
     * Gets the value of the citationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitationType() {
        return citationType;
    }

    /**
     * Sets the value of the publicationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationType(String value) {
        this.publicationType = value;
    }
    
    /**
     * Sets the value of the citationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitationType(String value) {
        this.citationType = value;
    }

    /**
     * Gets the value of the publisherType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisherType() {
        return publisherType;
    }

    /**
     * Sets the value of the publisherType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisherType(String value) {
        this.publisherType = value;
    }

    /**
     * Gets the value of the publicationFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublicationFormat() {
        return publicationFormat;
    }

    /**
     * Sets the value of the publicationFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublicationFormat(String value) {
        this.publicationFormat = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the show property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getShow() {
        return show;
    }

    /**
     * Sets the value of the show property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setShow(String value) {
        this.show = value;
    }

    /**
     * Gets the value of the actuate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActuate() {
        return actuate;
    }

    /**
     * Sets the value of the actuate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActuate(String value) {
        this.actuate = value;
    }
    
    /*EXTENSION*/
    public List<Object> getAll() {
    	List<Object> list = this.getArticleTitlesAndTransTitles();
    	list.addAll(this.getComments());
    	list.addAll(this.getFpagesAndLpages());
    	list.addAll(this.getIssuesAndSupplements());
    	list.addAll(this.getPersonGroupsAndCollabs());
    	list.addAll(this.getPubIds());
    	list.add(this.getAccessDate());
    	list.add(this.getConfDate());
    	list.add(this.getConfLoc());
    	list.add(this.getConfName());
    	list.add(this.getEdition());
    	list.add(this.getId());
    	list.add(this.getMonth());
    	list.add(this.getPageCount());
    	list.add(this.getPatent());
    	list.add(this.getPublisherLoc());
    	list.add(this.getPublisherName());
    	list.add(this.getSource());
    	list.add(this.getYear());
    	return (list);
    }

}
