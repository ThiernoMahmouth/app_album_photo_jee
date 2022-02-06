<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
        <title>Photo ESP</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- favicon -->
        <link rel="shortcut icon" href='<c:url value="/images/favicon.ico"/>'>
        <!-- Bootstrap -->
        <link href='<c:url value="/css/bootstrap.min.css"/>' rel="stylesheet" type="text/css" />
        <!-- Icons -->
        <link href='<c:url value="/css/materialdesignicons.min.css"/>' rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href='<c:url value="/unicons.iconscout.com/release/v3.0.3/css/line.css"/>'>
        <!-- FLEXSLIDER -->
        <link href='<c:url value="/css/flexslider.css"/>' rel="stylesheet" type="text/css" />
        <!-- Slider -->               
        <link rel="stylesheet" href='<c:url value="/css/slick.css"/>'/> 
        <link rel="stylesheet" href='<c:url value="/css/slick-theme.css"/>' />
        <!-- Main Css -->
        <link href='<c:url value="/css/style.min.css"/>' rel="stylesheet" type="text/css" id="theme-opt" />
        <link href='<c:url value="/css/colors/default.css" />'  rel="stylesheet" id="color-opt">	
	</head>
	<body>
	
			<header id="topnav" class="defaultscroll sticky">
            <div class="container">
                <!-- Logo container-->
                <a class="logo" href='<c:url value="/index.jsp"/>'>
                    <img src="images/logo-dark.png" height="24" class="logo-light-mode" alt="">
                </a>
                <!-- End Logo container-->

                <div class="menu-extras">
                    <div class="menu-item">
                        <!-- Mobile menu toggle-->
                        <a class="navbar-toggle" id="isToggle" onclick="toggleMenu()">
                            <div class="lines">
                                <span></span>
                                <span></span>
                                <span></span>
                            </div>
                        </a>
                        <!-- End mobile menu toggle-->
                    </div>
                </div>

                <ul class="buy-button list-inline mb-0">
                <c:choose>
                	<c:when test="${ empty sessionScope.currentUser }">
                		<a href='<c:url value="/login"/>' class="btn btn-primary">Inscription/Connexion</a>
                	</c:when>
                	<c:otherwise>
                		<a href='<c:url value="/logout"/>' class="btn btn-primary">Deconnexion</a>
                	</c:otherwise>
                </c:choose>
                    
                </ul><!--end login button-->
        
                <div id="navigation">
                    <!-- Navigation Menu-->   
                    <ul class="navigation-menu">
                        <li class="active"><a href='<c:url value="/index.jsp"/>' class="sub-menu-item active">Home</a></li>
						
					<c:choose>
	                	<c:when test="${ empty sessionScope.currentUser }">
	                		<li><a href='<c:url value="/albums/gallery"/>' class="sub-menu-item">Gallerie Publique</a></li>
	                	</c:when>
	                	<c:otherwise>
	                		<li><a href='<c:url value="/albums/list-albums"/>' class="sub-menu-item">Ma Gallerie</a></li>
	                		<c:if test="${ sessionScope.currentUser.role == 'ADMIN' }"> 
								<li><a href='<c:url value="/admin/users"/>' class="sub-menu-item">Users</a></li>
							</c:if>
	                	</c:otherwise>
	                </c:choose>
                        
						 
					
						
						
                    </ul><!--end navigation menu-->
                    
                </div><!--end navigation-->
            </div><!--end container-->
        </header>	