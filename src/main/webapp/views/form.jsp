<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" pageEncoding="UTF-8" %>
<form:form modelAttribute="a">

    <p>MÃ :<form:input path="magiohang"/>
    <form:errors path="magiohang" cssStyle="color: red"/> </p>
    <p>Ngày Tạo :<form:input path="ngaytao" type="date"/></p>
    <p>Tên Người Nhận:<form:input path="tennguoinhan"/></p>
    <p>Địa chỉ:<form:input path="diachi"/></p>
    <p>Số ĐT:<form:input path="sdt"/></p>
    <p>Tên Khách Hàng:
        <form:select path="khachhang.id">
            <c:forEach items="${listKH}" var="a">
                <option value="${a.id}">${a.tenkhachhang}</option>
            </c:forEach>
        </form:select>
    </p>
    <button onclick='return confirm("bạn muốn lưu ko")' type="submit" >Lưu</button>
</form:form>