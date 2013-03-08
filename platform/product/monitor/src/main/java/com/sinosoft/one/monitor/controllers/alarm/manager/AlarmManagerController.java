package com.sinosoft.one.monitor.controllers.alarm.manager;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.application.repository.ApplicationRepository;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zfb
 * Date: 13-3-8
 * Time: 下午3:11
 * To change this template use File | Settings | File Templates.
 */
@Path("alarmmanager")
public class AlarmManagerController {

    @Autowired
    AlarmRepository alarmRepository;
    @Autowired
    ApplicationRepository applicationRepository;

    @Get("list")
    public String getAlarmList(Invocation inv){
        return "alarmList";
    }

    @Post("alarmdata")
    public void getAlarmData(Invocation inv) throws Exception {
        String statusStart="<div class='";
        String statusEnd="' onclick='viewRelevance()'></div>";
        String messageNameStart="<a href='javascript:void(0)' onclick='alarmDetailInfo(this)'>";
        String messageNameEnd="</a>";
        String owerNameStart="<div class='people'>";
        String owerNameEnd="</div>";
        List<Alarm> dbAlarms= (List<Alarm>) alarmRepository.findAll(new Sort(Sort.Direction.DESC,"createTime"));
        if(dbAlarms!=null&&dbAlarms.size()>0){
            List<Alarm> newAlarms=new ArrayList<Alarm>();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for(Alarm alarm:dbAlarms){
                String statusMiddle="";
                Alarm tempAlarm=new Alarm();
                String tempStatusMiddle=getStatusOfAlarm(alarm.getSeverity());
                if(!StringUtils.isBlank(tempStatusMiddle)){
                    //设置状态
                    statusMiddle=tempStatusMiddle;
                }
                //拼接状态字符串
                alarm.setStatus(statusStart+statusMiddle+statusEnd);
                //得到告警标题
                String allMessage=alarm.getMessage();
                if(!StringUtils.isBlank(allMessage)){
                    String[] messageArray=allMessage.split("<br>");
                    alarm.setMessage(messageNameStart+messageArray[0]+messageNameEnd);
                }else {
                    alarm.setMessage(messageNameStart+messageNameEnd);
                }
                //拼接应用中文名
                alarm.setAppName(applicationRepository.findOne(alarm.getMonitorId()).getCnName());
                //获得类型对应的中文名
                alarm.setMonitorType(ResourceType.valueOf(alarm.getMonitorType()).cnName());
                //格式化时间，供页面显示
                alarm.setRecordtime(formatter.format(alarm.getCreateTime()));
                String owerNameMiddle="无";
                if(!StringUtils.isBlank(alarm.getOwnerName())){
                    owerNameMiddle=alarm.getOwnerName();
                }
                //拼接所有者
                alarm.setOwnerName(owerNameStart+owerNameMiddle+owerNameEnd);
                //保存每一个格式化过的Alarm
                newAlarms.add(alarm);
            }
            Page alarmPage=new PageImpl(newAlarms);
            Gridable<Alarm> gridable=new Gridable<Alarm>(alarmPage);
            gridable.setIdField("id");
            gridable.setCellStringField("status,message,appName,monitorType,createTime,ownerName");
            try {
                UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
            } catch (Exception e) {
                throw new Exception("JSON数据转化出错！",e);
            }
        }
    }

    //获得与前台相对应的状态
    public String getStatusOfAlarm(SeverityLevel severityLevel){
        if(severityLevel!=null){
            if(severityLevel.name().equals("CRITICAL")){
                return "poor";
            }else if(severityLevel.name().equals("WARNING")){
                return "y_poor";
            }else if(severityLevel.name().equals("INFO")){
                return "fine";
            }
        }
        return "";
    }

}
