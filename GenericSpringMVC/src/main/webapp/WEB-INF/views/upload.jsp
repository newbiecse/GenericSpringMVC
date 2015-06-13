<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Upload File Request Page</title>
	<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/upload.js" />"></script>
</head>
<body>
 
    <form method="POST" action="uploadFile" enctype="multipart/form-data">
        File to upload: <input type="file" name="file"><br /> 
        <input type="submit" value="Upload"> Press here to upload the file!
    </form>
     
</body>
</html>