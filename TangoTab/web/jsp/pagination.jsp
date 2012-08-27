<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
<script src="../js/sendmail.js" type="text/javascript" charset="utf-8"></script>
<div id="pagination"> 
  
                        <c:if test="${num gt 1}">
                            page&nbsp; 
                     
                     <a href="javascript:submit(1);" class="blue_low" style="text-decoration:none;">First</a>&nbsp;
                           
                     
                     <c:if test="${num lt 10 and currentPage lt  10}">
                            
                   
                            
                           <c:forEach var="i" begin="1" end="${num}" step="1" varStatus ="status">
                            <c:if test="${currentPage ne i}">
                            <a href="javascript:submit(${i});" class="blue_low" style="text-decoration:none;">${i}</a>&nbsp;
                            </c:if>
                            <c:if test="${currentPage eq i}">
                              <a href="#" class="red_text">${i}</a>&nbsp;
                            </c:if>
                            </c:forEach>
                            </c:if>
                               
                     <c:if test="${ num eq 10 }">
                            
                   
                            
                           <c:forEach var="i" begin="1" end="${num}" step="1" varStatus ="status">
                            <c:if test="${currentPage ne i}">
                            <a href="javascript:submit(${i});" class="blue_low" style="text-decoration:none;">${i}</a>&nbsp;
                            </c:if>
                            <c:if test="${currentPage eq i}">
                              <a href="#" class="red_text">${i}</a>&nbsp;
                            </c:if>
                            </c:forEach>
                            </c:if>
                            <c:if test="${num gt 10 and currentPage lt 10}">
                            
                            <c:set var="num1" value="10" />
                            
                           <c:forEach var="i" begin="1" end="${num1}" step="1" varStatus ="status">
                            <c:if test="${currentPage ne i}">
                            <a href="javascript:submit(${i});" class="blue_low" style="text-decoration:none;">${i}</a>&nbsp;
                            </c:if>
                            <c:if test="${currentPage eq i}">
                              <a href="#" class="red_text">${i}</a>&nbsp;
                            </c:if>
                            </c:forEach>
                            </c:if>
                            
                             <c:if test="${num gt 10 and currentPage gt 9}">
                            
                            <c:set var="num2" value="${currentPage+5}" />
                            <c:if test="${num2 gt num}">
                             <c:set var="num2" value="${num}" />
                            </c:if>
                            
                           <c:forEach var="i" begin="${currentPage-5}" end="${num2}" step="1" varStatus ="status">
                            <c:if test="${currentPage ne i}">
                            <a href="javascript:submit(${i});" class="blue_low" style="text-decoration:none;">${i}</a>&nbsp;
                            </c:if>
                            <c:if test="${currentPage eq i}">
                              <a href="#" class="red_text">${i}</a>&nbsp;
                            </c:if>
                            </c:forEach>
                            </c:if>
                            &nbsp;
                             <a href="javascript:submit(${num});" class="blue_low" style="text-decoration:none;">Last</a>&nbsp;
                           
                       </c:if>
</div>
 