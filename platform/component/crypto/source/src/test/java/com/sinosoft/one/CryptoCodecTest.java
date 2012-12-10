package com.sinosoft.one;

import com.sinosoft.one.mvc.crypto.CryptoCodec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-6
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
public class CryptoCodecTest {
    private String mockSessionId;
    private String key;
    @Before
    public void setUp(){
        char[] letters={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<32;i++){
            int j=(int)(Math.random()*16);
            stringBuilder.append(letters[j]);
        }
        mockSessionId=stringBuilder.toString();
        key=CryptoCodec.getCryptoKey(mockSessionId);
    }

    @Test
    public void testCryptoWithAllChineseData(){
        String dataForCrypto="测试后端加密的数据";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("测试后端加密的数据", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithAllEnglishData(){
        String dataForCrypto="abcdefgABCDEFGabcdefgABCDEFG";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("abcdefgABCDEFGabcdefgABCDEFG", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithAllDigitalData(){
        String dataForCrypto="123456789123456789123456789";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("123456789123456789123456789", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithAllSpaceDataInChinese(){
        //20个中文空格
        String dataForCrypto="                    ";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("                    ", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithAllSpaceDataInEnglish(){
        //20个英文空格
        String dataForCrypto="                    ";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("                    ", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithEmptyString(){
        //空字符串
        String dataForCrypto="";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithNull(){
        //空字符串
        String dataForCrypto="null";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("null", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithAllSymbolDataInChinese(){
        //其中"\\"是转义符，两个"\\"代表一个"\"
        //"\""中的\是转义符，表示一个英文输入下的双引号"
        //dataForCrypto的最末尾是一个中文空格
        String dataForCrypto="~·！@#￥%……&*（）——-+={【}】|、：；“‘《，》。？、 ";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("~·！@#￥%……&*（）——-+={【}】|、：；“‘《，》。？、 ", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithAllSymbolDataInEnglish(){
        //dataForCrypto的最末尾是一个英文空格
        String dataForCrypto="~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/ ";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/ ", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithMixSymbolData(){
        //dataForCrypto的开头是一个中文空格，最末尾是一个英文空格
        String dataForCrypto=" ~·！@#￥%……&*（）——-+={【}】|、：；“‘《，》。？、~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/ ";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals(" ~·！@#￥%……&*（）——-+={【}】|、：；“‘《，》。？、~`!@#$%^&*()_-+={[}]|\\:;\"'<,>.?/ ", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithMixData(){
        String dataForCrypto="测3a3b3c试后端·！@#￥%加  密!@#$%^&*()的5E5F5G  数据";
        String cipherText=CryptoCodec.encode(key,dataForCrypto);
        System.out.println(cipherText);
        String dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        assertEquals("测3a3b3c试后端·！@#￥%加  密!@#$%^&*()的5E5F5G  数据", dataForUnCrypto);
    }

    @Test
    public void testCryptoWithMixArrayData(){
        String[] dataForCrypto={"测试 数据","Test data with English","1234567890","@#￥%……&*（）","后Test data端·！@#￥%加  密"};
        String[] cipherText=new String[dataForCrypto.length];
        for(int i=0;i<dataForCrypto.length;i++){
            cipherText[i]=CryptoCodec.encode(key,dataForCrypto[i]);
        }
        String[] dataForUnCrypto=CryptoCodec.decode(key,cipherText);
        for(int i=0;i<dataForUnCrypto.length;i++){
            assertEquals(dataForCrypto[i],dataForUnCrypto[i]);
        }
    }
}
