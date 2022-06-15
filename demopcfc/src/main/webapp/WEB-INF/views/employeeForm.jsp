<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="row justify-content-center">
	<div class="col-lg-7">
		<div class="p-5">
			<div class="text-center">
				<h1 class="h4 text-gray-900 mb-4"><c:if test="${not empty employee.id && Integer.valueOf(employee.id) > 0 }"><c:out value="Update"></c:out></c:if> <c:if test="${not empty employee.id && Integer.valueOf(employee.id) lt 1 }"><c:out value="Add New"></c:out> </c:if>Employee!</h1>
			</div>
			<c:set var = "managerObj" scope = "session" value = "${employee.manager}"></c:set>
			<form:form method="POST"
				action="${pageContext.request.contextPath}/employee/save"
				modelAttribute="employee">
				<div Class="form-group row">
					<div Class="col-sm-6 mb-3 mb-sm-0">
						<form:input path="firstName" placeholder="First Name"
							cssClass="form-control form-control-user" />
						<form:errors path="firstName" cssClass="text-danger small" />
					</div>
					<div class="col-sm-6">
						<form:input path="lastName" placeholder="Last Name"
							cssClass="form-control form-control-user" />
						<form:errors path="lastName" cssClass="text-danger small" />
						
					</div>
				</div>
				<div Class="form-group row">
					<div Class="col-sm-6 mb-3 mb-sm-0">
					<form:input path="dob" type="date" cssClass="form-control form-control-user" />
					<form:errors path="dob" cssClass="text-danger small" />
					</div>
					<div class="col-sm-6">
						<form:input type="number" path="salary" cssClass="form-control form-control-user"/>
						<form:errors path="salary" cssClass="text-danger small" />
					</div>
				</div>
				<div Class="form-group row">
					<div Class="col-sm-6 mb-3 mb-sm-0">
						<form:select path="department" cssClass="form-control form-control-user select">
							<option value="">--Select Department--</option>
							<option value="Finance" <c:if test="${not empty employee.department && employee.department eq 'Finance' }">selected</c:if>>Finance</option>
							<option value="Marketing" <c:if test="${not empty employee.department && employee.department eq 'Marketing' }">selected</c:if>>Marketing</option>
							<option value="Human Resource" <c:if test="${not empty employee.department && employee.department eq 'Human Resource' }">selected</c:if>>Human Resource</option>
						</form:select>
						<form:errors path="department" cssClass="text-danger small"/>
					</div>
					<div class="col-sm-6">
						<form:select path="managerid" cssClass="form-control form-control-user select">
							<option value="0">--Select Manager--</option>
							<c:forEach items="${employees}" var="emp">
								<c:if test="${employee.id != emp.id }">
									<option value="${emp.id}" <c:if test="${not empty managerObj && not empty managerObj.id && managerObj.id eq emp.id }">selected</c:if>>${emp.firstName}&nbsp;${emp.lastName}</option>
								</c:if>
							</c:forEach>
						</form:select>
					</div>
					<form:input path="id" type="hidden" />
				</div>
				<c:if test="${not empty employee.id && Integer.valueOf(employee.id) > 0 }"><input type="submit" value="Update"
					class="btn btn-warning btn-user btn-block"></c:if> <c:if test="${not empty employee.id && Integer.valueOf(employee.id) lt 1 }"><input type="submit" value="Submit"
					class="btn btn-primary btn-user btn-block"> </c:if>
			</form:form>
			<hr>
		</div>
	</div>
</div>
