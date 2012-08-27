  <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <script>
		!window.jQuery && document.write('<script src="../js/jquery-1.4.3.min.js"><\/script>');
	</script>
	<script type="text/javascript">

	var loc=window.location;
 	<%request.setAttribute("source",TangoTabUtility.getTangoTabResourceBundle().getString(TangotabConstants.TANGO_TAB_WEB_SITE_HOME));
 	  %>
	loc=loc.toString().replace('${source}',"").replace('/','-');
	loc+="; path=/" ;
 
	
	</script>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tangotab.util.TangotabConstants"%>
<%@page import="com.tangotab.util.TangoTabUtility"%>
<%   

/* Getting Error Url and storing in cookies    */
String ErrorUrl=request.getAttribute("errorPath").toString().replaceFirst("/","").replace("/","-");					
Cookie cookie = new Cookie("ErrorUrl", ErrorUrl); 	
					
String sendurl= "/jsp/errorsignup.jsp";
if(request.getAttribute("errorPath").toString().indexOf('.')==-1)
{
String s[]=request.getAttribute("errorPath").toString().split("/");

ArrayList<String> landlist=new ArrayList<String>();
landlist.add("waka");
landlist.add("fondalo");
landlist.add("feedthechildren");
landlist.add("jayratliff");
landlist.add("cactus1");
landlist.add("cotterweb1");
landlist.add("nyc");
landlist.add("nifb");
landlist.add("lecpta");
landlist.add("eataroundokc");
landlist.add("dallasobserver");

sendurl="";
/* the cookie should remove after browser closes (dont persist) */
cookie.setMaxAge(-1);
cookie.setPath("/");
response.addCookie(cookie);

for(int i=0;i<landlist.size();i++)
{
 

            if(s.length>1)
			
            {
            String source="";
                  for(int j=1;j<s.length;j++)
                  {
                  
                  if(j!=1)
                  source=source+"-"+s[j];
                  else 
                   source= s[j];
                        if(landlist.get(i).equals(source))
                        {     sendurl="";
                          sendurl=sendurl+ "/"+source+"/";
                          sendurl=sendurl.replace("-","/");
						
                        }
						 // System.out.println(source);
                  }
            }
			//System.out.println(landlist.get(i));
}
if(sendurl.equals(""))
{  sendurl= "/jsp/errorsignup.jsp";
}

if(request.getAttribute("errorPath").toString().indexOf("mobile")!=-1)
{
  sendurl= "/mobile/signup/errorsignup.jsp";
}
}
//System.out.println(sendurl);
%>
<jsp:forward page="<%=sendurl%>"></jsp:forward>
