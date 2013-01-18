package com.sinosoft.one.mvc.controllers;




import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.validation.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

@Path("param")
public class ParamValidationController {
	
	@Get("validate")
	public String validate1(@Validation(errorPath = "validate") @Param("id") @Max(10) int id,
                            @Param("name") @Size(max = 10,min=5) String name){

		return "validate";
	}


    @Get("validationCar")
    public String validateCar(@Validation(errorPath = "validate/{id:[a-zA-Z0-9]+}",
                        size = @SizeEx(min=2,max=14,props = {"licensePlate","manufacturer",
                                "rentalCar.rentalStation"}),
                         min=@MinEx(value = 10,props = {"seatCount"}),
                         notBlank=@NotBlankEx(props = {"rentalCarList.rentalStation"}))
                                 Car car,

                              Car car2){
        return null;
    }


}
