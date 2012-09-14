
public class ConstructorUsage {

	public void personConstructor() {		
		Person defaultConstructor = new Person();
		Person minimalConstructor = new Person("a name", new EntityAddress("street", "city"));
	}
	
	public void employeeConstructor() {		
		Employee defaultConstructor = new Employee();
		Employee fullConstructor = new Employee("a name", new EntityAddress("street", "city"), 2.0);
		Employee minimalConstructor = new Employee("a name", new EntityAddress("street", "city"));
	}
	
	public void entityAddressConstructor() {		
		EntityAddress defaultConstructor = new EntityAddress();		
		EntityAddress allConstructor = new EntityAddress("street", "city");
		EntityAddress minimalConstructor = new EntityAddress("street");
	}
	
	public void companyConstructor() {
		Company defaultConstructor = new Company();
		CompanyId cid = new CompanyId(42,'a');
		Company allConstructor = new Company(cid,"myBrand", new java.util.HashSet());
		Company minimalConstructor = new Company(cid,"myBrand");
	}
	
	public void productConstructor() {
		BrandProduct defaultConstructor = new BrandProduct();
		BrandProduct minimalConstructor = new BrandProduct("id");
		BrandProduct fullConstructor = new BrandProduct("id", "a name");
	}
}
