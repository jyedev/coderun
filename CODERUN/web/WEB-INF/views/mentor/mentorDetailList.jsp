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
    <link rel="icon" type="image/x-icon" href="/img/favicon.png" />
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
    <section class="page-section bg" id="teacher-info" style="width: 1000px; margin: 0 auto;">
        <div class="container">
            <br><br>
            <c:if test="${ empty mentor.image.edit }">
            <img src="${ pageContext.servletContext.contextPath }/resources/img/user-icon.png" class="rounded mx-auto d-block" alt="...">
            </c:if>
            <c:if test="${ !empty mentor.image.edit }">
            <img src="${ pageContext.servletContext.contextPath }${ mentor.image.root }/${ mentor.image.edit }" class="rounded mx-auto d-block" alt="...">
            </c:if>
            <br><br>
        	
            <h2 class="text-center">${ mentor.nickname }</h2>
            <br>
            <div class="mb-3 text-center">
               <!--   최신 UI 디자인 기법인 피그마를 사용 해 감각적인 UI 디자인을 강의합니다.<br><br>

                회사를 다니면서 습득한 디자인 툴 사용법과 포트폴리오를 통해<br>
                여러분들의 디자인 스킬을 한층 더 업그레이드 시켜드립니다. <br><br><br> -->
                ${ mentor.introduce}
            </div>
            <div class="mb-3 row">
                <table class="table" id="teacher-cur">
                    <thead>
                        <tr>
                        <th scope="col"></th>
                        <th scope="col">수업 목록</th>
                        <th scope="col">보러가기</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="curriculum" items="${ mentor.curriculumName }" varStatus="status">
                        <tr>
                            <th scope="row">${ status.count }</th>
                            <td>${ curriculum.name }</td>
                            <td><button type="button" class="btn btn-warning" onclick="curriPlay('${ curriculum.videoLink}')">재생</button></td>
                        </tr>
            
                       </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
    
    <script>
    	function curriPlay(link){
    		window.open(link);
    	}
    </script>
    
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



</body>
</html>