<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/merchant/header.jsp"/>    

<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item"><a href="#">Products</a></li>
            <li class="breadcrumb-item active">Cart2</li>
        </ul>
    </div>
</div>
<!-- Breadcrumb End -->



<!-- Cart Start -->
<div class="cart-page">
    
        <div class="container-fluid">
            <div class="row table-responsive">
                <div class="col-lg-8">
                    <form method="post" action="/orders2/save">
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
                                    <c:forEach var="g" items="${map.gList}">
                                        <tr>
                                            <td>
                                                <div class="img">
                                                    <img src="/resources/home/img/${g.photo}" alt="photo"/>
                                                    <p>${g.pName}</p>

                                                </div>
                                            </td>
                                            <td>${g.pPrice}</td>
                                            <td>

                                                <input id="qty" class="p-qty" name="qty[]" type="number" value="1"  onchange="change(this)">

                                            </td>
                                            <td>${g.discount}</td>
                                            <td><input type="text" value="${g.total}" class="in-total" id="inTotal" disabled=""/></td>

                                            <td><button><i class="fa fa-trash"></i></button></td>
                                            <td>
                                                <input type="hidden" name="gid[]" value="${g.gid}"/>
                                                <input type="hidden" name="pid[]" value="${g.pid}"/>
                                                <input type="hidden" name="photo[]" value="${g.photo}"/>
                                                <input type="hidden" name="pName[]" value="${g.pName}"/>
                                                <input type="hidden" name="pCode[]" value="${g.pCode}"/>                                               
<!--                                                <input type="text" name="sp[]" value="${g.sp}"/>
                                                <input type="text" name="des[]" value="${g.des}"/>-->
                                                <input type="hidden" name="pPrice[]" class="p-price" value="${g.pPrice}"/>
                                                <input type="hidden" name="discount[]" class="p-discount" value="${g.discount}"/>
                                                <input type="hidden" name="total[]" id="total" class="p-total" value="${g.total}"/>
                                                <input type="hidden" name="cid[]" value="${g.cid}"/>
                                                <input type="hidden" name="cid" value="${g.cid}"/>


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
                         </form>
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
                                        <button class="btn btn-outline-secondary"><a href="/goods/view">Update Cart</a></button>
                                         <button class="btn btn-outline-secondary"><a href="/checkout2/create">Checkout</a></button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
   
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

<jsp:include page="/WEB-INF/jsp/common/home/footer.jsp"/>    

