<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="icon" type="image/x-icon" href="${ pageContext.servletContext.contextPath }/resources/img/favicon.png" />
        <title>CODERUN</title>
        <link href="${ pageContext.servletContext.contextPath }/resources/css/admin-style.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    </head>
    <body class="sb-nav-fixed">
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div class="sb-sidenav-menu">
                        <div class="nav">
                            <a class="navbar-brand" href="${ pageContext.servletContext.contextPath }"><img src="${ pageContext.servletContext.contextPath }/resources/img/logo.png" alt="..." style="width: 190px; margin-left: 10px;"/></a>
                            <br><br>
                            <a class="nav-link collapsed" href="${ pageContext.servletContext.contextPath }/admin/dashboard">
                                대시보드
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <a class="nav-link collapsed" href="${ pageContext.servletContext.contextPath }/admin/member/list">
                                회원 정보 조회
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <a class="nav-link collapsed" href="/관리자/관리자 멘토 관리.html">
                                멘토 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <a class="nav-link collapsed" href="${ pageContext.servletContext.contextPath }/admin/payment/list">
                                결제 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <a class="nav-link collapsed" href="/관리자/관리자 게시글 목록.html">
                                게시판 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <a class="nav-link collapsed" href="${ pageContext.servletContext.contextPath }/admin/calculation/list">
                                정산 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                            <a class="nav-link collapsed" href="/관리자/관리자 신고 관리.html">
                                신고 관리
                                <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                            </a>
                        </div>
                    </div>
                    <div class="sb-sidenav-footer">
                        <div class="dropdown">
                            <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                              <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
                              <strong>관리자</strong>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                            <!-- 로그아웃 클릭 시 메인페이지 이동 + 로그아웃 상태 변경.!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                              <li><a class="dropdown-item" href="${ pageContext.servletContext.contextPath }/member/logout">Sign out</a></li>
                            </ul>
                          </div>
                    </div>
                </nav>
            </div>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <form action="${ pageContext.servletContext.contextPath }/admin/calculation/list" method="GET">
                            <div class="input-group mb-4 border rounded-pill p-1">
                                <div class="input-group-prepend border-0">
                                <!-- button type=button->submit -->
                                <button id="button-addon4" type="submit" class="btn btn-link text-warning"><i class="fa fa-search"></i></button>
                                </div> 
                               <input type="search" placeholder="검색" aria-describedby="button-addon4" class="form-control bg-none border-0" style="margin-right: 20px;"
                                name="searchValue"	value="${ param.searchValue }">
                            </div> 
                        </form>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th scope="col">아이디</th>
                                    <th scope="col">정산 단위</th>
                                    <th scope="col">기여도</th>
                                    <th scope="col">금액</th>
                                    <!-- <th scope="col">정산 상태</th> -->
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="adminCalculation" items="${ calculationList }">
                                    <tr>
                                        <td id="id">${ adminCalculation.memberId }</td>
                                        <td id="period">${ adminCalculation.period }</td>
                                        <td id="percent">${ adminCalculation.percent }</td>
                                        <td id="amount">${ adminCalculation.amount }</td>
                                        <!-- <td id="status">${ adminCalculation.status }</td> -->
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <br>
							<jsp:include page="../common/paging.jsp"/>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    </body>
</html>
