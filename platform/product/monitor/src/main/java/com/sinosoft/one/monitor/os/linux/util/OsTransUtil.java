package com.sinosoft.one.monitor.os.linux.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.sinosoft.one.monitor.os.linux.model.OsCpu;
import com.sinosoft.one.monitor.os.linux.model.OsDisk;
import com.sinosoft.one.monitor.os.linux.model.OsRam;

public class OsTransUtil {
	private static OsCpu osCpu = null;
	private static OsRam osRam = null;
	private static OsDisk osDisk = null;

	public static OsCpu getCpuInfo(String cpuInfo) {
		// 运行队列，阻塞进程，用户时间%，系统时间%，i/o等待%，空闲时间%，中断/秒
		String[] cpuInfos = cpuInfo.split(" ");
		osCpu = new OsCpu();
		osCpu.setRunQueue(cpuInfos[0].trim());
		osCpu.setBlockProcess(cpuInfos[1].trim());
		osCpu.setUserTime(cpuInfos[2].trim());
		osCpu.setSysTime(cpuInfos[3].trim());
		osCpu.setIoWait(cpuInfos[4].trim());
		osCpu.setCpuIdle(cpuInfos[5].trim());
		osCpu.setInterRupt(cpuInfos[6].trim());
		Integer cpuUtilZation = 100 - new Integer(osCpu.getCpuIdle());
		osCpu.setUtiliZation(cpuUtilZation.toString());
		return osCpu;
	}

	public static OsRam getRamInfo(String ramInfo) {
		String MemInfo = ramInfo.substring(ramInfo.indexOf("Mem"),
				ramInfo.indexOf("Swap")).split(":")[1];
		String SwapInfo = ramInfo.substring(ramInfo.indexOf("Swap")).split(":")[1];
		osRam = new OsRam();
		for (String mems : MemInfo.split(",")) {
			String[] mem = mems.trim().split("k");
			if (mem[1].trim().equals("total")) {
				osRam.setMemTotal(mem[0]);
			} else if (mem[1].trim().equals("used")) {
				osRam.setMemUsed(mem[0]);
			}
		}
		System.out.println(countUtilZation("3", "2"));
		osRam.setMemUtiliZation(countUtilZation(osRam.getMemTotal(),
				osRam.getMemUsed()));
		for (String swaps : SwapInfo.split(",")) {
			String[] swap = swaps.trim().split("k");
			if (swap[1].trim().equals("total")) {
				osRam.setSwapTotal(swap[0]);
			} else if (swap[1].trim().equals("used")) {
				osRam.setSwapUsed(swap[0]);
			}
		}
		osRam.setSwapUtiliZation(countUtilZation(osRam.getSwapTotal(),
				osRam.getSwapUsed()));
		return osRam;
	}

	public static List<OsDisk> getDiskInfo(String diskInfo) {
		String[] diskInfos = diskInfo.split(",");
		String[] elements = null;
		List<OsDisk> osDisks = new ArrayList<OsDisk>();
		long totalCount=0;
		long UsedCount=0;
		String totalUtiliZation;
		for (int i = 0; i < diskInfos.length; i++) {
			String line = diskInfos[i];
			elements = line.split("-");
			if (i == 0) {
				continue;
			}
			totalCount+=Long.parseLong(elements[1].trim());
			UsedCount+=Long.parseLong(elements[2].trim());
		}
		totalUtiliZation=countUtilZation(totalCount+"", UsedCount+"");
		for (int i = 0; i < diskInfos.length; i++) {
			String line = diskInfos[i];
			elements = line.split("-");
			if (i == 0) {
				continue;
			}
			osDisk = new OsDisk();
			osDisk.setDiskPath(elements[0].trim());
			osDisk.setTotal(elements[1].trim());
			osDisk.setUsed(elements[2].trim());
			osDisk.setFree(elements[3].trim());
			osDisk.setUsedUtiliZation(elements[4].substring(0,
					elements[4].indexOf("%")).trim());
			Integer freeUtilZation = 100 - new Integer(
					osDisk.getUsedUtiliZation());
			osDisk.setFreeUtiliZation(freeUtilZation.toString());
			osDisk.setMountPoint(elements[5].trim());
			osDisk.setTotalUtiliZation(totalUtiliZation);
			osDisks.add(osDisk);
			
		}
		return osDisks;
	}

	public static String countUtilZation(String total, String used) {
		double tota = new Double(total);
		double use = new Double(used);
		DecimalFormat df = new DecimalFormat("##.00%");
		String utilZation = df.format(use / tota);
		utilZation = utilZation.substring(0, utilZation.indexOf("%"));
		if (utilZation.startsWith(".")) {
			utilZation = "0" + utilZation;
		}
		return utilZation;
	}

	/**
	 * long数字转换成日期
	 * 
	 * @param lang
	 * @return
	 */

	public static String LongToHMS(long lg) {
		long hours = (lg) / (1000 * 60 * 60);
		long minutes = (lg - hours * 60 * 60 * 1000) / (1000 * 60);
		long seconds = (lg - hours * 60 * 60 * 1000 - minutes * 60 * 1000) / (1000l);
		if (seconds >= 60) {
			minutes += seconds / 60;
			seconds = seconds % 60;
		}
		if (minutes >= 60) {
			hours += minutes / 60;
			minutes = minutes % 60;
		}
		if (hours == 0) {
			return minutes + "分" + seconds + "秒";
		}
		if(minutes==0){
			return seconds + "秒";
		}
		return hours + "小时" + minutes + "分" + seconds + "秒";
	}
	public static void main(String[] args) {
		double a = 2.2;
		int b= 2;
		System.out.println(countAve(a, b));
	}
	
	public static String countAve(Object dividend, int divisor) {
		Object ave = null;
		if (dividend.getClass().equals(Double.class)) {
			Double d = (Double) dividend;
			ave = new BigDecimal(d).divide(new BigDecimal(divisor),2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
		}
		if (dividend.getClass().equals(Long.class)) {
			Long d = (Long) dividend;
			ave = new BigDecimal(d).divide(new BigDecimal(divisor), 2,
					BigDecimal.ROUND_HALF_UP).longValue();
		}
		return ave.toString();
	}

}
