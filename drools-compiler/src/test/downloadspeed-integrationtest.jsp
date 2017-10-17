<%@ page import="com.agfa.ris.server.services.IDownloadSpeedServiceLocal"%>
<%@ page import="com.agfa.ris.common.services.ServerDownloadSpeedData"%>
<%@ page import="javax.ejb.EJB"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="com.google.common.collect.ImmutableList" %>
<%@ page import="com.google.common.collect.ImmutableMap" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%
    Context ctx=new InitialContext();
    IDownloadSpeedServiceLocal downloadSpeedService= (IDownloadSpeedServiceLocal) ctx.lookup("java:global/agility/com.agfa.ris.server/DownloadSpeedServiceBean!com.agfa.ris.server.services.IDownloadSpeedServiceLocal");

    final String noImagesReceivedStudyUID = "2.25.135634324272707640874247026795042200665";
    final String allInstancesFastHubStudyUID= "2.25.58668216771224452402291368346023171777";
    final String deletedImagesStudyUID = "2.25.38572049936112234186618140005873187953";

   final Map<String, String> useCase2StudyUID = new HashMap<String, String>();
   useCase2StudyUID.put("no images received yet", "2.25.135634324272707640874247026795042200665");
   useCase2StudyUID.put("all instances fast hub", "2.25.58668216771224452402291368346023171777");
   useCase2StudyUID.put("deleted images hub", "2.25.38572049936112234186618140005873187953");
   useCase2StudyUID.put("only on archive", "2.25.183587227984951231492279260301692357112");
   useCase2StudyUID.put("deleted images archive", "2.25.97413321378668926526886850246316658963");
   useCase2StudyUID.put("split fast caches", "2.25.232624988393767199266453555553587616692");
   useCase2StudyUID.put("split fast and slow", "1.2.40.0.13.1.324456222961461322770758749939265794491");

  
%>


<!DOCTYPE html>
<html>
<head>
<title>downloadspeed integration tests</title>
</head>

<body>
<h1>Download speed tests</h1>
<%
System.out.println("start test");
%>

<table style="width:100%">
  <tr>
    <th>case</th>
    <th>downloadSpeedData 2 args</th>
    <th>downloadSpeedData 3 args</th>
    <th>bulkServerDownloadSpeedData</th>
  </tr>
  <% for ( Map.Entry<String,String> entry  :  useCase2StudyUID.entrySet()) {%>
  <tr>
    <td><%=entry.getKey()%></td>
    <td><%=downloadSpeedService.downloadSpeedData(null, entry.getValue()) %></td> 
    <td></td>
    <td><%=downloadSpeedService.bulkServerDownloadSpeedData(null, ImmutableList.of(entry.getValue()))%></td>
  </tr>
<% } //end for loop  %>
 
 
  
</table>


<hr>
The End !

</body>

</html>


