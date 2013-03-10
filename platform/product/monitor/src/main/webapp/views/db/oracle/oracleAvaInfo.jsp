<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="my_table">
  <c:forEach items="${oracleAvaInfoList}" var="oracleAvaInfo">
   <tr>
       <td>
           <a href="oracle.html">${oracleAvaInfo.monitorName}</a>
       </td>
       <td>
           <table width="100%" border="0" cellspacing="0" cellpadding="0" class="green_bar">
               <tr>
                   <c:forEach items="${oracleAvaInfo.graphInfo}" var="point">
                    <td width="${point[2]}" class="${point[1]==0?'not_available':(point[1]==2?'xp_available':'')}">&nbsp;</td>
                   </c:forEach>
               </tr>
           </table>
       </td>
       <td>${oracleAvaInfo.avaRate}</td>
   </tr>
   </c:forEach>
  <tr class="last_row">
    <td>&nbsp;</td>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0" class="time_bar">
      <tr>
      	<c:if test="${avaInfoStyle==1 }">
        <td>01:00</td>
        <td>02:00</td>
        <td>03:00</td>
        <td>04:00</td>
        <td>05:00</td>
        <td>06:00</td>
        <td>07:00</td>
        <td>08:00</td>
        <td>09:00</td>
        <td>10:00</td>
        <td>11:00</td>
        <td>12:00</td>
      	</c:if>
      	<c:if test="${avaInfoStyle==30 }"></c:if>
      </tr>
    </table></td>
    <td>&nbsp;</td>
  </tr>
</table>