package sw.Helpers;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlUtils {
    
    public static Document getDocument(final byte[] bytesFile) throws SAXException, IOException, ParserConfigurationException {
        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document xmlDoc = db.parse(new ByteArrayInputStream(bytesFile));
        return xmlDoc;
    }
    public static String getCfdiVersion(final byte[] xmlBytes) throws SAXException, IOException, ParserConfigurationException 
    {
        Document xmlDoc = getDocument(xmlBytes);
        return getCfdiVersion(xmlDoc);
    }
    public static Source getSource(final byte[] bytesXml) {
        return new StreamSource(new ByteArrayInputStream(bytesXml));
    }
    public static String getCfdiVersion(Document xmlDoc)
    {
        String version = getAtribute(xmlDoc, "cfdi:Comprobante", "Version");
        if(version.equals("--")){
            version = getAtribute(xmlDoc, "cfdi:Comprobante", "version");
        }
        return version;
    }
    public static String getAtribute(final Document invoice, final String nodeName, final String namedItem) {
        final NodeList nodeList = invoice.getElementsByTagName(nodeName);
        if (nodeList.getLength() > 0) {
            final Element comprobante = (Element) nodeList.item(0);
            final NamedNodeMap atributes = comprobante.getAttributes();
            final Node atribute = atributes.getNamedItem(namedItem);
            if (atribute != null) {
                return atribute.getNodeValue();
            }
        }
        return "--";
    }
}
