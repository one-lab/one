package com.sinosoft.one.monitor.application.domain;

import com.sinosoft.one.monitor.application.model.EumUrlAva;
import com.sinosoft.one.monitor.application.model.EumUrlAvaSta;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaRepository;
import com.sinosoft.one.monitor.application.repository.EumUrlAvaStaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    private EumUrlAvaRepository eumUrlAvaRepository;

    @Autowired
    private EumUrlAvaStaRepository eumUrlAvaStaRepository;

    /**
     * 查询当天的仿真URL统计数据，如果没有会默认返回初始化的仿真URL统计数据
     * @param eumUrlId
     * @return
     */
    public EumUrlAvaSta getTodayEumUrlStatistics(String eumUrlId){
        List<EumUrlAvaSta> eumUrlAvaStas = eumUrlAvaStaRepository.findByRecordTimeAndEumUrl_Id(new Date(),eumUrlId);
        return eumUrlAvaStas.isEmpty()?newEumUrlAvaSta():eumUrlAvaStas.get(0);
    }

    public EumUrlAva getTodayFirstEumUrlAva(String eumUrlId){
        Sort desc = new Sort(Sort.Direction.DESC,"recordTime");
        Pageable pageDesc = new PageRequest(0,1,desc);
        List<EumUrlAva> eumUrlAvas = eumUrlAvaRepository.findByEumUrl_Id(eumUrlId, pageDesc).getContent();
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
}
