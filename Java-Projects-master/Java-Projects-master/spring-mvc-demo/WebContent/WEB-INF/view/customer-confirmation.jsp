<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>This my sucess page</title>
</head>

<body>

The Customer is Confirmed: ${customer.firstName} ${customer.lastName}

<br><br>

Free Passes: ${customer.freePasses}

<br><br>

Postal Code: ${customer.postalCode}

<br><br>

Course code: ${customer.courseCode}

</body>

</html>