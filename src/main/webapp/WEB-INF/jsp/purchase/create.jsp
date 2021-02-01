<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>   
<h1 class="text-center">Create Purchase</h1> <br>
<div class="row ml-auto">
    <div class="col-md-2"></div>
    <div class="col-md-8  ">
        <div class="section-block" id="basicform">
            <h3 class="section-title text-center">Purchase</h3>
        </div>
        <div class="card">
            <div class="card-header">

            </div>
            <div class="card-body">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-4">
                            <form action="/purchase/edit" method="GET"> 
                                <input type="text" name="id"/>
                                <input class="btn-info" type="submit" value="Search"/>
                            </form>
                        </div>
                        <div class="col-md-3"></div>
                        <div class="col-md-5 float-right" >
                            <img  src="/resources/home/img/${p.photo}" width="250px" height="200px"/>
                        </div>
                    </div>
                </div>
                <form action="/purchase/save" method="POST">
                    <div class="form-group">
                        <input name="pid" type="hidden" value="${p.id}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Name</label>
                        <input name="pName" type="text" value="${p.name}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Code</label>
                        <input name="pCode" type="text" value="${p.code}" class="form-control">
                    </div>
                    <div class="form-group">
                        <!--                                                    <label  class="col-form-label"></label>-->
                        <input name="cid" type="hidden" value="${p.cid}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Category</label>
                        <input name="cname" type="text" value="${p.cname}" class="form-control">
                    </div>

                    <div>
                        <!--                                                    <label  class="col-form-label"></label>-->
                        <input name="pDes" type="hidden"  value="${p.des}" class="form-control"/>
                    </div>
                    <div >
                        <!--                                                    <label  class="col-form-label"></label>-->
                        <input name="photo" type="hidden" value="${p.photo}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Cost</label>
                        <input name="price" id="pCost" type="number" class="form-control">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">Quantity</label>
                        <input name="qty" id="qty" type="number" class="form-control">
                    </div>
                    <div class="form-group">

                        <input name="total" id="total" type="hidden" class="form-control">
                    </div>
                    <div class="form-group">
                        <label  class="col-form-label">VAT</label>
                        <input name="vat"id="vat" type="number" class="form-control">
                    </div>
                    <div class="form-group">

                        <input  name="grandTotal" id="grandTotal" type="hidden" class="form-control">
                    </div>

                    <div class="form-group">   
                        <input class="btn btn-lg btn-info"  type="submit" value="Save"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-md-2"></div>
</div>

<script>
//    $("#vat").focusout(function () {
//        var qty = $("#qty").val();
//        var price = $("#price").val();
//        var vat = $("#vat").val();
//        var totalPrice = $("#totalPrice").val();
//        var total = parseInt(price) * parseInt(qty);
//        var netTotal = (parseInt(total) + (parseInt(vat) / parseInt(100)));
//        $("#totalPrice").val("");
//        $("#totalPrice").val(qty);
//    });
//
//    $(document).ready(function () {
//        $("#hide").click(function () {
//            $("p").hide();
//        });
//        $("#show").click(function () {
//            $("p").show();
//        });
//    });
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>

