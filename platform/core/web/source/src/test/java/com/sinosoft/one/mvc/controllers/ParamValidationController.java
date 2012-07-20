package com.sinosoft.one.mvc.controllers;




import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.validation.annotation.Validation;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Path("param")
public class ParamValidationController {
	
	@Get("validate")
	public String validate1(@Validation(errorPath = "validate") @Param("id") @Max(10) int id,
                            @Param("name") @Size(max = 10,min=5) String name){

		return "validate";
	}
}
