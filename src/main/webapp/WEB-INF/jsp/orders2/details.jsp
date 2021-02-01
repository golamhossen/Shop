<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/mDash/header.jsp"/>
<div class="dashboard-wrapper">
    <div class="container-fluid  dashboard-content">
        <div class="row">
            <!-- ============================================================== -->
            <!-- data table  -->
            <!-- ============================================================== -->
            <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
                <div class="card">
                    <div class="card-header">
                        <h1 class="text-center">Recent Orders</h1>

                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table  id="orders" class="table table-striped table-bordered second" style="width:100%">
                                <thead>
                                    <tr>

                                        <th>Order Date</th>
                                        <th>Order No.</th>


                                        <th>Order Status</th>
                                        <th>Product Details</th>
                                        <th>Address</th>
                                        <th>Invoice</th>
                                        <th>Payment Status</th>
                                        <th>Confirm Order</th>
                                        <th>Cancel</th>




                                    </tr>
                                </thead>
                                <tbody>

                                    <c:forEach var="p" items="${map.inList}">
                                        <tr>
                                    <input type="hidden" name="orderNo" value="${p.orderNo}"/>

                                    <td>${p.orderDate}</td>
                                    <td>${p.orderNo}</td>

                                    <td class="status">New</td>
                                    <td><a href="/orders/pDetails/${p.orderNo}"><button onclick="change(this)" class="btn btn-primary">Products</button></a></td>
                                    <td><a href="/address/address/${p.cid}"><button class="btn btn-primary">Address</button></a></td>
                                    <td><a href="/orders/invoice/${p.orderNo}"><button class="btn btn-primary">invoice</button></a></td>
                                    <td><a href="/orders/payment/${p.cid}"><button class="btn btn-primary">Payment Status</button></a></td>
                                    <td><a href="/orders/confirm/${p.orderNo}"><button class="btn btn-primary">Confirm Order</button></a></td>
                                    <td><a href="/orders/deleteByOrderNo/${p.orderNo}"><button class="btn btn-primary">Cancel</button></a></td>

                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                    <tr>

                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ============================================================== -->
            <!-- end data table  -->
            <!-- ============================================================== -->
        </div>

    </div>
</div>
</body>
</html>
