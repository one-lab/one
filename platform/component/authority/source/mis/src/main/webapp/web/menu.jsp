<%@ page language="java" contentType="text/html;charset=utf-8" import="java.util.Map;import com.sinosoft.ebusiness.rms.model.Employe;"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>中华联合电子商务 </title>
<%@include file="/common/taglibs.jsp" %>
<link href="${ctx}/css/menu.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/standard.css" rel="stylesheet" type="text/css"/>
<link href="${ctx}/css/file.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" language="script" src="${ctx}/js/jquery-1.6.4.js"></script>
<script type="text/javascript" language="script" src="${ctx}/js/employee2.js"></script>
<script language="javascript">
			var openID = "";  //处于展开状态的菜单ID
			var firstLength = 3;   //一级子菜单的长度
			var subLength = 3;    //两级菜单的长度差

      var off_img = "${ctx}/images/collapse.gif";//缩进时图片
      var on_img =  "${ctx}/images/expand.gif";//展开时图片
      
	function tdclick(urlname){
			
					form1.action = urlname;
				    form1.target = "main";
                    
					//去掉所有没选中的tr为
					var rows=document.getElementsByTagName("tr");
					for(var i=0;i<rows.length;i++){
                           rows[i].className="";
					}
					 //设置选中的tr
					event.srcElement.parentNode.className="red"; 
				form1.submit();
			}

			function tree(ctlID)   //点击菜单时菜单的伸缩
			{
				var isOpen = -1;   //该菜单下的所有菜单是展开还是缩进 0为缩进,1为展开
				var obj;
				var le=document.getElementsByTagName("*").length;
				for(var i=0;i<le;i++)
				{
				  	obj = document.getElementsByTagName("*").item(i);
					if(obj.id.length > firstLength){
						if(obj.id.substring(0,ctlID.length) == ctlID
									&& obj.id.length == (ctlID.length + subLength) ){
									  							
								if(obj.style.display == "none"){
									obj.style.display = "";
								}else{
									obj.style.display = "none";
								}						
						}else{ //所有下级菜单都缩进
							obj.style.display = "none";
							changeImage(obj,off_img);
						}
					}
				}
			}

			function tree1(ctlID)   //二级子菜单
			{
				var isOpen = -1;   //该菜单下的所有菜单是展开还是缩进 0为缩进,1为展开
				var obj;
        
				for(var i=0;i<document.getElementsByTagName("*").length;i++)
				{
				  obj = document.getElementsByTagName("*").item(i);
					if(obj.id.length > firstLength)
					{
						if(obj.id.substring(0,ctlID.length) == ctlID
									&& obj.id.length > ctlID.length ){
									  							
								if(obj.style.display == "none"){
								  
									obj.style.display = "";
									changeImage(document.getElementById(ctlID),on_img);
									
								}else{
								  
									obj.style.display = "none";
									changeImage(document.getElementById(ctlID),off_img);
									
								}
							
						}else if(obj.id.substring(0,ctlID.length) != ctlID){//所有同级菜单都收缩
						    if (obj.id.length == ctlID.length){
						      						      
						        changeImage(obj,off_img);
						        
						    }else if(obj.id.length > ctlID.length ){
									  
							      obj.style.display = "none";
							
						    }
						}
					}
				}
				
			}

			function iniTtree()
			{
				var thisID = "";
				for(var i=0;i<document.getElementsByTagName("*").length;i++)
				{
					if(document.getElementsByTagName("*").item(i).id.length>0)
					{
						if(thisID == "")
							thisID = document.getElementsByTagName("*").item(i).id;
						if(document.getElementsByTagName("*").item(i).id.length > thisID.length)
							document.getElementsByTagName("*").item(i).style.display = "none";
					}
				}
				tree(thisID);
			}
			
			//把oTr里的图片换成sImg
			function changeImage(oTr,sImg){
			  //var oTr = event.srcElement.parentElement;
			  if (oTr.tagName != "TR") return(false);
			  
			  var aObj = oTr.getElementsByTagName("IMG");
			  for(var i = 0; i < aObj.length; i++){
			    if(aObj[i].src != null 
			        && (aObj[i].src.indexOf(on_img.substring(on_img.indexOf("/"),on_img.length - 1)) != -1 
			        || aObj[i].src.indexOf(off_img.substring(off_img.indexOf("/"),off_img.length - 1)) != -1 )){
			      aObj[i].src = sImg; 
			    }
			  }
			}
			
			//选中的颜色
		function  selectThis(obj){
	
}

</script>
</head>

<body>
  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  	
  		<tr>
          <td> 
            <c:forEach var="parenttask" items="${sessionScope.loginInfo.ls}" varStatus="status">
          		<tr>
            	<td>
            <table width="100%" border="0" cellspacing="0" cellpadding="0"> 
                  <tr id="10${status.count }" style="CURSOR: hand" onclick="javascript:tree('10${status.count }');" class="menunav" onMouseOver="this.className='menunavover'" onMouseOut="this.className='menunav'">
                   	<td height="26" align="left"><input id="sessionid" value="${sessionScope.loginInfo.employe.userCode}" type="hidden"/> <img src="${ctx}/images/img_arrow01.gif"   height="9"><a target="main" class="kind1">${parenttask.name} </a></td>
                  </tr>
              	<c:forEach var="childtask" items="${parenttask.children }" varStatus="child_status">
                <tr id="10${status.count }00${child_status.count }">
                  <td height="26">
                  	<table width="100%" border="0" cellspacing="0" cellpadding="0">
                  		<tr id="10${status.count }00${child_status.count }" style="CURSOR: hand" onclick="javascript:tree1('10${status.count }00${child_status.count }');" >
                      		 	<td height="26" class="size1"> 
                      		 		<c:if test="${childtask.menuURL!=null}">
                      		 			<a href="${childtask.menuURL}" target="main" class="kind2">${childtask.name}</a>
                      		 		</c:if>
                      		 		<c:if test="${childtask.menuURL==null}">
                      		 			<a href="#"  class="kind2">${childtask.name}</a>
                      		 		</c:if>
                      		 	</td>
                    	</tr>
                  		 <c:forEach var="subsontask" items="${childtask.children }" varStatus="subson_status">
                    		 <tr id="10${status.count }00${child_status.count }00${subson_status.count }">
                      			<td height="26">
                      				<table width="100%" border="0" cellspacing="0" cellpadding="0">
                    					<tr>
                     						 <td height="26" class="size2"><a href="${subsontask.menuURL }"   target="main" class="kind3">${subsontask.name }</a></td>
                   						</tr>
               					</table> 
                     			</td>
                    		</tr>
                 	 	</c:forEach>
                  	</table>
                  </td>
                </tr>
               </c:forEach>
            </table>
            </td>
         </tr>
         </c:forEach>
         </td>
      </tr>
  </table>
</body>
</html>
