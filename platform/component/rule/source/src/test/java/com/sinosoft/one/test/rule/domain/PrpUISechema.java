package com.sinosoft.one.test.rule.domain;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.drools.definition.type.PropertyReactive;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.springframework.format.datetime.joda.JodaTimeFormatterRegistrar;

@PropertyReactive
public class PrpUISechema {
	private static final long serialVersionUID = 1L;
	// 规则组的字段，用于判断
	private String ruleFlowGroup;
	private int i;
	// 机构代码
	private String comcode;
	// 保单保费
	private BigDecimal sumpreminu;
	// 险类
	private String classcode;
	// 保险期限(月)
	private Integer periodMonth;
	// 险种
	private String riskcode;
	// 最后一期缴费止期时间(最后一期付费时间）
	private String lastPayendate;
	// 业务类型
	private String excepType;
	// 保单止期
	private String enddate;
	// 录单时投保人的客户性质
	private String AppliInsuredNature;
	// 分期缴费第一期的保费
	private BigDecimal firstpremium;
	// 保单分期缴费次数
	private Integer payTimes;
	// 一年平均保费（当前保单保费/当前的保险期间）*365
	private BigDecimal avgpremium;
	// 保单分期缴费最大的间隔时间，以月为单位
	private Integer payIntervalTime;
	// 到签单对象的返回结果及错误提示信息对象
	public ControlMessage overDueBillResult;
	// 分期控制的返回结果及错误提示信息对象
	public ControlMessage payTimesResult;
	// 见费控制的返回结果及错误信息提示对象
	public ControlMessage jFeeResult;
	// 承保倒签单控制（天）
	private Integer undwrtControlDay;
	// 收费倒签单控制（天）
	private Integer chargeControlDay;

	public String getRuleFlowGroup() {
		return ruleFlowGroup;
	}

	public void setRuleFlowGroup(String ruleFlowGroup) {
		this.ruleFlowGroup = ruleFlowGroup;
	}

	public Integer getUndwrtControlDay() {
		return undwrtControlDay;
	}

	public void setUndwrtControlDay(Integer undwrtControlDay) {
		this.undwrtControlDay = undwrtControlDay;
	}

	public Integer getChargeControlDay() {
		return chargeControlDay;
	}

	public void setChargeControlDay(Integer chargeControlDay) {
		this.chargeControlDay = chargeControlDay;
	}

	public ControlMessage getOverDueBillResult() {
		return overDueBillResult;
	}

	public void setOverDueBillResult(ControlMessage overDueBillResult) {
		this.overDueBillResult = overDueBillResult;
	}

	public ControlMessage getPayTimesResult() {
		return payTimesResult;
	}

	public void setPayTimesResult(ControlMessage payTimesResult) {
		this.payTimesResult = payTimesResult;
	}

	public ControlMessage getjFeeResult() {
		return jFeeResult;
	}

	public void setjFeeResult(ControlMessage jFeeResult) {
		this.jFeeResult = jFeeResult;
		System.out.println("返回的结果是"+jFeeResult.isResultFlag());
	}
	
	public String getResult(){		
		System.err.println("走了=="+i++ +" ||"+System.currentTimeMillis());
		if(jFeeResult == null)
			{return "00";}
		System.err.println("流程的结果是:"+jFeeResult.isResultFlag());
		return jFeeResult.isResultFlag()?"01":"00";
		
	}
	
	public String getComcode() {
		return comcode;
	}

	public void setComcode(String comcode) {
		this.comcode = comcode;
	}

	public BigDecimal getSumpreminu() {
		return sumpreminu;
	}

	public void setSumpreminu(BigDecimal sumpreminu) {
		this.sumpreminu = sumpreminu;
	}

	public String getClasscode() {
		return classcode;
	}

	public void setClasscode(String classcode) {
		this.classcode = classcode;
	}

	public Integer getPeriodMonth() {
		return periodMonth;
	}

	public void setPeriodMonth(Integer periodMonth) {
		this.periodMonth = periodMonth;
	}

	public String getRiskcode() {
		return riskcode;
	}

	public void setRiskcode(String riskcode) {
		this.riskcode = riskcode;
	}

	public String getLastPayendate() {
		return lastPayendate;
	}

	public void setLastPayendate(String lastPayendate) {
		this.lastPayendate = lastPayendate;
	}

	public String getExcepType() {
		return excepType;
	}

	public void setExcepType(String excepType) {
		this.excepType = excepType;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getAppliInsuredNature() {
		return AppliInsuredNature;
	}

	public void setAppliInsuredNature(String appliInsuredNature) {
		AppliInsuredNature = appliInsuredNature;
	}

	public BigDecimal getFirstpremium() {
		return firstpremium;
	}

	public void setFirstpremium(BigDecimal firstpremium) {
		this.firstpremium = firstpremium;
	}

	public Integer getPayTimes() {
		return payTimes;
	}

	public void setPayTimes(Integer payTimes) {
		this.payTimes = payTimes;
	}

	public BigDecimal getAvgpremium() {
		return avgpremium;
	}

	public void setAvgpremium(BigDecimal avgpremium) {

		this.avgpremium = new BigDecimal(
				(sumpreminu.doubleValue() / periodMonth) * 365);
	}

	public Integer getPayIntervalTime() {
		return payIntervalTime;
	}

	public void setPayIntervalTime(Integer payIntervalTime) {
		this.payIntervalTime = payIntervalTime;
	}

	// 包含关系的方法定义,一个字段来自domain,一个字段来自决策表。
	public Boolean isContains(String domainParam, String $param) {

		boolean isFlag = false;
		String[] allAtr = $param.split(",");
		for (String StrObj : allAtr) {
			if (domainParam.equals(StrObj)) {
				isFlag = true;
				break;
			}
		}
		System.out.println("包含关系返回值为" + domainParam+","+$param+","+isFlag);
		return isFlag;
	}

	// 不包含关系方法定义
	public Boolean isNotContains(String domain, String $param) {
		boolean flag = true;
		String[] arrStrings = $param.split(",");
		for (String string : arrStrings) {
			if (domain.equals(string)) {
				flag = false;
				break;
			}

		}
		System.out.println("不包含关系的返回值为:"+domain+","+$param+","+flag);
		return flag;
	}

	// 日期全部参数来自决策表里字段的比较，参数都来自决策表。还有一个是是否执行字段判断标志。
	public boolean compareDate(String $param1, String $operatorFlag,
			String $param2, String isExecuteMethod) {
		boolean flag = false;
		if ("Y".equals(isExecuteMethod)) {
			flag = compareDate($operatorFlag, $param1, $param2);
		}
		return flag;
	}

	// domain里的字段和决策表里的字段比较。
	public boolean compareDate(String operatorFlag, String domainParam,
			String $param) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		boolean flag = false;
		try {

			Date param1 = sdf.parse(domainParam);
			Date param2 = sdf.parse($param);
			if (">".equals(operatorFlag)) {
				flag = param1.after(param2);
			} else if ("<".equals(operatorFlag)) {
				flag = param1.before(param2);
			} else if ("=".equals(operatorFlag)) {
				flag = param1.equals(param2);
			} else if (">=".equals(operatorFlag)) {
				flag = param1.after(param2) || param1.equals(param2);
			} else if ("<=".equals(operatorFlag)) {
				flag = param1.before(param2) || param1.equals(param2);
			}
		} catch (ParseException e) {

			throw new RuntimeException("请输入正确的日期格式yyyy-mm-dd", e);
		}

		return flag;
	}

	// 对于数字方法的比较，参数都来自决策表。还有一个是是否执行字段判断标志。
	public boolean compareNumber(BigDecimal $param1, String $operatorFlag,
			BigDecimal $param2, String isExcuteMethod) {
		boolean flag = false;
		if (isExcuteMethod.equals("Y")) {
			flag = compareNumber($param1, $param2, $operatorFlag);
		}
		System.out.println("直接从决策表取值的结果为：" + flag);
		return flag;
	}

	// 对于数字的方法比较定义，一个参数值来自domain，一个参数值来自决策表。
	public Boolean compareNumber(String $operatorFlag, BigDecimal domainParam,
			BigDecimal $param2) {
		boolean flag = false;
		flag = compareNumber(domainParam, $param2, $operatorFlag);
		System.out.println("和domain数字比较的结果为：" + flag);
		System.out.println("和domain数字比较的结果为：" + $operatorFlag+"--"+domainParam+"--"+$param2);
		return flag;
	}

	// 公共方法的比较定义
	public boolean compareNumber(BigDecimal param1, BigDecimal param2,
			String operatorFlag) {
		boolean flag = false;
		if (">".equals(operatorFlag)) {
			flag = param1.compareTo(param2) > 0 ? true : false;
		} else if (">=".equals(operatorFlag)) {
			flag = param1.compareTo(param2) >= 0 ? true : false;
		} else if ("<".equals(operatorFlag)) {
			flag = param1.compareTo(param2) < 0 ? true : false;
		} else if ("<=".equals(operatorFlag)) {
			flag = param1.compareTo(param2) <= 0 ? true : false;
		} else if ("=".equals(operatorFlag)) {
			flag = param1.compareTo(param2) == 0 ? true : false;
		}
		return flag;
	}

	// 保险期限每增加一年，分期缴费次数增加一次的判断
	public boolean calculatePayTimes(int domainpaytimes, int $timesAddPerYear) {
		return domainpaytimes <= $timesAddPerYear * (periodMonth % 12) + 3;
	}

	// 首期保费不得少于总保费的比例判断
	public boolean firstFeeNoLessThanTotal(Double firstFee, Double totalFee,
			Double $param) {
		return firstFee >= (totalFee * $param) / 100;
	}

	// 最后一期付款时间不得晚于保险止期的前几个月
	public boolean lastPayDateNOLessThanEndDate(String lastPayDate,
			String endDate, int $PreMonth) {

        DateTime date1 =DateTime.parse(lastPayDate, DateTimeFormat.forPattern("yyyy-mm-dd"));
        DateTime date2 =DateTime.parse(endDate, DateTimeFormat.forPattern("yyyy-mm-dd"));
		try {
            Interval interval = new Interval(date1,date2);

			return interval.toPeriod().getMonths() < $PreMonth;
		} catch (Exception e) {
			throw new RuntimeException("请输入正确的日期格式:yyyy-mm-dd", e);
		}
	}

	// 计算出两个日期的时间相差的天数
	public int getOverDueDays(String param1, String param2) {
		int intEndHour = 0;
		int intStartHour = 0;
        DateTime date1 =DateTime.parse(param1, DateTimeFormat.forPattern("yyyy-mm-dd"));
        DateTime date2 =DateTime.parse(param2, DateTimeFormat.forPattern("yyyy-mm-dd"));
		//com.sinosoft.utility.string.Date date1 = DateUtils.StringToDate(param1);
		//com.sinosoft.utility.string.Date date2 = DateUtils.StringToDate(param2);
//		if (date1.toUtilDate().after(date2.toUtilDate())) {
//			com.sinosoft.utility.string.Date temp = new com.sinosoft.utility.string.Date();
//			temp = date1;
//			date1 = date2;
//			date2 = temp;
//		}
        Interval interval = new Interval(date1,date2);

		try {
			int days = (int)interval.toDuration().getStandardDays();
			return days;
		} catch (Exception e) {
			throw new RuntimeException("请输入正确的日期格式yyyy-mm-dd", e);
		}
	}
	
//	public boolean compareMonthsByParamAndOperorFlag(String param1, String param2,
//			String operatorFlag, int $month) {
//		boolean flag = false;
//		com.sinosoft.utility.string.Date date1 = DateUtils
//				.StringToDate(param1);
//		com.sinosoft.utility.string.Date date2 = DateUtils
//				.StringToDate(param2);
//		int intStartHour = 0;
//		int intEndHour = 0;
//		int intMonth;
//		if (date1.toUtilDate().after(date2.toUtilDate())) {
//			com.sinosoft.utility.string.Date temp = new com.sinosoft.utility.string.Date();
//			temp = date1;
//			date1 = date2;
//			date2 = temp;
//		}
//		try {
//			intMonth = DateUtils.getMonthMinus(date1, intStartHour, date2,
//					intEndHour);
//			if (">".equals(operatorFlag)) {
//				flag = intMonth - $month > 0 ? true : false;
//			} else if (">=".equals(operatorFlag)) {
//				flag = intMonth - $month >= 0 ? true : false;
//			} else if ("<".equals(operatorFlag)) {
//				flag = intMonth - $month < 0 ? true : false;
//			} else if ("<=".equals(operatorFlag)) {
//				flag = intMonth - $month <= 0 ? true : false;
//			} else if ("=".equals(operatorFlag)) {
//				flag = intMonth - $month == 0 ? true : false;
//			}
//			return flag;
//		} catch (Exception e) {
//			throw new RuntimeException("请输入正确的日期格式:yyyy-mm-dd", e);
//		}
//	}
//	// 根据输入的值灵活处理设置的日期时间数。
//	public boolean comparDateByParamAndOpertor(String param1, String param2,
//			String operatorFlag, int days) {
//		boolean flag = false;
//		if (">".equals(operatorFlag)) {
//			flag = getOverDueDays(param1, param2) - days > 0 ? true : false;
//		} else if (">=".equals(operatorFlag)) {
//			flag = getOverDueDays(param1, param2) - days >= 0 ? true : false;
//		} else if ("<".equals(operatorFlag)) {
//			flag = getOverDueDays(param1, param2) - days < 0 ? true : false;
//		} else if ("<=".equals(operatorFlag)) {
//			flag = getOverDueDays(param1, param2) - days <= 0 ? true : false;
//		} else if ("=".equals(operatorFlag)) {
//			flag = getOverDueDays(param1, param2) - days == 0 ? true : false;
//		}
//		return flag;
//	}
}
