<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>新建监视器</title>
    <%@include file="/WEB-INF/layouts/base.jsp" %>
    <script type="text/javascript">
        $(function () {
            $("body").layout({
                top:{
                    topHeight:100
                },
                bottom:{
                    bottomHeight:30
                }
            });
            $("#myDesk").height($("#layout_center").height());
            $("#nav").delegate('li', 'mouseover mouseout', navHover);
            $("#nav,#menu").delegate('li', 'click', navClick);
        });
        function navHover() {
            $(this).toggleClass("hover")
        }
        function navClick() {
            $(this).addClass("seleck").siblings().removeClass("seleck");
            if ($(this).hasClass('has_sub')) {
                var subMav = $(this).children("ul.add_sub_menu");
                var isAdd = false;
                if ($(this).parent().attr("id") == "menu") {
                    isAdd = true;
                }
                ;
                subMav.slideDown('fast', function () {
                    $(document).bind('click', {
                        dom:subMav,
                        add:isAdd
                    }, hideNav);
                    return false;
                });
            }
            ;
        }
        function hideNav(e) {
            var subMenu = e.data.dom;
            var isAdd = e.data.add;
            subMenu.slideUp('fast', function () {
                if (isAdd) {
                    subMenu.parent().removeClass('seleck');
                }
                ;
            });
            $(document).unbind();
        }
        function save() {
            var flag = false;
            $.ajax({
                type:"Post",
                url:"/monitor/os/isIpExists",
                data:"ipAddr=" + $("#ipAddr").val(),
                success:function (data) {
                    if (data == false) {
                        $("#ipAddr").next().addClass("prompt").html("监视器已存在！");
                    } else {
                        msgSuccess("系统消息", "操作成功，监视器已保存！", function () {
                            $('#addSystem').submit();
                        });
                    }
                }
            });
        }
    </script>
</head>

<body>
<div id="layout_top">
    <div class="header">
        <%@include file="/WEB-INF/layouts/menu.jsp"%>
    </div>
</div>
<div id="layout_center">
    <div class="main">
        <div class="add_monitor">
            <%@include file="/WEB-INF/layouts/selectMonitorType.jsp"%>
            <form id="addSystem" action="${ctx }/os/addApp" method="post"
                  class="form-horizontal">
                <table width="100%" border="0" cellspacing="0" cellpadding="0"
                       class="add_monitor_box add_form">
                    <tr>
                        <td colspan="2" class="group_name">基本信息</td>
                    </tr>
                    <tr>
                        <td width="25%">显示名称<span class="mandatory">*</span></td>
                        <td><input name="os.name" type="text" class="formtext"
                                   value="${os.name }"/></td>
                    </tr>
                    <tr>
                        <td>主机名/IP地址<span class="mandatory">*</span></td>
                        <td><input id="ipAddr" name="os.ipAddr" type="text"
                                   class="formtext" value=""/><span></span></td>
                    </tr>
                    <tr>
                        <td>子网掩码<span class="mandatory">*</span></td>
                        <td><input name="os.subnetMask" type="text" class="formtext"
                                   value="255.255.255.0" size="30"/></td>
                    </tr>
                    <tr>
                        <td>OS类型<span class="mandatory">*</span></td>
                        <td><select name="os.type" class="diySelect" style="width: 100px">
                            <option value="addLinux.html">Linux</option>
                        </select></td>
                    </tr>
                    <tr>
                        <td>端口<span class="mandatory">*</span></td>
                        <td><input name="input2" type="text" class="formtext" size="8"/></td>
                    </tr>
                    <tr>
                        <td>轮询间隔<span class="mandatory">*</span></td>
                        <td><input name="input3" type="text" class="formtext" size="8"/>
                            分
                        </td>
                    </tr>
                    <tr>
                        <td class="group_name">&nbsp;</td>
                        <td class="group_name"><input type="button" class="buttons"
                                                      value="确定添加" onclick="save()"/> <input type="reset"
                                                                                             class="buttons"
                                                                                             value="重 置"/> <input
                                type="button" class="buttons" value="取 消"
                                onclick="window.history.back()"/></td>
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
