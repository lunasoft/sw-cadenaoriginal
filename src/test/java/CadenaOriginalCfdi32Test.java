import junit.framework.TestCase;
import org.junit.Assert;
import sw.CadenaOriginalCfdi32;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerException;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.net.URISyntaxException;

public class CadenaOriginalCfdi32Test extends TestCase {

    public void testGenerateCadena() throws URISyntaxException, TransformerException {
        CadenaOriginalCfdi32 cadenaOriginalService = new CadenaOriginalCfdi32();
        Source xml = new StreamSource(new File("src/test/resources/cfdi32_01.xml"));
        String cadenaOriginal = cadenaOriginalService.getCadenaOriginal(xml);
        String expected = "||3.2|2017-11-07T23:35:52|ingreso|Pago en una sola exhibición|1333.00|1.0000|MXN|1546.28|NA|ZAPOPAN, JALISCO|No Identificado|IIA040805DZ4|MI SUPER CUENTA DE DESSARROLLO|AV WASHINGTON|4921|12345|JARDINES VALLARTA|ZAPOPAN|ZAPOPAN|JALISCO|MÉXICO|45110|GENERAL DE LEY PERSONAS MORALES|GENERAL DE LEY PERSONAS MORALES DOBLE REGIMEN|CACX7605101P8|PUBLICO GENERAL|CALLE|1|GUADALAJARA|GUADALAJARA|GUADALAJARA|JALISCO|MEX|45100|1|No Aplica|UT421511|123|1333|1333.000000|IVA|16|213.28||";
        Assert.assertEquals(cadenaOriginal, expected);
    }
}