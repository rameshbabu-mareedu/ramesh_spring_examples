
package org.krams.tutorial.oxm;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.blueblademobile.ws.schema.xavier package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Id_QNAME = new QName("http://krams915.blogspot.com/ws/schema/oss", "id");
    private final static QName _Code_QNAME = new QName("http://krams915.blogspot.com/ws/schema/oss", "code");
    private final static QName _Description_QNAME = new QName("http://krams915.blogspot.com/ws/schema/oss", "description");
    private final static QName _Name_QNAME = new QName("http://krams915.blogspot.com/ws/schema/oss", "name");
    private final static QName _Email_QNAME = new QName("http://krams915.blogspot.com/ws/schema/oss", "email");
   
    public ObjectFactory() {
    }

    public SubscriptionResponse createSubscriptionResponse() {
        return new SubscriptionResponse();
    }

    public SubscriptionRequest createSubscriptionRequest() {
        return new SubscriptionRequest();
    }

    @XmlElementDecl(namespace = "http://krams915.blogspot.com/ws/schema/oss", name = "id")
    public JAXBElement<String> createId(String value) {
        return new JAXBElement<String>(_Id_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://krams915.blogspot.com/ws/schema/oss", name = "code")
    public JAXBElement<String> createCode(String value) {
        return new JAXBElement<String>(_Code_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://krams915.blogspot.com/ws/schema/oss", name = "description")
    public JAXBElement<String> createDescription(String value) {
        return new JAXBElement<String>(_Description_QNAME, String.class, null, value);
    }

    @XmlElementDecl(namespace = "http://krams915.blogspot.com/ws/schema/oss", name = "name")
    public JAXBElement<String> createName(String value) {
        return new JAXBElement<String>(_Name_QNAME, String.class, null, value);
    }
    
    @XmlElementDecl(namespace = "http://krams915.blogspot.com/ws/schema/oss", name = "email")
    public JAXBElement<String> createEmail(String value) {
        return new JAXBElement<String>(_Email_QNAME, String.class, null, value);
    }


}
