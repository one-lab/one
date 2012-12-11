package ins.prpall.report.web;

import ins.framework.common.Page;
import ins.framework.web.Struts2Action;
import ins.prpall.report.model.LCGrpInsuredInfoReport;
import ins.prpall.report.service.facade.LCInsuredReportService;

import java.io.File;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class LCInsuredReportAction extends Struts2Action {
	private static final long serialVersionUID = 1L;
	/**上传的文件*/
	private File insuredFile;
	/**集体被保人模糊信息表*/
	private List<LCGrpInsuredInfoReport> lcGrpInsuredInfoReportList;
	/**服务*/
	private LCInsuredReportService lcInsuredReportService;
	public File getInsuredFile() {
		return insuredFile;
	}
	public void setInsuredFile(File insuredFile) {
		this.insuredFile = insuredFile;
	}
	public LCInsuredReportService getLcInsuredReportService() {
		return lcInsuredReportService;
	}
	public void setLcInsuredReportService(
			LCInsuredReportService lcInsuredReportService) {
		this.lcInsuredReportService = lcInsuredReportService;
	}
	

	public List<LCGrpInsuredInfoReport> getLcGrpInsuredInfoReportList() {
		return lcGrpInsuredInfoReportList;
	}
	public void setLcGrpInsuredInfoReportList(
			List<LCGrpInsuredInfoReport> lcGrpInsuredInfoReportList) {
		this.lcGrpInsuredInfoReportList = lcGrpInsuredInfoReportList;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	//导入被保人
	public String importInsured() throws Exception {
		if (insuredFile != null) {
			boolean ok = lcInsuredReportService.importInsured(insuredFile);
			JSONObject jsonObject = new JSONObject();
			if (ok) {
				jsonObject.put("success", JSONArray.fromObject("ok"));
			} else {
				jsonObject.put("success", JSONArray.fromObject("false"));
			}
			renderHtml(jsonObject.toString());
		} else {
			System.out.print("文件为空！");
		}
		return NONE;
	}
	//集体被保人模糊信息保存
	public String saveGrpInsurInfor() throws ParseException{
		if(pageNo == 0){
			pageNo = 1;
		}
		if(pageSize == 0){
			pageSize = 20;
		}
		Page page=lcInsuredReportService.saveGrpInsurInfor(lcGrpInsuredInfoReportList, pageNo, pageSize);
		this.writeJSONData(page, new String[]{"id.serialNo","id.repNo","type","typeName","typeValue","peoples","rate","maxAge","minAge","averAge"});
		return NONE;
	}
}
