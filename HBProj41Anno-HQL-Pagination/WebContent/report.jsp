<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>
   <c:when test="${policiesList ne null && !empty policiesList }">
       <table border="1" align="center">
            <tr>
                <th>SerialNo </th>
                <th>PolicyId </th>
                <th>PolicyName </th>
                <th>PolicyType </th>
                <th>Company </th>
                <th>Tenure </th>
            </tr>
            <c:forEach  var="dto"  items="${policiesList}">
                <tr bgcolor="yellow">
                    <td>${dto.serialNo} </td>
                    <td>${dto.policyId} </td>
                    <td>${dto.policyName} </td>
                    <td>${dto.policyType} </td>
                    <td>${dto.company} </td>
                    <td>${dto.tenure} </td>
                </tr>
            </c:forEach>
       </table>
       <center>
         <c:forEach var="i"  begin="1"  end="${pagesCount}"  step="1">
            <b><a href="controller?pageNo=${i}&s1=link">[ ${i} ] </a></b>  &nbsp; &nbsp; 
         </c:forEach>
         </center>
   </c:when>
     <c:otherwise>
         <h1 style="color:red;text-align:center">No records found </h1>
     </c:otherwise>
</c:choose>
 <br>
  <a href="index.html">home</a>