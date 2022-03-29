<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <button class="btn btn-sm" type="button" onclick="updateBoard(${ board.no })">수정</button>
                <button type="button" class="btn btn-sm" value="delete" onclick="deleteBoard()">삭제</button>
                <form name="boardForm" method="post">
					<input type="hidden" name="no" value="${ board.no }">
				</form>
            </div>
        </div>
        <br><br><br>
        <div class="commentbox mx-auto border-top">
            <div class="commenttitle">
                <br>
                <h5>댓글</h5>
            </div>
            <br><br>
            <div class="commentbody">
                        <div class="icon-box">
                            <table>
                            <tr>
                            <td class="userprofile"><img id="profilepic" src="${ pageContext.servletContext.contextPath }/resources/img/community-profile4.jpeg">갱얼쥐가세상을구함</td>
                            <td width="10%" id="comment-day">2022.03.27</td>
                            </tr>
                            </table>
                        </div>
                        <div class="commentwrapping">
                            <p class="text-box mx-auto">멍멍왈왈밥주세요산책가요개껌줘내놔노즈워크고고</p>
                            <div class="btn-toolbar">
                                <div class="btn-group me-2">
                                  <!--  button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#modal">수정</button>
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
                                  <button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#deletecheck">삭제</button>
                                    <div class="modal" id="deletecheck" tabindex="-1">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-body">
                                                    <div class="mb-3">
                                                    삭제가 완료되었습니다.
                                                    </div>
                                                </div>
                                                <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">확인</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div-->
                                </div>
                            </div>
                        </div>                                 
            </div>
            <br><br>
            <!--div class="commentbody">
                <div class="icon-box">
                    <table>
                    <tr>
                    <td class="userprofile"><img id="profilepic" src="${ pageContext.servletContext.contextPath }/resources/img/커뮤니티 프로필3.jpeg">야옹이가세상을구함</td>
                    <td width="10%" id="comment-day">2022.03.27</td>
                    </tr>
                    </table>
                </div>
                <div class="commentwrapping">
                    <p class="text-box mx-auto">야옹야옹하삼이네놀러간다</p>
                    <div class="btn-toolbar">
                        <div class="btn-group me-2">
                            <button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#reportmodal">신고</button>
                            <div class="modal" id="reportmodal" tabindex="-1">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title">신고</h5>
                                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="mb-3">
                                                사유를 선택해 주세요.
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">
                                                    <label class="form-check-label" for="exampleRadios1">
                                                        스팸홍보/도배글입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                                                    <label class="form-check-label" for="exampleRadios2">
                                                        음란물입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3">
                                                    <label class="form-check-label" for="exampleRadios3">
                                                        불법 정보를 포함하고 있습니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios4" value="option4">
                                                    <label class="form-check-label" for="exampleRadios4">
                                                        욕설/생명경시/혐오/차별적 표현입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios5" value="option5">
                                                    <label class="form-check-label" for="exampleRadios5">
                                                        개인정보 노출 게시물입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios6" value="option6">
                                                    <label class="form-check-label" for="exampleRadios6">
                                                        불쾌한 표현이 있습니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios7" value="option7">
                                                    <label class="form-check-label" for="exampleRadios7">
                                                        명예훼손/저작권 침해 게시물입니다.
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                                        <button type="button" class="btn btn-primary">완료</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                                    
            </div-->
            <br><br>
            <!--div class="commentbody">
                <div class="icon-box">
                    <table>
                    <tr>
                    <td class="userprofile"><img id="profilepic" src="${ pageContext.servletContext.contextPath }/resources/img/커뮤니티 프로필2.jpeg">악플러다</td>
                    <td width="10%" id="comment-day">2022.03.27</td>
                    </tr>
                    </table>
                </div>
                <div class="commentwrapping">
                    <p class="text-box mx-auto">즐KIN</p>
                    <div class="btn-toolbar">
                        <div class="btn-group me-2">
                            <button type="button" class="btn btn-sm" data-bs-toggle="modal" data-bs-target="#reportmodal">신고</button>
                            <div class="modal" id="reportmodal" tabindex="-1">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                        <h5 class="modal-title">신고</h5>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="mb-3">
                                                사유를 선택해 주세요.
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios1" value="option1">
                                                    <label class="form-check-label" for="exampleRadios1">
                                                    스팸홍보/도배글입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios2" value="option2">
                                                    <label class="form-check-label" for="exampleRadios2">
                                                    음란물입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios3" value="option3">
                                                    <label class="form-check-label" for="exampleRadios3">
                                                    불법 정보를 포함하고 있습니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios4" value="option4">
                                                    <label class="form-check-label" for="exampleRadios4">
                                                    욕설/생명경시/혐오/차별적 표현입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios5" value="option5">
                                                    <label class="form-check-label" for="exampleRadios5">
                                                    개인정보 노출 게시물입니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios6" value="option6">
                                                    <label class="form-check-label" for="exampleRadios6">
                                                    불쾌한 표현이 있습니다.
                                                    </label>
                                                </div>
                                                <div class="form-check">
                                                    <input class="form-check-input" type="radio" name="exampleRadios" id="exampleRadios7" value="option7">
                                                    <label class="form-check-label" for="exampleRadios7">
                                                    명예훼손/저작권 침해 게시물입니다.
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                                        <button type="button" class="btn btn-primary">완료</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>                                    
            </div>
        </div-->
        <br><br>
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
    </section>

    <footer class="footer py-4 bg-light">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-12 text-lg-end">Copyright &copy; CODERUN 2022</div>
          </div>
        </div>
    </footer>
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