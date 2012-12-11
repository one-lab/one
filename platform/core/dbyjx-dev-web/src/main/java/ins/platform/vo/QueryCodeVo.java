package ins.platform.vo;
/**
 * 双击时，通用的vo类其中间转换的作用
 * @author Administrator
 *
 */
public class QueryCodeVo {
	private String codeValue;
	private String codeLabel;
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getCodeLabel() {
		return codeLabel;
	}
	public void setCodeLabel(String codeLabel) {
		this.codeLabel = codeLabel;
	}
	public QueryCodeVo(){
		
	}
	public QueryCodeVo(String codeValue, String codeLabel) {
		super();
		this.codeValue = codeValue;
		this.codeLabel = codeLabel;
	}
	
}
