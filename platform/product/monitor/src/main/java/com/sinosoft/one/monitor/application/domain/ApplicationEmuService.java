package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.application.model.EumUrl;
import com.sinosoft.one.monitor.application.model.EumUrlAva;
import com.sinosoft.one.monitor.application.model.EumUrlAvaSta;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaRepository;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaStaRepository;
import com.sinosoft.one.monitor.application.repository.EumUrlRepository;
import com.sinosoft.one.monitor.common.Trend;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 仿真URL服务对象
 * User: cq
 * Date: 13-3-6
 * Time: AM11:37
 */
@Service
public class ApplicationEmuService {

    @Autowired
    private EumUrlRepository eumUrlRepository;

    @Autowired
    private EumUrlAvaRepository eumUrlAvaRepository;

    @Autowired
    private EumUrlAvaStaRepository eumUrlAvaStaRepository;


    /**
     * 查询当天的仿真URL统计数据，如果没有会默认返回初始化的仿真URL统计数据
     * @param eumUrlId
     * @return
     */
    public EumUrlAvaSta getTodayEumUrlStatistics(String eumUrlId){
        return getEumUrlStatisticsByEnumIdAndDate(eumUrlId,DateTime.now().toDate());
    }

    EumUrlAvaSta getEumUrlStatisticsByEnumIdAndDate(String eumUrlId,Date date){
        List<EumUrlAvaSta> eumUrlAvaStas = eumUrlAvaStaRepository.findByRecordTimeAndEumUrl_Id(date,eumUrlId);
        return eumUrlAvaStas.isEmpty()?newEumUrlAvaSta():eumUrlAvaStas.get(0);
    }


    public EumUrlAva getTodayLatestEumUrlAva(String eumUrlId){
        Assert.hasText(eumUrlId);
        Sort desc = new Sort(Sort.Direction.DESC,"recordTime");
        Pageable pageDesc = new PageRequest(0,1,desc);
        List<EumUrlAva> eumUrlAvas = eumUrlAvaRepository.findByEumUrlId(eumUrlId, pageDesc).getContent();
        if(eumUrlAvas.isEmpty())
            return  null;
        return eumUrlAvas.get(0);
    }

    public EumUrlAva getTodayFirstEumUrlAva(String eumUrlId){
        Sort asc = new Sort("recordTime");
        Pageable pageAsc = new PageRequest(0,1,asc);
        List<EumUrlAva> eumUrlAvas =eumUrlAvaRepository.findByEumUrlId(eumUrlId, pageAsc).getContent();
        if(eumUrlAvas.isEmpty())
            return null;
        return eumUrlAvas.get(0);
    }

    private EumUrlAvaSta newEumUrlAvaSta(){
        EumUrlAvaSta eumUrlAvaSta = new EumUrlAvaSta();
        eumUrlAvaSta.setRecordTime(new Date());
        eumUrlAvaSta.setNormalRuntime(BigDecimal.ZERO);
        eumUrlAvaSta.setTotalFailureTime(BigDecimal.ZERO);
        eumUrlAvaSta.setFailureCount(BigDecimal.ZERO);
        return eumUrlAvaSta;
    }

    public Trend applicationAvaTrend(String applicationId){
        List<EumUrl> eumUrls = eumUrlRepository.findByApplication_Id(applicationId);
        return calTrend(eumUrls);
    }

    public Trend urlAvaTrendByUrlId(String urlId){
        List<EumUrl> eumUrls =  eumUrlRepository.findByUrlId(urlId);
        return calTrend(eumUrls);
    }


    void saveApplicationEnumUrlAvailable(String eumUrlId,boolean result,BigDecimal interval,EumUrlAva eumAvaLast){
        DateTime today = DateTime.now();
        if(eumAvaLast!=null){
            DateTime prevDate = new DateTime(eumAvaLast.getRecordTime());
            if(prevDate.getDayOfYear()<  today.getDayOfYear()){
                eumUrlAvaRepository.deleteAll();
            }
        }
        EumUrlAva eumUrlAva = new EumUrlAva();
        eumUrlAva.setEumUrlId(eumUrlId);
        eumUrlAva.setInterval(interval);
        eumUrlAva.setRecordTime(DateTime.now().toDate());
        eumUrlAva.setState(result?"1":"0");
        eumUrlAvaRepository.save(eumUrlAva);
    }

    List<EumUrl> findEumUrlByApplicationId(String applicationId){
        return  eumUrlRepository.findByApplication_Id(applicationId);
    }



    private Trend calTrend(List<EumUrl> eumUrls ){
        int yesterdayCount=0;
        int todayCount=0;
        Date yesterday = DateTime.now().plusDays(-1).toDate();
        for(EumUrl eumUrl:eumUrls){
            todayCount += getTodayEumUrlStatistics(eumUrl.getId()).getFailureCount().intValue();
            yesterdayCount+= getEumUrlStatisticsByEnumIdAndDate(eumUrl.getId(),yesterday).getFailureCount().intValue();
        }
        if(yesterdayCount<todayCount){
            return Trend.RISE;
        }
        else if(yesterdayCount>todayCount){
            return Trend.DROP;
        }
        else
            return Trend.SAME;
    }



}
