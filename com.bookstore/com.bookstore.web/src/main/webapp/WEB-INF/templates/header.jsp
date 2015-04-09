<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

	<jsp:directive.page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" />

	<div class="header">
		<div class="logo">
			<spring:url value="/index.htm" var="home" />
			<spring:url value="/resources/images/logo.gif" var="logo" /> 
		</div>
		<div class="nav">
			<ul>
				<li>
					<spring:message code="nav.home"/></a>
				</li>
				<li>
				    createOrders
				</li>
				<li>
					login
				</li>
				
			</ul>
			<ul style="float: right;">
			 	<c:url value="/resources/images/gb.gif" var="gb"/>
			 	<c:url value="/resources/images/nl.gif" var="nl"/>
                <li><a href="?lang=en" class="selected"><img src="${gb}" alt="" title="" border="0" /></a></li>
                <li><a href="?lang=nl"><img src="${nl}" alt="" title="" border="0" /></a></li>
            </ul>
			
			
		</div>
	</div>