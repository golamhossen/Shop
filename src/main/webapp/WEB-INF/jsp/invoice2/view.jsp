<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/mDash/header.jsp"/>     

<h1 class="text-center">Total Invoice Report</h1> <br>
<div class="container-fluid">
    <div class="row">
        <!--        <div class="col-md-2">
        
                </div>-->
        <div class="col-md-12">
            <table class="table" border="1" width="45" cellspacing="1">
                <thead>
                    <tr class="table">
                        <th>Id</th>
                        <th>Sub Total</th>
                        <th>Vat</th>
                        <th>Shipping Cost</th>
                        <th>Grand Total</th>
                        <th>Order No</th>
                        <th>Order Date</th>                        

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="st" items="${map.inList}">
                        <tr >
                            <td>${st.id}</td>
                            <td>${st.subTotal}</td>
                            <td>${st.vat}</td>
                            <td>${st.dCharge}</td>
                            <td>${st.grandTotal}</td>
                            <td>${st.orderNo}</td>
                            <td>${st.orderDate}</td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!--        <div class="col-md-2">
        
                </div>-->
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

