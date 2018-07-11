import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;
import java.net.URISyntaxException;



public class ResourceSW {
    private InputStream _cadenaOriginal;
    private InputStream _cfdiXSD;
    private  String _systemId_cadenaOriginal;
    private  String _systemId_cfdiXSD;

    public Source CadenaOriginalSource() {


        StreamSource c1 = new StreamSource(this._cadenaOriginal);
        c1.setSystemId(_systemId_cadenaOriginal);
        return c1;
    }

    private Source  _cadenaOriginalSource;
    private  Source _cfdiXSDSource;

    public Source CfdiXSDSource() {
        StreamSource c1 = new StreamSource(this._cfdiXSD);
        c1.setSystemId("001");
        return c1;
    }

    public ResourceSW() {
        try {
            this._systemId_cadenaOriginal = getClass().getResource("/cadenaoriginal_3_3.xslt").toURI().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        this._cadenaOriginal = getClass().getResourceAsStream("/cadenaoriginal_3_3.xslt");
        this._cfdiXSD = getClass().getResourceAsStream("/cfdv33.xsd");

    }

    public InputStream CadenaOriginal() {
        return _cadenaOriginal;
    }

    public InputStream CfdiXSD() {
        return _cfdiXSD;
    }
}
