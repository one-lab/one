package ins.common.util;

public class FinalCollection {
	/**设置页面大小--pageSize*/
	public static final int PAGE_SIZE = 20;
	
	/**added by wangchangming 2012-08-17**/
	/** 新契约保单状态----LCGrpCont表中的State字段控制**/
	public static final String CONT_STATE1 = "01"; //01---初审中
	public static final String CONT_STATE2 = "02"; //02---待保单录入
	public static final String CONT_STATE3 = "03"; //03---保单录入
	public static final String CONT_STATE4 = "04"; //04---待保单复核
	public static final String CONT_STATE5 = "05"; //05---保单复核
	public static final String CONT_STATE6 = "06"; //06---待人工核保
	public static final String CONT_STATE7 = "07"; //07---人工核保
	public static final String CONT_STATE8 = "08"; //08---待签单/待核保订正
	public static final String CONT_STATE9 = "09"; //09---保单失效，或保单效力终止
	public static final String CONT_STATE0 = "00";  //00----已签单,保单生效
	
	/**记事本录入位置---LcNotepad表中的InputLocation字段控制**/
	
	public static final String INPUTLOCATION1 = "01";  //01---投保单初审
	public static final String INPUTLOCATION2 = "02";  //02---无扫描录入
	public static final String INPUTLOCATION3 = "03";  //03---影像录入
	public static final String INPUTLOCATION4 = "04";  //04---投保单复核
	public static final String INPUTLOCATION5 = "05";  //05---人工核保

}
