package com.sinosoft.one.monitor.job;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.one.monitor.model.Response;
import com.sinosoft.one.monitor.service.ResponseService;
import com.sinosoft.one.monitor.utils.ResponseUtil;
import com.sinosoft.one.monitoragent.notification.MethodInitConfigure;
import com.sinosoft.one.monitoragent.notification.NotificationService;

/**
 * 资源扫描定时任务
 * 
 * @author gwt
 */
public class ResponseJob {
	@Autowired
	private ResponseService responseService;
	@Autowired
	private NotificationService notificationService;
	private static Logger logger = LoggerFactory.getLogger(ResponseJob.class);

	public void work() throws UnsupportedEncodingException {
//		logger.debug("--------启动定时任务-------");
//		List<MethodInitConfigure> list=notificationService.getMethodInitConfigure();
//		for (MethodInitConfigure methodInitConfigure : list) {
//			logger.debug("---------------"+methodInitConfigure.getMethodName());
//		}
		
		logger.debug("-----------------working-----------------");
		List<Response> responses = responseService.findAllUrls();
		logger.debug("-----------------Responses----list size-------------"+responses.size());
		logger.debug("-----------------开始扫描-----------------");
		for (Response response : responses) {
			Long begin = System.currentTimeMillis();
			response.setStartDate(new Date());
			int responseCode = ResponseUtil.getResponseCode(response.getUrl());
			// int responseCode = 200;
			Long end = System.currentTimeMillis();
			response.setEndDate(new Date());
			if (responseCode != 200) {
				logger.debug("---请求地址没有正常返回,短信通知---请求地址:"+response.getUrl());
			} else {
				Long consumeTime = end - begin;
				logger.debug("---一切正常,共花费:"+consumeTime+"毫秒,请求地址为:"+response.getUrl()+"---");
				int requestCount = 0;
				int threshhold = 0;
				int overCount = 0;
				int highestValue = 0;
				int averageValue = 0;
				if (response.getRequestCount() != null) {
					requestCount = Integer.parseInt(response.getRequestCount());
				}
				if (response.getThreshold() != null) {
					threshhold = Integer.parseInt(response.getThreshold());
				}
				if (response.getOverCount() != null) {
					overCount = Integer.parseInt(response.getOverCount());
				}
				if (response.getHighestValue() != null) {
					highestValue = Integer.parseInt(response.getHighestValue());
				}
				if (response.getAverageValue() != null) {
					averageValue = Integer.parseInt(response.getAverageValue());
				}
				if (consumeTime > threshhold) {
					logger.debug("---网页响应速度超过阀值,短信通知,请求地址:"+response.getUrl()+",阀值:"+threshhold+",消耗时间为:"+consumeTime+"---");
					// response 测试响应模块的代码是03
					// sms.setReceiver(telService.findTels("03"));
					//
					// geMonitorSmsLog.setAppName("monitor");
					// geMonitorSmsLog.setSendReason("网页响应速度超过阀值,--阀值为:"
					// + threshhold + "   消耗时间为:" + consumeTime);
					// geMonitorSmsLog.setSmsContent("网页响应速度超过阀值");
					// // 调用monitor短信通知服务
					// notificationService
					// .notification(sms, null, geMonitorSmsLog);
					// ResponseJob.dbLogger.info("网址" +
					// geMonitorResponse.getUrl()
					// + "响应速度超过阀值--阀值为:" + threshhold + "   消耗时间为:"
					// + consumeTime + ",已经短信通知");
					//TODO:这里要入库
				}
				// 上次计算结果无效
				if ("0".equals(response.getIsValid())) {
					response.setRequestCount("1");
					response.setHighestValue(consumeTime.toString());
					response.setAverageValue(consumeTime.toString());
					if (consumeTime > threshhold) {
						response.setOverCount("1");
					} else {
						response.setOverCount("0");
					}
					// 使本次计算结果在下次可用
					response.setIsValid("1");
				}
				// 上次计算结果有效
				else if ("1".equals(response.getIsValid())) {
					response.setRequestCount(new Integer(requestCount + 1).toString());
					if (consumeTime > threshhold) {
						response.setOverCount(new Integer(overCount + 1).toString());
					}
					if (consumeTime > highestValue) {
						response.setHighestValue(consumeTime.toString());
					}
					int averageValue_new = (int) ((averageValue * requestCount + consumeTime) / (requestCount + 1));
					response.setAverageValue(new Integer(averageValue_new).toString());
				} else {
					response.setIsValid("1");
				}
				responseService.updateResponse(response);
				logger.debug("------一次 url请求完毕------");
			}
		}
		logger.debug("-----一次job调度完毕--------");
	
	}

	public ResponseService getResponseService() {
		return responseService;
	}

	@Autowired
	public void setResponseService(ResponseService responseService) {
		this.responseService = responseService;
	}

}
