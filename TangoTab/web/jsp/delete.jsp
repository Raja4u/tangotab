<% String signed_request=request.getParameter("signed_request");%>
<% response.sendRedirect("http://184.173.113.66/jsp/Face.do?signed_request="+signed_request);%>