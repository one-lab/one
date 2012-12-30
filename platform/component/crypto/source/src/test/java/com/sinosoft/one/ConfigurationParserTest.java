package com.sinosoft.one;

import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.config.UnCrypto;
import com.sinosoft.one.mvc.crypto.parser.CryptoConfigurationParser;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: carvin
 * Date: 12-12-28
 * Time: 上午12:41
 * To change this template use File | Settings | File Templates.
 */
public class ConfigurationParserTest {
    private String configurationLocation = "";
    @Before
    public void setUp() {
        configurationLocation = "classpath:crypto/crypto_config.xml";
    }

    @Test
    public void testConfigurationParser() {
        new CryptoConfigurationParser().parserCryptoConfiguration(configurationLocation);
        CryptoConfig cryptoConfig = CryptoConfig.getInstance();
        Map<String, UnCrypto> unCryptoMap = cryptoConfig.getUncryptoMap();
        Assert.assertEquals(7, unCryptoMap.size());
        UnCrypto unCrypto = unCryptoMap.get("/demo/send");
        Assert.assertEquals("/demo/send", unCrypto.getUrl());
    }
}
