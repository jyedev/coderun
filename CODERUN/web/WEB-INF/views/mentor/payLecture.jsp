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
    <link href="${ pageContext.servletContext.contextPath }/resources/css/style.css" rel="stylesheet" />
</head>
<body>
	<script>
		(function(){
			const payResult = "${ requestScope.payResult }";
			if(payResult == "success"){
			alert('결제되었습니다.');
			} else if(payResult == "fail"){
			alert('결제 정보 저장에 실패했습니다.');
			}
		})();
	</script>
    <jsp:include page="../common/menubar.jsp"/>
    <section class="page-section bg" id="pay-lecture" style="width: 1000px; margin: 0 auto;">
        <div class="container">
            <br><br>
            <h4>프리패스 구매 정보</h4>
            <br>
            <div class="mb-3 row">
                <label class="col-md-1 col-form-label">가격</label>
                <div class="col-md-11">
                    <input type="text" readonly class="form-control-plaintext" id="price" value="100,000원">
                </div>
            </div>
            <br>
            <h5>코드런 프리패스를 구매해 주셔서 감사합니다</h5>
            <br>
            <hr>
            <br>
            <div class="d-grid col-2 mx-auto">
                <button class="btn btn-primary" id="payBtn" onclick="requestPay()">결제하기</button>
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
    <script>
    	var IMP = window.IMP;
    	IMT.init("imp23105038");
    
    	function requestPay() {
    		IMP.init('imp23105038');
    		IMP.request_pay({
    			pg: "inicis",
    			pay_method: "card",
    			merchant_uid : 'merchant_' + new Date().getTime(),
    			name: '결제 테스트',
    			// 임의로 가격 조정
    			amount: 10
    		}, function (rsp) {
    			if(rsp.success) {
    				alert("결제되었습니다.");
    				location.href = "${ pageContext.servletContext.contextPath }/mentor/paySuccess";
    			} else {
    				alert("결제 실패했습니다.");
    				location.href = "${ pageContext.servletContext.contextPath }";
    			}
    		});
    	}
    </script>
    <!-- jQuery -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<!-- iamport.payment.js -->
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>