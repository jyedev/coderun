<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link href="${ pageContext.servletContext.contextPath }/resources/css/community-style.css" rel="stylesheet" />
</head>
<body id="page-top">
<script type="text/javascript">
   (function() {
      const result1 = "${ requestScope.insertCommentResult }";
      const result2 = "${ reqeustScope.deleteCommentResult }";
      if(result1 == "fail")
    	  alert("댓글 등록에 실패했습니다.");
      if(result2 == "fail")
    	  alert("댓글 삭제에 실패했습니다.");
   })();
</script>
	<jsp:include page="../common/menubar.jsp"/>
	<section>
		<div class="blog-page mx-auto">
			<br>
			<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
           		<h1 class="h2" width="30%">${ board.title }</h1>
          		<div class="writer-info">
           			<input type="hidden" value=${ board.no }>
           			<span>${ board.writerId }</span>
           			<span>${ board.date }</span>
          		</div>
       		</div>
       	<div class="writebox">
       		${ board.content }
       	</div>
       	<div class="btn-toolbar">
       		<div class="btn-group me-2">
               	<c:if test="${ board.writerId == sessionScope.loginMember.id }">
            	<button class="btn btn-sm" type="button" onclick="updateBoard(${ board.no })">수정</button>
               	<button type="button" class="btn btn-sm" value="delete" onclick="deleteBoard()">삭제</button>
               	<form name="boardForm" method="post">
					<input type="hidden" name="no" value="${ board.no }">
				</form>
               	</c:if>
               	<c:if test="${ sessionScope.loginMember.type eq '관리자' }">
            	<button class="btn btn-sm" type="button" onclick="updateBoard(${ board.no })">수정</button>
               	<button type="button" class="btn btn-sm" value="delete" onclick="deleteBoard()">삭제</button>
               	<form name="boardForm" method="post">
					<input type="hidden" name="no" value="${ board.no }">
				</form>
               	</c:if>
           	</div>
       	</div>
       	<br><br><br>
       	<div class="commentbox mx-auto border-top">
       		<div class="commenttitle"><br><h5>댓글</h5></div>
           		<br><br>
           		<!-- 댓글 -->
           		<c:forEach var="comment" items="${ board.commentList }" varStatus="status">
           		<c:if test="${ comment.delete eq 'N' }">
           		<div class="commentbody">
           			<div class="icon-box">
           				<table>
           					<tr>
           						<!-- 프로필 사진, 작성자 아이디 들어가는 곳 -->
           						<td class="userprofile">
						            <c:if test="${ empty comment.writer.image.edit }">
						            <img id="profilepic" src="${ pageContext.servletContext.contextPath }/resources/img/user-icon.png">${ comment.writerId }
						            </c:if>
						            <c:if test="${ !empty comment.writer.image.edit }">
						            <img id="profilepic" src="${ pageContext.servletContext.contextPath }${ comment.writer.image.root }/${ comment.writer.image.edit }">${ comment.writerId }
						            </c:if>
           						</td>
                   				<!-- 작성일이나 수정일 들어가는 곳 -->
                   				<c:if test="${ empty comment.update }">
                   				<td width="10%" id="comment-day">${ comment.date }</td>
                   				</c:if>
                   				<c:if test="${ !empty comment.update }">
                   				<td width="10%" id="comment-day">${ comment.update }</td>
                   				</c:if>
                   			</tr>
                   		</table>
               		</div>
               		<div class="commentwrapping">
               			<!-- 댓글 내용 들어가는 곳 -->
               			<p class="text-box mx-auto" id="contentView${ status.count }">${ comment.content }</p>
               			<div class="btn-toolbar">
               				<!-- 댓글 작성자만 수정, 삭제 가능 -->
               				<c:if test="${ comment.writerId == sessionScope.loginMember.id }">
               				<div class="btn-group me-2">
				            	<button class="btn btn-sm" type="button" id="modifyCmtBtn${ status.count }" onclick="modifyComment(${ status.count })">수정</button>
				               	<button type="button" class="btn btn-sm" value="delete" onclick="deleteComment(${ status.count })">삭제</button>
				               	<form name="commentForm${ status.count }" method="post" id="commentForm${ status.count }">
									<input type="hidden" name="no" value="${ comment.no }">
									<input type="hidden" name="bdNo" value="${ board.no }">
									<input type="hidden" name="content" id="modifyCmtValue${ status.count }">
								</form>
               				</div>
               				</c:if>
               				<!-- 관리자면 수정, 삭제 가능 -->
               				<c:if test="${ sessionScope.loginMember.type eq '관리자' }">
               				<div class="btn-group me-2">
				            	<button class="btn btn-sm" type="button" id="modifyCmtBtn${ status.count }" onclick="modifyComment(${ status.count })">수정</button>
				               	<button type="button" class="btn btn-sm" value="delete" onclick="deleteComment(${ status.count })">삭제</button>
				               	<form name="commentForm${ status.count }" method="post" id="commentForm${ status.count }">
									<input type="hidden" name="no" value="${ comment.no }">
									<input type="hidden" name="bdNo" value="${ board.no }">
									<input type="hidden" name="content" id="modifyCmtValue${ status.count }">
								</form>
               				</div>
               				</c:if>
        				</div>
        			</div>
        		</div>
        		</c:if>
        		</c:forEach>
        		<br>
        		<div class="comment-form">
        			<form id="insertCommentForm" method="post" action="${ pageContext.servletContext.contextPath }/board/insertComment">
        				<div class="form-group row">
        					<input type="hidden" value="${ board.no }" name="bdNo">
        					<div class="col-10">
        						<c:if test="${ !empty sessionScope.loginMember }">
        						<textarea rows="1" class="form-control" placeholder="댓글 입력" name="content"></textarea>
        						</c:if>
        						<c:if test="${ empty sessionScope.loginMember }">
        						<textarea rows="1" class="form-control" placeholder="로그인 후 이용해주세요." name="content"></textarea>
        						</c:if>
        					</div>
        					<div class="col-auto">
        						<!-- 로그인한 회원만 작성 가능 -->
        						<c:if test="${ !empty sessionScope.loginMember }">
        						<button type="submit" class="btn btn-block btn-primary" id="addComment">등록</button>
        						</c:if>
        						<c:if test="${ empty sessionScope.loginMember }">
        						<button type="button" class="btn btn-block btn-primary" id="addComment">등록</button>
        						</c:if>
        					</div>
        				</div>
        			</form>
        		</div>
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
	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script>
	    function updateBoard(no){
			location.href = "${ pageContext.servletContext.contextPath }/board/update?no="+no;
		}
	    
	    function deleteBoard(){
			if(confirm('이 게시글을 삭제하시겠습니까?')){
				document.forms.boardForm.action = "${ pageContext.servletContext.contextPath }/board/delete";
				document.forms.boardForm.submit();
			}
		}
	    
	    function deleteComment(num) {
	    	let form = document.getElementById('commentForm' + num);
	    	
	    	if(confirm('댓글을 삭제하시겠습니까?')) {
	    		form.action = "${ pageContext.servletContext.contextPath }/board/deleteComment";
	    		form.submit();
	    	}
	    }
	    
	    function modifyComment(num) {
			let contentView = document.getElementById('contentView' + num);
			let modifyCmtBtn = document.getElementById('modifyCmtBtn' + num);
			let modifyCmtValue = document.getElementById('modifyCmtValue' + num);
			let form = document.getElementById('commentForm' + num);
			
			let text = document.createElement('textarea');
			text.rows = '1';
			text.className = 'form-control';
			
			text.value = contentView.innerHTML;
			
			contentView.replaceWith(text);
			
			text.onkeydown = function(input) {
				if(input.key == 'Enter') {
					contentView.innerHTML = text.value;
					text.replaceWith(contentView);
					modifyCmtValue.value = text.value;
					
					form.action = "${ pageContext.servletContext.contextPath }/board/updateComment";
					form.submit();
				}
			};
		};
    </script>
</body>
</html>