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
    <script type="text/javascript">
		(function() {
			const result = "${ requestScope.acceptMentorResult }"
			
			if(result == "success")
				alert("멘토 승인에 성공했습니다.")
			if(result == "failed")
				alert("멘토 승인에 실패했습니다.")
		})();
		
		(function() {
			const result = "${ requestScope.rejectMentorResult }"
			
			if(result == "success")
				alert("멘토 거절에 성공했습니다.")
			if(result == "failed")
				alert("멘토 거절에 실패했습니다.")
		})();
		
	</script>
	<jsp:include page="../common/menubar.jsp" />
	<section class="page-section bg" id="teacher-info"
		style="width: 1000px; margin: 0 auto;">
		<div class="container">
			<br> <br>
			<c:if test="${ empty mentorDetail.member.image.edit }">
				<img
					src="${ pageContext.servletContext.contextPath }/resources/img/user-icon.png"
					class="rounded mx-auto d-block" alt="..."
					style="width: 150px; height: 150px">
			</c:if>
			<c:if test="${ !empty mentorDetail.member.image.edit }">
				<img
					src="${ pageContext.servletContext.contextPath }${ mentorDetail.member.image.root }/${ mentorDetail.member.image.edit }"
					class="rounded mx-auto d-block" alt="..."
					style="width: 150px; height: 150px">
			</c:if>
			<br> <br>
			<div class="mb-3">                                                                                                                                                                                                      
             <label for="exampleFormControlInput1" class="form-label">닉네임</label>
             <input type="text" class="form-control" name="nickname" value="${ mentorDetail.nickname }" readonly>
            </div>
			<br>
			<h4>강점</h4>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">코드런에 지원한 이유를 본인의 경험/경력 등 구체적인 사례를 들어 기술하여 주십시오.(300자 이상)</label>
                    <textarea class="form-control" rows="5" style="resize: none" name="strength" readonly>${ mentorDetail.strength }</textarea>
                </div><br>
			<div class="mb-3 row">
				<c:if test="${ mentorDetail.request.approveStatus == '승인' }">
				<table class="table" id="teacher-cur">
					<thead>
						<tr>
							<th scope="col"></th>
							<th scope="col">수업 목록</th>
							<th scope="col">보러가기</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="curriculum"
							items="${ mentorDetail.curriculumName }" varStatus="status">
							<tr>
								<th scope="row">${ status.count }</th>
								<td>${ curriculum.name }</td>
								<td><button type="button" class="btn btn-warning"
										onclick="curriPlay('${ curriculum.videoLink}')">재생</button></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				</c:if>
				
				<c:if test="${ mentorDetail.request.approveStatus == '처리전' }">
				<br><br>
					<div class="d-grid col-2 mx-auto">
						<button class="btn btn-primary" type="button" style="width: 150px; height: 50px" id="acceptMentorBtn" onclick="acceptMentor()">승인</button>
					</div>
					<div class="d-grid col-2 mx-auto">
						<button class="btn btn-primary" type="button" style="width: 150px; height: 50px"
							onclick="rejectMentor()">거절</button>
					</div>
					<form name="mentorForm" method="post" id="mentorForm">
 						<input type="hidden" name="reqNo" value="${ mentorDetail.request.reqNo }">
 						<input type="hidden" name="memberId" value="${ mentorDetail.memberId }">
					</form>
				</c:if>
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
		<script>
			function acceptMentor() {
				document.forms.mentorForm.action = "${ pageContext.servletContext.contextPath }/admin/accept";
				document.forms.mentorForm.submit();
			}
			function rejectMentor() {
				document.forms.mentorForm.action = "${ pageContext.servletContext.contextPath }/admin/reject";
				document.forms.mentorForm.submit();
			}
			
		</script>
		
		
	</footer>
	
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>