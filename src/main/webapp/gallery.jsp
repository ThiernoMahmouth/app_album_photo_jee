<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp" />

	<div class="contenuPrincipal">
		<section class="bg-half bg-light d-table w-100">
			<div class="container">
				<div class="row justify-content-center">
		            <div class="col-lg-12 text-center">
		                <div class="page-next-level">
		                	<c:choose>
		                		<c:when test="${ empty sessionScope.currentUser }">
		                			<h4 class="title"> Gallerie publique </h4>
		                		</c:when>
		                		<c:otherwise>
		                			<h4 class="title"> Ma Gallerie </h4>
		                		</c:otherwise>
		                	</c:choose>
		                    
		                    <div class="page-next">
		                        <nav aria-label="breadcrumb" class="d-inline-block">
		                            <ul class="breadcrumb bg-white rounded shadow mb-0">
		                                <li class="breadcrumb-item">Photo ESP</li>
		                                <li class="breadcrumb-item active" aria-current="page">Public</li>
		                            </ul>
		                        </nav>
		                    </div>
		                </div>
		            </div><!--end col-->
        		</div>		
			</div>
		</section>
		<div class="position-relative">
			<div class="shape overflow-hidden text-white">
				<svg viewBox="0 0 2880 48" fill="none" xmlns="http://www.w3.org/2000/svg">
		            <path d="M0 48H1437.5H2880V0H2160C1442.5 52 720 0 720 0H0V48Z" fill="currentColor"></path>
		        </svg>
			</div>
		</div>
		<section class="section">
			<div class="container">
				<div class="row">
		            <div class="col-lg-3 col-md-4 col-12">
		            	<div class="card border-0 sidebar sticky-bar">
		            		<div class="card-body p-0">
		                		<c:if test="${ ! empty sessionScope.currentUser }">
			            			<div class="widget">
			            					<a href='<c:url value="${ request.getContextPath() }/albums/addAlbum" />' class="btn btn-primary" >Add Album</a>
							                <a href='<c:url value="${ request.getContextPath() }/albums/addImage" />' class="btn btn-info mt-2" >Add Image</a>						                   
			            			</div>
			            		</c:if>
			            		<div class="widget mt-4 pt-2">
		            				<h5 class="widget-title" >Albums</h5>
		            				<ul class="list-unstyled mt-4 mb-0 blog-categories">
		            				<c:forEach items="${ albums }" var="album">
		            					<li>
		            						<a href='<c:url value="${ request.getContextPath() }/albums/album?id=${ album.id }" />'> 
		            							<c:out value="${ album.nom }" />	    
		            						</a>
		            					</li>
		            				</c:forEach>
		            					
		            					
		            				</ul>
		            			</div>
		            		</div>
		            	</div>
		            </div>
		            <div class="col-lg-9 col-md-8 col-12 mt-5 pt-2 mt-sm-0 pt-sm-0">
		            	<div class="row align-items-center">
		            		<div class="col-lg-8 col-md-7">
		            			<div class="section-title">
		            			<c:choose>
		                			<c:when test="${ empty sessionScope.currentUser }">
						            	<h5 class="mb-0">Photos publics</h5>
						            </c:when>
						            <c:otherwise>
						            	<h5 class="mb-0">Toutes mes Photos</h5>
						            </c:otherwise>
						         </c:choose>
						        </div>
		            		</div>
		            	</div>
		            	<div class="row">	            		
		            			<c:forEach items="${ images }" var="image">
		            				<div class="col-lg-4 col-md-6 col-12 mt-4 pt-2">
		            					<div class="card shop-list border-0 position-relative">
								            <div class="shop-image position-relative overflow-hidden rounded shadow">
							
								                <a href='image?id=<c:out value="${ image.id }" />' >
								                	<img src='<c:url value="/${ image.fileName }" />' class="img-fluid" alt=""> 
								                </a>
								                <a href="shop-product-detail.html" class="overlay-work">
								                    <img src='<c:out value="${ image.fileName }" />' class="img-fluid" alt="">
								                </a>
								            </div>
								            <div class="card-body content pt-4 p-2">
								                <a href='image?id=' class="text-dark product-name h6"><c:out value="${ image.titre }" /></a>
								                <div class="d-flex justify-content-between mt-1">						                    
								                </div>
								            </div>
								        </div>
								    </div>
		            			</c:forEach>
		            		</div>

		            	</div>
		            </div>
		         </div>
			</div>
		</section>
	</div>
</body>
</html>