package sw;

import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.StringWriter;
import java.net.URISyntaxException;

public class CadenaOriginalCfdi40 {
    Templates xsltcfdi_template;
    private final String _resource_location = "/cfdi40/cadenaoriginal_4_0.xslt";

    public CadenaOriginalCfdi40() throws TransformerConfigurationException {
        Source xslt_template = new StreamSource(getClass().getResourceAsStream(_resource_location));
        xslt_template.setSystemId(GetResourceId());
        TransformerFactory factory = TransformerFactory.newInstance();
        xsltcfdi_template = factory.newTemplates(xslt_template);
    }

    private String GetResourceId() {
        try {
            return getClass().getResource(_resource_location).toURI().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String GetCadenaOriginal(final Source xml)
            throws TransformerException, URISyntaxException {
        Transformer xsltcfditransformer = xsltcfdi_template.newTransformer();
        final StringWriter writer = new StringWriter();
        xsltcfditransformer.transform(xml, new StreamResult(writer));
        final String output = writer.getBuffer().toString();
        return output;
    }
}
