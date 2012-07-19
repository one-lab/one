package com.sinosoft.web.test.controllers;


import com.sinosoft.web.validation.annotation.NotBlankEx;
import com.sinosoft.web.validation.annotation.NotNullEx;
import com.sinosoft.web.validation.annotation.SizeEx;
import com.sinosoft.web.validation.annotation.Validation;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("param")
public class ParamValidationController {
	
	@Get("validate")
	public String validate1(@Validation(errorPath = "validate",
			notNull=@NotNullEx(props = { "id","name" }), 
			notBlank=@NotBlankEx(props = { "id","name" })
			//size=@SizeEx(props = { "name","ignoreField" },max=10,min=2)

			) Student stu){
		
		return "validate";
	}
}
