package ins.prpall.proposal.vo;

import ins.prpall.proposal.model.LCGrpAppnt;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCGrpRepInfo;
import ins.prpall.proposal.model.LCGrpRepInfoDetail;
import ins.prpall.proposal.model.LDGrp;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @title LcGrpContGroupVo
 * @description 无影像录入页面中的投保信息类
 * @author xu_xinling
 * @version 
 * @create date 2012-8-6
 * @copyright (c) 
 *
 */
public class LcGrpContGroupVo {
	
	//集体保单类
	private LCGrpCont lcGrpCont;
	//团体客户类
	private LDGrp ldGrp;
	//团单投保人 类
	private LCGrpAppnt lcGrpAppnt;
	//告知单类
	private List<LCGrpRepInfo> lcRepInfoList;
	//告知单明细表
	private LCGrpRepInfoDetail lcGrpRepInfoDetail;
	
	//能过呈报号、客户号 查询的集体险种集合类 
	private List<LCGrpPolVo> lcGrpPolList;
	//客户号
	private String customerNoHidden;

	public LCGrpCont getLcGrpCont() {
		return lcGrpCont;
	}

	public void setLcGrpCont(LCGrpCont lcGrpCont) {
		this.lcGrpCont = lcGrpCont;
	}

	public LDGrp getLdGrp() {
		return ldGrp;
	}

	public void setLdGrp(LDGrp ldGrp) {
		this.ldGrp = ldGrp;
	}

	public LCGrpAppnt getLcGrpAppnt() {
		return lcGrpAppnt;
	}

	public void setLcGrpAppnt(LCGrpAppnt lcGrpAppnt) {
		this.lcGrpAppnt = lcGrpAppnt;
	}

	public List<LCGrpRepInfo> getLcRepInfoList() {
		return lcRepInfoList;
	}

	public void setLcRepInfoList(List<LCGrpRepInfo> lcRepInfoList) {
		this.lcRepInfoList = lcRepInfoList;
	}

	public LCGrpRepInfoDetail getLcGrpRepInfoDetail() {
		return lcGrpRepInfoDetail;
	}

	public void setLcGrpRepInfoDetail(LCGrpRepInfoDetail lcGrpRepInfoDetail) {
		this.lcGrpRepInfoDetail = lcGrpRepInfoDetail;
	}

	public List<LCGrpPolVo> getLcGrpPolList() {
		return lcGrpPolList;
	}

	public void setLcGrpPolList(List<LCGrpPolVo> lcGrpPolList) {
		this.lcGrpPolList = lcGrpPolList;
	}

	public String getCustomerNoHidden() {
		return customerNoHidden;
	}

	public void setCustomerNoHidden(String customerNoHidden) {
		this.customerNoHidden = customerNoHidden;
	}

	
	
	
}
