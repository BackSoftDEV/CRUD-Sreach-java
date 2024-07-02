<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" pageEncoding="UTF-8" %>

<a href="/gio-hang/add" >Thêm</a>
<form action="/gio-hang/search">
    <p>Tên mã giỏ hàng :<input type="text" name="keyword" value="${param.keyword}"></p>
    <button>Search</button>

</form>
<table border="2" >
    <tr>
        <th>Mã</th>
        <th>Ngày Tạo</th>
        <th>Tên Người Nhận</th>
        <th>Địa chỉ</th>
        <th>Số Điện Thoại</th>
        <th>Tên Khách Hàng</th>
        <th>Mã Khách Hàng</th>
        <th colspan="2">Hành Động</th>
    </tr>
    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.magiohang}</td>
            <td>${p.ngaytao}</td>
            <td>${p.tennguoinhan}</td>
            <td>${p.diachi}</td>
            <td>${p.sdt}</td>
            <td>${p.khachhang.tenkhachhang}</td>
            <td>${p.khachhang.makhachhang}</td>
            <td><a href="/gio-hang/edit/${p.id}">Update</a></td>
            <td><a onclick='return confirm("bạn muốn xóa ko")' href="/gio-hang/delete/${p.id}">Delete</a></td>

        </tr>
    </c:forEach>
</table>
