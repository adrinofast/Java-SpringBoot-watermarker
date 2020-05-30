<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
    <%@ page isELIgnored="false" %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Location</title>
</head>
<body>
<form action="saveLoc" method="post">
<pre>

ID : <input type="text" name="id" value="${allloc.id}" readonly = "true"/>
NAME : <input type="text" name="name"  value="${allloc.name}" />
CODE : <input type="text" name="code" value="${allloc.code}"  />
TYPE : URBAN<input type="radio" name="type" value="URBAN"  ${allloc.type == 'URBAN'?'checked':'' }/>
       RURAL<input type="radio" name="type" value="RURAL" ${allloc.type == 'RURAL'?'checked':'' } />
 
 <input type="submit" value="save">
</form>

</pre>
</body>
</html>
