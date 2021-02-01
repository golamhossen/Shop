<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/home/header.jsp"/>  
<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Wishlist</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!-- Wishlist Start -->
<div class="wishlist-page">
    <div class="container-fluid">
        <div class="wishlist-page-inner">
            <div class="row">
                <div class="col-md-12">
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Product</th>
                                    <th>Price</th>
                                    <th>Quantity</th>
                                    <th>Add to Cart</th>
                                    <th>Remove</th>
                                </tr>
                            </thead>
                            <tbody class="align-middle">
                                <c:forEach var="ban" items="${map.pList}">
                                    <tr>
                                        <td>
                                            <div class="img">
                                                <a href="#"><img src="/resources/home/img/${ban.photo}" alt="Image"></a>
                                                <p>${ban.pName}</p>
                                            </div>
                                        </td>
                                        <td>${ban.pPrice}</td>
                                        <td>
                                            <div class="qty">
                                                <input type="number" value="1">
                                            </div>
                                        </td>
                                        <td><button class="btn-cart">Add to Cart</button></td>
                                        <td><button><i class="fa fa-trash"></i></button></td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Wishlist End -->
<jsp:include page="/WEB-INF/jsp/common/home/footer.jsp"/>  