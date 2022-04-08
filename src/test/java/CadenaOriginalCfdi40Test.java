import junit.framework.TestCase;
import org.junit.Assert;
import sw.CadenaOriginalCfdi40;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.net.URISyntaxException;

public class CadenaOriginalCfdi40Test extends TestCase {

    public void testGenerateCadena() throws URISyntaxException{

        try {

            //INICIALIZAS LA CLASE RECURSO
            CadenaOriginalCfdi40 cadenaOriginal40 = new CadenaOriginalCfdi40();
            Source xml = new StreamSource(new File("src/test/resources/cfdi40_01.xml"));
            String cadenaOriginal = cadenaOriginal40.GetCadenaOriginal(xml);
            String expected = "||4.0|Serie|Folio|2021-12-16T15:40:21|30001000000400002444|0|XXX|0.0|P|01|20008|XAXX010101000|PUBLICO GENERAL|601|XAXX010101000|Nombre|45000|601|G01|84111506|1|ACT|Pago|0|0|01|2.0|0.00|0|0|940337.15|150453.94|16728123.41|1338249.87|16675096.20|0|10.79|4000.00|2021-12-02T00:18:10|01|USD|1|14000.00|1|XAXX010101000|NomBancoOrdExt1|0000000000000000|XAXX010101000|003293324|1|004004040|CadPago|SelloPago|BEDC8964-7E57-4604-9968-7E01378E8706|Serie3|Folio3|MXN|1.329310|1|5000.00|2000.00|3000.00|02|1|001|Tasa|0.300000|0.300000|625000.00|002|Tasa|0.160000|100000.00|22166372.13|002|Tasa|0.080000|1773309.77|22166372.13|002|Tasa|0.000000|0|1|002|Exento|BEDC8964-7E57-4604-9968-7E01378E8706|Serie3|Folio3|MXN|23.5728|1|5000.00|2000.00|3000.00|02|11083186.11|002|Tasa|0.160000|1773309.77|1250000.00|002|Tasa|0.080000|100000.00|1|002|Exento|001|2|940337.15|002|Tasa|0.160000|150453.94|16728123.41|002|Tasa|0.080000|1338249.87|16675096.20|002|Tasa|0.000000|0|0.79|002|Exento||";
            Assert.assertEquals(cadenaOriginal, expected);

        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}