package com.sinosoft.one.monitor.controllers.alarm.manager;

import com.sinosoft.one.monitor.alarm.model.Alarm;
import com.sinosoft.one.monitor.alarm.repository.AlarmRepository;
import com.sinosoft.one.monitor.application.repository.ApplicationRepository;
import com.sinosoft.one.monitor.common.ResourceType;
import com.sinosoft.one.monitor.threshold.model.SeverityLevel;
import com.sinosoft.one.mvc.web.Invocation;
import com.sinosoft.one.mvc.web.annotation.Param;
import com.sinosoft.one.mvc.web.annotation.Path;
import com.sinosoft.one.mvc.web.annotation.rest.Get;
import com.sinosoft.one.mvc.web.annotation.rest.Post;
import com.sinosoft.one.mvc.web.instruction.reply.Reply;
import com.sinosoft.one.mvc.web.instruction.reply.Replys;
import com.sinosoft.one.uiutil.Gridable;
import com.sinosoft.one.uiutil.UIType;
import com.sinosoft.one.uiutil.UIUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

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

    //向页面返回json数据
    private void getJsonDataOfAlarms(List<Alarm> alarms,Invocation inv) throws Exception {
        Page alarmPage=new PageImpl(alarms);
        Gridable<Alarm> gridable=new Gridable<Alarm>(alarmPage);
        gridable.setIdField("id");
        gridable.setCellStringField("status,message,appName,monitorType,recordTime");
        try {
            UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
        } catch (Exception e) {
            throw new Exception("JSON数据转化出错！",e);
        }
    }

    //没有选择时间和类型的ajax请求
    @Post("alarm")
    public void getAlarmListWithNoChoice(Invocation inv) throws Exception {
        List<Alarm> allAlarms= (List<Alarm>) alarmRepository.findAllAlarms();
        getAlarmListWithGivenCondition(allAlarms, inv);
    }

    //只选择时间,或者只选择类型的ajax请求
    @Post("onecondition/{givenTimeOrType}")
    public void getAlarmListWithGivenTimeOrType(@Param("givenTimeOrType")String givenTimeOrType,Invocation inv) throws Exception {
        List<Alarm> timeOrTypeAlarms=new ArrayList<Alarm>();
        String givenTime="";
        String givenType="";
        if(!StringUtils.isBlank(givenTimeOrType)){
            if("twentyFourHours".equals(givenTimeOrType)){
                givenTime=String.valueOf(24);
                timeOrTypeAlarms=alarmRepository.findAlarmsWithGivenTime(givenTime);
            }else if("thirtyDays".equals(givenTimeOrType)){
                givenTime=String.valueOf(30);
                timeOrTypeAlarms=alarmRepository.findAlarmsWithGivenTime(givenTime);
            }else if(ResourceType.APPLICATION.name().equals(givenTimeOrType)){
                givenType=ResourceType.APPLICATION.name();
                timeOrTypeAlarms=alarmRepository.findAlarmsWithGivenType(givenType);
            }else if(ResourceType.OS.name().equals(givenTimeOrType)){
                givenType=ResourceType.OS.name();
                timeOrTypeAlarms=alarmRepository.findAlarmsWithGivenType(givenType);
            }else if(ResourceType.DB.name().equals(givenTimeOrType)){
                givenType=ResourceType.DB.name();
                timeOrTypeAlarms=alarmRepository.findAlarmsWithGivenType(givenType);
            }

            getAlarmListWithGivenCondition(timeOrTypeAlarms, inv);
        }else {
            timeOrTypeAlarms= (List<Alarm>) alarmRepository.findAll();
            getAlarmListWithGivenCondition(timeOrTypeAlarms, inv);
        }
    }

    //时间和类型都选择的ajax请求
    @Post("twocondition/{givenTime}/{givenType}")
    public void getAlarmListWithGivenTimeAndType(@Param("givenTime")String givenTime, @Param("givenType") String givenType,Invocation inv) throws Exception {
        if("twentyFourHours".equals(givenTime)){
            givenTime=String.valueOf(24);
        }else if("thirtyDays".equals(givenTime)){
            givenTime=String.valueOf(30);
        }
        if(ResourceType.APPLICATION.name().equals(givenType)){
            givenType=ResourceType.APPLICATION.name();
        }else if(ResourceType.OS.name().equals(givenType)){
            givenType=ResourceType.OS.name();
        }else if(ResourceType.DB.name().equals(givenType)){
            givenType=ResourceType.DB.name();
        }
        List<Alarm> allAlarmsWithGivenTimeAndType=alarmRepository.findAlarmsWithGivenTimeAndType(givenTime,givenType);
        getAlarmListWithGivenCondition(allAlarmsWithGivenTimeAndType,inv);
    }

    //各种条件组个统一调用这个方法，获得告警列表
    private void getAlarmListWithGivenCondition(List<Alarm> dbAlarms,Invocation inv) throws Exception {
        List<Alarm> newAlarms=new ArrayList<Alarm>();
        if(dbAlarms!=null&&dbAlarms.size()>0){
            String statusStart="<div class='";
            String statusEnd="' onclick='viewRelevance()'></div>";
            String messageNameStart="<a href='javascript:void(0)' onclick='alarmDetailInfo(this)'>";
            String messageNameEnd="</a>";
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
                alarm.setRecordTime(formatter.format(alarm.getCreateTime()));
                //暂时不需要显示用户
                /*String owerNameMiddle="无";
                if(!StringUtils.isBlank(alarm.getOwnerName())){
                    owerNameMiddle=alarm.getOwnerName();
                }
                //拼接所有者
                alarm.setOwnerName(owerNameStart+owerNameMiddle+owerNameEnd);*/
                //保存每一个格式化过的Alarm
                newAlarms.add(alarm);
            }
            getJsonDataOfAlarms(newAlarms,inv);
            return;
            /*gridable.setCellStringField("status,message,appName,monitorType,recordTime,ownerName");*/
        }else {
            getJsonDataOfAlarms(newAlarms,inv);
            return;
        }
    }

    //获得与前台页面相对应的状态
    private  String getStatusOfAlarm(SeverityLevel severityLevel){
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
    //获得与前台页面相对应的图片
    private String getImageOfAlarm(SeverityLevel severityLevel){
        if(severityLevel!=null){
            if(severityLevel.name().equals("CRITICAL")){
                return "bussinessY2.gif";
            }else if(severityLevel.name().equals("WARNING")){
                return "bussinessY3.gif";
            }else if(severityLevel.name().equals("INFO")){
                return "bussinessY.gif";
            }
        }
        return "";
    }

    //告警详细信息页面
    @Get("detail/{alarmId}")
    public String getAlarmDetail(@Param("alarmId") String alarmId,Invocation inv){
        Alarm dbAlarm=alarmRepository.findOne(alarmId);
        inv.addModel("alarm",dbAlarm);
        inv.addModel("monitorName",applicationRepository.findOne(dbAlarm.getMonitorId()).getCnName());
        inv.addModel("_cnName",dbAlarm.getSeverity().cnName());
        inv.addModel("alarmImage",getImageOfAlarm(dbAlarm.getSeverity()));
        //用以发送ajax，获得当前监视器的历史告警信息
        inv.addModel("monitorId",dbAlarm.getMonitorId());
        return "alarmDetail";
    }

    //当前监视器的历史告警信息
    @Post("history/{monitorId}")
    public void getHistoryAlarm(@Param("monitorId") String monitorId,Invocation inv) throws Exception {
        List<Alarm> dbAlarms=alarmRepository.findByMonitorId(monitorId);
        if(null!=dbAlarms&&dbAlarms.size()>0){
            String statusStart="<div class='";
            String statusEnd="'></div>";
            String messageStart="<p class=\"magess\">";
            String messageEnd="</p>";
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            List<Alarm> tempAlarms=new ArrayList<Alarm>();
            for(Alarm alarm:dbAlarms){
                //拼接页面显示的状态
                alarm.setStatus(statusStart+getStatusOfAlarm(alarm.getSeverity())+statusEnd);
                alarm.setRecordTime(formatter.format(alarm.getCreateTime()));
                alarm.setMessage(messageStart+alarm.getMessage()+messageEnd);
                tempAlarms.add(alarm);
            }
            Page historyAlarmPage=new PageImpl(tempAlarms);
            Gridable<Alarm> gridable=new Gridable<Alarm>(historyAlarmPage);
            gridable.setIdField("id");
            gridable.setCellStringField("status,recordTime,message");
            try {
                UIUtil.with(gridable).as(UIType.Json).render(inv.getResponse());
            } catch (Exception e) {
                throw new Exception("JSON数据转换出错！",e);
            }
        }
    }

    //批量删除告警详细信息
    @Post("batchdelete")
    public Reply batchDeleteAlarms(Invocation inv){
        String[] alarmIds=inv.getRequest().getParameterValues("alarmIds[]");
        //执行批量删除告警的SQL
        if(null!=alarmIds&&alarmIds.length>0){
            alarmRepository.batchDeleteAlarms(alarmIds);
            return Replys.with("successDeleted");
        }
        return Replys.with("failDeleted");
    }
}
