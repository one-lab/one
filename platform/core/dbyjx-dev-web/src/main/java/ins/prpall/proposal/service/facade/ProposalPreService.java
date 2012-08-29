package ins.prpall.proposal.service.facade;

import java.util.List;

import ins.framework.common.Page;
import ins.framework.common.QueryRule;

import ins.prpall.proposal.model.LCGrpCont;
import ins.prpall.proposal.model.LCGrpServInfo;
import ins.prpall.proposal.model.LCNotepad;
import ins.prpall.report.model.LCReport;
import ins.prpall.report.vo.ReportInfoVo;
import ins.prpall.report.vo.ReportQueryResultVo;
public interface ProposalPreService {
	/**根据投保单号、管理机构、初审日期、投保单位、主营业务员查询投保单信息
	 * @param LCGrpContt
	 * @author 郭占红
	 */
	Page findProsalPreInfo(QueryRule findRiskRule,int pageNo,int pageSize);
	
	/**据客户号查询相关呈报件
	 * @param lcReport
	 * @author 郭占红
	 */
	Page findReportInfo(String appno,int pageNo,int pageSize);
	/**据集体合同号查询投保单
	 * @param grpContNo
	 * @author 郭占红
	 */
	LCGrpCont findProsalPreInfoByGrpContNo(String grpContNo);
	/**根据业务号查看记事本内容 
	 * @param lcNotepad
	 * @author 郭占红
	 */
	Page findNoteInfo(LCNotepad lcNotepad,int pageNo,int pageSize );
	
	/**保存记事本内容
	 * @param lcNotepad
	 * @author 郭占红
	 */
	LCNotepad savaNoteInfo(LCNotepad lcNotepad);
	 /**保存投保单初审信息
  	 * @param  lcGrpCont
  	 * @author 郭占红
  	 */
    public  boolean saveProposalInfo(LCGrpCont lcGrpCont);
     /**根据集体合同号更新投保单初审信息
      * @param  lcGrpCont
  	  * @author 郭占红	
      */
    public boolean updateProposalInfo(LCGrpCont lcGrpCont);
    /**判断投保单号（集体合同号）是否存在
     *  @param  lcGrpCont
 	  * @author 郭占红
     */
    public boolean findProposalInfoByGrpContNo(String grpContNo);
    /**
     * @title saveLcGrpServInfo
     * @description 保存团单服务信息
     * @author 郭占红
     * @param lcGrpServInfo
     * @return
     */
    public  boolean saveLcGrpServInfo(LCGrpServInfo lcGrpServInfo);
    /**
     * @title updateLcGrpServInfo
     * @description 更新团单服务信息
     * @author 郭占红
     * @param lcGrpServInfo
     * @return
     */
    public  boolean updateLcGrpServInfo(LCGrpServInfo lcGrpServInfo);
    /**根据投保单位名称查询客户号
     * @param  ldGrp
     * @author 郭占红
     */
    public String findCustomerNoByGrpName(String customerNo);
    /**
	 * 自动生成集体投保单号
	 * @param lcgrpcont
	 * @author 郭占红
	 */
    public String obtainProposalGrpContNo();
    /**
	 * 初审确认
	 * @param lcgrpcont
	 * @author 郭占红
	 */
    public boolean proposalPreConfirm(LCGrpCont lcGrpCont);
   
}
