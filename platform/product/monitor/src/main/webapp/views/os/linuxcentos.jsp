<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${ctx}/global/css/base.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.grid.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/bussiness.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.message.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.window.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/global/css/sinosoft.tabs.css" rel="stylesheet" type="text/css" />
<script language="javascript" src="${ctx}/global/js/jquery-1.7.1.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.layout.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.grid.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.message.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.window.js"></script>
<script language="javascript" src="${ctx}/global/js/highcharts.js"></script>
<script language="javascript" src="${ctx}/global/js/exporting.js"></script>
<script language="javascript" src="${ctx}/global/js/highcharts-more.js"></script>
<script language="javascript" src="${ctx}/global/js/sinosoft.tabs.js"></script>
<script language="javascript" src="${ctx}/global/js/os/linuxcentos.js"></script>
</head>

<body>
<div id="layout_top">
  <div class="header">
    <p class="user">您好,系统管理员 <span>|</span> <a href="#">退出系统</a></p>
    <div class="menu_box">
      <ul class="nav" id="nav">
        <li><a href="index.html">首页</a></li>
        <li class="has_sub"> <a href="javascript:viod(0)">监视器</a><span class="show_sub_anv"></span>
          <ul class="add_sub_menu" id="subNav">
            <li class="action"><span class="sever">操作系统</span>
              <ul class="list">
                <li><a href="javascript:viod(0)">操作系统1</a></li>
                <li><a href="javascript:viod(0)">操作系统2</a></li>
              </ul>
            </li>
            <li class="action"><span class="system">应用系统</span>
              <ul class="list">
                <li><a href="javascript:viod(0)">在线投保</a></li>
                <li><a href="javascript:viod(0)">在线查询</a></li>
                <li><a href="javascript:viod(0)">应急处置</a></li>
                <li><a href="javascript:viod(0)">人员角色管理</a></li>
              </ul>
            </li>
            <li class="action" style="border:none "><span>数据库</span>
              <ul class="list">
                <li><a href="javascript:viod(0)">SQL DBA</a></li>
                <li><a href="javascript:viod(0)">SQL SYS</a></li>
              </ul>
            </li>
            <li class="clear"></li>
          </ul>
        </li>
        <li><a href="javascript:viod(0)">应用性能</a></li>
        <li><a href="BusinessSimulation.html">业务仿真</a></li>
        <li><a href="javascript:viod(0)">告警</a></li>
      </ul>
    </div>
    <ul class="add_menu" id="menu">
      <li><a href="javascript:viod(0)">新建监视器</a></li>
      <li><a href="javascript:viod(0)">配置监视器</a></li>
      <li class="has_sub"> <a href="javascript:viod(0)"><span>预警对象管理</span></a>
        <ul class="add_sub_menu">
          <li class="title"><a href="javascript:viod(0)">显示动作</a></li>
          <li class="action">创建新动作</li>
          <li><a class="sms" href="javascript:viod(0)">短信动作</a></li>
          <li><a class="email" href="javascript:viod(0)">邮件动作</a></li>
        </ul>
      </li>
    </ul>
  </div>
</div>
<div id="layout_center">
<div class="main-linux">
      <ul class="crumbs">
      <li><a href="#">管理</a> ></li>
      <li><b>Linux</b></li>
    </ul>
     <hr class="top_border" />
     <div id="tabs">
        	<ul>
            	<li class="tabs_select">概览</li>
                <li>磁盘</li>
            </ul>
  	 <br />
 <div class="first">
  <div class="linux-on" style="width:99%; height:280px">
    <div>
      <table width="50%" cellspacing="0" cellpadding="0" border="0" class="lrtbdarkborder" height="280px">
        <tbody>
          <tr>
            <td colspan="2" class="jsq-message">监视器信息</td>
          </tr>
          <tr>
            <td class="monitorinfoodd">名称 <input id='osid' type="hidden" value="${id}"/></td>
            <td id="monitorName" width="70%" class="monitorinfoeven"></td>
          </tr>
          <tr>
            <td class="monitorinfoodd">系统健康状况</td>
            <td class="monitorinfoeven"><img src="images/bussinessY.gif" />&nbsp;&nbsp;健康状态为正常  .&nbsp;没有出现严重的告警。 </td>
          </tr>
          <tr>
            <td class="monitorinfoodd" >类型 </td>
            <td id="type" class="monitorinfoeven"></td>
          </tr>
          <tr>
            <td class="monitorinfoodd" >主机名</td>
            <td id="osName" class="monitorinfoeven"></td>
          </tr>
          <tr>
            <td class="monitorinfoodd">操作系统 </td>
            <td id="os" class="monitorinfoeven"></td>
          </tr>
          <tr>
            <td class="monitorinfoodd">最后轮询时间</td>
            <td id="lastTime" class="monitorinfoeven"></td>
          </tr>
          <tr>
            <td class="monitorinfoodd">下次轮询时间</td>
            <td id="nextTime" class="monitorinfoeven"></td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="tableheadingbborder" style="width:49%; height:280px">
      <div class="head-cpu">今天的可用性</div>
      <div class="cpu-img"><a class="cpu7-img" href='javascript:void(0)' onclick='viewWindow(this,"historyAvaylable/7")'></a><a class="cpu30-img" href='javascript:void(0)' onclick='viewWindow(this,"historyAvaylable/30")'></a></div>
      <div id="container" style="width: 300px; height: 240px; margin: 0 auto"></div>
      <div class="cpu-text"><b>当前状态&nbsp;&nbsp;<a class="cpu-textimg">&nbsp;</a><a class="bodytext-img" href="setEmergency.html">警告配置</a></b></div>
    </div>
  </div>
  <div class="know-time" style="width:49.5%; height:80px">
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard-time" height="80">
      <tbody>
        <tr>
          <td width="100%" align="center" class="dashboard"><table width="100%" cellspacing="0" cellpadding="0" border="0">
              <tbody>
                <tr>
                  <td width="60%" class="bodytextbold">&nbsp;&nbsp;应答时间&nbsp;&nbsp;<a class="bodytextbold1"></a></td>
                  <td width="30%" align="right"><a class="cpu7-img" href='javascript:void(0)' onclick='viewWindow(this,"historyRespond/7")'></a><a class="cpu30-img" href='javascript:void(0)' onclick='viewWindow(this,"historyRespond/30")'></a></td>
                </tr>
                <tr>
                  <td align="center" class="textResponseTime" colspan="1"> 0 毫秒 </td>
                  <td valign="bottom" align="right"><a class="bodytext-img" href="setEmergency.html">警告配置</a>&nbsp;</td>
                </tr>
              </tbody>
            </table></td>
        </tr>
      </tbody>
    </table>
  </div>
  <div class="linux-midd" style="width:99.1%; height:200px; padding-bottom:10px;" >
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="lrtbdarkborder3">
      <tbody>
        <tr>
          <td height="26" align="center" class="tableheading" >CPU使用率</td>
          <td height="26" align="center" class="tableheading">内存使用率</td>
          <td height="26" align="center" class="tableheading">磁盘利用率</td>
        </tr>
      </tbody>
    </table>
    <table width="99%" cellspacing="0" cellpadding="10" border="0" class="lrbborder">
      <tbody>
        <tr>
          <td width="30%" valign="top" height="180"><table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard">
              <tbody>
                <tr>
                  <td width="100%" align="center" class="dashboard"><table width="99%" cellspacing="0" cellpadding="3" border="0">
                      <tbody >
                        <tr>
                          <td id="cpuUtilzation1" height="28" align="center" title="CPU使用率-3 %" class="bodytext" colspan="1"><a href="#" class="speed"  onclick='viewWindow(this,"historyCPU/7")'><div id="cpuUtilzation" style="width: 200px; height: 140px; margin: 0 auto; "></div></a></td>
                        </tr>
                        <tr>
                          <td  align="center" class="bodytextbold"><a id="cpuUtilzation2" class="staticlinks" onclick='viewWindow(this,"historyCPU/7")' href="javascript:void(0)">CPU使用率 - 3</a> % </td>
                        </tr>
                      </tbody>
                    </table></td>
                </tr>
              </tbody>
            </table></td>
          <td width="30%" height="180"><table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard">
              <tbody>
                <tr>
                  <td width="100%" align="center" class="dashboard"><table cellspacing="0" cellpadding="3" border="0">
                      <tbody>
                        <tr>
                          <td id="ramUtilzation1" height="28" align="center" title="内存使用率-16 %" class="bodytext" colspan="1"><a href="#" class="speed2" onclick='viewWindow(this,"historyMem/7")'><div id="ramUtilzation" style="width: 200px; height: 140px; margin: 0 auto"></div></a></td>
                        </tr>
                        <tr>
                          <td  align="center" class="bodytextbold"><a id="ramUtilzation2" class="staticlinks" onclick='viewWindow(this,"historyMem/7")' href="javascript:void(0)">内存使用率-16</a> % </td>
                        </tr>
                      </tbody>
                    </table>
                    
                    <!--$Id$--></td>
                </tr>
              </tbody>
            </table></td>
          <td width="30%" height="180"><table width="100%" cellspacing="0" cellpadding="0" border="0" class="dashboard">
              <tbody>
                <tr>
                  <td width="100%" align="center" class="dashboard"><table cellspacing="0" cellpadding="3" border="0">
                      <tbody>
                        <tr>
                          <td id="diskUtilzation1" height="28" align="center" title="磁盘利用率-12%" class="bodytext" colspan="1"><a href="#" class="speed3" onclick='viewWindow(this,"historyDisk/7")'><div id="diskUtilzation" style="width: 200px; height:140px; margin: 0 auto"></div></a></td>
                        </tr>
                        <tr>
                          <td  align="center" class="bodytextbold"><a id="diskUtilzation2"  onclick='viewWindow(this,"historyDisk/7")' class="staticlinks"  href="javascript:void(0)">磁盘使用率-12</a> %</td>
                        </tr>
                      </tbody>
                    </table>
                    
                    <!--$Id$-->
              </tbody>
            </table>
      </tbody>
    </table>
  </div>
  <div class="linux-down" style="width:99%; height:500px; float:right">
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="linux-downhead">
      <tbody>
        <tr>
          <td width="100%" height="29" class="tableheadingtrans">&nbsp;CPU及内存使用率 - 最近6小时<a name="Memory Utilization"></a></td>
        </tr>
      </tbody>
    </table>
    <div id="CPU_line" style="height:230px"></div>
    <div class="grid-total">
      <div id="grid_Memory" class="grid-Memory" style="width:50%;"> </div>
      <div class="Memory1" style="width:50%"><a class="Memory" href="setEmergency.html"> 警告配置 </a></div>
      <div id="grid_cpu" class="grid_cpu" style="width:50%;"> </div>
      <div class="cpu1" style="height:20px"><a class="cpu" href="setEmergency.html"> 警告配置 </a></div>
    </div>
  </div>
  <div class="linux-bottom" style="width:99%; float:right; height:650px">
    <table width="100%" cellspacing="0" cellpadding="0" border="0" class="linux-downhead">
      <tbody>
        <tr>
          <td width="100%" height="29" class="tableheadingtrans">&nbsp;分解CPU利用率<a name="Memory Utilization"></a></td>
        </tr>
      </tbody>
    </table>
    <div id="CPU_line2"></div>
    <div class="grid_cpudo" id="grid_cpudo" style="width:70%"> </div>
    <div class="tool_bar2" style="width:70.2%"><a class="gaojin" href="setEmergency.html">告警配置</a></div>
  </div>
</div>
<div class="second">
	 <div class="threshold_file">
            <h2 class="title3">磁盘空间明细</h2>
            <div id="cipan_space_detail" style="width:100%"></div>
          	<div class="tool_bar_top">
              <img  src="${ctx }/global/images/legend-green.png" /><span>空闲%</span>
             <img  src="${ctx }/global/images/legend-red.png" /><span>已用%</span>
            </div>
</div>
</div>
</div>

</div>
</div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
