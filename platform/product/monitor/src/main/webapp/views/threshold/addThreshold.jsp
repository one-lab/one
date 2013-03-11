<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>创建新的阈值配置文件</title>
    <link href="${ctx}/global/css/base.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/global/css/style.css" rel="stylesheet" type="text/css"/>
    <link href="${ctx}/global/css/sinosoft.message.css" rel="stylesheet" type="text/css"/>
    <script language="javascript" src="${ctx}/global/js/jquery-1.7.1.js"></script>
    <script language="javascript" src="${ctx}/global/js/sinosoft.layout.js"></script>
    <script language="javascript" src="${ctx}/global/js/sinosoft.message.js"></script>

<script type="text/javascript">

function save(){
	msgSuccess("系统消息", "操作成功，监视器已保存！");
}
function rowsTogle(){
	var rows = $("#threshold tr.hideRows");
	if(rows.eq(0).is(':hidden')){
		rows.show();
	}else{
		rows.hide();
	};
	return false;
}
</script>
</head>

<body>
<%@include file="/WEB-INF/layouts/menu.jsp"%>
<div id="layout_center">
	<div class="main">
    	<div class="add_monitor">
       	  <h2 class="title2"><b>创建新的阈值配置文件　</b></h2>
          <form action="${ctx}/threshold/threshold/save" method="post">
          <table width="100%" border="0" cellspacing="0" cellpadding="0" class="add_monitor_box add_form threshold" id="threshold">
              <input type="hidden" name="id" value="${threshold.id }">	
              <tr>
                <td width="20%">阈值名称<span class="mandatory">*</span></td>
                <td colspan="2"><input type="text" class="formtext" size="38" name="name"  value="${ threshold.name}"/></td>
              </tr>
              <tr>
                <td><img src="${ctx}/static/images/icon_critical.gif" alt="严重重要度" class="m_b"/> <b>严重重要度:</b></td>
                <td colspan="2"> 被监控的值是
               	  <select name="criticalThresholdCondition" class="diySelect" style="font-family:Arial, Helvetica, sans-serif;width:60px">
                         <option value="LT"   ${threshold.warningThresholdCondition eq "LT"  ? "selected='selected'" : ''}>&lt;</option>
                         <option value="GT"   ${threshold.warningThresholdCondition eq "GT"  ? "selected='selected'" : ''}>&gt;</option>
                         <option value="EQ"   ${threshold.warningThresholdCondition eq "EQ"  ? "selected='selected'" : ''}>=</option>
                         <option value="NE"  ${threshold.warningThresholdCondition eq "NE"  ? "selected='selected'" : ''}>!=</option>
                         <option value="LE"  ${threshold.warningThresholdCondition eq "LE"  ? "selected='selected'" : ''}>&lt;=</option>
                         <option value="GE"  ${threshold.warningThresholdCondition eq "GE"  ? "selected='selected'" : ''}>&gt;=</option>
                    </select>
                    　			阈值界限
                    <input  type="text" class="formtext"  size="4" name="criticalThresholdValue" value="${ threshold.criticalThresholdValue}"/>
                </td>
              </tr>
              <tr>
                <td><input name="senior" type="checkbox" value="" class="m_b"  onclick="rowsTogle()" id="senior" /> <label for="senior">显示高级选项</label></td>
                <td colspan="2"></td>
              </tr>
              <tr class="hideRows">
                <td>&nbsp;</td>
                <td width="8%" valign="top">信息</td>
                <td><textarea cols="48" class="formtext" style="height:60px" name="criticalThresholdMessage"  >${threshold.criticalThresholdMessage==null?"严重警告信息":threshold.criticalThresholdMessage}</textarea></td>
              </tr>
              <tr class="hideRows">
                <td colspan="3">
                	<hr class="hr" />
                </td>
              </tr>
              <tr class="hideRows">
                <td><img src="${ctx}/static/images/icon_warning.gif" alt="严重重要度" class="m_b"/> <b>警告重要度:</b></td>
                <td>被监控的值是</td>
                <td><select name="warningThresholdCondition" class="diySelect" style="font-family:Arial, Helvetica, sans-serif;width:60px">
                   		  <option value="LT"   ${threshold.warningThresholdCondition eq "LT"  ? "selected='selected'" : ''}>&lt;</option>
		                  <option value="GT"   ${threshold.warningThresholdCondition eq "GT"  ? "selected='selected'" : ''}>&gt;</option>
		                  <option value="EQ"   ${threshold.warningThresholdCondition eq "EQ"  ? "selected='selected'" : ''}>=</option>
		                  <option value="NE"  ${threshold.warningThresholdCondition eq "NE"  ? "selected='selected'" : ''}>!=</option>
		                  <option value="LE"  ${threshold.warningThresholdCondition eq "LE"  ? "selected='selected'" : ''}>&lt;=</option>
		                  <option value="GE"  ${threshold.warningThresholdCondition eq "GE"  ? "selected='selected'" : ''}>&gt;=</option>
                </select>
　				阈值界限
			<input name="warningThresholdValue" type="text" class="formtext" size="4" value="${ threshold.warningThresholdValue}" /></td>
              </tr>
              <tr class="hideRows">
                <td>&nbsp;</td>
                <td width="8%" valign="top">信息</td>
                <td><textarea cols="48" class="formtext" style="height:60px" name="warningThresholdMessage" >${threshold.warningThresholdMessage==null?"警告告警信息":threshold.warningThresholdMessage}</textarea></td>
              </tr>
              <tr class="hideRows">
                <td colspan="3"><hr class="hr" /></td>
              </tr>
              <tr class="hideRows">
                <td><img src="${ctx}/static/images/icon_clear.gif" alt="严重重要度" class="m_b"/> <b>正常重要度:</b></td>
                <td>被监控的值是                  </td>
                <td><select name="infoThresholdCondition" class="diySelect" style="font-family:Arial, Helvetica, sans-serif;width:60px">
                    <option value="LT"   ${threshold.warningThresholdCondition eq "LT"  ? "selected='selected'" : ''}>&lt;</option>
                    <option value="GT"   ${threshold.warningThresholdCondition eq "GT"  ? "selected='selected'" : ''}>&gt;</option>
                    <option value="EQ"   ${threshold.warningThresholdCondition eq "EQ"  ? "selected='selected'" : ''}>=</option>
                    <option value="NE"  ${threshold.warningThresholdCondition eq "NE"  ? "selected='selected'" : ''}>!=</option>
                    <option value="LE"  ${threshold.warningThresholdCondition eq "LE"  ? "selected='selected'" : ''}>&lt;=</option>
                    <option value="GE"  ${threshold.warningThresholdCondition eq "GE"  ? "selected='selected'" : ''}>&gt;=</option>
                </select>
	阈值界限
	<input type="text" class="formtext"  size="4" name="infoThresholdValue"  value="${ threshold.infoThresholdValue}"/></td>
              </tr>
              <tr class="hideRows">
                <td>&nbsp;</td>
                <td valign="top">信息</td>
                <td><textarea name="infoThresholdMessage" cols="48" class="formtext" style="height:60px" >${threshold.infoThresholdMessage==null?"正常告警信息":threshold.infoThresholdMessage}</textarea></td>
              </tr>
              <tr>
                <td class="group_name">&nbsp;</td>
                <td colspan="2" class="group_name">
                	<input type="submit" class="buttons" value="创建阈值配置文件" />　
                    <input type="reset" class="buttons" value="重 置" />　
                    <input type="button" class="buttons" value="取 消" onclick="window.history.back()" />
                </td>
              </tr>
            </table>
            </form>
        </div>
    </div>
</div>
<div id="layout_bottom">
	<p class="footer">Copyright &copy; 2013 Sinosoft Co.,Lt</p>
</div>
</body>
</html>
