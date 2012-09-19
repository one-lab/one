package com.sinosoft.one.mvc.mock.controllers.methodparameter;

import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;

@Path("$controller.id/$controller.bool")
public class MethodParameterController {

    public void innt(@Param("controller.id") int cid) {
    }

    public void integer(@Param("controller.id") Integer cid) {
    }

    public void bool(@Param("controller.bool") boolean cid) {
    }

    public void boool(@Param("controller.bool") Boolean cid) {
    }

    public void loong(@Param("controller.id") long cid) {
    }

    public void looong(@Param("controller.id") Long cid) {
    }

    public void string(@Param("controller.id") String cid) {
    }

    public void nullPrimitiveBool(@Param("controller.abcded") boolean cid) {
    }

    public void nullPrimitiveBoolWrapper(@Param("controller.abcded") Boolean cid) {
    }
}
