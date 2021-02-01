

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>   
<div class="row">
    <div class="col-3"></div>
    <div class="col-9"><h1>Overall Report for E-Commerce Business</h1></div>
</div>

<div class="container-fluid">
    <div class="container my-4">


        <p class="font-weight-bold"></p>

        <div class="row">

            <!-- Grid column -->
            <div class="container-fluid">

                <table id="myTable" class="display nowrap" style="width:100%">
                    <thead>
                        <tr class="table">

                            <th></th>
                            <th>Quantity</th>
                            <th>Total Price</th>
                            <th>Sales Price</th>
                            <th>Total Sales Price</th>
                            <th>Profit</th>

                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="st" items="${map.sList}">
                            <tr class="text-center">
                                <td></td>
                                <td class="bg-primary">${st.qty}</td>
                                <td class="bg-purple">${st.totalPrice}</td>
                                <td>${st.salesPrice}</td>
                                <td class="bg-light">${st.totalSales}</td>
                                <td class="bg-orange">${st.profit}</td>
                            </tr>
                        </c:forEach>
                        <tr class="text-center" >
                            <td colspan=""><strong>Total</strong></td>
                            <td>${map.totalQty}</td>
                            <td>${map.totalPrice}</td>
                            <td></td>
                            <td>${map.totalSalesPrice}</td>
                            <td>${map.profit}</td>
                        </tr>
                    </tbody>
                </table>

                <script>
                    $(document).ready(function () {
                        $('#myTable').DataTable({
                            "scrollX": true
                        });
                    });
                </script>

                <div class="col-xl-6">

                </div>
                <!-- Grid column -->

            </div>

        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>