package com.sinosoft.one.bpm.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.sinosoft.one.bpm.model.ActiveNodeInfo;

public class JbpmAPIUtil {

	private static BpmServiceSupport bpmServiceSupport;
	
	public static String getImageInfoes(String processId, String businessId,
			String imageUrl, String contextPath) {
		if (StringUtils.isBlank(processId)) {
			throw new IllegalArgumentException("the process id is not blank.");
		}
		if (StringUtils.isBlank(businessId)) {
			throw new IllegalArgumentException("the bussiness id is not blank.");
		}

		List<ActiveNodeInfo> activeNodeInfos = bpmServiceSupport.getActiveNodeInfo(processId, businessId);
		String s = "<div style='width:1024px; height:768px; background-color:#ffffff;'>"
				+ "<div id=\"imageContainer\" style=\"position:relative;top:-1;left:-1;\">"
				+ "<img src=\""
				+ imageUrl
				+ "\" style=\"position:absolute;top:0;left:0\" />";
		for (ActiveNodeInfo activeNodeInfo : activeNodeInfos) {

			s += "<div class=\"bpm-graphView-activityImage\" style=\"position:absolute;top:"
					+ (activeNodeInfo.getActiveNode().getY() - 8)
					+ "px;left:"
					+ (activeNodeInfo.getActiveNode().getX() - 8)
					+ "px;width:50px;height:50px; z-index:1000;background-image: url(" + contextPath + "/images/play_red_big.png);background-repeat:no-repeat;\"></div>";
		}
		s += "</div>" + "</div>";
		return s;
	}

	public static List<String> getBusinessIds(String userId) throws Exception {
		return bpmServiceSupport.getBusinessIds(userId);
	}
	public void setBpmServiceSupport(BpmServiceSupport bpmServiceSupport) {
		JbpmAPIUtil.bpmServiceSupport = bpmServiceSupport;
	}
}
