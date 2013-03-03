package com.sinosoft.one.monitor.db.oracle.domain;

import com.sinosoft.one.monitor.db.oracle.model.Info;

import java.util.Date;

/**
 * User: Chunliang.Han
 * Date: 13-3-3
 * Time: 下午10:17
 */
public interface RecordService {
    void insertLastEvent(Info info,Date date);
    void insertEventSta(Info info,Date date);
    void insertAva(Info info,Date date);
    void insertAvaSta(Info info,Date date);
}
