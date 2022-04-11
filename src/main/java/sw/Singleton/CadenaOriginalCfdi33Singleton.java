package sw.Singleton;

import javax.xml.transform.TransformerConfigurationException;

import sw.CadenaOriginalCfdi33;

public class CadenaOriginalCfdi33Singleton {
    private static CadenaOriginalCfdi33 instance = null;
    private CadenaOriginalCfdi33Singleton()
    {

    }
    public static CadenaOriginalCfdi33 getInstance() throws TransformerConfigurationException
    {
        if(instance == null)
            instance = new CadenaOriginalCfdi33();
        return instance;
    }
}
