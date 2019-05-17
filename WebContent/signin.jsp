<center>
<%="SignUp"%>

<form action="SignInServlet">

	FirstName* : <input type="text" name="firstname" value = "<%= request.getAttribute("Fname") %>" required> <br> <br>
    LastName* : <input type="text" name="lastname" value = "<%= request.getAttribute("Lname") %>" required>   <br> <br>
    EmailId* : <input type="text" name="emailId" value = "<%= request.getAttribute("Eid") %>" required> <br> <br> 
    PhoneNo* : <input type="text" name="phoneNo"  value = "<%= request.getAttribute("PhNo") %>" required> <br> <br> 
    Address* : <input type="text" name="address" value = "<%= request.getAttribute("Addr") %>" required> <br> <br> 
    Password* : <input type="password" name="password" value = "<%= request.getAttribute("Pwd") %>" required> <br> <br>
	Re-typePassword* : <input type="password" name="repassword" value = "<%= request.getAttribute("Repwd") %>" required> <br>
	<br> <input type="submit"> <br> <br> 
	<input type="button" value="back">


</form>
</center>