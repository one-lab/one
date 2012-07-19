package net.paoding.rose.mock.controllers;

import javax.validation.constraints.Max;

import com.sinosoft.web.validation.annotation.Validation;

import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

@Path("param")
public class ParamValidationController {
	
	@Get("validate")
	public String validate1(@Param("id") @Max(10) int id){
		
		return "validate";
	}
}
