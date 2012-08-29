<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>关联账单定义</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link href="${ctx}/common/css/Standard.css" rel="stylesheet" type="text/css" />
	<script src="${ctx}/common/calender/WdatePicker.js"></script>
  </head>
  <body>
    <form name="fm" method="post" onkeypress="KeyDown()">
	<div style = "width:100%">
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td class="left">险种编码：</td>
				<td class="right"><input name="" class="common" type="text"></td>
				<td class="left">给付代码：</td>
				<td class="right"><input name="" class="common" type="text"></td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">已有项目</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="45%">账单项目编码</td>
					<td width="45%">账单项目名称</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>1</td>
					<td>101</td>
					<td>西药费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>2</td>
					<td>102</td>
					<td>中成药费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>3</td>
					<td>103</td>
					<td>门观费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>4</td>
					<td>104</td>
					<td>治疗费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>5</td>
					<td>105</td>
					<td>换药费</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="删除" onclick="">
				</td>
			</tr>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<thead>
				<tr>
					<td class="formtitle" colspan="8"><img src="${ctx}/images/bgformtitle.gif" style="cursor:hand;">责任给付账单项目选项</td>
				</tr>
				<tr class="tableHead" align="center">
					<td width="5%">&nbsp;</td>
					<td width="5%">序号</td>
					<td width="45%">账单项目编码</td>
					<td width="45%">账单项目名称</td>
				</tr>
			</thead>
			<tbody align="center">
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>1</td>
					<td>101</td>
					<td>西药费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>2</td>
					<td>102</td>
					<td>中成药费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>3</td>
					<td>103</td>
					<td>门观费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>4</td>
					<td>104</td>
					<td>治疗费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>5</td>
					<td>105</td>
					<td>换药费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>6</td>
					<td>106</td>
					<td>诊疗费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>7</td>
					<td>107</td>
					<td>检查费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>8</td>
					<td>108</td>
					<td>心电费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>9</td>
					<td>109</td>
					<td>急救费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>10</td>
					<td>110</td>
					<td>B超费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>11</td>
					<td>111</td>
					<td>放射费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>12</td>
					<td>112</td>
					<td>化验费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>13</td>
					<td>113</td>
					<td>手术费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>14</td>
					<td>114</td>
					<td>注射费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>15</td>
					<td>115</td>
					<td>体检费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>16</td>
					<td>116</td>
					<td>卫才费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>17</td>
					<td>117</td>
					<td>氧气费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>18</td>
					<td>118</td>
					<td>其他费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>19</td>
					<td>119</td>
					<td>自负</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>20</td>
					<td>201</td>
					<td>床位费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>21</td>
					<td>202</td>
					<td>西药费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>22</td>
					<td>203</td>
					<td>中成药</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>23</td>
					<td>204</td>
					<td>中草药</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>24</td>
					<td>205</td>
					<td>检查费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>25</td>
					<td>206</td>
					<td>治疗费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>26</td>
					<td>207</td>
					<td>放射费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>27</td>
					<td>208</td>
					<td>手术费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>28</td>
					<td>209</td>
					<td>化验费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>29</td>
					<td>210</td>
					<td>输血费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>30</td>
					<td>211</td>
					<td>输氧费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>31</td>
					<td>212</td>
					<td>护理费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>32</td>
					<td>213</td>
					<td>治疗费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>33</td>
					<td>214</td>
					<td>B超费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>34</td>
					<td>215</td>
					<td>接生费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>35</td>
					<td>216</td>
					<td>婴儿费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>36</td>
					<td>216</td>
					<td>麻醉费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>38</td>
					<td>219</td>
					<td>陪床费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>39</td>
					<td>220</td>
					<td>空调费</td>
				</tr>
				<tr class="content">
					<td><input name="" type="checkbox" value="" /></td>
					<td>40</td>
					<td>221</td>
					<td>其他</td>
				</tr>
			</tbody>
		</table>
		<table id="" class="common" cellpadding="3" cellspacing="0">
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="增加" onclick="">
				</td>
			</tr>
			<tr>
				<td>
					<input type = "button" class="cssbutton" name="Button" value="返回" onclick="javascript:history.back()">
				</td>
			</tr>
		</table>
	</div>
	</form>
  </body>
</html>
