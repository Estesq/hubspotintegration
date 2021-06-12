<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <title>View Books</title>
        <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    </head>
    <body>
        <table>
        <tr>
           <td><button onClick="processContacts()"> Process Contacts</button></td>
		</tr>
		<tr>
			<td id="count"></td>
		</tr>		
        </table>
        <p id="data">
    </body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
function processContacts(){

 $.get('https://api.hubapi.com/crm/v3/objects/contacts?limit=100&archived=false&hapikey=6cb8ea17-3c6f-43d7-b041-6bf47e812f84&properties=company,email', 
	      function (res) {  
	      		console.log(res);
	      	   const data = res.results;
			   console.log(data);
			   reqData = JSON.stringify(data); 
  $.ajax({  
    type: 'POST',  
    url: "/processContacts",  
    contentType: "application/json; charset=utf-8",  
    dataType: 'json',  
    headers: {  
        'Accept': 'application/json',  
        'Content-Type': 'application/json'
    },  
    data: reqData,  
    async: false,  
    success: function(response) {  
        console.log(response);  
        var s = document.getElementById("count");
            s.innerHTML  = "Processed " + response + "contacts";
        window.open('http://localhost:8080/download/contact.csv');
    },  
    error: function(XMLHttpRequest, textStatus, errorThrown) {  
		console.log(errorThrown);
    }  
});
    });
  
}
</script>