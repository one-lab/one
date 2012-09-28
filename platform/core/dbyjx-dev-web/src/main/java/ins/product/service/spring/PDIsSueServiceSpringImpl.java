package ins.product.service.spring;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


import com.sinosoft.one.mvc.web.Invocation;
import ins.framework.common.Page;
import ins.framework.common.QueryRule;
import ins.framework.dao.GenericDaoHibernate;
import ins.platform.common.DateUtil;
import ins.platform.model.PrpDuser;
import ins.product.model.PDIsSue;
import ins.product.model.PDIsSueId;
import ins.product.service.facade.PDBaseFieldService;
import ins.product.service.facade.PDIsSueService;
import org.springframework.web.multipart.MultipartFile;

public class PDIsSueServiceSpringImpl extends GenericDaoHibernate<PDIsSue,PDIsSueId> implements PDIsSueService {
	private PDBaseFieldService pdBaseFieldService;
	
	public PDBaseFieldService getPdBaseFieldService() {
		return pdBaseFieldService;
	}


	public void setPdBaseFieldService(PDBaseFieldService pdBaseFieldService) {
		this.pdBaseFieldService = pdBaseFieldService;
	}

	
	/**
	 * 通过查询条件查询险种信息--分页
	 * 
	 * @param findRiskRule
	 * @return
	 */
	@Override
	public Page findRiskByCondition(QueryRule findRiskRule, int pageNo,
			int pageSize) {
		Page riskPage = this.find(findRiskRule, pageNo, pageSize);
		return riskPage;
	}
	
	
	/**
	 * 上传附件保存
	 * @param file 文件
	 * @param lcFile文件信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String IssureFileUpload(MultipartFile file, String path,int pageNo, int pageSize) {
		String message="";
		//获取文件名称
		String fileName="";
		int num=1;
		String name0="";
		String name1=".rar";
		fileName="11"+num+name1;
		System.out.println("->>"+path);
		String filePath=path+fileName;
		System.out.println(filePath);
		// 文件保存路径

		try {
			File desFile = new File(filePath);
			desFile.createNewFile();
			System.out.println(path);
			InputStream fis = file.getInputStream();
			FileOutputStream fos = new FileOutputStream(desFile);

			byte[] buffer = new byte[1024];
			int length = 0;
			while ((length = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, length);
			}
			fos.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("ok");
		message="ok";
		return message;
	}
	
	
	/**
	 * @title saveIssue
	 * @description 保存问题件
	 * @param PDIsSue
	 * @return PDIsSue
	 */
	@Override
	public PDIsSue saveIssue(PDIsSue pdIsSue, Invocation invocation) {
		try{
			PrpDuser user = (PrpDuser) invocation.getRequest().getSession().getAttribute("user");
			pdIsSue.setOperator(user.getUserCode());
			pdIsSue.setOperpostman(user.getUserCode());
			pdIsSue.setMakeDate(DateUtil.getDate());
			pdIsSue.setMaketime(DateUtil.getTime());
			pdIsSue.setModifydate(DateUtil.getDate()); 
			pdIsSue.setModifyTime(DateUtil.getTime());
		}catch(Exception e){
			e.printStackTrace();
		}
		this.save(pdIsSue);
		return pdIsSue;
	}
	
	public int countIssue() {
		 int count=0;
		 List<Object> IssueList=new ArrayList<Object>();
		 IssueList=this.findByHql("select count(*) from PDIsSue  ",null);
		 count=Integer.parseInt(String.valueOf(IssueList.get(0)));
		 return count;
	}

	/**
	 * @title deleteIssue
	 * @description  删除一条问题件
	 * @param ID
	 * @return
	 */
	@Override
	public String deleteIssue(PDIsSueId ID) {
		try{			 
			this.deleteByPK(ID);
		}catch(Exception e){
			return e.getMessage();
		}
		return "记录已经删除";
	}
	
	@Override
	public PDIsSue findIssueByID(PDIsSueId ID) {
		PDIsSue issue = this.get(ID);
		return issue;
	} 

}
