<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>MorningCode: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>MorningCode: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for MorningCode: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllTableType.jsp'>List</a> all TableTypes.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="tabletype.do" >
        <b>輸入桌型編號 (如1):</b>
        <input type="text" name="tableId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="tableSvc" scope="page" class="com.tabletype.model.TableTypeService" />
   
  <li>
     <FORM METHOD="post" ACTION="tabletype.do" >
       <b>選擇桌型人數:</b>
       <select size="1" name="tableId">
         <c:forEach var="tableTypeVO" items="${tableSvc.all}" > 
          <option value="${tableTypeVO.tableId}">${tableTypeVO.tableId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="emp.do" >
       <b>選擇桌子人數:</b>
       <select size="1" name="empno">
         <c:forEach var="tabkeTypeVO" items="${tableSvc.all}" > 
          <option value="${tableVO.empno}">${tabltypeVO.tableType}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addEmp.jsp'>Add</a> a new Emp.</li>
</ul>

</body>
</html>