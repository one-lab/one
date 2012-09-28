package ins.prpall.proposal.vo;
/**
 * 
 * @title ClertQueryInfoVo
 * @description 团体客户类的客户号，单位名称、单位性质类
 * @author xu_xinling
 * @version 
 * @create date 2012-8-13
 * @copyright (c) 
 *
 */
public class ClertQueryInfoVo {
	//客户号
	private String customerNo;
	//单位名称
	private String grpName;
	//单位性质
	private String grpNature;
	
	//构造方法
	public ClertQueryInfoVo(String customerNo,String grpName,String grpNature){
		this.customerNo=customerNo;
		this.grpName=grpName;
		this.grpNature=grpNature;
	}
	/**
	 * @return the customerNo
	 */
	public String getCustomerNo() {
		return customerNo;
	}
	/**
	 * @param customerNo the customerNo to set
	 */
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	/**
	 * @return the grpName
	 */
	public String getGrpName() {
		return grpName;
	}
	/**
	 * @param grpName the grpName to set
	 */
	public void setGrpName(String grpName) {
		this.grpName = grpName;
	}
	/**
	 * @return the grpNature
	 */
	public String getGrpNature() {
		return grpNature;
	}
	/**
	 * @param grpNature the grpNature to set
	 */
	public void setGrpNature(String grpNature) {
		this.grpNature = grpNature;
	}
}
