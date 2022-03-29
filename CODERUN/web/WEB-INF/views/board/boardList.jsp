<jsp:directive.page language="java" 
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"	/>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link href="${ pageContext.servletContext.contextPath }/resources/css/style.css" rel="stylesheet" />
	<style type="text/css">
	.paging_area button {
	color: #282A35;
	width: 40px;
	height : 40px;
	border : 0;
	outline : 0;
	background : white;
	cursor : pointer;
} 
	.paging_area .currentPage {
		border-bottom : 2px solid #282A35;
		font-weight : bold;
	}
	
	.search_area select {
	width: 150px;
	height: 30px;
	border: 0px;
}

	#searchCondition {
	border: 0px;
	margin-left: 10px;
	}
	</style>
</head>

<body id="page-top">
<jsp:include page="../common/menubar.jsp"/>
    <!-- Navigation-->
    <section>
        <div class="mx-auto searchbox">
          <form action="${ pageContext.servletContext.contextPath }/board/list" method="GET">
            <div class="input-group mb-4 border rounded-pill p-1">
                <div class="input-group-prepend border-0">
                    <button id="button-addon4" type="button" class="btn btn-link text-warning"><i class="fa fa-search"></i></button>
                </div>
                  <select id="searchCondition" name="searchCondition">
						<option value="title"
							${ param.searchCondition == 'title' ? "selected" : ""}>제목</option>
						<option value="content"
							${ param.searchCondition == 'content' ? "selected" : ""}>내용</option>
					</select>
                <input type="search" name="searchValue" placeholder="검색" aria-describedby="button-addon4" class="form-control bg-none border-0" style="margin-right: 20px;" value="${ param.searchValue }">
            </div>
          </form>
        </div>
        <br>
        <div class="mx-auto tablebox">
            <table class="table" id="community-list">
                <tbody>
                 <c:forEach var="board" items="${ boardList }">
                 <input type="hidden" value="${ board.no }">
                    <tr class="board_tr" onclick="boardView(${board.no})">
                        <td width="5%"></td>
                        <td class="list-subject title">
                          <a href="${ pageContext.servletContext.contextPath }/board/view?no=${board.no}">${ board.title }									                          
                          </a>
                        </td>
                        <td width="15%" colspan="1"><span class="member writerId">${ board.writerId }	</span></td>
                        <td width="13%" class="text-center en font-11 date">${ board.date }</td>
                    </tr>
                      </c:forEach>
                </tbody>
              </table>
        </div>
        
       
        <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        <jsp:include page="../common/boardPaging.jsp"/>
            
        <br>
        <br>
        <br>
        <div class="mx-auto writebutton d-grid gap-0 d-md-flex justify-content-md-end">
          <button class="btn btn-primary" type="button" onclick="location.href='${ pageContext.servletContext.contextPath }/board/insert'">글 작성</button>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script>
const boardList = document.querySelector(".table");

boardList.addEventListener('mouseover', function() {
	if(event.target.classList.contains('board_tr'))
		event.target.classList.add('onmouseover');
	else if(event.target.parentNode.classList.contains('board_tr'))
		event.target.parentNode.classList.add('onmouseover');
});

noticeList.addEventListener('mouseout', function() {
	if(event.target.classList.contains('board_tr'))
		event.target.classList.remove('onmouseover');
	else if(event.target.parentNode.classList.contains('board_tr'))
		event.target.parentNode.classList.remove('onmouseover');
});

function boardView(no){
		console.log(no);
		location.href = '${ pageContext.servletContext.contextPath }/board/view?no=' + no;
}
</script>
</body>
</html>