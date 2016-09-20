<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "teamc.Defect" %>
<%@ page import = "java.lang.*" %>

<!DOCTYPE HTML>
<html lang = "en-US">

<head>
	<title>Team-C Bug Tracker</title>
	<link rel="stylesheet" href="styles.css">
</head>

<body>
	<div class="header">
		<h1>Team-C Corporation <br/><span class="sub">Defect Tracking System</span></h1> 
		    <img src = "${pageContext.request.contextPath}/images/logo1.jpg"
		         alt = "Evil Corp Logo" />
          
               
	</div>

	</br>
    <section class="instructions">
        <p>To enter a new defect, please use the button below to access the Defect Creation page.<br/>
           Additional information may be found on any defect by selecting it from the list.  After<br/>    
           reaching the Defect Details page, you may update the defect as required.<br/>
        </p>   
    </section>
    <br/>
	<a href = "createDefects.html">
		<input type = "submit" value ="+ Create Defect">
	</a>
	<br></br>
	<!--Search for Open Defects based on selected Project-->
    <form action="OpenDefects" method="post">
	     <select name = "choice">
			<option value="all" selected>All Open Defects</option>
			<option value="ProjectA">Project A </option>
			<option value="ProjectB">Project B </option>
			<option value="ProjectC">Project C </option>
	     </select>
       <input type="submit" value="submit">
    </form>
	<br></br>

	<!--Start Table : Need to query info from database. These are sample data only-->

     <%if(request.getAttribute("passby").equals("noDefects")){
        String noDef = "This projects does not have any open defects.";
     %>
        <table>
		<thead>
           <caption>List of Open Defects</caption>
 			<tr>
				<th>
					 <%=noDef%>
				</th>     
			</tr>
		</thead>     
	 </table>     
    <%}else {%>
    	 <% List<Defect> newList = (ArrayList<Defect>) request.getAttribute("passby");%> 
         <%// System.out.println("Inside jsp: " + newList.get(1).getDescription()); %>

    <form action="ShowDetails" method="post">

	 <table>
		<thead>
           <caption>List of Open Defects</caption>
           	<tr>
    			<th class="Def">Defect Name</th>
    			<th class="Pro">Project</th>
    			<th class ="Sum">Summary</th>
    			<th class="Assign">Assignee</th>
			</tr>
        </thead>

		<tbody>
        <%for(Defect useList : newList){
        	Integer cell1 = useList.getDefectName();
            String cell2 = useList.getapplication();
        	String cell3 = useList.getSummary();
        	String cell4 = useList.getAssignee();
//        	System.out.println(cell1 + " " + cell2 + " " + cell3);
        	%>

			<tr>
				<td>
				    <input type="radio" name="commonKey" value= <%=cell1%> checked = "checked">  <%= cell1%><br>
				</td>
				<td><%=cell2%></td>
				<td><%=cell3%></td>
				<td><%=cell4%></td>				
			</tr>
         <%} %>
		</tbody>
 
	 </table>
       <input type="submit" value="submit">
    </form>
  <%}%>

</body>

</html>