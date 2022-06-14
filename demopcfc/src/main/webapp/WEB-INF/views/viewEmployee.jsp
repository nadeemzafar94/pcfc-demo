<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Employee Details</h1>
	<p class="mb-4">
		
	</p>
	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary"><a href="${pageContext.request.contextPath}/employee/form?id=${employee.id}" class="btn btn-primary btn-icon-split btn-sm"><span class="icon text-white-50">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </span>
                                        <span class="text">Edit</span></a></h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					  <tr>
					    <th>First Name:</th>
					    <td>${employee.firstName}</td>
					  </tr>
					  <tr>
					    <th>Last Name:</th>
					    <td>${employee.lastName}</td>
					  </tr>
					  <tr>
					    <th>Date of Birth:</th>
					    <td>${employee.dob}</td>
					  </tr>
					  <tr>
					    <th>Salary in AED:</th>
					    <td>${employee.salary}</td>
					  </tr>
					  <tr>
					    <th>Department:</th>
					    <td>${employee.department}</td>
					  </tr>
					  <tr>
					    <th>Manager:</th>
					    <c:set var = "manager" scope = "session" value = "${employee.manager}"/>
						<td>${manager.firstName}&nbsp;${manager.lastName}</td>
					  </tr>
					
				</table>
			</div>
		</div>
	</div>

</div>