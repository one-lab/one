package com.sinosoft.one;

import com.sinosoft.one.mvc.crypto.ajax.AjaxCryptoCodec;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-12
 * Time: 下午6:07
 * To change this template use File | Settings | File Templates.
 */
public class AjaxCryptoCodecTest {
    private User user;
    private MockHttpServletRequest request =new MockHttpServletRequest();
    @Before
    public void setUp(){
        user=new User("1234567","张三","男",Integer.valueOf(20));
        request.getSession().setAttribute("crypto_key_attr_name","387E0C232658B90C56359B8B93422F47");
    }
    @Test
    public void test1() throws Throwable {
        //MockHttpServletRequest request=new MockHttpServletRequest();
        AjaxCryptoCodec.encode(request,"id,name",user).toJson();

    }
}
