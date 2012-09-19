package ins.product.service.facade;

import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.product.model.PDIsSue;
import ins.product.model.PDIsSueId;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface PDIsSueService {
	
	
	/**
	 * 通过查询条件查询险种信息--分页
	 * @param findRiskRule
	 * @return 
	 */
	Page findRiskByCondition(QueryRule findRiskRule, int pageNo, int pageSize);
	
	
	/**
	 * 上传附件
	 */
	String IssureFileUpload(MultipartFile file,String path,int pageNo,int pageSize);
	
	/**
	 * @title saveCheckField
	 * @description 保存问题件
	 * @param pdlmCheckField
	 * @return
	 */
	PDIsSue saveIssue(PDIsSue pdIsSue, Invocation invocation);
	
	int countIssue();
	
	
	String deleteIssue(PDIsSueId ID);
	
	/**
	 * 通过ID查询问题件
	 * @return PDIsSue
	 */
	PDIsSue findIssueByID(PDIsSueId ID);
}
