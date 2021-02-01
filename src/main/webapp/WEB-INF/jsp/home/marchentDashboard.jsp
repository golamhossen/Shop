<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/common/mDash/header.jsp"/>  
<!-- Nav Bar End -->      

<!--        <a href="/country/view" class="dropdown-item"><h1>Country</h1></a>
        <a href="/category/view" class="dropdown-item"><h1>Category</h1></a>
        <a href="/bank/view" class="dropdown-item"><h1>Bank</h1></a>
        <a href="/color/view" class="dropdown-item"><h1>Color</h1></a>
        <a href="/brand/view" class="dropdown-item"><h1>Brand</h1></a>-->







</script><div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/goods/view">

                <p style="color: white; font-size: 20px;">Product Info</p>
            </a>
        </div>
    </div>
</div>
<div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/category/view">

                <p style="color: white; font-size: 20px;">Category</p>
            </a>
        </div>
    </div>
</div>

<div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/subCategory/view">

                <p style="color: white; font-size: 20px;">Sub Category</p>
            </a>
        </div>
    </div>
</div>
<div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/goods/view">

                <p style="color: white; font-size: 20px;">Product</p>
            </a>
        </div>
    </div>
</div>
<div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/brand/view">

                <p style="color: white; font-size: 20px;">Brands</p>
            </a>
        </div>
    </div>
</div>



<div class="col-xs-4" style="margin-top: 20px;"></div>

<div style="font-size: 16px; font-weight: bolder; padding-top: 200px; margin-top: 250px;">
    <p style="text-align: center; color: green;">Copyright &copy; 2020. Designed & Developed by
        <a href="https://golam1255656.blogspot.com/" target="_blank" style="color: brown;">ASG SOFTWARE &
            TECHNOLOGY</a>. All rights reserved</p>
</div><style><!--
    .footer {
        left: 0;
        bottom: 0;
        width: 100%;
        height: 50px;
        background-color: #5a9610;
        color: white;
        text-align: center;
        /*   border-radius: 10px 10px 0px 0px;*/
    }
</style>

<!--Datepicker-->
<script>
    $(function () {
        $(".new_datepicker").datepicker({
            dateFormat: 'yy-mm-dd',
            constrainInput: true,
            changeYear: true,
            changeMonth: true
        });
    });
</script>
<style>
    div.ui-datepicker{
        font-size:13px;
    }
    /*.ui-datepicker-calendar a.ui-state-default { background: cyan; }
    .ui-datepicker-calendar td.ui-datepicker-today a { background: red; }*/
    .ui-datepicker-calendar a.ui-state-hover { background: #066;color: white; } 
    .ui-datepicker-calendar a.ui-state-active { background: #066;color: white; } 
</style>






<!-- Footer Start -->

<!-- Footer End -->

<!-- Footer Bottom Start -->
<div class="footer-bottom">
    <div class="container">
        <div class="row">
            <div class="col-md-6 copyright">
                <p>Copyright &copy; <a href="https://golam1255656.blogspot.com">ASG Group</a>. All Rights Reserved</p>
            </div>

            <div class="col-md-6 template-by">
                <p>Template By <a href="https://golam1255656.blogspot.com">ASG Group</a></p>
            </div>
        </div>
    </div>
</div>
<!-- Footer Bottom End -->       

<!-- Back to Top -->
<a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script src="/resources/home/lib/easing/easing.min.js"></script>
<script src="/resources/home/lib/slick/slick.min.js"></script>

<!-- Template Javascript -->
<script src="/resources/home/js/main.js"></script>



</body>
</html>
