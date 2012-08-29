package ins.platform.model;

// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * POJO类UtiMenuStyle
 */
@Entity
@Table(name = "UTIMENUSTYLE")
public class UtiMenuStyle implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性ID */
	private UtiMenuStyleId id;

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

	/** 属性备注 */
	private String remark;

	/** 属性标志 */
	private String flag;

	/**
	 * 类UtiMenuStyle的默认构造方法
	 */
	public UtiMenuStyle() {
	}

	/**
	 * 属性ID的getter方法
	 */
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "menuLevel", column = @Column(name = "MENULEVEL")),
			@AttributeOverride(name = "systemCode", column = @Column(name = "SYSTEMCODE")) })
	public UtiMenuStyleId getId() {
		return this.id;
	}

	/**
	 * 属性ID的setter方法
	 */
	public void setId(UtiMenuStyleId id) {
		this.id = id;
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

}
