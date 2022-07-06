<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/7/4
  Time: 8:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.js"></script>
    <script>
        function checkId(id) {
            //alert("能进来吗？");
            $.ajax({
                type: "POST",
                url: "${pageContext.request.contextPath}/checkId.do",
                data: "id="+id+"&location=Boston",
                success: function(msg){
                    //alert( "Data Saved: " + msg );
                    var userNameErr =document.getElementById("userNameErr");
                    if(msg==0 ){
                        userNameErr.innerHTML="用户名已经注册不能再注册";
                    }else {
                        userNameErr.innerHTML="可以使用";
                    }
                }
            });
        }
    </script>
</head>
<body>

传入的是：${msg=='2'?'updateDog.do':'addOneDog.do'}
<form action="${pageContext.request.contextPath}/${msg=='2'?'updateDog.do':'addOneDog.do'}" method="post"  >

    <%--inpute中有id--%>

    <%--<input name="id" value="${dog.id}" type="hidden">--%>

    id:<input name="id" value="${dog.id}" onchange="checkId(this.value)">
    <font id="userNameErr"></font>

    价格:<input name="sal" value="${dog.sal}">
    品种：<input  name="breed" value="${dog.breed}">

    <input type="submit" value="提交">

</form>
</body>
</html>
