<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/merchant/header.jsp"/>    

<!-- Bottom Bar End --> 
<!-- Breadcrumb Start -->
<div class="breadcrumb-wrap">
    <div class="container-fluid">
        <ul class="breadcrumb">
            <li class="breadcrumb-item"><a href="#">Home</a></li>
            <li class="breadcrumb-item active"><a href="#">Products</a></li>
            <li class="breadcrumb-item ">Marchent</li>
        </ul>
    </div>
</div>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
    $grey: #F5F5F5;
    $dark-grey: #323B40;

    $light-blue: #E0F5FF;
    $blue: #B9E5FE;
    $dark-blue: #00A5FA;

    $green: #B7E0DC;
    $dark-green: #019888;

    $lime: #C7E8C8;
    $dark-lime: #42B045;

    $yellow: #FFEEBA;
    $dark-yellow: #FF9901;

    $pink: #FABAD0;
    $dark-pink: #EF075F;

    $red: #FEC9C6;
    $dark-red: #FD3D08;

    @mixin color-div($color1, $color2){
        background-color: $color1;
        color: $color2;
    }

    .container {
        padding: 2rem 0rem;
    }

    h4 {
        margin: 2rem 0rem;
    }

    .panel {
        border-radius: 4px;
        padding: 1rem;
        margin-top: 0.2rem;

        @include color-div($grey, $dark-grey);

        &.panel-blue {
            @include color-div($light-blue, $dark-blue);
        }

        &.panel-big-height{
            min-height: 150px;
        }
    }

    .item {
        border-radius: 4px;
        padding: 0.5rem;
        margin: 0.2rem;

        &.item-blue {
            @include color-div($blue, $dark-blue);
        }

        &.item-green {
            @include color-div($green, $dark-green);
        }

        &.item-lime {
            @include color-div($lime, $dark-lime);
        }

        &.item-yellow {
            @include color-div($yellow, $dark-yellow);
        }

        &.item-pink {
            @include color-div($pink, $dark-pink);
        }

        &.item-red {
            @include color-div($red, $dark-red);
        }

        &.item-big-width{
            min-width: 380px;
        }
    }
    body {
        font-family: "Open Sans", -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen-Sans, Ubuntu, Cantarell, "Helvetica Neue", Helvetica, Arial, sans-serif; 
    }


</style>

<div class="row mb_30">

    <c:forEach var="good" items="${map.gList}">
        <div class="col-lg-3 col-sm-6">

            <div class="accomodation_item text-center">
                <div class="hotel_img">
                    <img src="/resources/home/img/${good.photo}" alt="Photo Error">

                </div>
                <h3 class="sec_h4">${good.name}</h3>
                <h3>${good.price}</h3>
            </div>
            <div class="row">
                <div class="col-6">
                    <form action="/cart2/save" method="POST">
                        <input type="hidden" class="form-control" value="${good.id}" name="pid" id="name" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.name}" name="pName" id="name" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.code}" name="pCode" id="code" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.sp}" name="sp" id="photo" aria-describedby="emailHelp" >
                        <input type="hidden" class="form-control" value="${good.des}" name="des" id="photo" aria-describedby="emailHelp" >
                        <input type="hidden" class="form-control" value="${good.price}" name="pPrice" id="price" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.photo}" name="photo" id="photo" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.discount}" name="discount" id="photo" aria-describedby="emailHelp">



                        <a href="#"><input onclick="valid()" type="submit" class="btn-primary" value="Add to Cart" ></a>



                    </form>

                </div>

                <div class="col-6">
                    <form action="/cart2/save" method="POST">
                        <input type="hidden" class="form-control" value="${good.id}" name="pid" id="name" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.name}" name="pName" id="name" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.code}" name="pCode" id="code" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.sp}" name="sp" id="photo" aria-describedby="emailHelp" >
                        <input type="hidden" class="form-control" value="${good.des}" name="des" id="photo" aria-describedby="emailHelp" >
                        <input type="hidden" class="form-control" value="${good.price}" name="pPrice" id="price" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.photo}" name="photo" id="photo" aria-describedby="emailHelp">
                        <input type="hidden" class="form-control" value="${good.discount}" name="discount" id="photo" aria-describedby="emailHelp">



                        <a href="#"><input  type="submit" class="btn-primary" value="Add to Wishlist" ></a>

                        <!--<a href="/goods/view2"><input type="button" class="btn-info" value="Product Details" ></a>-->


                    </form>

                </div>
            </div>
        </div>
    </c:forEach>

</div>
<!--<h1 class="text-center">View Product</h1> <br>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
        </div>
        <div class="col-md-10">
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
</div>

</div>
</div>-->
<!-- Modal Area-->





<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    function addCartt(b, c, d, e) {

        $("#name").val(b);
        $("#code").val(c);
        $("#price").val(d);
        $("#photo").val(e);

        alert(b);
    }

    Swal.fire(
            'Good job!',
            'You clicked the button!',
            'success'
            )
</script>
<!--<script>
           function valid(){
               var rand =( Math.floor(Math.random() * 10000) +1);
               alert(rand);
               
               var pro = prompt("Enter your Otp Number");
               
               if(rand == pro){
                   alert("otp matched");
               }else{
                   alert("otp does not matched");
               }
           }
       </script>-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="/resources/home/lib/easing/easing.min.js"></script>
<script src="/resources/home/lib/slick/slick.min.js"></script>

<!-- Template Javascript -->
<script src="/resources/home/js/main.js"></script>
</body>
</html>
