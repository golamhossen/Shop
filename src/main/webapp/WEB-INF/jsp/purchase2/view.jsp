<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/mDash/header.jsp"/>     

<h1 class="text-center">View Purchase</h1> <br>
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
                        <th>Category Id</th>
                        <th>Category Name</th>
                        <th>Product Description</th>
                        <th>Product Photo</th>
                        <th>Product Price</th>
                        <th>Product Quantity</th>
                        <th>Total</th>
                        <th>Vat</th>
                        <th>Grand Total</th>
                        <th>Cost Per Product</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="st" items="${map.pList}">
                        <tr >
                            <td>${st.id}</td>
                            <td>${st.pid}</td>
                            <td>${st.pName}</td>
                            <td>${st.pCode}</td>
                            <td>${st.cid}</td>
                            <td>${st.cname}</td>
                            <td>${st.pDes}</td>
                            <td><div class="img">
                                    <img src="/resources/home/img/${st.photo}" alt="photo" width="100px" height="100px"/>
                                </div></td>                                    
                            <td>${st.price}</td>
                            <td>${st.qty}</td>
                            <td>${st.total}</td>
                            <td>${st.vat}</td>
                            <td>${st.grandTotal}</td>
                            <td>${st.costPerProduct}</td>
                        </tr>
                    </c:forEach>
                    <tr class="text-center" >
                        <td colspan="9" class="bg-light"><strong>Total</strong></td>
                        <td class="bg-purple">${map.totalQty}</td>
                        <td class="bg-primary">${map.total}</td>
                        <td class="bg-light"></td>
                        <td class="bg-orange">${map.totalGrandTotal}</td>
                        <td class="bg-light"></td>
                    </tr>
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

