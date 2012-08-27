    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <tr>
	<td colspan="3" align="center" valign="top">
	<!--Client Start-->
	<table width="965" border="0" cellspacing="0" cellpadding="0">
	  <tr>
	    <td><img src="../images/c_lt.png" width="7" height="7" /></td>
	    <td width="949" height="7" background="../images/c_tm.png"></td>
	    <td width="7" height="7" background="../images/c_rt.png"></td>
	  </tr>
	  <tr>
	    <td bgcolor="#7d9b17">&nbsp;</td>
	    <td height="75" align="center" valign="middle" bgcolor="#7d9b17" class="white_max1">Member Profile</td>
	    <td bgcolor="#7d9b17">&nbsp;</td>
	  </tr>
	  <tr>
	    <td width="7" height="7" background="../images/c_lb.png"></td>
	    <td height="7" background="../images/c_bm.png"></td>
	    <td width="7" height="7" background="../images/c_br.png"></td>
	  </tr>
	<tr><td colspan="3" height="5"></td></tr>
	</table>
	<!--Client End-->
	</td>
</tr>    
<tr>
	<td align="left" valign="top" width="8"><img src="../images/rednavleft.png" width="8" height="32" /></td>
	<td height="32" align="left" valign="top" width="949" background="../images/r_bot-mid.png">
		<div id="myslidemenu" class="jqueryslidemenu">
		<ul>
		<li><a href="consumer_edit_profile.jsp">Edit Profile</a></li>
		<li><a href="reset_password.jsp">Reset Password</a></li>
		<li><a href="historyofDeals.do?operation=display">History</a>
		  <!--<ul>
		  <li><a href="historyofDeals.do">History of deals reserved</a></li>
		
		  </ul> -->
		</li>
			<c:if test="${not empty profileUsers}">
		  <!-- 	  <li><a href="post_login.jsp">Switch Profile</a></li> -->
		  	  	  <li><a href="switchProfile.do">Switch Profile</a></li>
		  	</c:if>
		</ul>
		<br style="clear: left" />
		</div>
	</td>
	<td width="8" align="left" valign="top"><img src="../images/rednavright.png" width="8" height="32" /></td>
</tr>
<tr>
	<td height="6" colspan="3" align="left" valign="top"></td>
</tr>