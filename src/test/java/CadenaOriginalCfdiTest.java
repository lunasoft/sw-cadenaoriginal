import junit.framework.TestCase;
import org.junit.Assert;
import org.xml.sax.SAXException;
import sw.CadenaOriginalCfdi;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class CadenaOriginalCfdiTest extends TestCase {

    public void testWarmUpCadenaOriginal() throws URISyntaxException, TransformerException {
        CadenaOriginalCfdi.warmUp();
    }

    public void testGenerateCadena40()
            throws URISyntaxException, TransformerException, IOException, SAXException, ParserConfigurationException {
        byte[] xmlBytes = Files.readAllBytes(new File("src/test/resources/cfdi40_01.xml").toPath());
        String cadenaOriginal = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes);
        String expected = "||4.0|Serie|Folio|2021-12-16T15:40:21|30001000000400002444|0|XXX|0.0|P|01|20008|XAXX010101000|PUBLICO GENERAL|601|XAXX010101000|Nombre|45000|601|G01|84111506|1|ACT|Pago|0|0|01|2.0|0.00|0|0|940337.15|150453.94|16728123.41|1338249.87|16675096.20|0|10.79|4000.00|2021-12-02T00:18:10|01|USD|1|14000.00|1|XAXX010101000|NomBancoOrdExt1|0000000000000000|XAXX010101000|003293324|1|004004040|CadPago|SelloPago|BEDC8964-7E57-4604-9968-7E01378E8706|Serie3|Folio3|MXN|1.329310|1|5000.00|2000.00|3000.00|02|1|001|Tasa|0.300000|0.300000|625000.00|002|Tasa|0.160000|100000.00|22166372.13|002|Tasa|0.080000|1773309.77|22166372.13|002|Tasa|0.000000|0|1|002|Exento|BEDC8964-7E57-4604-9968-7E01378E8706|Serie3|Folio3|MXN|23.5728|1|5000.00|2000.00|3000.00|02|11083186.11|002|Tasa|0.160000|1773309.77|1250000.00|002|Tasa|0.080000|100000.00|1|002|Exento|001|2|940337.15|002|Tasa|0.160000|150453.94|16728123.41|002|Tasa|0.080000|1338249.87|16675096.20|002|Tasa|0.000000|0|0.79|002|Exento||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
    
    public void testGenerateCadena33()
            throws URISyntaxException, TransformerException, IOException, SAXException, ParserConfigurationException {
        byte[] xmlBytes = Files.readAllBytes(new File("src/test/resources/cfdi33_01.xml").toPath());
        String cadenaOriginal = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes);
        String expected = "||3.3|RogueOne|HNFK231|2018-07-06T12:17:59|01|20001000000300022816|200.00|MXN|1|603.20|I|PUE|06300|LAN8507268IA|MB IDEAS DIGITALES SC|601|AAA010101AAA|SW SMARTERWEB|G03|50211503|UT421511|1|H87|Pieza|Cigarros|200.00|200.00|200.00|002|Tasa|0.160000|32.00|232.00|003|Tasa|1.600000|371.20|002|Tasa|0.160000|32.00|003|Tasa|1.600000|371.20|403.20||";
        Assert.assertEquals(cadenaOriginal, expected);
    }

    public void testGenerateCadena32()
            throws URISyntaxException, TransformerException, IOException, SAXException, ParserConfigurationException {
        byte[] xmlBytes = Files.readAllBytes(new File("src/test/resources/cfdi32_01.xml").toPath());
        String cadenaOriginal = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes);
        String expected = "||3.2|2017-11-07T23:35:52|ingreso|Pago en una sola exhibición|1333.00|1.0000|MXN|1546.28|NA|ZAPOPAN, JALISCO|No Identificado|IIA040805DZ4|MI SUPER CUENTA DE DESSARROLLO|AV WASHINGTON|4921|12345|JARDINES VALLARTA|ZAPOPAN|ZAPOPAN|JALISCO|MÉXICO|45110|GENERAL DE LEY PERSONAS MORALES|GENERAL DE LEY PERSONAS MORALES DOBLE REGIMEN|CACX7605101P8|PUBLICO GENERAL|CALLE|1|GUADALAJARA|GUADALAJARA|GUADALAJARA|JALISCO|MEX|45100|1|No Aplica|UT421511|123|1333|1333.000000|IVA|16|213.28||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
}