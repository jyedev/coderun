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
            <jsp:include page="../common/sidebar.jsp"/>
            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <form action="${ pageContext.servletContext.contextPath }/admin/payment/list" method="GET">
                            <div class="input-group mb-4 border rounded-pill p-1">
                                <div class="input-group-prepend border-0">
                                <!-- button type=button->submit -->
                                <%-- <select id="Condition" name="searchCondition">
                                	<option value="id" ${ param.searchCondition == 'id' ? "selected" : "" }>아이디</option>
                                </select> --%>
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
                                    <th scope="col">결제일</th>
                                    <th scope="col">만료일</th>
                                    <th scope="col">금액</th>
                                </tr>
                                </thead>
                                <tbody>
                                <!-- c:forEach 추가!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->
                                    <c:forEach var="adminPayment" items="${ paymentList }">
                                    <tr>
                                        <td id="id">${ adminPayment.memberId }</td>
                                        <td id="date">${ adminPayment.date }</td>
                                        <td id="end">${ adminPayment.end }</td>
                                        <td id="price">${ adminPayment.price }</td>
                                    </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                            <br>
							<jsp:include page="../common/paging_payment.jsp"/>
                        </div>
                    </div>
                </main>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    </body>
</html>
