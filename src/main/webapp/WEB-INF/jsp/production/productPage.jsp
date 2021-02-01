<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>  

<div class="row mb_30">
    <c:forEach var="c" items="${map.pList}">
        <div class="col-lg-3 col-sm-6">
            <div class="accomodation_item text-center">
                <div class="hotel_img">
                    <img src="/resources/home/img/${c.photo}" alt="Photo Error">
                    <a href="home/create" class="btn theme_btn button_hover" style="background-color: #f8bb00">View Details</a>
                </div>
                <a href="home/create"><h4 class="sec_h4">Double Deluxe Room</h4></a>
                <h5>$250<small>/night</small></h5>
            </div>
            <input type="hidden" id="place" value="${c.place}"/>
        </div>
    </c:forEach>
</div>
<h1>Hello World!</h1>
</body>
</html>
