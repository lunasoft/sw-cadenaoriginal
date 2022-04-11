package sw;

import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import sw.Helpers.XmlUtils;

import java.io.StringWriter;
import java.net.URISyntaxException;

public class CadenaOriginalCfdiBase {
    protected Templates xsltcfdi_template;

    public CadenaOriginalCfdiBase(String resourceLocation) throws TransformerConfigurationException {
        Source xslt_template = new StreamSource(getClass().getResourceAsStream(resourceLocation));
        xslt_template.setSystemId(getResourceId(resourceLocation));
        TransformerFactory factory = TransformerFactory.newInstance();
        xsltcfdi_template = factory.newTemplates(xslt_template);
    }

    private String getResourceId(String resourceLocation) {
        try {
            return getClass().getResource(resourceLocation).toURI().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getCadenaOriginal(final Source xml)
            throws TransformerException, URISyntaxException {
        Transformer xsltcfditransformer = xsltcfdi_template.newTransformer();
        final StringWriter writer = new StringWriter();
        xsltcfditransformer.transform(xml, new StreamResult(writer));
        final String output = writer.getBuffer().toString();
        return output;
    }
    public String getCadenaOriginal(final byte[] xmlBytes)
            throws TransformerException, URISyntaxException {
        Source xmlSource = XmlUtils.getSource(xmlBytes);
        return getCadenaOriginal(xmlSource);                
    }
}
