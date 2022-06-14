<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title><tiles:insertAttribute name="title" ignore="true" /></title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Custom fonts for this template -->
    <link href="${pageContext.request.contextPath}/resources/pcfc/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/pcfc/css/fontawesome.min.css" > --%>
    <link href="${pageContext.request.contextPath}/resources/pcfc/css/sb-admin-2.min.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom styles for this page -->
    <link href="${pageContext.request.contextPath}/resources/pcfc/css/dataTables.bootstrap4.min.css" rel="stylesheet">
</head>

<body  id="page-top">
	<div id="wrapper">
		<tiles:insertAttribute name="menu" />
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<tiles:insertAttribute name="header" />
				<tiles:insertAttribute name="body" />
			</div>
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

  <!-- JavaScript Libraries -->
  <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/bootstrap.bundle.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/bootstrap.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="${pageContext.request.contextPath}/resources/pcfc/js/datatables-demo.js"></script>
</body>
</html>