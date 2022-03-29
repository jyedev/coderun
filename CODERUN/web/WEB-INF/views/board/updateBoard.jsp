<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="${ pageContext.servletContext.contextPath }/resources/img/favicon.png" />
    <title>CODERUN</title>
    <script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
  
    <link href="${ pageContext.servletContext.contextPath }/resources/css/style.css" rel="stylesheet" />
   
</head>

<body id="page-top">
<jsp:include page="../common/menubar.jsp"/>
    <section>
        <div class="mx-auto writeform">
            <h2 class="mb-3 border-bottom">게시글 수정<br><br></h2>
            <br><br>
            <form class="needs-validation" method="post" action="${ pageContext.servletContext.contextPath }/board/update" validate>
            <input type="hidden" name="no" value="${ board.no }">
                <div class="writesubmit row g-3">
                    <div class="titletextbox col-sm-6">
                        <label for="firstName" class="form-label"><strong>제목</strong></label>
                        <input type="text" name="title" class="form-control" id="firstName" placeholder="제목 입력" value="${ board.title }" required>
                        <div class="invalid-feedback">
                            제목을 입력하세요
                        </div>
                        <br><br>
                    </div>
                    <div class="contentwritebox">
                        <label for="firstName" class="form-label"><strong>내용</strong></label>
                        <div class="contentcontainer mx-auto">
                           <textarea class="textarea" rows="20" cols="100" name="content" required>${ board.content }</textarea>
                        <div class="invalid-feedback">
                            내용을 입력하세요
                        </div>
                    </div>
                    <br><br>
                    <div class="d-grid col-1 mx-auto">
                        <button class="btn btn-primary" type="submit">수정</button>
                    </div>
                </div>
            </form>
        </div> 
    </section>
    <!-- --------------푸터-------------- -->
    <footer class="footer py-4 bg-light">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-12 text-lg-end">Copyright &copy; CODERUN 2022</div>
          </div>
        </div>
    </footer>

<script src="js/summernote/summernote-lite.js"></script>
    <script src="js/summernote/lang/summernote-ko-KR.js"></script>
    
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>