<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>
<!--        <a href="/country/view" class="dropdown-item"><h1>Country</h1></a>
        <a href="/category/view" class="dropdown-item"><h1>Category</h1></a>
        <a href="/bank/view" class="dropdown-item"><h1>Bank</h1></a>
        <a href="/color/view" class="dropdown-item"><h1>Color</h1></a>
        <a href="/brand/view" class="dropdown-item"><h1>Brand</h1></a>-->







</script><div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/country/view">
                <!--<p style="color: wheat; font-size: 20px;">${map.count}</p>-->
                <p style="color: white; font-size: 20px;">Country</p>
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
            <a style="color: wheat;" href="http://localhost:8084/Bank/view">

                <p style="color: white; font-size: 20px;">Sub Category</p>
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
<div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/customer/view">

                <p style="color: white; font-size: 20px;">General Member</p>
            </a>
        </div>
    </div>
</div>
<div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-orange" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/marchent/view">

                <p style="color: white; font-size: 20px;">Merchant Member</p>
            </a>
        </div>
    </div>
</div>
<div class="col-xs-4" style="margin-top: 20px;"></div>
<div class="col-xs-4" style="margin-top: 20px;">
    <div class="small-box bg-purple" style="border-radius: 10px;">
        <div class="inner" style="text-align: center; height: 100px; padding-top: 30px;">
            <a style="color: wheat;" href="http://localhost:8084/contact/view">

                <p style="color: white; font-size: 20px;">Customer Message</p>
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

<jsp:include page="/WEB-INF/jsp/admin/footer.jsp"/>