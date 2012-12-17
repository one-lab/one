package ins.prpall.proposal.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * POJO类LCBnfId
 */
@Embeddable
public class LCBnfId implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性保单号码 */
	private String polNo;

	/** 属性被保人客户号码 */
	private String insuredNo;

	/** 属性受益人类别 */
	private String bnfType;

	/** 属性受益人序号 */
	private BigDecimal bnfNo;

	/** 属性受益人级别 */
	private String bnfGrade;

	/**
	 * 类LCBnfId的默认构造方法
	 */
	public LCBnfId() {
	}

	/**
	 * 属性保单号码的getter方法
	 */

	@Column(name = "POLNO")
	public String getPolNo() {
		return this.polNo;
	}

	/**
	 * 属性保单号码的setter方法
	 */
	public void setPolNo(String polNo) {
		this.polNo = polNo;
	}

	/**
	 * 属性被保人客户号码的getter方法
	 */

	@Column(name = "INSUREDNO")
	public String getInsuredNo() {
		return this.insuredNo;
	}

	/**
	 * 属性被保人客户号码的setter方法
	 */
	public void setInsuredNo(String insuredNo) {
		this.insuredNo = insuredNo;
	}

	/**
	 * 属性受益人类别的getter方法
	 */

	@Column(name = "BNFTYPE")
	public String getBnfType() {
		return this.bnfType;
	}

	/**
	 * 属性受益人类别的setter方法
	 */
	public void setBnfType(String bnfType) {
		this.bnfType = bnfType;
	}

	/**
	 * 属性受益人序号的getter方法
	 */

	@Column(name = "BNFNO")
	public BigDecimal getBnfNo() {
		return this.bnfNo;
	}

	/**
	 * 属性受益人序号的setter方法
	 */
	public void setBnfNo(BigDecimal bnfNo) {
		this.bnfNo = bnfNo;
	}

	/**
	 * 属性受益人级别的getter方法
	 */

	@Column(name = "BNFGRADE")
	public String getBnfGrade() {
		return this.bnfGrade;
	}

	/**
	 * 属性受益人级别的setter方法
	 */
	public void setBnfGrade(String bnfGrade) {
		this.bnfGrade = bnfGrade;
	}

	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if ((other == null)) {
			return false;
		}
		if (!(other instanceof LCBnfId)) {
			return false;
		}
		LCBnfId castOther = (LCBnfId) other;

		return ((this.getPolNo() == castOther.getPolNo()) || (this.getPolNo() != null
				&& castOther.getPolNo() != null && this.getPolNo().equals(
				castOther.getPolNo())))
				&& ((this.getInsuredNo() == castOther.getInsuredNo()) || (this
						.getInsuredNo() != null
						&& castOther.getInsuredNo() != null && this
						.getInsuredNo().equals(castOther.getInsuredNo())))
				&& ((this.getBnfType() == castOther.getBnfType()) || (this
						.getBnfType() != null && castOther.getBnfType() != null && this
						.getBnfType().equals(castOther.getBnfType())))
				&& ((this.getBnfNo() == castOther.getBnfNo()) || (this
						.getBnfNo() != null && castOther.getBnfNo() != null && this
						.getBnfNo().equals(castOther.getBnfNo())))
				&& ((this.getBnfGrade() == castOther.getBnfGrade()) || (this
						.getBnfGrade() != null
						&& castOther.getBnfGrade() != null && this
						.getBnfGrade().equals(castOther.getBnfGrade())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPolNo() == null ? 0 : this.getPolNo().hashCode());
		result = 37 * result
				+ (getInsuredNo() == null ? 0 : this.getInsuredNo().hashCode());
		result = 37 * result
				+ (getBnfType() == null ? 0 : this.getBnfType().hashCode());
		result = 37 * result
				+ (getBnfNo() == null ? 0 : this.getBnfNo().hashCode());
		result = 37 * result
				+ (getBnfGrade() == null ? 0 : this.getBnfGrade().hashCode());
		return result;
	}

}
