<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@page isELIgnored="false" %>

<h1 style="color:red;text-align:center">Result page</h1>

  <c:choose>
      
       <c:when  test="${!empty pDTO ||  pDTO ne null   }">
           <table border="1" align="center">
    	     <tr> 
    	       <td>${pDTO.pid}  </td>
    	       <td>${pDTO.pname}  </td>
    	       <td>${pDTO.price}  </td>
    	       <td>${pDTO.qty}  </td>
    	       <td>${pDTO.category}  </td>
    	     </tr>
    	  </table>             
      </c:when>
       <c:otherwise>
           <h1 style="color:red;text-align:center">Product not found </h1>
      </c:otherwise>
  </c:choose>

 <br><br>
    <a href="search.html">home</a> 




<%-- <%@page isELIgnored="false" %>

<h1 style="color:red;text-align:center">Result page</h1>

 <%
     if(request.getAttribute("pDTO")!=null){  %>
    	  <table border="1" align="center">
    	     <tr> 
    	       <td>${pDTO.pid}  </td>
    	       <td>${pDTO.pname}  </td>
    	       <td>${pDTO.price}  </td>
    	       <td>${pDTO.qty}  </td>
    	       <td>${pDTO.category}  </td>
    	     </tr>
    	  </table>
<%  	 
     } //if
     else{ %>
         <h1 style="color:red;text-align:center"> No Product found </h1>
      <%   }
 %>
  <br><br>
    <a href="search.html">home</a> --%>
 