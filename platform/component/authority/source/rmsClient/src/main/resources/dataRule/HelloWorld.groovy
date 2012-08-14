package dataRule

import com.sinosoft.one.rms.client.DataRuleScript

/**
* Created by IntelliJ IDEA.
* User: ChengQi
* Date: 8/10/12
* Time: 2:54 PM
* To change this template use File | Settings | File Templates.
*/
class HelloWorld implements DataRuleScript {

    String say() {
        return "hello";
    }

    @Override
    String rule() {
        return say();
    }
}
