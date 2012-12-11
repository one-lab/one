package ins.prpall.proposal.service.facade;

import ins.framework.common.Page;
import ins.prpall.proposal.model.LCCont;
import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCInsured;
import ins.prpall.proposal.model.LCIssue;
import ins.prpall.proposal.model.LCSingleSearchInfo;
import ins.prpall.proposal.model.LCSingleSearchItem;
import ins.prpall.proposal.model.LDPerson;
import ins.prpall.proposal.vo.AutoUWGrpInfoVo;
import ins.prpall.proposal.vo.AutoUWPersonInfoVo;

import java.util.List;
import java.util.Map;

public interface ArtificalUWService {
	
	/**
	 * @title initArtificalUWApply
	 * @description 初始化人工核保界面，即显示个人工作池中的任务
	 * @author 薛玉强
	 * @return
	 */
	Page initArtificalUWApply(int pageNo,int pageSize);
	
	/**
	 * @title findProposalGrpContInfo
	 * @description 人工核保中查询团体保单信息
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @return
	 */
	Page findProposalGrpContInfo(LCGrpCont lcGrpCont,int pageNo,int pageSize);
	
	/**
	 * 人工核保中申请团体保单信息
	 * @title applyProposalGrpContInfo
	 * @description 
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page applyProposalGrpContInfo(LCGrpCont lcGrpCont,int pageNo,int pageSize);
	
	/**
	 * @title saveLcGrpCont
	 * @description 申请投保单后更改节点状态
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @return
	 */
	public LCGrpCont saveLcGrpContState(LCGrpCont lcGrpCont);
	
	/**
	 * 人工核保中查询集体投保单详细信息
	 * @title findArtificalUWDeal
	 * @description 
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @return
	 */
	Map<String, Object> findArtificalUWDeal(LCGrpCont lcGrpCont);
	
	/**
	 * 保存人工核保中审核意见和核保结论
	 * @title saveArtificalUWResultAndIdea
	 * @description 
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @return
	 */
	boolean saveArtificalUWResultAndIdea(LCGrpCont lcGrpCont);
	
	/**
	 * 人工核保中查询个人投保单基本信息
	 * @title findArtificalUWContInfo
	 * @description 
	 * @author 薛玉强
	 * @param lcInsured
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	Page findArtificalUWContInfo(LCInsured lcInsured,int pageNo,int pageSize);
	
	/**
	 * 人工核保中查询个人投保单详细信息
	 * @title findArtificalUWPersonDeal
	 * @description 
	 * @author 薛玉强
	 * @param lcCont
	 * @return
	 */
	Map<String, Object> findArtificalUWPersonDeal(LCCont lcCont);
	
	/**
	 * 人工核保中保存对个人投保单的审核结论和核保意见
	 * @title saveArtificalUWPersonResultAndIdea
	 * @description 
	 * @author 薛玉强
	 * @param lcCont
	 * @return
	 */
	boolean saveArtificalUWPersonResultAndIdea(LCCont lcCont);
	
	/**
	 * 人工核保中自动核保功能，查找团体投保单核保信息
	 * @title autoUWInfoQuery
	 * @description 
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @param lcCont
	 * @return
	 */
	List<AutoUWGrpInfoVo> autoUWGrpInfoQuery(LCGrpCont lcGrpCont);
	
	/**
	 * @title autoUWPersonInfoQuery
	 * @description 人工核保中自动核保功能，查找个人投保单核保信息
	 * @author 薛玉强
	 * @param autoUWGrpInfoVoList
	 * @return
	 */
	List<AutoUWPersonInfoVo> autoUWPersonInfoQuery(List<AutoUWGrpInfoVo> autoUWGrpInfoVoList);
	
	/**
	 * 人工核保中问题件录入
	 * @title saveIssueFile
	 * @description 
	 * @author 薛玉强
	 * @param lcGrpCont
	 * @return
	 */
	LCIssue saveIssueFile(LCIssue lcIssue,LCGrpCont lcGrpCont);
	
	/**
	 * @title findGrpIssue
	 * @description 团体问题件查询
	 * @author 薛玉强
	 * @param lcIssue
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	List<LCIssue> findGrpIssue(LCIssue lcIssue,int pageNo,int pageSize);
	/**
	 * @title viewContentAndReply
	 * @description 团体问题件内容和回复查询
	 * @param lcIssue
	 * @param pageNo
	 * @param pageSize
	 * @author 薛玉强
	 */
	LCIssue viewContentAndReply(LCIssue lcIssue);
	/**
	 * @title findSearchInfoInput
	 * @description 契调信息录入
	 * @author 薛玉强
	 * @param lcCont
	 * @return
	 */
	Map<String, Object> findSingleSearchInfoInput(LCCont lcCont);
	
	/**
	 * @title saveSingleSearchInfo
	 * @description 保存契调信息
	 * @author 薛玉强
	 * @param lcCont
	 * @param ldPerson
	 * @param lcSingleSearchInfo
	 * @param lcSingleSearchItemList
	 * @return
	 */
	LCSingleSearchInfo saveSingleSearchInfo(LCCont lcCont,LDPerson ldPerson,LCSingleSearchInfo lcSingleSearchInfo,List<LCSingleSearchItem> lcSingleSearchItemList);

	/**
	 * @title findGrpSearchInfoQuery
	 * @description 查询团体契调结论信息（根据团体投保单号查询个人投保单）
	 * @author 薛玉强
	 * @param lcCont
	 * @return
	 */
	Page findGrpSearchInfoQuery(LCGrpCont lcGrpCont,int pageNo,int pageSize);
	
	/**
	 * @title findGrpSearchItemList
	 * @description 查询个人契调项目列表
	 * @author 薛玉强
	 * @param lcCont
	 * @return
	 */
	Page findGrpSearchItemList(LCCont lcCont,int pageNo,int pageSize);
}
