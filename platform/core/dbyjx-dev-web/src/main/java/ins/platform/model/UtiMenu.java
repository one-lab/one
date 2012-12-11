package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * POJO类UtiMenu
 */
@Entity
@Table(name = "UTIMENU")
public class UtiMenu implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性菜单编号 */
	private String menuId;

	/** 属性上级菜单编号 */
	private String upperMenuId;

	/** 属性菜单层级 */
	private BigDecimal menuLevel;

	/** 属性系统代码 */
	private String systemCode;

	/** 属性菜单中文名称 */
	private String menuCName;

	/** 属性菜单英文名称 */
	private String menuEName;

	/** 属性url */
	private String url;

	/** 属性目标 */
	private String target;

	/** 属性显示序号 */
	private BigDecimal displayNo;

	/** 属性菜单标题图片名 */
	private String image;

	/** 属性展开菜单的图片名 */
	private String imageExpand;

	/** 属性合上菜单的图片名 */
	private String imageCollapse;

	/** 属性展开菜单的图标 */
	private String iconExpand;

	/** 属性合上菜单的图标 */
	private String iconCollapse;

	/** 属性效力状态 */
	private String validStatus;

	/** 属性备注 */
	private String remark;

	/** 属性标志 */
	private String flag;

	/** 属性功能代码 */
	private String taskCode;

	/** 属性 */
	private String permitRiskClass;

	/** 属性 */
	private String exceptRiskCode;

	/** 属性 */
	private String exceptRiskClass;

	/** 属性险种范围 */
	private String permitRiskCode;

	/** 属性checkclass */
	private String checkclass;

	/**
	 * 类UtiMenu的默认构造方法
	 */
	public UtiMenu() {
	}

	/**
	 * 属性菜单编号的getter方法
	 */
	@Id
	@Column(name = "MENUID")
	public String getMenuId() {
		return this.menuId;
	}

	/**
	 * 属性菜单编号的setter方法
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	/**
	 * 属性上级菜单编号的getter方法
	 */

	@Column(name = "UPPERMENUID")
	public String getUpperMenuId() {
		return this.upperMenuId;
	}

	/**
	 * 属性上级菜单编号的setter方法
	 */
	public void setUpperMenuId(String upperMenuId) {
		this.upperMenuId = upperMenuId;
	}

	/**
	 * 属性菜单层级的getter方法
	 */

	@Column(name = "MENULEVEL")
	public BigDecimal getMenuLevel() {
		return this.menuLevel;
	}

	/**
	 * 属性菜单层级的setter方法
	 */
	public void setMenuLevel(BigDecimal menuLevel) {
		this.menuLevel = menuLevel;
	}

	/**
	 * 属性系统代码的getter方法
	 */

	@Column(name = "SYSTEMCODE")
	public String getSystemCode() {
		return this.systemCode;
	}

	/**
	 * 属性系统代码的setter方法
	 */
	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	/**
	 * 属性菜单中文名称的getter方法
	 */

	@Column(name = "MENUCNAME")
	public String getMenuCName() {
		return this.menuCName;
	}

	/**
	 * 属性菜单中文名称的setter方法
	 */
	public void setMenuCName(String menuCName) {
		this.menuCName = menuCName;
	}

	/**
	 * 属性菜单英文名称的getter方法
	 */

	@Column(name = "MENUENAME")
	public String getMenuEName() {
		return this.menuEName;
	}

	/**
	 * 属性菜单英文名称的setter方法
	 */
	public void setMenuEName(String menuEName) {
		this.menuEName = menuEName;
	}

	/**
	 * 属性url的getter方法
	 */

	@Column(name = "URL")
	public String getUrl() {
		return this.url;
	}

	/**
	 * 属性url的setter方法
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 属性目标的getter方法
	 */

	@Column(name = "TARGET")
	public String getTarget() {
		return this.target;
	}

	/**
	 * 属性目标的setter方法
	 */
	public void setTarget(String target) {
		this.target = target;
	}

	/**
	 * 属性显示序号的getter方法
	 */

	@Column(name = "DISPLAYNO")
	public BigDecimal getDisplayNo() {
		return this.displayNo;
	}

	/**
	 * 属性显示序号的setter方法
	 */
	public void setDisplayNo(BigDecimal displayNo) {
		this.displayNo = displayNo;
	}

	/**
	 * 属性菜单标题图片名的getter方法
	 */

	@Column(name = "IMAGE")
	public String getImage() {
		return this.image;
	}

	/**
	 * 属性菜单标题图片名的setter方法
	 */
	public void setImage(String image) {
		this.image = image;
	}

	/**
	 * 属性展开菜单的图片名的getter方法
	 */

	@Column(name = "IMAGEEXPAND")
	public String getImageExpand() {
		return this.imageExpand;
	}

	/**
	 * 属性展开菜单的图片名的setter方法
	 */
	public void setImageExpand(String imageExpand) {
		this.imageExpand = imageExpand;
	}

	/**
	 * 属性合上菜单的图片名的getter方法
	 */

	@Column(name = "IMAGECOLLAPSE")
	public String getImageCollapse() {
		return this.imageCollapse;
	}

	/**
	 * 属性合上菜单的图片名的setter方法
	 */
	public void setImageCollapse(String imageCollapse) {
		this.imageCollapse = imageCollapse;
	}

	/**
	 * 属性展开菜单的图标的getter方法
	 */

	@Column(name = "ICONEXPAND")
	public String getIconExpand() {
		return this.iconExpand;
	}

	/**
	 * 属性展开菜单的图标的setter方法
	 */
	public void setIconExpand(String iconExpand) {
		this.iconExpand = iconExpand;
	}

	/**
	 * 属性合上菜单的图标的getter方法
	 */

	@Column(name = "ICONCOLLAPSE")
	public String getIconCollapse() {
		return this.iconCollapse;
	}

	/**
	 * 属性合上菜单的图标的setter方法
	 */
	public void setIconCollapse(String iconCollapse) {
		this.iconCollapse = iconCollapse;
	}

	/**
	 * 属性效力状态的getter方法
	 */

	@Column(name = "VALIDSTATUS")
	public String getValidStatus() {
		return this.validStatus;
	}

	/**
	 * 属性效力状态的setter方法
	 */
	public void setValidStatus(String validStatus) {
		this.validStatus = validStatus;
	}

	/**
	 * 属性备注的getter方法
	 */

	@Column(name = "REMARK")
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 属性备注的setter方法
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 属性标志的getter方法
	 */

	@Column(name = "FLAG")
	public String getFlag() {
		return this.flag;
	}

	/**
	 * 属性标志的setter方法
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 属性功能代码的getter方法
	 */

	@Column(name = "TASKCODE")
	public String getTaskCode() {
		return this.taskCode;
	}

	/**
	 * 属性功能代码的setter方法
	 */
	public void setTaskCode(String taskCode) {
		this.taskCode = taskCode;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "PERMITRISKCLASS")
	public String getPermitRiskClass() {
		return this.permitRiskClass;
	}

	/**
	 * 属性的setter方法
	 */
	public void setPermitRiskClass(String permitRiskClass) {
		this.permitRiskClass = permitRiskClass;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "EXCEPTRISKCODE")
	public String getExceptRiskCode() {
		return this.exceptRiskCode;
	}

	/**
	 * 属性的setter方法
	 */
	public void setExceptRiskCode(String exceptRiskCode) {
		this.exceptRiskCode = exceptRiskCode;
	}

	/**
	 * 属性的getter方法
	 */

	@Column(name = "EXCEPTRISKCLASS")
	public String getExceptRiskClass() {
		return this.exceptRiskClass;
	}

	/**
	 * 属性的setter方法
	 */
	public void setExceptRiskClass(String exceptRiskClass) {
		this.exceptRiskClass = exceptRiskClass;
	}

	/**
	 * 属性险种范围的getter方法
	 */

	@Column(name = "PERMITRISKCODE")
	public String getPermitRiskCode() {
		return this.permitRiskCode;
	}

	/**
	 * 属性险种范围的setter方法
	 */
	public void setPermitRiskCode(String permitRiskCode) {
		this.permitRiskCode = permitRiskCode;
	}

	/**
	 * 属性checkclass的getter方法
	 */

	@Column(name = "CHECKCLASS")
	public String getCheckclass() {
		return this.checkclass;
	}

	/**
	 * 属性checkclass的setter方法
	 */
	public void setCheckclass(String checkclass) {
		this.checkclass = checkclass;
	}

}
