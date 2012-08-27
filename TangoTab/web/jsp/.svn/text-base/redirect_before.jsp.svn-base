<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="/WEB-INF/struts-bean.tld"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% String restid = (String)request.getAttribute("restId"); %>
<% if(restid != null && !restid.equals("0") )
       response.sendRedirect("AdminCreateDeal.do?operation=viewDeals&restid="+restid);
   else
       response.sendRedirect("AdminCreateDeal.do?operation=display"); %>
