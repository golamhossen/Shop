<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/> 
<!-- Bottom Bar Start -->


<div class="cart-page">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="cart-page-inner">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                                <c:forEach var="pp" items="${map.pList}">
                                    <tr>
                                        <td><div class="name">${pp.name}</div></td>
                                        <td>${pp.price}</td>
                                        <td>
                                            <div class="qty">
                                                <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                <input type="text" value="${pp.qty}">
                                                <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </td>
                                        <td>${pp.totalPrice}</td>
                                        <td><button><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="cart-page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="coupon">
                                <input type="text" placeholder="Coupon Code">
                                <button>Apply Code</button>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="cart-summary">
                                <div class="cart-content">
                                    <h1>Cart Summary</h1>
                                    <p>Sub Total<span>$99</span></p>
                                    <p>Shipping Cost<span>$1</span></p>
                                    <h2>Grand Total<span>$100</span></h2>
                                </div>
                                <div class="cart-btn">
                                    <button>Update Cart</button>
                                    <button><a href="/checkout">Checkout</a></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bottom Bar End -->

<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">

        </div>
        <div class="col-md-10">
            <table class="table" border="1" width="45" cellspacing="1">
                <thead>
                    <tr class="table">
                        <th>Id</th>
                        <th>Product Id</th>
                        <th>Product Name</th>
                        <th>Product Code</th>
                        <th>Product Price</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Vat</th>
                        <th>Total Price</th>

                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="st" items="${map.pList}">
                        <tr >
                            <td>${st.id}</td>
                            <td>${st.pid}</td>
                            <td>${st.pName}</td>
                            <td>${st.pCode}</td>
                            <td>${st.pPrice}</td>
                            <td>${st.price}</td>
                            <td>${st.qty}</td>
                            <td>${st.vat}</td>
                            <td>${st.totalPrice}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<!-- Breadcrumb Start -->


<!--<div class="col-md-10">
    <table class="table" border="1" width="45" cellspacing="1">
        <thead>
            <tr class="table">
                <th>Id</th>
                <th>Product Name</th>
                <th>Product Code</th>
                <th>Category Id</th>
                <th>Category Name</th>
                <th>Specification</th>
                <th>Description</th>
                <th>Price</th>


            </tr>
        </thead>
        <tbody>
<c:forEach var="pp" items="${map.pList}">
    <tr >
        <td>${pp.id}</td>
        <td>${pp.name}</td>
        <td>${pp.code}</td>
        <td>${pp.cid}</td>
        <td>${pp.cname}</td>
        <td>${pp.sp}</td>
        <td>${pp.des}</td>
        <td>${pp.price}</td>
        <td> 
            <img src="/resources/home/img/${pp.photo}" alt="photo"/>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>-->



<div class="cart-page">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-8">
                <div class="cart-page-inner">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Total</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                                <c:forEach var="pp" items="${map.pList}">
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <img src="/resources/home/img/${pp.photo}" alt="files"/>
                                                <p>${pp.name}</p>
                                            </div>
                                        </td>
                                        <td>${pp.price}</td>
                                        <td>
                                            <div class="qty">
                                                <button class="btn-minus"><i class="fa fa-minus"></i></button>
                                                <input type="text" value="1">
                                                <button class="btn-plus"><i class="fa fa-plus"></i></button>
                                            </div>
                                        </td>
                                        <td>${pp.code}</td>
                                        <td><button><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                </c:forEach>
                               
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-4">
                <div class="cart-page-inner">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="coupon">
                                <input type="text" placeholder="Coupon Code">
                                <button>Apply Code</button>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="cart-summary">
                                <div class="cart-content">
                                    <h1>Cart Summary</h1>
                                    <p>Sub Total<span>$99</span></p>
                                    <p>Shipping Cost<span>$1</span></p>
                                    <h2>Grand Total<span>$100</span></h2>
                                </div>
                                <div class="cart-btn">
                                    <button>Update Cart</button>
                                    <button><a href="/checkout">Checkout</a></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
