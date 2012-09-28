package ins.prpall.proposal.model;
// default package
// 采用工具 Hibernate Tools 3.2.4.GA (sinosoft version) 生成，请勿手工修改。

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * POJO类LCRepFile
 */
@Entity
@Table(name = "LCREPFILE")
public class LCRepFile implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	/** 属性uploadcode */
	private String uploadcode;

	/** 属性repno */
	private String repno;

	/** 属性fileoperator */
	private String fileoperator;

	/** 属性上传时间 */
	private Date uploadDate;

	/** 属性原文件名称 */
	private String fileName;

	/** 属性生产日期 */
	private Date makeDate;

	/** 属性maketime */
	private String maketime;

	/** 属性modifydate */
	private Date modifydate;

	/** 属性修改时间 */
	private String modifyTime;

	/** 属性文件存放路径 */
	private String filePath;

	/** 属性oldpath */
	private String oldpath;

	/**
	 * 类LCRepFile的默认构造方法
	 */
	public LCRepFile() {
	}

	/**
	 * 属性uploadcode的getter方法
	 */
	@Id
	@Column(name = "UPLOADCODE")
	public String getUploadcode() {
		return this.uploadcode;
	}

	/**
	 * 属性uploadcode的setter方法
	 */
	public void setUploadcode(String uploadcode) {
		this.uploadcode = uploadcode;
	}

	/**
	 * 属性repno的getter方法
	 */

	@Column(name = "REPNO")
	public String getRepno() {
		return this.repno;
	}

	/**
	 * 属性repno的setter方法
	 */
	public void setRepno(String repno) {
		this.repno = repno;
	}

	/**
	 * 属性fileoperator的getter方法
	 */

	@Column(name = "FILEOPERATOR")
	public String getFileoperator() {
		return this.fileoperator;
	}

	/**
	 * 属性fileoperator的setter方法
	 */
	public void setFileoperator(String fileoperator) {
		this.fileoperator = fileoperator;
	}

	/**
	 * 属性上传时间的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "UPLOADDATE")
	public Date getUploadDate() {
		return this.uploadDate;
	}

	/**
	 * 属性上传时间的setter方法
	 */
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	/**
	 * 属性原文件名称的getter方法
	 */

	@Column(name = "FILENAME")
	public String getFileName() {
		return this.fileName;
	}

	/**
	 * 属性原文件名称的setter方法
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 属性生产日期的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MAKEDATE")
	public Date getMakeDate() {
		return this.makeDate;
	}

	/**
	 * 属性生产日期的setter方法
	 */
	public void setMakeDate(Date makeDate) {
		this.makeDate = makeDate;
	}

	/**
	 * 属性maketime的getter方法
	 */

	@Column(name = "MAKETIME")
	public String getMaketime() {
		return this.maketime;
	}

	/**
	 * 属性maketime的setter方法
	 */
	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}

	/**
	 * 属性modifydate的getter方法
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATE")
	public Date getModifydate() {
		return this.modifydate;
	}

	/**
	 * 属性modifydate的setter方法
	 */
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	/**
	 * 属性修改时间的getter方法
	 */

	@Column(name = "MODIFYTIME")
	public String getModifyTime() {
		return this.modifyTime;
	}

	/**
	 * 属性修改时间的setter方法
	 */
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}

	/**
	 * 属性文件存放路径的getter方法
	 */

	@Column(name = "FILEPATH")
	public String getFilePath() {
		return this.filePath;
	}

	/**
	 * 属性文件存放路径的setter方法
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 属性oldpath的getter方法
	 */

	@Column(name = "OLDPATH")
	public String getOldpath() {
		return this.oldpath;
	}

	/**
	 * 属性oldpath的setter方法
	 */
	public void setOldpath(String oldpath) {
		this.oldpath = oldpath;
	}

}
