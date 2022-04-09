package sw.Singleton;

import javax.xml.transform.TransformerConfigurationException;

import sw.CadenaOriginalCfdi32;

public class CadenaOriginalCfdi32Singleton {
    private static CadenaOriginalCfdi32 instance = null;
    private CadenaOriginalCfdi32Singleton()
    {

    }
    public static CadenaOriginalCfdi32 getInstance() throws TransformerConfigurationException
    {
        if(instance == null)
            instance = new CadenaOriginalCfdi32();
        return instance;
    }
}
