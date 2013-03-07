package com.sinosoft.one.monitor.utils;


import org.joda.time.LocalTime;
import org.springframework.util.Assert;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 可用性计算
 * User: cq
 * Date: 13-3-5
 * Time: PM12:36
 */
public class AvailableCalculate {

    private long runningTime;

    private List<AvailableDetail> avCount;

    private int interval;

    private long stopTime;

    private long unknownTime;

    private Long oldRunningTime;

    private Long oldStopTime;

    private List<AvailableDetail> unAvCount;

    //当天时间转换的分钟数
    private long dayMinute;

    private Integer falseCount;

    /**
     * 完全可用性计算，包括未知时间
     * @param startRecordTime 当天有效性开始记录的时间
     * @param oldRunningTime 原有运行时间的记录
     * @param oldStopTime 原有停止时间的记录
     * @param avCount 有效次数
     * @param unAvCount 无效次数
     * @param falseCount 失败次数
     * @param interval 时间间隔，以分钟为单位
     * @return
     */
    public static AvailableCalculate completeCalculate(final Date startRecordTime, final Long oldRunningTime,final Long oldStopTime,
                                                       final List<AvailableDetail> avCount,final List<AvailableDetail> unAvCount,final Integer falseCount, final Integer interval){
        //Assert.notEmpty(unAvCount);
        return new AvailableCalculate(startRecordTime,oldRunningTime,oldStopTime,avCount,unAvCount,falseCount,interval);
    }

    /**
     * 除去未知时间的计算
     * @param startRecordTime 当天有效性开始记录的时间
     * @param oldRunningTime 原有运行时间的记录
     * @param oldStopTime 原有停止时间的记录
     * @param avCount 有效次数
     * @param falseCount 失败次数
     * @param interval 时间间隔，以分钟为单位
     * @return
     */
    public static AvailableCalculate simpleCalculate(final Date startRecordTime, final Long oldRunningTime,final Long oldStopTime,
                                                   final List<AvailableDetail> avCount,final Integer falseCount,final int interval){
        return new AvailableCalculate(startRecordTime,oldRunningTime,oldStopTime,avCount,null,falseCount,interval);
    }

    private AvailableCalculate(final Date startRecordTime, final Long oldRunningTime,final Long oldStopTime,
                              final List<AvailableDetail> avCount,final List<AvailableDetail> unAvCount,final Integer falseCount,final Integer interval) {
//        Assert.notNull(startRecordTime);
//        Assert.notNull(oldRunningTime);
//        Assert.notNull(oldStopTime);
//        Assert.notEmpty(avCount);
//        Assert.notNull(falseCount);
//        Assert.notNull(interval);
        this.interval = interval;
        this.avCount = avCount;
        this.oldRunningTime = oldRunningTime;
        this.oldStopTime  = oldStopTime;
        this.unAvCount = unAvCount;
        this.falseCount = falseCount;
        init();
    }

    private void init(){
        timeCalculate();
        runTimeCalculate();
        stopTimeCalculate();
        unknownTimeCalculate();
    }

    private void unknownTimeCalculate() {
       this.unknownTime =  this.dayMinute - this.runningTime - this.stopTime;
    }


    private void runTimeCalculate(){
        if(runningTime == 0l){
            for(AvailableDetail availableDetail:avCount){
                runningTime = runningTime + availableDetail.getCount()*availableDetail.getInterval();
            }
            //正常运行次数*间隔时间即当天天可用时间
            //runningTime = avCount*interval;
        }
        //Assert.isTrue(runningTime > oldRunningTime, "oldRunningTime is " + oldRunningTime + ",new CalculateRunningTime is " +
        //        this.runningTime + "can't less than old !");
    }

    private void timeCalculate(){
        LocalTime localTime = LocalTime.now();
        this.dayMinute = localTime.getHourOfDay()*60+localTime.getMinuteOfHour();
    }

    private void stopTimeCalculate(){
        if(unAvCount==null){//并不考虑未知的情况，运行时间剩下的时间即为停止时间
           this.stopTime = this.dayMinute - this.runningTime;
        }else{
            for(AvailableDetail availableDetail:unAvCount){
                //失败运行次数*间隔时间即当天停止时间
                this.stopTime = this.stopTime +  availableDetail.getCount()*availableDetail.getInterval();
            }
        }
        //Assert.isTrue(stopTime > oldStopTime, "oldStopTime is " + oldStopTime + ",new CalculateStopTime is " +
        //        this.stopTime + "can't less than old !");
    }

    /**
     * 获取正常运行时间,以分钟为单位
     * @return
     */
    public BigDecimal getAliveTime(){
       if(runningTime == 0l) {
            runTimeCalculate();
        }
       return new BigDecimal(runningTime);
    }

    /**
     * 获取停止时间，以分钟为单位
     * @return
     */
    public BigDecimal getStopTime(){
        return new BigDecimal(this.stopTime);
    }

    public BigDecimal getUnknownTime(){
        return  new BigDecimal(this.unknownTime);
    }

    /**
     * 获取平均故障时间MTBF
     * @return
     */
   public BigDecimal getTimeBetweenFailures(){
      return  new BigDecimal(runningTime/(falseCount+1));
   }

    /**
     * 获取平均修复时间MTTR
     * @return
     */
   public BigDecimal getTimeToRepair(){
       if(this.falseCount == 0){
           return BigDecimal.ZERO;
       }
       return new BigDecimal(stopTime/this.falseCount);
   }

   public static class AvailableDetail{

        private int count;

        private int interval;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getInterval() {
            return interval;
        }

        public void setInterval(int interval) {
            this.interval = interval;
        }
    }

}
