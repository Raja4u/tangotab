<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<ul class="solidblockmenu">
                      <li><a href="learnmore.jsp" >Why Tango with us</a></li>
                      <li><a href="howdoesitworks.jsp" >How does it work</a></li>
                 <c:if test="${not empty userInfo or not empty profileUsers}">
				             <li><a href="#">Sign up</a></li>
              			<li> <a href="#"  class="blue_medium">Login</a></li>
                        </c:if>
                	<c:if test="${ empty userInfo and  empty profileUsers}">
                      <li><a href="client_registration.jsp">Sign up</a></li>
                      <li><a href="innerlogin.jsp">Login</a></li>
 				   </c:if>

                      <li><a href="contact_us1.jsp">Contact us</a></li>
                    </ul>