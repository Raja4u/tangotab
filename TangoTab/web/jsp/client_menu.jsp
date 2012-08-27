<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@ taglib uri="/WEB-INF/sslext.tld" prefix="sslext"%>
 
 <c:if test="${userInfo.roleId eq 5 }">
<tr>
  <td align="left" valign="top" width="8"><img src="../images/rednavleft.png" width="8" height="32" /></td>
  <td height="32" align="left" valign="top" width="952" background="../images/r_bot-mid.png">
	  <div id="myslidemenu" class="jqueryslidemenu">
		<ul>
		  <li><a href="#">Deal Management</a>
		      <ul>
		        <li><a href="dealPending.do">Deals Summary</a></li>
		        <li><a href="createDeal.do">Create Deals</a></li>
		        <li><a href="viewDeals.do">View Deals</a></li>
		        
		      </ul>
		  </li>
		  <li><a href="#">Confirmations</a>
		      <ul>
		        <li><a href="viewReservations.do">View Activity</a></li>
		        
		      </ul>
		  </li>
		  <li><a href="#">Account Management</a>
		      <ul>
		      
		        <li><a href="client_edit_profile.jsp">Edit Profile</a></li>
		        <li><a href="reset_password.jsp">Reset Password</a></li>
		        <!--<li><a href="clienteditlocation.jsp">Edit Restaurant</a></li>-->
		    </ul>
		</li>
		<li><a href="#">Billing</a>
		    <ul>
		     <c:if test="${userInfo.restaurent.billingMethodId eq 1 and userInfo.restaurent.isAutoDebit eq 0  }">
		 <!--      <li><a href="configPagedisplay.do?operation=calulate">Charge Account</a></li>	
		  -->	
		          <li><sslext:link forward="clientRecharge">Charge Account</sslext:link>
		          
		           </li>		     
 	 
		      </c:if>
		      <!--  <li><a href="client_advertise.jsp">Purchase Advertisements</a></li>
		     <li><a href="#">Billing Summary</a></li> -->
		    </ul>
		</li>
		<li><a href="#">Reports</a>
		    <ul>
		   <!--    <li><a href="#">Traffic Report</a></li> -->
		       <li><a href="billingSummary.do">Billing Summary</a></li> 
		      <li><a href="viewReservations.do">Activity Report</a></li>
		      <li><a href="dealDeatilSummary.do">Account Summary</a></li>
		      <li><a href="viewClientCredits.do?restid=${userInfo.restaurent.restaurantId}">Host Credit Report</a></li>
		   
		    </ul>
		</li>
		<li><a href="#">Location Management</a>
		    <ul>
		      <li><a href="manageLocations.do">View Locations</a></li>
		      <c:if test="${userInfo.noOfLocations gt userInfo.noOfEnteredLocatios}">
				             <li><a href="createLocation.do">Add Locations</a></li >
				                      	</c:if>
		  
		      </ul>
		  </li>
		  
		  	<c:if test="${not empty profileUsers}">
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
</c:if>

 <c:if test="${userInfo.roleId eq 6}">
 <tr>
        <td align="left" valign="top" width="8"><img src="../images/rednavleft.png" width="8" height="32" /></td>
        <td height="32" align="left" valign="top" width="952" background="../images/r_bot-mid.png"><div id="myslidemenu" class="jqueryslidemenu">
                     <ul>
                        <li><a href="manageLocations.do">Manage Locations</a></li>
                        <li><a href="viewDeals.do">View Deals</a></li>
                        <li><a href="dealPending.do">Deal Summary</a></li>
                        <li><a href="createDeal.do">Create Deal</a></li>
                        <li><a href="viewReservations.do">Deal Activity</a></li>
                                            
                        <li><a href="reset_password.jsp">Reset Password</a>
                           
                        </li>
                        
		  	           <c:if test="${not empty profileUsers}">
		  	            <li><a href="switchProfile.do">Switch Profile</a></li>
		  	           </c:if>
                    </ul>
                   <br style="clear: left" />
                  </div></td>
        <td width="8" align="left" valign="top"><img src="../images/rednavright.png" width="8" height="32" /></td>
      </tr>
 </c:if>