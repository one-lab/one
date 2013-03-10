<%@ page language="java" pageEncoding="UTF-8" %>
<div id="layout_top">
    <div class="header">
        <p class="user">您好,系统管理员 <span>|</span> <a href="#">退出系统</a></p>
        <div class="menu_box">
            <ul class="nav" id="nav">
                <li><a href="${ctx }/index">首页</a></li>
                <li class="has_sub">
                    <a href="javascript:viod(0)">监视器</a><span class="show_sub_anv"></span>
                    <ul class="add_sub_menu" id="subNav">
                        <li class="action"><span class="sever">操作系统</span>
                            <ul class="list">
                                <li><a href="systemMonitor.html"> Linux(2)</a></li>
                            </ul>
                        </li>
                        <li class="action"><span class="system">应用系统</span>
                            <ul class="list">
                                <li><a href="performance.html">在线查询</a></li>
                            </ul>
                        </li>
                        <li class="action" style="border:none"><span>数据库</span>
                            <ul class="list">
                                <li><a href="${ctx }/db/oracle/oracleMonitor">oracle</a></li>
                            </ul>
                        </li>
                        <li class="clear"></li>
                    </ul>

                </li>
                <li><a href="performance.html">应用性能</a></li>
                <li><a href="${ctx}/alarm/manager/alarmmanager/list">告警</a></li>
                <li><a href="userManager.html">用户管理</a></li>
            </ul>
        </div>
        <ul class="add_menu" id="menu">
            <li><a href="${ctx}/addmonitor/list">新建监视器</a></li>
            <li class="has_sub">
                <a href="javascript:viod(0)"><span>阈值配置文件</span></a>
                <ul class="add_sub_menu">
                    <li><a class="addThreshold" href="addThreshold.html">新建阈值文件</a></li>
                    <li><a class="thresholdFile" href="thresholdFile.html">查看阈值配置文件</a></li>
                </ul>
            </li>
            <li><a href="deployMonitor.html">配置监视器</a></li>
            <li class="has_sub">
                <a href="javascript:viod(0)"><span>动作</span></a>
                <ul class="add_sub_menu">
                    <li class="title"><a href="showMotion.html">显示动作</a></li>
                    <li class="action">创建新动作</li>
                    <li><a class="sms" href="message.html">短信动作</a></li>
                    <li><a class="email" href="mail.html">邮件动作</a></li>
                </ul>
            </li>
            <li><a href="${ctx}/alarm/manager/configemergency/config">配置告警</a></li>
        </ul>
    </div>
</div>