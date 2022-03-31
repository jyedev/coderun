<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="${ pageContext.servletContext.contextPath }/resources/img/favicon.png" />
    <title>CODERUN</title>
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="${ pageContext.servletContext.contextPath }/resources/css/style.css" rel="stylesheet" />
    <style>
        .img-responsive {
            display: inline-block;
        }
    </style>
</head>
<body>
  <jsp:include page="../common/menubar.jsp"/>
    <section class="page-section bg" id="teacher-info">
        <div class="container">
            <br>
            <h2 class="text-center">CODERUN의 멘토를 소개합니다</h2>
            <br><br>
            <div class="row justify-content-around">
               <c:forEach var="mentor" items="${ mentorList }">
                <div class="col-md-6">
					<div class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-250 position-relative" style="width: 500px; margin: 0 auto;">
                        <div class="col-md-3 p-4 d-flex flex-column position-static">
                        <c:if test="${ empty mentor.member.image.edit }">
                            <img src="${ pageContext.servletContext.contextPath }/resources/img/user-icon.png" style="width:100px; height:100px; margin: auto;"alt="...">
                        </c:if>
                        <c:if test="${ !empty mentor.member.image.edit }">
                        	<img src="${ pageContext.servletContext.contextPath }${ mentor.member.image.root }/${ mentor.member.image.edit }" style="width:100px; height:100px; margin: auto;"alt="...">
                        </c:if>
                        </div>
                        <div class="col-md-9 p-4 d-flex flex-column position-static">
                            <h3 class="mb-0">${ mentor.nickname }</h3>
                            <p class="card-text mb-auto">${ mentor.language }
                            <br>
                          <a href="${ pageContext.servletContext.contextPath }/mentor/detail?memberId=${mentor.memberId}"
                          class="stretched-link">자세히 보기</a>
                         <!--   <a class="detail" onclick="detailView(${mentor.memberId})">자세히 보기</a> -->
                          
                        </div>
                    </div>
                </div>
                 </c:forEach>
              </div>
       		<br><br>
	        <div class="d-grid col-2 mx-auto">
	        	<c:if test="${ !empty sessionScope.loginMember }">
		        <button class="btn btn-primary" type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/mentor/pay'">프리패스 구매하기</button>
		        </c:if>
		        <c:if test="${ empty sessionScope.loginMember }">
		        <button class="btn btn-primary" type="button" onclick="alert('로그인 후 이용해 주세요.')">프리패스 구매하기</button>
		        </c:if>
	        </div>
        </div>  
    </section>
    <footer class="footer py-4 bg-light">
        <div class="container">
            <div class="row align-items-center">
                <div class="col-lg-12 text-lg-end">Copyright &copy; CODERUN 2022</div>
            </div>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>