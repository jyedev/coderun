<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
</head>
<body>
   <jsp:include page="../common/menubar.jsp"/>
 
    <section class="page-section bg" id="teacher-info" style="width: 1000px; margin: 0 auto;">
        <div class="container">
            <form action="${ pageContext.servletContext.contextPath }/mentor/information" name="teacher-info" method="post">
                <br><br>
                <h4>멘토 정보</h4>
                <br>
                <div class="mb-3">
                    <label for="exampleFormControlInput1" class="form-label">닉네임</label>
                    <input type="text" class="form-control" name="nickname" placeholder="닉네임">
                </div>
                <div class="mb-3">
                    <label for="exampleFormControlTextarea1" class="form-label">자기 소개</label>
                    <textarea class="form-control" name="introduce" rows="5" style="resize: none"></textarea>
                </div>
                <br><br>
                <h4>커리큘럼</h4>
                <br>
                <button class="btn btn-primary" type="button" onclick="addInput();">추가</button>
                <button class="btn btn-primary" type="button" onclick="deleteInput();">삭제</button>
                <br><br>
                <div id="parah">
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">커리큘럼명</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="커리큘럼명">
                    </div>
                    <div class="mb-3">
                        <label for="exampleFormControlInput1" class="form-label">영상 링크</label>
                        <input type="url" class="form-control" id="exampleFormControlInput1" placeholder="영상 링크">
                    </div>
                </div>
               
                <br>
                <div class="d-grid col-1 mx-auto">
                    <button class="btn btn-primary" type="submit">수정</button>
                </div>
            </form>
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
    <script src="${ pageContext.servletContext.contextPath }/resources/js/scripts.js"></script>
</body>
</html>


</body>
</html>