<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/home/header.jsp"/>    
<!--
 Bottom Bar Start 
<div class="bottom-bar">
    <div class="container-fluid">
        <div class="row align-items-center">
            <div class="col-md-3">
                <div class="logo">
                    <a href="">
                        <img src="/resources/home/img/logo.png" alt="Logo">
                    </a>
                </div>
            </div>
            <div class="col-md-6">
                <div class="search">
                    <input type="text" placeholder="Search">
                    <button><i class="fa fa-search"></i></button>
                </div>
            </div>
            <div class="col-md-3">
                <div class="user">
                    <a href="/wishlist" class="btn wishlist">
                        <i class="fa fa-heart"></i>
                        <span>(0)</span>
                    </a>
                    <a href="/cart" class="btn cart">
                        <i class="fa fa-shopping-cart"></i>
                        <span>(${map.count})</span>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
 Bottom Bar End -->

<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Cart</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->

<!--<div class="col-md-10">
    <table class="table" border="1" width="45" cellspacing="1">
        <thead>
            <tr class="table">
                <th>Id</th>
                <th>Product Id</th>
                <th>Product Name</th>
                <th>Product Code</th>
                <th>Specification</th>
                <th>Description</th>
                <th>Price</th>
                <th>Product Photo</th>



            </tr>
        </thead>
        <tbody>
<c:forEach var="pp" items="${map.pList}">
    <tr >
        <td>${pp.kid}</td>
        <td>${pp.pid}</td>
        <td>${pp.pName}</td>
        <td>${pp.pCode}</td>
        <td>${pp.sp}</td>
        <td>${pp.des}</td>
        <td>${pp.pPrice}</td>
        <td>${pp.photo}</td>
        <td> 
            <img src="/resources/home/img/${pp.photo}" alt="photo"/>
        </td>
    </tr>
</c:forEach>
</tbody>
</table>
</div>-->

<!-- Cart Start -->
<div class="cart-page">
    <form method="post" action="/orders/save">
        <div class="container-fluid">
            <div class="row table-responsive">
                <div class="col-lg-8">
                    <div class="cart-page-inner">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="basket">
                                <thead class="thead-dark">
                                    <tr>
                                        <th>Product</th>                                   
                                        <th>Price</th>
                                        <th>Quantity</th>
                                        <th>Discount</th>
                                        <th>Total</th>
                                        <th>Remove</th>
                                    </tr>
                                </thead>
                                <tbody class="align-middle">
                                    <c:forEach var="ban" items="${map.pList}">
                                        <tr>
                                            <td>
                                                <div class="img">
                                                    <img src="/resources/home/img/${ban.photo}" alt="photo"/>
                                                    <p>${ban.pName}</p>

                                                </div>
                                            </td>
                                            <td>${ban.pPrice}</td>
                                            <td>

                                                <input id="qty" class="p-qty" name="qty[]" type="number" value="1"  onchange="change(this)">

                                            </td>
                                            <td>${ban.discount}</td>
                                            <td><input type="text" value="${ban.total}" class="in-total" id="inTotal" disabled=""/></td>

                                            <td><button><i class="fa fa-trash"></i></button></td>
                                            <td>
                                                <input type="hidden" name="kid[]" value="${ban.kid}"/>
                                                <input type="hidden" name="pid[]" value="${ban.pid}"/>
                                                <input type="hidden" name="photo[]" value="${ban.photo}"/>
                                                <input type="hidden" name="pName[]" value="${ban.pName}"/>
                                                <input type="hidden" name="pCode[]" value="${ban.pCode}"/>                                               
<!--                                                <input type="text" name="sp[]" value="${ban.sp}"/>
                                                <input type="text" name="des[]" value="${ban.des}"/>-->
                                                <input type="hidden" name="pPrice[]" class="p-price" value="${ban.pPrice}"/>
                                                <input type="hidden" name="discount[]" class="p-discount" value="${ban.discount}"/>
                                                <input type="hidden" name="total[]" id="total" class="p-total" value="${ban.total}"/>
                                                <input type="hidden" name="cid[]" value="${ban.cid}"/>
                                                <input type="hidden" name="cid" value="${ban.cid}"/>

                                            </td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                                <tfoot>
                                    <tr>
                                        <th colspan="4">Subtotal</th>
                                        <th colspan="1">

                                            <label class="lblTotal" id="lblTotal">
                                                0
                                            </label>
                                        </th>
                                        <th colspan="1"></th>
                                    </tr>

                                </tfoot>
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
                                        <input type="hidden" name="subTotal" class="sub-total"/>
                                        <input type="hidden" name="vat" value="5"/>
                                        <input type="hidden" name="dCharge" value="150" id="dCharge"/>
                                        <input type="hidden" name="grandTotal" class="grand-total"/>
                                        <h1>Cart Summary</h1>
                                        <h2>Sub Total<span><p id="subTotal"></p></span></h2>
                                        <h2>Vat<span><p id="vat">5%</span></p></h2>
                                        <h2>Shipping Cost<span><p id="dCharge">150</span></p></h2>

                                        <h2>Grand Total<span><p id="grandTotal"></span></p></h2>
                                    </div>
                                    <div class="cart-btn">
                                        <button onclick="valid()" type="submit" class="btn btn-primary">Proceed to checkout <i class="fa fa-chevron-right"></i></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    <button class="btn btn-outline-secondary"><a href="/checkout/create">Update cart</a></button>

</div>
<!-- Cart End -->



<!-- Footer Start -->
<script>
    function change(el) {
        var pName = $(el).closest("tr").find(".p-name").val();
        var pPrice = $(el).closest("tr").find(".p-price").val();
        var pQty = $(el).closest("tr").find(".p-qty").val();
        var pDiscount = $(el).closest("tr").find(".p-discount").val();
        var total = parseFloat(parseFloat(pPrice) * parseInt(pQty));
        var pTotal = (total - (parseFloat(parseInt(pDiscount) * total) / 100));
        $(el).closest("tr").find(".p-total").val(pTotal);
        $(el).closest("tr").find(".in-total").val(pTotal);
        calcTotal();

        //After working
        var lblTotal = $("#lblTotal").text();
        $("#sub").text(lblTotal);
        var vat = parseFloat(lblTotal) * 0.05;
        var grandToatal = parseInt(lblTotal) + vat;
        console.log(grandToatal);
        $("#grandTotal").text(grandToatal);
        $(".grand-total").val(grandToatal);
        $(".sub-total").val(lblTotal);



    }


    var sum = 0;
    function calcTotal() {
        sum = 0;
        $('#basket tbody tr').each(function () {
            $(this).find('.p-total').each(function () {
                var combat = parseFloat($(this).val());
                calc(combat);
            });
            $("#lblTotal").text(sum);
            //After working
            var lblTotal = $("#lblTotal").text();
            $("#sub").text(lblTotal);
            var vat = parseFloat(lblTotal) * 0.05;
            var grandToatal = parseFloat(lblTotal) + vat;
            console.log(grandToatal);
            $("#grandTotal").text(grandToatal);
            $("#subTotal").text(lblTotal);

            $(".grand-total").val(grandToatal);
            $(".sub-total").val(lblTotal);

        });

    }
    function calc(a) {
        sum += a;
        console.log(sum)
    }

    calcTotal();
</script>

<script>
           function valid(){
               var rand =( Math.floor(Math.random() * 100) +1);
               alert(rand);
               
               var pro = prompt("Enter your OTP Number");
               
               if(rand == pro){
                   alert("Your Order is Ready");
               }else{
                   alert("Your Order is Ready");
               }
           }
       </script>
<jsp:include page="/WEB-INF/jsp/common/home/footer.jsp"/>    

