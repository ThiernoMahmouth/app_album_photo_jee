<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/header.jsp" />

	<div class="contenuPrincipal">
		<section class="bg-half bg-light d-table w-100">
			<div class="container">
				<div class="row justify-content-center">
		            <div class="col-lg-12 text-center">
		                <div class="page-next-level">
		                    <h4 class="title">Gestion des Utilisateurs</h4>
		                    <div class="page-next">
		                        <nav aria-label="breadcrumb" class="d-inline-block">
		                            <ul class="breadcrumb bg-white rounded shadow mb-0">
		                                <li class="breadcrumb-item">Photo ESP</li>
		                                <li class="breadcrumb-item active" aria-current="page">Users</li>
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
			
		            <div class="mt-4 mt-sm-0">
                          <a href='<c:url value="${ request.getContextPath() }/admin/add" />' class="btn btn-primary" >Add</a>
                    </div>
                <c:if test="${ ! empty succes }">
                		<div class="mt-4 mt-sm-0">
                			<p class="text-success" style="width=100%;"><c:out value="${ succes }" /></p>
                		</div>
                </c:if>
                <c:if test="${ ! empty erreur }">
                      	<p><span class="text-danger" style="width=100%;"><c:out value="${ erreur }" /></span></p>
                 </c:if>
					<div class="row">
                            <div class="col-12 mt-4">
                                <div class="table-responsive shadow rounded">
                                    <table class="table table-center bg-white mb-0">
                                        <thead>
                                            <tr>
                                                <th class="border-bottom p-3">ID</th>
                                                <th class="text-center border-bottom p-3">NOM</th>
                                                <th class="text-center border-bottom p-3" style="min-width: 200px;">PRENOM</th>
                                                <th class="text-center border-bottom p-3">LOGIN</th>
                                                <th class="text-center border-bottom p-3" style="min-width: 150px;">ROLE</th>
                                                <th class="text-end border-bottom p-3" style="min-width: 200px;"></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        	
                                        	<c:choose>
                                        		<c:when test="${ empty utilisateurs }">
                                        			<tr><td><span class="text-danger" style="width=100%;">Aucun utilisateur dans la base</span></td></tr>
                                        		</c:when>
                                        		<c:otherwise>
                                        			<c:forEach items="${ utilisateurs }" var="user">
                                        				<tr>
			                                        				<th class="p-3">#<c:out value="${ user.id }" /></th>
			                                        				<td class="text-center p-3"><c:out value="${ user.nom }" /></td>
			                                        				<td class="text-center p-3"><c:out value="${ user.prenom }" /></td>	                                        				                                        				
			                                        				<td class="text-center p-3"><c:out value="${ user.login }" /></td>	                           
			                                        				<td class="text-center p-3"><c:out value="${ user.role }" /></td>
			                                        				<td >
					                                                    <a href='<c:url value="${ request.getContextPath() }/admin/update?id=${ user.id }" />' class="btn btn-sm btn-primary">Modifier</a>
					                                                    <a href='<c:url value="${ request.getContextPath() }/admin/delete?id=${ user.id }" />' class="btn btn-sm btn-danger ms-2">Supprimer</a>
					                                                </td>
					                                          	</tr>
                                        			</c:forEach>
                                        		</c:otherwise>
                                        	</c:choose>
                                        </tbody>
                                    </table>
                                </div>
                            </div><!--end col-->
                        </div><!--end row-->
			</div>
		</section>
	</div>
</body>
</html>