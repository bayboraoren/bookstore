<!DOCTYPE HTML>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
	<head>
		<spring:url value="resources/css/style.css" var="bookstoreCss" />
		<link rel="stylesheet" type="text/css" href="${bookstoreCss}" />
	</head>
	<body>
		<tiles:insertAttribute name="header"/>
        <tiles:insertAttribute name="content"/>  
        
        	<div class="right_content">
      	     	<div class="right_box">
			       <div class="title">
						<spring:url value="/resources/images/bullet4.gif" var="bullet4"/>
						<span class="title_icon"><img src="${bullet4}" alt="" title="" /></span>
						<spring:message code="main.title.randombooks"/>
					</div> 
                    <c:forEach items="${randomBooks}" var="book">
                        <div class="new_prod_box" style="width: 100%">
                            <c:url value="/book/detail/${book.id}" var="bookUrl" />
                            <a href="${bookUrl}">${book.title}</a>
                            <div class="new_prod_img" style="width: 100%">
                            <c:url value="/resources/images/books/${book.isbn}/book_front_cover.png" var="bookImage"/>
                            <a href="${bookUrl}"><img src="${bookImage}" alt="${book.title}" title="${book.title}" class="thumb" border="0" width="100px"/></a>
                            </div>           
                        </div>
                    </c:forEach>
           	  	</div>
           	  </div>        
        
                  
		<tiles:insertAttribute name="footer"/>         
	</body> 
</html>