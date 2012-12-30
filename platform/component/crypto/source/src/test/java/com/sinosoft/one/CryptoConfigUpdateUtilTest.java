package com.sinosoft.one;

import com.sinosoft.one.mvc.crypto.config.CryptoConfig;
import com.sinosoft.one.mvc.crypto.parser.CryptoConfigurationParser;
import com.sinosoft.one.mvc.crypto.util.CryptoConfigUpdateUtil;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 加密解密文件动态更新测试
 * User: carvin
 * Date: 12-12-28
 * Time: 上午2:20
 * To change this template use File | Settings | File Templates.
 */
public class CryptoConfigUpdateUtilTest {
    private String configurationLocation = "";
    @Before
    public void setUp() {
        configurationLocation = "classpath:crypto/crypto_config.xml";
        new CryptoConfigurationParser().parserCryptoConfiguration(configurationLocation);
    }

    @Test
    public void testSaveUnCryptoConfig() {
        CryptoConfigUpdateUtil.saveUnCryptoConfig("/testA/testA", "/testB/testB");
        CryptoConfig cryptoConfig = CryptoConfig.getInstance();
        Assert.assertEquals(9, cryptoConfig.getUncryptoMap().size());
        new CryptoConfigurationParser().parserCryptoConfiguration(configurationLocation);
        Assert.assertEquals(9, cryptoConfig.getUncryptoMap().size());
    }
    @Test
    public void testDeleteUnCryptoConfigs() {
        testSaveUnCryptoConfig();
        CryptoConfigUpdateUtil.deleteUnCryptoConfigs("/testA/testA", "/testB/testB");
        CryptoConfig cryptoConfig = CryptoConfig.getInstance();
        Assert.assertEquals(7, cryptoConfig.getUncryptoMap().size());
    }

}
