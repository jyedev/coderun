<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" type="image/x-icon" href="/img/favicon.png" />
<title>CODERUN</title>
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${ pageContext.servletContext.contextPath }/resources/css/style.css"
	rel="stylesheet" />
<style>
.img-responsive {
	display: inline-block;
}
</style>
</head>
<body>
	<jsp:include page="../common/menubar.jsp" />
	<section class="page-section bg" id="teacher-info"
		style="width: 1000px; margin: 0 auto;">
		<div class="container">
		<br>
			<h4>프로필 사진</h4>
			<br> <br>
			<div class="mb-3 row">
				<div class="mb-3">
					<label class="form-label">아이디</label> <input type="text"
						class="form-control" name="memberName" id="memberId"
						value="${ reportDetail.memberId }" readonly>
				</div>
				<div class="mb-3">
					<label class="form-label">게시글 제목</label> <input type="text"
						class="form-control" name="memberName" id="memberId"
						value="${ reportDetail.board.title }" readonly>
				</div>
				<div class="mb-3">
					<label class="form-label">게시글 내용</label> <input type="text"
						class="form-control" name="memberName" id="memberId"
						value="${ reportDetail.board.content }" readonly>
				</div>
				<div class="mb-3">
					<label class="form-label">댓글 내용</label> <input type="text"
						class="form-control" name="memberName" id="memberId"
						value="${ reportDetail.comment.content }" readonly>
				</div>
				<br> <br>
				
			</div>
		</div>
	</section>
	<footer class="footer py-4 bg-light">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-12 text-lg-end">Copyright &copy; CODERUN
					2022</div>
			</div>
		</div>

		<script>
         function curriPlay(link) {
            window.open(link);
         }
      </script>

	</footer>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>