import junit.framework.TestCase;
import org.junit.Assert;
import sw.ResourceSW;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;

public class ResourceSWTest extends TestCase {

    public void testCadenaOriginalSource() {
        ResourceSW recurso = new ResourceSW();
        Assert.assertNotNull(recurso.CadenaOriginalSource());
    }

    public void testCfdiXSDSource() {
        ResourceSW recurso = new ResourceSW();
        Assert.assertNotNull(recurso.CfdiXSDSource());
    }

    public void testCadenaOriginal() {
        ResourceSW recurso = new ResourceSW();
        Assert.assertNotNull(recurso.CadenaOriginal());
    }

    public void testCfdiXSD() {
        ResourceSW recurso = new ResourceSW();
        Assert.assertNotNull(recurso.CfdiXSD());
    }
    public void testGenerateCadena(){

        try {

            //INICIALIZAS LA CLASE RECURSO
            ResourceSW recurso = new ResourceSW();
            TransformerFactory factory = TransformerFactory.newInstance();
            //AQUI ES DONDE REQUIERES EL XSLT
            Source xslt = recurso.CadenaOriginalSource();

            Transformer transformer = factory.newTransformer(xslt);


            StringWriter writer = new StringWriter();
            Source xml = new StreamSource(new File("src/test/resources/basico.xml"));
            transformer.transform(xml, new StreamResult(writer));
            String output = writer.getBuffer().toString();
            String expected = "||3.3|RogueOne|HNFK231|2018-07-06T12:17:59|01|20001000000300022816|200.00|MXN|1|603.20|I|PUE|06300|LAN8507268IA|MB IDEAS DIGITALES SC|601|AAA010101AAA|SW SMARTERWEB|G03|50211503|UT421511|1|H87|Pieza|Cigarros|200.00|200.00|200.00|002|Tasa|0.160000|32.00|232.00|003|Tasa|1.600000|371.20|002|Tasa|0.160000|32.00|003|Tasa|1.600000|371.20|403.20||";
            System.out.println(output);
            Assert.assertEquals(output, expected);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}