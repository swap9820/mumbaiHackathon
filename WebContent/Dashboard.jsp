<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>


<style>
body {font-family: Arial;}


.tab {
  overflow: hidden;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
}


.tab button {
  background-color: inherit;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  transition: 0.3s;
  font-size: 17px;
}


.tab button:hover {
  background-color: #ddd;
}


.tab button.active {
  background-color: #ccc;
}


.tabcontent {
  display: none;
  padding: 6px 12px;
  border: 1px solid #ccc;
  border-top: none;
}
 tptt {
            width:400px; 
            height:450px;
        }
        .iframe-class { overflow-x:hidden; overflow-y:auto; }
</style>






<body>
<%

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setHeader("Expires","0");

	if(session.getAttribute("id")==null){
		response.sendRedirect("index.html");
	}


%>


Welcome to Dashboard

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')">Profile</button>
  <button class="tablinks" onclick="openCity(event, 'Paris')">sell</button>
  
    <button class="tablinks" onclick="openCity(event, 'msg')">Messages</button>
</div>

<div id="London" class="tabcontent">
  
  
  <h3>Profile</h3>
  
  <img src="<%=session.getAttribute("photos") %>" style="width:20%;height:50%">
  </br>
First Name<%=session.getAttribute("fname") %><br>
Last Name<%=session.getAttribute("lname") %><br>
PhoneNo Name<%=session.getAttribute("Phoneno") %><br>
State<%=session.getAttribute("state") %><br>
Pin<%=session.getAttribute("pin") %> <br>
  
  
  
  
  
</div>

<div id="Paris" class="tabcontent">
 
  <form action="dash" method="post">
<div style=" border: 1px solid black;height:400px;width:50%;" >

<h2>Sell Item
</h2>
<br>

Item name 
<input type="text" name="item">

<br>
<br>
Select Catagory of Item<br>


<form>
  <input type="radio" name="icat" value="fer" > Fertilizer
  <input type="radio" name="icat" value="cop"> Coops
  <input type="radio" name="icat" value="sed"> Seeds  
</form> 
</br>
</br>

Quantity<input type="number" name="qut">

<br>
<br>
Prize<input type="number" name="prz">

<br>
<br>

Description
<textarea rows="4" cols="50" name="dis">

</textarea>
<br><br>
<input type="submit">
</div>
</form>
  
 
 <div style=" border: 1px solid black;height:400px;width:50%;" >
 
 
 
 <h2>Item Status
</h2>
 
 
 
  <iframe src="istat" style="width:550px" ></iframe>
 
 
 </div>







 
 
</div>






<div id="msg" class="tabcontent">

<h2>Messages</h2>
 
 
 
</div>


<% //<a href="tcops">coops</a> %>

<script>
function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
   


</body>
</html>