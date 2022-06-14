<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Employee List</h1>
	<p class="mb-4">
	</p>
	<c:if test="${fn:length(smessage) > 0}">
	<div class="alert alert-success alert-dismissible">
		<strong>Success!</strong> ${smessage}
	</div>
	</c:if>
	<c:if test="${fn:length(fmessage) > 0}">
	<div class="alert alert-danger alert-dismissible">
		<strong>Error!</strong> ${fmessage }.
	</div>
	</c:if>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href="${pageContext.request.contextPath}/employee/form" class="btn btn-primary btn-icon-split btn-sm"><span class="icon text-white-50">
                                            <i class="fa fa-plus" aria-hidden="true"></i>
                                        </span>
                                        <span class="text">Add new</span></a></h6>
		</div>
		
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Date of birth</th>
							<th>Salary in AED</th>
							<th>Department</th>
							<th>Manager</th>
							<th>Edit</th>
							<th>View</th>
						</tr>
					</thead>
					<tbody>
					<p></p>
					<c:forEach items="${employees}" var="employee">
						<tr>
							<td>${employee.firstName}</td>
							<td>${employee.lastName}</td>
							<td>${employee.dob}</td>
							<td>${employee.salary}</td>
							<td>${employee.department}</td>
							<c:set var = "manager" scope = "session" value = "${employee.manager}"/>
							<td>${manager.firstName}&nbsp;${manager.lastName}</td>
							<td><a href="${pageContext.request.contextPath}/employee/form?id=${employee.id}" class="btn btn-warning btn-icon-split btn-sm"><span class="icon text-white-50">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </span>
                                        <span class="text">Edit</span></a>
                             </td>
                             <td><a href="${pageContext.request.contextPath}/employee/view?id=${employee.id}" class="btn btn-success btn-icon-split btn-sm"><span class="icon text-white-50">
                                            <i class="fa fa-eye" aria-hidden="true"></i>
                                        </span>
                                        <span class="text">View</span></a>
                             </td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>