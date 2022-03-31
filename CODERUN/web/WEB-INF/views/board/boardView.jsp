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
	<jsp:include page="../common/menubar.jsp"/>
	<section>
		<div class="blog-page mx-auto">
			<br>
			<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
           		
           		<!-- 게시글 제목 들어가는 곳 -->
           		<h1 class="h2" width="30%">${ board.title }</h1>
           		
          		<div class="writer-info">
           			<input type="hidden" value=${ board.no }>
           			<span>${ board.writerId }</span>
           			<!-- 게시글 작성일이나 수정일 들어가는 곳 -->
           				<c:if test="${ empty board.update }">
           				<span id="board-day">${ board.date }</span>
           				</c:if>
						<c:if test="${ !empty board.update }">
						<span id="board-day">${ board.update }</span>
						</c:if>
          		</div>
          		
       		</div>
		       		
		       	<!-- 게시글 내용 들어가는 곳 -->
		       	<div class="writebox">
		       		${ board.content }
		       	</div>
		       	
		       	<div class="btn-toolbar">
	       			<!-- 게시글 작성자만 수정, 삭제 가능 -->
	       			<c:if test="${ board.writerId == sessionScope.loginMember.id or sessionScope.loginMember.id eq 'admin001'}">
	       			<div class="btn-group me-2">
	            	<button class="btn btn-sm" type="button" onclick="updateBoard(${ board.no })">수정</button>
	               	<button type="button" class="btn btn-sm" value="delete" onclick="deleteBoard()">삭제</button>
	               	</div>
					</c:if>
					<!-- 게시글 작성자 아니면 신고 -->
       				<c:if test="${ board.writerId != sessionScope.loginMember.id or sessionScope.loginMember.id eq 'admin001'}">
       				<div class="btn-group me-2">
       					<button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#reportModal">신고</button>
       				</div>
       				</c:if>
       				
	               	<form name="boardForm" method="post">
						<input type="hidden" name="no" value="${ board.no }">
					</form>
				</div>
        </div>
       	
       	<br><br><br>
       	<div class="commentbox mx-auto border-top">
       		<div class="commenttitle"><br><h5>댓글</h5></div>
           		<br><br>
           		<!-- 댓글 -->
           		<c:forEach var="comment" items="${ board.commentList }">
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
						            <img id="profilepic" src="${ pageContext.servletContext.contextPath }${ mentor.member.image.root }/${ mentor.member.image.edit }">${ comment.writerId }
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
               			<p class="text-box mx-auto">${ comment.content }</p>
               			<div class="btn-toolbar">
               				<!-- 댓글 작성자만 수정, 삭제 가능 -->
               				<c:if test="${ comment.writerId == sessionScope.loginMember.id or sessionScope.loginMember.id eq 'admin001' }">
               				<div class="btn-group me-2">
               					<button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#modal">수정</button>
               					<button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#deletecheck">삭제</button>
               				</div>
               				</c:if>
               				<!-- 댓글 작성자 아니면 신고 -->
               				<c:if test="${ comment.writerId != sessionScope.loginMember.id or sessionScope.loginMember.id eq 'admin001'  }">
               				<div class="btn-group me-2">
               					<button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#reportModal">신고</button>
               				</div>
               				</c:if>
        				</div>
        			</div>
        		</div>
        		</c:if>
        		</c:forEach>
        		<div class="comment-form">
        			<form>
        				<div class="form-group">
        					<textarea rows="1" class="form-control" placeholder="댓글 입력"></textarea>
        				</div>
        				<br>
        				<button type="submit" class="btn btn-block btn-primary">등록</button>
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
    
    <!-- 댓글 수정 모달 -->
	<div class="modal" id="modal" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">댓글 수정</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
                <div class="modal-body">
                    <div class="mb-3">
                    	<textarea class="form-control" id="message-text"></textarea>
                   	</div>
                </div>
                <div class="modal-footer">
                	<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                	<button type="button" class="btn btn-primary">등록</button>
                </div>
			</div>
		</div>
	</div>
	
	<!-- 삭제 모달 -->
	<div class="modal" id="deletecheck" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<div class="mb-3">삭제가 완료되었습니다.</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- 신고 모달 -->
	<div class="modal" id="reportModal" tabindex="-1">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">신고</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                
               	<form name=form id="reportContent" method=post action="${ pageContext.servletContext.contextPath }/report/insert">
               		<div class="modal-body">
                    <div class="mb-3">
                        사유를 선택해 주세요.
                        <input type="hidden" value=${ report.memberId }>
                        <input type="hidden" value=${ report.bdNo }>
                        <input type="hidden" value=${ report.cmtNo }>
                        <br>
                        <br>
                        <input class="form-check-input" type="radio" name="typeNo" id="exampleRadios1" value="1">
                        <label class="form-check-label" for="exampleRadios1">
                            스팸홍보/도배글입니다.
                        </label>
                   		<br>
                        <input class="form-check-input" type="radio" name="typeNo" id="exampleRadios2" value="2">
                        <label class="form-check-label" for="exampleRadios2">
                            음란물입니다.
                        </label>
                   		<br>
                        <input class="form-check-input" type="radio" name="typeNo" id="exampleRadios3" value="3">
                        <label class="form-check-label" for="exampleRadios3">
                            불법 정보를 포함하고 있습니다.
                        </label>
                  		<br>
                        <input class="form-check-input" type="radio" name="typeNo" id="exampleRadios4" value="4">
                        <label class="form-check-label" for="exampleRadios4">
                            욕설/생명경시/혐오/차별적 표현입니다.
                        </label>
                  		<br>
                        <input class="form-check-input" type="radio" name="typeNo" id="exampleRadios5" value="5">
                        <label class="form-check-label" for="exampleRadios5">
                            개인정보 노출 게시물입니다.
                        </label>
                   		<br>
                        <input class="form-check-input" type="radio" name="typeNo" id="exampleRadios6" value="6">
                        <label class="form-check-label" for="exampleRadios6">
                            불쾌한 표현이 있습니다.
                        </label>
                   		<br>
                        <input class="form-check-input" type="radio" name="typeNo" id="exampleRadios7" value="7">
                        <label class="form-check-label" for="exampleRadios7">
                            명예훼손/저작권 침해 게시물입니다.
                        </label>
                    </div>
                    <div class="modal-footer">
		                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		                <input type="submit" class="btn btn-primary" onclick="clickModify(reportContent)" value="완료">
		            </div>
		            
		     		</div>
		     	</form>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
   	<script>
	    function updateBoard(no){
			location.href = "${ pageContext.servletContext.contextPath }/board/update?no="+no;
		}	function deleteBoard(){
			if(confirm('이 게시글을 삭제하시겠습니까?')){
				document.forms.boardForm.action = "${ pageContext.servletContext.contextPath }/board/delete";
				document.forms.boardForm.submit();
			}
		}
    </script>
   	
</body>
</html>