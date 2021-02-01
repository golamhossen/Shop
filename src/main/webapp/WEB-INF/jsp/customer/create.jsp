<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/jsp/admin/header.jsp"/>   

        <h1 class="text-center">Create Customer</h1> <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-2">


                </div>
                <div class="col-md-10">
                    <form action="/customer/save" method="POST">
                        Country: 
                        <select class="" name="cid">
                            <c:forEach var="c" items="${map.cList}">
                                <option value="${c.id}">${c.name}</option>
                            </c:forEach>
                        </select><br/><br/>
                        City:
                        <select class="" name="cityId">
                            <c:forEach var="c1" items="${map.cityList}">
                                <option value="${c1.id}">${c1.name}</option>
                            </c:forEach>
                        </select><br/><br/>
                        Name : <input type="text" name="name"/> <br/><br/>
                        Gender:<input type="radio" name="gender" value="male">Male<input type="radio" name="gender" value="female">Female<br/><br/>
                        Age : <input type="text" name="age"/> <br/><br/>
                        Address : <input type="text" name="address"/><br/><br/>
                        Email : <input type="text" name="email"/><br/><br/>
                        Password : <input type="text" name="password"/><br/><br/>

                        <input class="btn-info" type="submit" value="save"/>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
