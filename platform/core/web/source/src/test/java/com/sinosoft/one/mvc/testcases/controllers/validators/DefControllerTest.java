package com.sinosoft.one.mvc.testcases.controllers.validators;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.validation.Configuration;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validation;

import com.sinosoft.one.mvc.testcases.AbstractControllerTest;
import com.sinosoft.one.mvc.web.validation.OneTraversableResolver;
import junit.framework.Assert;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.hibernate.validator.cfg.context.PropertyConstraintMappingContext;
import org.hibernate.validator.cfg.defs.MinDef;
import org.hibernate.validator.cfg.defs.NotNullDef;
import org.hibernate.validator.cfg.defs.SizeDef;
import org.hibernate.validator.internal.engine.PathImpl;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.springframework.beans.BeanUtils;

public class DefControllerTest extends AbstractControllerTest {

    public void testIndex() throws ServletException, IOException {
        request.addParameter("p", "not-int");
        assertEquals("error", invoke("/validators/hello"));
    }

    public void testIndex2() throws ServletException, IOException {
        request.addParameter("p", "34");
        assertEquals(34, invoke("/validators/hello"));
    }

    public void testMutileBean()throws ServletException, IOException{
        request.addParameter("licensePlate", "n123123");
        request.addParameter("manufacturer", "0");
        request.addParameter("rentalCar.rentalStation", "0");
        request.addParameter("rentalCarList[0].rentalStation", "");
        assertEquals("validate/", invoke("/param/validationCar"));
    }

    public void testCascade(){

        RentalCar rentalCar = new RentalCar();
        Car car = new Car();
        car.setRentalCar(rentalCar);
        car.setLicensePlate("1");
        car.setManufacturer("2");
        List<RentalCar> list = new ArrayList<RentalCar>();
        list.add(rentalCar);
        car.setRentalCarList(list);
        HibernateValidatorConfiguration config = Validation.byProvider(HibernateValidator.class).configure();
        ConstraintMapping mapping = config.createConstraintMapping();
        PropertyConstraintMappingContext context = mapping.type(Car.class)
                .property("manufacturer", ElementType.FIELD)
                .constraint(new NotNullDef()).valid()
                .property("licensePlate", ElementType.FIELD)
                .constraint(new NotNullDef())
                .constraint(new SizeDef().min(2).max(14))
                .property("seatCount", ElementType.FIELD)
                .constraint(new MinDef().value(2))
                .property("rentalCarList", ElementType.FIELD).valid()
                .type(RentalCar.class)
                .property("rentalStation", ElementType.FIELD);
                System.out.println(context.getClass());
                context.constraint(new NotNullDef()).valid();
        config.addMapping(mapping);
        Set<ConstraintViolation<Car>> result= config.buildValidatorFactory().getValidator().validate(car);
        Assert.assertEquals(3,result.size());

    }

    public static void main(String[] args){
//        PropertyDescriptor[] s=   BeanUtils.getPropertyDescriptors(Car.class);
//        for(PropertyDescriptor p:s){
//            System.out.println(p.attributeNames());
//
//        }

        for(Iterator<Path.Node> iterable= PathImpl.createPathFromString("a").iterator();iterable.hasNext();){
            Path.Node node = iterable.next();
            System.out.println(node.getName()+"="+node.getIndex());
        }
    }



}
