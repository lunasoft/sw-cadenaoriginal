package sw;

import java.io.IOException;
import java.net.URISyntaxException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;
import sw.Helpers.XmlUtils;
import sw.Singleton.*;

public class CadenaOriginalCfdi {

    public static String getCadenaOriginal(byte[] xmlBytes)
            throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException,
            TransformerException, URISyntaxException {
        String version = XmlUtils.getCfdiVersion(xmlBytes);
        return getCadenaOriginal(xmlBytes, version);
    }

    public static String getCadenaOriginal(byte[] xmlBytes, String version)
            throws TransformerConfigurationException, TransformerException, URISyntaxException {
        if (version.equals("4.0"))
            return CadenaOriginalCfdi40Singleton.getInstance().getCadenaOriginal(xmlBytes);
        else if (version.equals("3.3"))
            return CadenaOriginalCfdi33Singleton.getInstance().getCadenaOriginal(xmlBytes);
        else if (version.equals("3.2"))
            return CadenaOriginalCfdi32Singleton.getInstance().getCadenaOriginal(xmlBytes);
        else
            return CadenaOriginalCfdi40Singleton.getInstance().getCadenaOriginal(xmlBytes);
    }

    public static void warmUp() throws TransformerConfigurationException {
        CadenaOriginalCfdi32Singleton.getInstance();
        CadenaOriginalCfdi33Singleton.getInstance();
        CadenaOriginalCfdi40Singleton.getInstance();
    }
}
