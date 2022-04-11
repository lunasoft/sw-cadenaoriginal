package sw.Singleton;

import javax.xml.transform.TransformerConfigurationException;

import sw.CadenaOriginalCfdi40;

public class CadenaOriginalCfdi40Singleton {
    private static CadenaOriginalCfdi40 instance = null;
    private CadenaOriginalCfdi40Singleton()
    {

    }
    public static CadenaOriginalCfdi40 getInstance() throws TransformerConfigurationException
    {
        if(instance == null)
            instance = new CadenaOriginalCfdi40();
        return instance;
    }
}
