<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/mDash/header.jsp"/>      

<h1 class="text-center">View Merchant Stock</h1> <br>
<div class="container-fluid">
    <div class="row">
        <!--        <div class="col-md-2">
        
                </div>-->
        <div class="col-md-12">
            <table class="table" border="1" width="45" cellspacing="1">
                <thead>
                    <tr class="table">
                        <th>Id</th>
                        <th>Product Id</th>
                        <th>Product Name</th>
                        <th>Product Code</th>
                        <th>Product Price</th>
                        <th>Quantity</th>
                        <th>Total Price</th>
                        <th>Sales Price</th>
                        <th>Total Sales Price</th>
                        <th>Profit</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="st" items="${map.s2List}">
                        <tr class="text-center">
                            <td>${st.id}</td>
                            <td>${st.pid}</td>
                            <td>${st.pName}</td>
                            <td>${st.pCode}</td>
                            <td>${st.pPrice}</td>
                            <td class="bg-purple">${st.qty}</td>
                            <td>${st.totalPrice}</td>
                            <td>${st.salesPrice}</td>
                            <td class="bg-orange">${st.totalSales}</td>
                            <td class="bg-primary">${st.profit}</td>
                        </tr>
                    </c:forEach>
                        <tr class="text-center" >
                        <td colspan="5"><strong>Total</strong></td>
                        <td>${map.totalQty}</td>
                        <td>${map.totalPrice}</td>
                        <td></td>
                        <td>${map.totalSalesPrice}</td>
                        <td>${map.profit}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

