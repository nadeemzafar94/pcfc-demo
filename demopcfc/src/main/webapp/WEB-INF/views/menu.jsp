<ul
	class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
	id="accordionSidebar">

	<!-- Sidebar - Brand -->
	<a
		class="sidebar-brand d-flex align-items-center justify-content-center"
		href="${pageContext.request.contextPath}/home">
		<!-- <div class="sidebar-brand-icon rotate-n-15">
			<i class="fas fa-laugh-wink"></i>
		</div> -->
		<div class="sidebar-brand-text mx-3">
			PCFC <sup class="text-danger">DEMO</sup>
		</div>
	</a>

	<!-- Divider -->
	<hr class="sidebar-divider my-0">

	<!-- Nav Item - Dashboard -->
	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/home"> <i
			class="fas fa-fw fa-table"></i> <span>Employee list</span></a></li>
	<!-- Nav Item - Tables -->
	<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/employee/form">
			<i class="fas fa-fw fa-table"></i> <span>Add Employee</span>
	</a></li>

	<!-- Divider -->
	<hr class="sidebar-divider d-none d-md-block">

	<!-- Sidebar Toggler (Sidebar) -->
	<div class="text-center d-none d-md-inline">
		<button class="rounded-circle border-0" id="sidebarToggle"></button>
	</div>

</ul>