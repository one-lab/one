package com.sinosoft.one.monitor.os.linux.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinosoft.one.monitor.os.linux.model.Os;
import com.sinosoft.one.monitor.os.linux.model.OsAvailabletemp;
import com.sinosoft.one.monitor.os.linux.model.viewmodel.OsAvailableViewModel;
@Component
public class OsViewDataHandleService {
	
	@Autowired
	private OsService osService;
	
	@Autowired
	private OsAvailableServcie osAvailableServcie;
	
	int remainder;//图形百分比进位计数 维持最大为100%
	long chufayuliang;//除法余量计算
	int listSize=0;
	/**
	 *获取可用性视图数据 
	 *以0 和1 之间为状态切换 计算停机和未停机时间 
	 */
	public Map<String, Object> getAvailableViewData(Date currentTime ,int interCycle){
		List<Os> oss = osService.getAllOs();
		Map<String, Object> map=new HashMap<String, Object>();
		for (Os os : oss) {
			List<OsAvailabletemp> osAvailabletemps=osAvailableServcie.getFFHourAvailale(os.getOsInfoId(), currentTime);
			if(osAvailabletemps.size()>0){
				long nomorRun=0;//可用时间记录
				long crashtime=0;//不可用时间记录
				long timeDiffer=0;//时间差
				remainder=0;//图形百分比进位计数 维持最大为100%
				Calendar c  = Calendar.getInstance();//获取当前时间的小时数 取整时点
				c.set(Calendar.DATE, currentTime.getDate());
				c.set(Calendar.MINUTE, 0);
				c.set(Calendar.SECOND, 0);
				c.add(Calendar.HOUR_OF_DAY, -24);
				Date lastFFtime = c.getTime();//前24小时的整点
				listSize=osAvailabletemps.size();//数据集合长度
				long timeLength=(currentTime.getTime()-lastFFtime.getTime())/100;//(当前时间到前24小时时间长度 )/1000/100 ：获取这个时间段中 1%的长度
				List<OsAvailableViewModel> osAvailableViewModels=new ArrayList<OsAvailableViewModel>(); //图形传输对象
				OsAvailableViewModel viewModel=null;//需要new的对象外放
				String lastStatus=osAvailabletemps.get(0).getStatus();//上次状态
				Date lastDate=osAvailabletemps.get(0).getSampleDate();
				for (int i = 0; i < listSize; i++) {
					OsAvailabletemp osAvtemp=osAvailabletemps.get(i);
					String thisStatus=osAvtemp.getStatus();//本次状态
					if(i==0){//判断第一条数据的时间与 时间轴起点时间是否大于轮询时间
						timeDiffer=osAvtemp.getSampleDate().getTime()-lastFFtime.getTime();
						if(timeDiffer>(interCycle*1000)){//时间差大于轮询时间则为无数据状态
							viewModel=new OsAvailableViewModel();	//创建第一个图形对象
							viewModel.setIndex(1);
							viewModel.setStatus("0");//2为无数据
							setOsAvailableModelPercentage(timeDiffer, timeLength, viewModel);	//差	值与1%的时间长度做除法
							osAvailableViewModels.add(viewModel);
						}else {
							if(thisStatus.toString().equals("0")){//第一次为0 计入不可用时间
								viewModel=new OsAvailableViewModel();	//创建第一个图形对象
								viewModel.setIndex(1);
								viewModel.setStatus("0");
								crashtime=timeDiffer;//计入不可用时间
							}else{
								viewModel=new OsAvailableViewModel();
								viewModel.setIndex(1);
								viewModel.setStatus("1");
								nomorRun=timeDiffer;//计入可用时间
							}
						}
					}else {
						if(!thisStatus.toString().equals(lastStatus)){//不等于上次状态
							if(thisStatus.toString().equals("0")){//本次是0 上次是1  记为可用
								if(i==listSize-1){//判断是不是最后一次
									nomorRun +=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
									viewModel.setStatus("1");
									setOsAvailableModelPercentage(nomorRun, timeLength, viewModel);
									viewModel.setPercentage(Integer.parseInt(viewModel.getPercentage())+"");//做时间差的除法
									osAvailableViewModels.add(viewModel);  //先吧上次NEW的图形对象保存
								}else {
									nomorRun +=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
									viewModel.setStatus("1");
									setOsAvailableModelPercentage(nomorRun, timeLength, viewModel);
									osAvailableViewModels.add(viewModel);  //先吧上次NEW的图形对象保存
									viewModel=new OsAvailableViewModel();//保存后再创建新的图形对象
									nomorRun=0;//可用时间归零
								}
							}
							if(thisStatus.toString().equals("1")){//本次是1 上次是0 记为不可用
								if(i==listSize-1){
									crashtime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
									setOsAvailableModelPercentage(crashtime, timeLength, viewModel);
									viewModel.setStatus("0");
									viewModel.setPercentage(Integer.parseInt(viewModel.getPercentage())+"");
									osAvailableViewModels.add(viewModel);  //先吧上次NEW的图形对象保存
								}else {
									crashtime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
									setOsAvailableModelPercentage(crashtime, timeLength, viewModel);
									viewModel.setStatus("0");
									osAvailableViewModels.add(viewModel);
									viewModel=new OsAvailableViewModel();//保存后再创建新的图形对象
									crashtime=0;//不可用时间归零
								}
							}
						}else{  //等于上次状态
							if(thisStatus.toString().equals("0")){//本次是0 上次是0  记为不可用
								crashtime+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
									if(i==listSize-1){//判断是否是最后一个
										viewModel.setStatus("0");
										setOsAvailableModelPercentage(crashtime, timeLength, viewModel);
										viewModel.setPercentage(Integer.parseInt(viewModel.getPercentage())+"");
										osAvailableViewModels.add(viewModel);
									} 
							}
							if(thisStatus.toString().equals("1")){//本次是1 上次是1  
								if(osAvtemp.getSampleDate().getTime()-lastDate.getTime()>(interCycle+1)*1000){
									  //如果相隔时间大于轮询时间则为不可用 //则保存上一个为1的对象 创建新的对象
									crashtime=crashtime+(osAvtemp.getSampleDate().getTime()-lastDate.getTime());
									if(i==listSize-1){//判断是否是最后一个
										setOsAvailableModelPercentage(crashtime, timeLength, viewModel);
										viewModel.setPercentage(String.valueOf((Integer.parseInt(viewModel.getPercentage()))));
										viewModel.setStatus("0");
										osAvailableViewModels.add(viewModel);
									}else {
										OsAvailableViewModel osAvailableViewModel=new OsAvailableViewModel();
										setOsAvailableModelPercentage(crashtime, timeLength, osAvailableViewModel);
										osAvailableViewModel.setStatus("0");
										osAvailableViewModels.add(osAvailableViewModel);
										crashtime=0;
										if(nomorRun>0){//2次的差值大于轮询时间 则可用时间可能为0
											setOsAvailableModelPercentage(nomorRun, timeLength, viewModel);
											viewModel.setStatus("1");
											osAvailableViewModels.add(viewModel);
											viewModel=new OsAvailableViewModel();//保存后再创建新的图形对象
											nomorRun=0;//可用时间归零
										} 
									}
								}else{ 
									nomorRun+=osAvtemp.getSampleDate().getTime()-lastDate.getTime();
									if(i==listSize-1){
										setOsAvailableModelPercentage(nomorRun, timeLength, viewModel);
										viewModel.setPercentage(Integer.parseInt(viewModel.getPercentage())+"");
										viewModel.setStatus("1");
										osAvailableViewModels.add(viewModel);
									} 
								}
							}
						}
					}
					lastDate=osAvtemp.getSampleDate();
					thisStatus=osAvtemp.getStatus();
				}
				map.put(os.getOsInfoId(), osAvailableViewModels);
//				int i=0;
//				for (OsAvailableViewModel osAvailableViewModel : osAvailableViewModels) {
//					i+=Integer.parseInt(osAvailableViewModel.getPercentage());
//				}
//				System.out.println(i+"ssss");
			}
		}
		return map;
	}
	//判断和设置图形对象的百分比
	private Integer setOsAvailableModelPercentage(long timeDiffer,long timeLength ,OsAvailableViewModel osAvailableViewModel){
		if(timeDiffer%timeLength>(timeLength/2)){//如果余数大于0则图形对象中的百分比 
			osAvailableViewModel.setPercentage((timeDiffer/timeLength+1)+"");//+1为四舍五入
			remainder=remainder+1;
		}else{
			if(timeDiffer/timeLength<1){
				chufayuliang+=timeLength-timeDiffer;
				if(chufayuliang/timeLength>1&&(chufayuliang%timeLength)<timeLength){
					remainder=remainder+1;
				}
				osAvailableViewModel.setPercentage(1+"");
			}else{
				osAvailableViewModel.setPercentage(timeDiffer/timeLength+"");
			}
		}
		return remainder;
	}
	
}
