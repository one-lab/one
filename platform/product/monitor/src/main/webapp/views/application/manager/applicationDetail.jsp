<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="${ctx}/global/css/base.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/global/css/style.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/global/css/apmservice/apmservice.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/global/css/sinosoft.grid.css" rel="stylesheet" type="text/css" />
    <script language="javascript" src="${ctx}/global/js/jquery-1.7.1.js"></script>
    <script language="javascript" src="${ctx}/global/js/sinosoft.grid.js"></script>
    <script language="javascript" src="${ctx}/global/js/sinosoft.layout.js"></script>
    <script language="javascript" src="${ctx}/global/js/highcharts.src.js"></script>
    <script language="javascript" src="${ctx}/global/js/apmservice/apmservice.js"></script>
    <script type="text/javascript">
        $(function(){
            $("body").layout({
                top:{topHeight:100}
            });
            $("#myDesk").height($("#layout_center").height());
            $("#nav").delegate('li', 'mouseover mouseout', navHover);
            $("#nav,#menu").delegate('li', 'click', navClick);
            // 饼状图1
            $(".show_all_error").live("click",showAllError);
            $(".hide_some_error").live("click",hideSomeError);


            $("#grid_info_table").Grid({
                url : "service.json",
                dataType: "json",
                height: 'auto',
                colums:[
                    {id:'1',text:'url地址',name:"methodName",width:'',index:'1',align:'',color:''},
                    {id:'2',text:'最大响应时间',name:"maxTime",width:'',index:'1',align:'',color:''},
                    {id:'3',text:'最小响应时间',name:"minTime",width:'',index:'1',align:'',color:''},
                    {id:'4',text:'平均响应时间',name:"avgTime",width:'',index:'1',align:'',color:''},
                    {id:'5',text:'健康性',name:"status",width:'',index:'1',align:'',color:''}
                ],
                rowNum:10,
                rowList:[10,20,30],
                pager : true,
                number:false,
                multiselect:true,
            });
        });

        function showAllError(){
            $(this).hide();
            $(this).siblings("p").css("overflow","auto");
            $(".hide_some_error").show();
        }
        function hideSomeError(){
            $(this).hide();
            $(".show_all_error").show();
            $(this).siblings("p").css("overflow","hidden");
        }

    </script>
</head>

<body>

<div id="layout_center">
    <div class="service_all">
        <ul class="crumbs">
            <li><a href="${ctx}/application/manager/appmanager/applist/1">应用性能</a> ></li>
            <li><a href="${ctx}/application/manager/appmanager/applist/1">应用列表</a> ></li>
            <li><b>应用明细</b></li>
        </ul>
        <table cellpadding="0" cellspacing="0" width="100%" >
            <tbody>
            <tr>
                <td class="health" >
                    <table class="health_table">
                        <tbody>
                        <tr class="health_head">
                            <td colspan="2">可用性和当前健康状况</td>

                        </tr>
                        <tr>
                            <td class="health_info">
                                <table  >
                                    <tbody>
                                    <tr>
                                        <td style="width:95px;padding:30px 0 5px 25px;">可用性</td>
                                        <td style="width:95px;padding:30px 0 5px 5px;">健康性</td>

                                    </tr>
                                    <tr>
                                        <td style="width:95px;padding:0 0 0 30px;">
                                            <div class="idown"></div>

                                        </td>
                                        <td  style="width:95px;padding:0 0 0 0px;">
                                            <div class="icannot"></div>
                                        </td>

                                    </tr>
                                    <tr>
                                        <td  style="width:95px;padding:0 0 0 30px;"><strong>下降</strong></td>
                                        <td><strong>评定 2/2</strong></td>

                                    </tr>
                                    </tbody>
                                </table>
                            </td>
                            <td class="health_dec">
                                <table>
                                    <tr>
                                        <td></td>
                                        <td>警报</td>
                                    </tr>
                                    <tr>
                                        <td  style="width:35%">评定</td>
                                        <td><div class="bar">2</div></td>
                                    </tr>
                                    <tr>
                                        <td></td>
                                        <td >共有监控个数 = 2</td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                        <tr class="health_error">
                            <td colspan="2">

                                <lable>Root Cause:</lable>
                                <p>
                                    1. Health of WebRole1_IN_1 is critical.
                                    -- Events Matched With Rule:[Any Application error].

                                    2. Health of WebRole1_IN_0 is critical.
                                    -- Events Matched With Rule:[Any Application error].
                                    3. Health of Novell is critical.

                                    1. Health of WebRole1_IN_1 is critical.
                                    -- Events Matched With Rule:[Any Application error].

                                    2. Health of WebRole1_IN_0 is critical.
                                    -- Events Matched With Rule:[Any Application error].
                                    3. Health of Novell is critical. </p>

                                <div class="show_all_error" style="float:right;cursor:pointer;"><img src="images/spmservice/icon_plus.gif" />显示所有信息</div>
                                <div class="hide_some_error" style="display:none;float:right;cursor:pointer;"><img src="images/spmservice/icon_minus.gif" />隐藏部分信息</div>
                            </td>

                        </tr>
                        </tbody>
                    </table>
                </td>
                <td class="pie_chart">
                    <table class="pie_table">
                        <tr class="pie_head">
                            <td>今天可用性</td>
                            <td>今天健康状态</td>
                        </tr>
                        <tr>
                            <td class="pie"><div style="width: 250px; height:246px; height: 230px\9; margin: 0 auto" id="pie_availability"></div></td>
                            <td class="pie"><div id="pie_health"></div></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>&nbsp;</td>
                        </tr>
                    </table>


                </td>
            </tr>
            </tbody>
        </table>
        <div class="grid_info">
            <div class="threshold_file">

                <div class="tool_bar_top">
                    URL地址信息
                </div>
                <div id="grid_info_table"></div>

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
