import junit.framework.TestCase;
import org.junit.Assert;
import sw.CadenaOriginalCfdi33;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.net.URISyntaxException;

public class CadenaOriginalCfdi33Test extends TestCase {

    public void testGenerateCadena() throws URISyntaxException, TransformerException {
        CadenaOriginalCfdi33 cadenaOriginalService = new CadenaOriginalCfdi33();
        Source xml = new StreamSource(new File("src/test/resources/cfdi33_01.xml"));
        String cadenaOriginal = cadenaOriginalService.getCadenaOriginal(xml);
        String expected = "||3.3|RogueOne|HNFK231|2018-07-06T12:17:59|01|20001000000300022816|200.00|MXN|1|603.20|I|PUE|06300|LAN8507268IA|MB IDEAS DIGITALES SC|601|AAA010101AAA|SW SMARTERWEB|G03|50211503|UT421511|1|H87|Pieza|Cigarros|200.00|200.00|200.00|002|Tasa|0.160000|32.00|232.00|003|Tasa|1.600000|371.20|002|Tasa|0.160000|32.00|003|Tasa|1.600000|371.20|403.20||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
}