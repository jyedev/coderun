<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" type="image/x-icon"
	href="${ pageContext.servletContext.contextPath }/resources/img/favicon.png" />
<title>CODERUN</title>
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/admin-style.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<a class="navbar-brand"
						href="${ pageContext.servletContext.contextPath }"><img
						src="${ pageContext.servletContext.contextPath }/resources/img/logo.png"
						alt="..." style="width: 190px; margin-left: 10px;" /></a> <br> <br>
					<a class="nav-link collapsed"
						href="${ pageContext.servletContext.contextPath }/admin/member/list">
						회원 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a> <a class="nav-link collapsed"
						href="${ pageContext.servletContext.contextPath }/admin/mentor/list">
						멘토 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a> <a class="nav-link collapsed"
						href="${ pageContext.servletContext.contextPath }/admin/payment/list">
						결제 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a> <a class="nav-link collapsed"
						href="${ pageContext.servletContext.contextPath }/admin/calculation/list">
						정산 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a> <a class="nav-link collapsed"
						href="${ pageContext.servletContext.contextPath }/board/list">
						게시판 관리
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
				</div>
			</div>
			<div class="sb-sidenav-footer">
				<div class="dropdown">
					<a href="#"
						class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
						id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
						<img src="https://github.com/mdo.png" alt="" width="32"
						height="32" class="rounded-circle me-2"> <strong>관리자</strong>
					</a>
					<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
						aria-labelledby="dropdownUser1">
						<li><a class="dropdown-item"
							href="${ pageContext.servletContext.contextPath }/member/logout">Sign
								out</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
</body>
</html>