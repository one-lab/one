package com.sinosoft.one.monitor.application.domain;

import com.alibaba.fastjson.JSON;
import com.sinosoft.one.monitor.application.model.RequestPerMinute;
import com.sinosoft.one.monitor.application.model.UrlResponseTime;
import com.sinosoft.one.monitor.application.repository.RequestPerMinuteRepository;
import com.sinosoft.one.monitor.application.repository.UrlResponseTimeRepository;
import com.sinosoft.one.monitor.utils.DateUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * URL响应时间代理端消息处理服务类.
 * User: carvin
 * Date: 13-3-4
 * Time: 下午5:06
 * To change this template use File | Settings | File Templates.
 */
@Service
public class UrlResponseTimeAgentMessageService implements AgentMessageService{
	@Autowired
	private UrlResponseTimeRepository urlResponseTimeRepository;
	@Autowired
	private RequestPerMinuteRepository requestPerMinuteRepository;

	/**
	 * 处理代理端URL响应时间消息
	 * @param applicationId 应用系统ID
	 * @param data URL响应时间数据
	 */
	public void handleMessage(String applicationId, String data) {
		List<UrlResponseTime> urlResponseTimes = JSON.parseArray(data, UrlResponseTime.class);

		MinMaxTime minMaxTime = new MinMaxTime();
		Map<String, UrlResponseTime> urlResponseTimeMap = new HashMap<String, UrlResponseTime>();
		Map<String, MinMaxTime> requestPerMinuteMap = new HashMap<String, MinMaxTime>();

		generateDatas(urlResponseTimes, urlResponseTimeMap, requestPerMinuteMap, minMaxTime);

		Date startDate = getConditionDate(minMaxTime.min);
		Date endDate = getConditionDate(minMaxTime.max);
		List<UrlResponseTime> storeUrlResponseTimes = urlResponseTimeRepository.selectUrlResponseTimes(startDate, endDate);

		List<UrlResponseTime> toUpdateUrlResponseTimes = new ArrayList<UrlResponseTime>();
		for(UrlResponseTime storeUrlResponseTime : storeUrlResponseTimes) {
			String key = getUrlResponseTimeKey(storeUrlResponseTime);
			if(urlResponseTimeMap.containsKey(key)) {
				UrlResponseTime targetUrlResponseTime = urlResponseTimeMap.get(key);
				if(storeUrlResponseTime.getMinResponseTime() > targetUrlResponseTime.getMinResponseTime()) {
					storeUrlResponseTime.setMinResponseTime(targetUrlResponseTime.getMinResponseTime());
				}
				if(storeUrlResponseTime.getMaxResponseTime() > targetUrlResponseTime.getMaxResponseTime()) {
					storeUrlResponseTime.setMaxResponseTime(targetUrlResponseTime.getMaxResponseTime());
				}
				storeUrlResponseTime.setAvgResponseTime((storeUrlResponseTime.getAvgResponseTime() + targetUrlResponseTime.getAvgResponseTime())/2);
				toUpdateUrlResponseTimes.add(storeUrlResponseTime);
			}
		}
		urlResponseTimeRepository.save(toUpdateUrlResponseTimes);

		List<RequestPerMinute> storeRequestPerMinutes = requestPerMinuteRepository.selectRequestPerMinutes(startDate, endDate);
		List<RequestPerMinute> toUpdateRequestPerMinutes = new ArrayList<RequestPerMinute>();
		for(RequestPerMinute storeRequestPerMinute : storeRequestPerMinutes) {
			String requestPerMinuteKey = getRequestPerMinuteKey(storeRequestPerMinute.getRecordTime());
			if(requestPerMinuteMap.containsKey(requestPerMinuteKey)) {
				storeRequestPerMinute.setRpm(storeRequestPerMinute.getRpm() + requestPerMinuteMap.get(requestPerMinuteKey).getRpm());
				toUpdateRequestPerMinutes.add(storeRequestPerMinute);
			}
		}
		requestPerMinuteRepository.save(toUpdateRequestPerMinutes);
	}

	/**
	 * 得到条件Date
	 * @param sourceDate
	 * @return
	 */
	private Date getConditionDate(Date sourceDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(sourceDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * 根据响应时间列表生成响应时间Map
	 * @param urlResponseTimes 响应时间List
	 * @param minMaxTime 最小最大时间对象
	 * @return 响应时间Map
	 */
	private void generateDatas(List<UrlResponseTime> urlResponseTimes,
	                          Map<String, UrlResponseTime> urlResponseTimeMap,
	                          Map<String, MinMaxTime> requestPerMinuteMap,
	                          MinMaxTime minMaxTime) {
		UrlResponseTime firstUrlResponseTime = urlResponseTimes.get(0);
		minMaxTime.min = firstUrlResponseTime.getRecordTime();
		minMaxTime.max = firstUrlResponseTime.getRecordTime();
		urlResponseTimeMap.put(getUrlResponseTimeKey(firstUrlResponseTime), firstUrlResponseTime);
		for(int i=1, len=urlResponseTimes.size(); i<len; i++) {
			UrlResponseTime urlResponseTime = urlResponseTimes.get(i);
			String key = getUrlResponseTimeKey(urlResponseTime);
			if(urlResponseTimeMap.containsKey(key)) {
				UrlResponseTime targetUrlResponseTime = urlResponseTimeMap.get(key);
				long responseTime = urlResponseTime.getResponseTime();
				if(targetUrlResponseTime.getMinResponseTime() > responseTime) {
					targetUrlResponseTime.setMinResponseTime(responseTime);
				}
				if(targetUrlResponseTime.getMaxResponseTime() < responseTime) {
					targetUrlResponseTime.setMaxResponseTime(responseTime);
				}
				targetUrlResponseTime.setAvgResponseTime((targetUrlResponseTime.getAvgResponseTime() + responseTime) / 2);
			} else {
				long responseTime = urlResponseTime.getResponseTime();
				urlResponseTime.setMaxResponseTime(responseTime);
				urlResponseTime.setAvgResponseTime(responseTime);
				urlResponseTime.setMinResponseTime(responseTime);
				urlResponseTimeMap.put(key, urlResponseTime);
			}

			String requestPerMinuteKey = getRequestPerMinuteKey(urlResponseTime.getRecordTime());
			Date recordTime = urlResponseTime.getRecordTime();
			if(requestPerMinuteMap.containsKey(requestPerMinuteKey)) {
				MinMaxTime tempMinMaxTime = requestPerMinuteMap.get(requestPerMinuteKey);
				if(tempMinMaxTime.min.compareTo(recordTime) > 0) {
					tempMinMaxTime.min = recordTime;
				}
				if(tempMinMaxTime.max.compareTo(recordTime) < 0) {
					tempMinMaxTime.max = recordTime;
				}
				requestPerMinuteMap.put(requestPerMinuteKey , requestPerMinuteMap.get(requestPerMinuteKey).addRpm(1));
			} else {
				MinMaxTime tempMinMaxTime = new MinMaxTime();
				tempMinMaxTime.min = recordTime;
				tempMinMaxTime.max = recordTime;
				requestPerMinuteMap.put(requestPerMinuteKey , tempMinMaxTime);
			}

			if(minMaxTime.min.compareTo(recordTime) > 0) {
				minMaxTime.min = recordTime;
			}
			if(minMaxTime.max.compareTo(recordTime) < 0) {
				minMaxTime.max = recordTime;
			}
		}
	}

	/**
	 * 得到UrlResponseTimeKey
	 * @param urlResponseTime
	 * @return
	 */
	private String getUrlResponseTimeKey(UrlResponseTime urlResponseTime) {
		return urlResponseTime.getUrl() + "_" + DateFormatUtils.format(urlResponseTime.getRecordTime(), "yyyy-MM-dd HH");
	}

	/**
	 * 得到RequestPerMinuteKey
	 * @param recordTime
	 * @return
	 */
	private String getRequestPerMinuteKey(Date recordTime) {
		return DateFormatUtils.format(recordTime, "yyyy-MM-dd HH");
	}

	/**
	 * 为了获得最大最小时间的类
	 */
	private class MinMaxTime {
		private Date min;
		private Date max;
		private int rpm = 1;

		public MinMaxTime addRpm(int rpm) {
			this.rpm += rpm;
			return this;
		}
		public int getRpm() {
			return BigDecimal.valueOf(rpm).divide(BigDecimal.valueOf(getMinutes())).intValue();
		}
		public long getMinutes() {
			return DateUtil.minus(max, min, Calendar.MINUTE);
		}
	}

	/**
	 * 查询当天的每分钟请求数
	 * @return 当天的每分钟请求数
	 */
	public RequestPerMinute queryCurrentDateRPM() {
		PageRequest pageRequest = new PageRequest(1, 1, new Sort(Sort.Direction.DESC, "recordDate"));
		Page<RequestPerMinute> pagable = requestPerMinuteRepository.findAll(pageRequest);
		return pagable.iterator().next();
	}
}
