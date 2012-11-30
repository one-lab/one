package com.sinosoft.one.rms.service.facade;

import java.util.List;

import com.sinosoft.one.rms.model.service.CompanyModelInterface;

/**
 * 如果有自定的机构model 请实现该接口
 * @author Administrator
 *
 */
public abstract interface CompanyServiceInterface {
	
	/**
	 * 查询下级机构 包含当前机构
	 * @param comCode
	 * @return
	 */
	public List<? extends CompanyModelInterface>findComAndNextSubCom(String comCode);
	
	
	 /**
     * 查询下级直属机构获得机构对象
     * @param comCode
     * @return
     */
	public List<? extends CompanyModelInterface>findNextSubCompany(String comCode);
	
	/**
     * 查询下级直属机构获得机构代码
     * @param comCode
     * @return
     */
	public List<String>findNextSubComCodes(String comCode);
	/**
	 * 判断是否有下属机构
	 * @return
	 */
	public boolean isExtSubCom(String comCode);
	
	
	 /**
     *	根据机构代码查询其归属的4级机构
     * @param comCode
     * @return
     */
	public List<? extends CompanyModelInterface> findLevFourCom(String comCode);
    
    /**
     * 根据机构代码查询机构对象
     * @param <T>
     * @param comCode
     * @return
     */
    public <T extends CompanyModelInterface> T findCompanyByComCode(String comCode);
    
    /**
     * 根据机构代码查询所有下级机构的机构代码
     * @param comCode
     * @return
     */
	public List<String>findAllNextSubComCodesByComCode(String comCode);
    
    /**
     * 根据机构代码查询所有下级机构 
     * @param comCode
     * @return
     */
    public List<? extends CompanyModelInterface> findAllNextLevelCompanybyComCode(String comCode);
    
    /**
     * 根据父类机构代码集合查询下级机构获得机构代码
     * @param comCode
     * @return
     */
    public List<String> findComCodebySuperComCode(List<String> comCodes);

    /**
     * 根据父机构代码 ，机构类型查询机构集合
     * @param SuppercomCode
     * @param comType
     * @return
     */
    public List<? extends CompanyModelInterface> findCompanyBySuperAndType(String SuppercomCode,String comType);
    
    /**
     * 根据机构代码集合查询机构
     * @param comCodes
     * @return
     */
    public List<? extends CompanyModelInterface> findCompanysByComcodes(List<String> comCodes);
}
