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
import org.junit.Ignore;

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
        String cadenaOriginal = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes,"3.2");
        String expected = "||3.2|2017-11-07T23:35:52|ingreso|Pago en una sola exhibicion|1333.00|1.0000|MXN|1546.28|NA|ZAPOPAN, JALISCO|No Identificado|IIA040805DZ4|MI SUPER CUENTA DE DESSARROLLO|AV WASHINGTON|4921|12345|JARDINES VALLARTA|ZAPOPAN|ZAPOPAN|JALISCO|MEXICO|45110|GENERAL DE LEY PERSONAS MORALES|GENERAL DE LEY PERSONAS MORALES DOBLE REGIMEN|CACX7605101P8|PUBLICO GENERAL|CALLE|1|GUADALAJARA|GUADALAJARA|GUADALAJARA|JALISCO|MEX|45100|1|No Aplica|UT421511|123|1333|1333.000000|IVA|16|213.28||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
    
    public void testGenerateCadena40CCP30()
            throws URISyntaxException, TransformerException, IOException, SAXException, ParserConfigurationException {
        byte[] xmlBytes = Files.readAllBytes(new File("src/test/resources/cfdi40_ccp30.xml").toPath());
        String cadenaOriginal = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes,"4.0");
        String expected = "||4.0|Serie|Folio|2023-10-08T00:00:55|01|30001000000500003416|100.00|MXN|100.00|I|01|PUE|42501|EKU9003173C9|ESCUELA KEMPER URGATE|601|EKU9003173C9|ESCUELA KEMPER URGATE|42501|601|S01|78101800|UT421511|1|H87|Pieza|Transporte de carga por carretera|100.00|100.00|01|3.0|CCCBCD94-870A-4332-A52A-A52AA52AA52A|No|1|Si|01|01|Origen|OR101010|EKU9003173C9|NombreRemitenteDestinatario1|2023-08-01T00:00:00|Calle1|211|212|1957|13|casa blanca|011|CMX|MEX|13250|Destino|DE202020|EKU9003173C9|NombreRemitenteDestinatario2|2023-08-01T00:00:01|1|Calle2|214|215|0347|23|casa negra|004|COA|MEX|25350|1.0|XBX|1|1|Si|11121900|Accesorios de equipo de telefonia|1.0|XBX|No|01|DenominacionGenericaProd1|DenominacionDistintivaProd1|Fabricante1|2028-01-01|LoteMedic1|01|01|RegistroSanita1|1|1|OR101010|DE202020|TPAF01|NumPermisoSCT1|VL|1|plac892|2020|AseguraRespCivil|123456789|CTR004|VL45K98|01|VAAM130719H60|a234567890|NombreFigura||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
    public void testGenerateCadena40CCE20()
            throws URISyntaxException, TransformerException, IOException, SAXException, ParserConfigurationException {
        byte[] xmlBytes = Files.readAllBytes(new File("src/test/resources/cfdi40_cce20.xml").toPath());
        String cadenaOriginal = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes,"4.0");
        String expected = "||4.0|Serie|Folio1|2024-01-18T00:00:00|99|30001000000500003416|CondicionesDePago|400|AMD|1|400.00|I|02|PPD|20000|EKU9003173C9|ESCUELA KEMPER URGATE|601|XEXX010101000|ESCUELA KEMPER URGATE|20000|616|S01|50211503|131494-1055|2|H87|Pieza|Cigarros|200.00|400.00|01|2.0|A1|0|FOB|17.1598|25.56|CALLE DEL PAPEL|0214|01|014|QUE|MEX|76199|123456789|ST. A|TX|USA|00000|131494-1055|2402200100|117.64|01|12.78|25.56||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
    public void testGenerateCadena40CCP31()
            throws URISyntaxException, TransformerException, IOException, SAXException, ParserConfigurationException {
        byte[] xmlBytes = Files.readAllBytes(new File("src/test/resources/cfdi40_ccp30.xml").toPath());
        String cadenaOriginal = CadenaOriginalCfdi.getCadenaOriginal(xmlBytes,"4.0");
        String expected = "||4.0|Serie|Folio|2023-10-08T00:00:55|01|30001000000500003416|100.00|MXN|100.00|I|01|PUE|42501|EKU9003173C9|ESCUELA KEMPER URGATE|601|EKU9003173C9|ESCUELA KEMPER URGATE|42501|601|S01|78101800|UT421511|1|H87|Pieza|Transporte de carga por carretera|100.00|100.00|01|3.0|CCCBCD94-870A-4332-A52A-A52AA52AA52A|No|1|Si|01|01|Origen|OR101010|EKU9003173C9|NombreRemitenteDestinatario1|2023-08-01T00:00:00|Calle1|211|212|1957|13|casa blanca|011|CMX|MEX|13250|Destino|DE202020|EKU9003173C9|NombreRemitenteDestinatario2|2023-08-01T00:00:01|1|Calle2|214|215|0347|23|casa negra|004|COA|MEX|25350|1.0|XBX|1|1|Si|11121900|Accesorios de equipo de telefonia|1.0|XBX|No|01|DenominacionGenericaProd1|DenominacionDistintivaProd1|Fabricante1|2028-01-01|LoteMedic1|01|01|RegistroSanita1|1|1|OR101010|DE202020|TPAF01|NumPermisoSCT1|VL|1|plac892|2020|AseguraRespCivil|123456789|CTR004|VL45K98|01|VAAM130719H60|a234567890|NombreFigura||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
}