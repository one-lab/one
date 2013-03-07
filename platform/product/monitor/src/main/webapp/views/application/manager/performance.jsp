<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>performance性能</title>

    <link href="${ctx}/global/css/base.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/global/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/global/css/performance/performance.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="${ctx}/global/js/jquery-1.7.1.js"></script>
    <script language="javascript" src="${ctx}/global/js/sinosoft.layout.js"></script>
    <script type="text/javascript">
        $(function(){
            $("body").layout({
                top:{topHeight:100}
            });
        });
        function changeRecentHour(obj) {
            location.href = "${ctx}/application/manager/appmanager/applist/" + $(obj).val();
        }
    </script>
</head>

<body>
<%@include file="/WEB-INF/layouts/menu.jsp"%>
<div id="layout_center">
    <div class="main">
        <ul class="crumbs">
            <li><a href="">应用性能</a> ></li>
            <li><b>应用列表</b></li>
        </ul>
        <div class="p_sub_index">
            <table class="p_sub_table">
                <tr>
                    <td class="p_sub_table_right">
                        <p>
                            <span><strong>rpm</strong>=每分钟请求数</span>
                        </p>
                    </td>
                </tr>
            </table>
            <div  class="p_info_div">
                <table class="p_table"  cellspacing="0" cellpadding="0" border="0" align="center">
                    <tr>
                        <td class="p_table_t_l">
                            应用系统名称
                        </td>
                        <td class="p_table_t_r">
                            <div>
                                <select onchange="changeRecentHour(this)">
                                    <option value="1" ${recentHour == 1 ? 'selected="selected"' : ''}>最近一小时</option>
                                    <option value="3" ${recentHour == 3 ? 'selected="selected"' : ''}>最近三小时</option>
                                    <option value="6" ${recentHour == 6 ? 'selected="selected"' : ''}>最近六小时</option>
                                    <option value="12" ${recentHour == 12 ? 'selected="selected"' : ''}>最近十二小时</option>
                                </select>
                            </div>
                            <div>查看:</div>
                        </td>
                    </tr>
                </table>
                <div class="p_info">
                    <table class="p_info_table">
                        <thead class="p_info_table_head">
                        <th>&nbsp;</th>
                        <th class="head_name">实例名称</th>
                        <th class="head_score">应用性能指数评分</th>
                        <th class="head">平均响应时间</th>
                        <th class="head">吞吐量</th>
                        <th class="head">管理</th>
                        </thead>
                    </table>
                    <div class="p_info_body_div">
                        <table>
                            <tbody>
                            <c:forEach items="${applicationIndexViewModels}" var="applicationIndexViewModel">
                                <tr class="p_info_table_body">
                                    <td class="body_name">
                                        <div><a class="p_info_table_td_text"
                                                href="${ctx}/application/manager/appmanager/appinfo/${applicationIndexViewModel.applicationId}">${applicationIndexViewModel.applicationName} </a></div>
                                    </td>
                                    <td class="body_score">
                                        <table>
                                            <tr>
                                                <td style="width:100%">
                                                    <div class="p_info_table_body_bar">
                                                        <div class="green" style="width:${applicationIndexViewModel.greenBarLength}%">&nbsp;</div>
                                                        <div class="yellow" style="width:${applicationIndexViewModel.yellowBarLength}%">&nbsp;</div>
                                                        <div class="red" style="width:${applicationIndexViewModel.redBarLength}">&nbsp;</div>
                                                    </div>

                                                </td>
                                                <td class="percent" style="color:green;">${applicationIndexViewModel.greenBarLength}%</td>
                                                <td class="percent" style="color: #C60">${applicationIndexViewModel.yellowBarLength}%</td>
                                                <td class="percent" style="color:red;">${applicationIndexViewModel.redBarLength}%</td>

                                            </tr>
                                        </table>
                                    </td>
                                    <td class="body"><span>${applicationIndexViewModel.avgResponseTime} 毫秒</span></td>
                                    <td class="body"><span>${applicationIndexViewModel.rpm} rpm</span></td>
                                    <td class="body"><a href="${ctx}/application/manager/bsmanager/list/${applicationIndexViewModel.applicationId}">管理业务场景</a>
                                        &nbsp;<a href="update/${applicationIndexViewModel.applicationId}">编辑</a>
                                        &nbsp;<a href="delete/${applicationIndexViewModel.applicationId}">删除</a>
                                            <%--<a href="javascript:void(0), onclick=delRow(${application.id})">删除</a>--%>
                                    </td>
                                        <%--href="${ctx}/application/manager/bsmanager/bizscenariolist/${application.id}">管理业务场景</a--%>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <table class="p_info_table_bottom">
                        <tr style="width:30%;">
                            <td class="user_info">
                                <div><img src="${ctx}/global/images/performance/legend-green.png"/><span>正常</span>
                                </div>
                                <div><img src="${ctx}/global/images/performance/legend-orange.png"/><span>警告</span>
                                </div>
                                <div><img src="${ctx}/global/images/performance/legend-red.png"/><span>严重</span></div>
                            </td>
                        </tr>
                    </table>
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
