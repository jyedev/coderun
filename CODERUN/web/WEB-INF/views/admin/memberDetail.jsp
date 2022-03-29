<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon"
	href="${ pageContext.servletContext.contextPath }/resources/img/favicon.png" />
<title>CODERUN</title>
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/style.css"
	rel="stylesheet" />
</head>
<style>
.img-responsive {
	display: inline-block;
}

.imgArea {
	margin: auto;
	height: 200px;
}
</style>
</head>
<body>
	<section class="page-section bg" id="modify"
		style="width: 1000px; margin: 0 auto;">
		<div class="container">
			<br>
			<br>
			<h4>프로필 사진</h4>
			<br>
			<br>
			<form method="post"
				action="${ pageContext.servletContext.contextPath }/profileImg/insert"
				enctype="multipart/form-data">
				<div class="d-grid col-2 mx-auto">
					<div class="imgfix">
						<!-- c:if문 작성 -->
						<c:if test="${ empty memberDetail.image.edit }">
							<img
								src="${ pageContext.servletContext.contextPath }/resources/img/user-icon.png"
								class="imgArea" id="imgArea">
						</c:if>
						<c:if test="${ !empty memberDetail.image.edit }">
							<img
								src="${ pageContext.servletContext.contextPath }/resources/upload/original/${ memberDetail.image.edit }"
								class="imgArea" id="imgArea">
						</c:if>
						<!-- <input type="image" id="imgfile" name="thumbnail" readonly>  -->
					</div>
					<br>
				</div>
				
			</form>

			<br>
			<br>
			<!-- 프리패스 소지한 회원인지 아닌지에 따라서 다르게 -->
			<form name=form id="modifyForm"
				action="${ pageContext.servletContext.contextPath }/member/modify"
				method="post">
				<c:if test="${ memberDetail.freepassYn eq 'Y' }">
					<div>
						<img
							src="${ pageContext.servletContext.contextPath }/resources/img/crown.png"
							class="align-middle" style="width: 20px; margin-right: 5px;">
						<span class="align-middle">프리패스를 소지한 회원입니다.</span>
					</div>
				</c:if>

				<br>
				<div class="mb-3">
					<label class="form-label">이름</label> <input type="text"
						class="form-control" name="memberName" id="memberName"
						value="${ memberDetail.name }" requried readonly>
				</div>
				<div class="mb-3">
					<label class="form-label">이메일</label> <input type="text"
						class="form-control" name="email" id="email"
						value="${ memberDetail.email }" required readonly>
				</div>
				<div class="mb-3">
					<label class="form-label">생년월일</label><br> <input type="date"
						class="form-control" name="birthday" id="birthday"
						value="${ memberDetail.birthday }" required readonly>
				</div>
				<c:if test="${ memberDetail.gender eq 'F' }">
					<div class="mb-3">
						<label class="form-label">성별</label><br> <input type="text"
							class="form-control" name="gender" id="gender"
							value="여성" required readonly>
					</div>
				</c:if>
				<c:if test="${ memberDetail.gender eq 'M' }">
					<div class="mb-3">
						<label class="form-label">성별</label><br> <input type="text"
							class="form-control" name="gender" id="gender"
							value="남성" required readonly>
					</div>
				</c:if>
				<div class="mb-3">
					<label class="form-label">유형</label><br> <input type="text"
						class="form-control" name="type" id="type"
						value="${ memberDetail.type }" required readonly>
				</div>
				
				
				<br>
				<br>
				<br>
				<br>
				<br>
			</form>
		</div>
	</section>
</body>
</html>