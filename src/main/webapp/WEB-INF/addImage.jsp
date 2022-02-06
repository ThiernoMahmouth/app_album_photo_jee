<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/header.jsp" />

	<div class="contenuPrincipal">
		
		<section class="bg-home bg-circle-gradiant d-flex align-items-center">
            <div class="bg-overlay bg-overlay-white"></div>
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-8"> 
                        <div class="card shadow rounded border-0">
                            <div class="card-body">
                                <h4 class="card-title text-center">Ajout d'image</h4>                                		                             		                              	
                                	<form class="login-form mt-4"  method="POST" enctype="multipart/form-data">
                                         <c:if test="${! empty erreur }">
                                    		<div class="row">
                                            		<div class="col-lg-12">
                                                        <div class="mb-3">
                                                            <label class="form-label">                                                   
                                                            	<span class="text-danger"><c:out value="${ erreur }"/></span>                                                          	
                                                            </label>                   	
														</div>
													</div>
					                        	</div>
                                    	</c:if> 
                                    <div class="row">
	                                        <div class="col-md-12">
	                                            <div class="mb-3">
	                                                <label class="form-label">Titre <span class="text-danger">*</span></label>
	                                                <div class="form-icon position-relative" >
	                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
	                                                    <input type="text" class="form-control ps-5" placeholder="Titre" name="titre" required="" style="padding-left: 1rem!important;">
	                                                </div>
	                                            </div>
	                                        </div><!--end col-->
										<div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Hauteur <span class="text-danger">*</span></label>
                                                <div class="form-icon position-relative" >
                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
                                                    <input type="number" min="1" class="form-control ps-5" placeholder="Hauteur" name="hauteur" required="" style="padding-left: 1rem!important;">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Largeur <span class="text-danger">*</span></label>
                                                <div class="form-icon position-relative" >
                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
                                                    <input type="number" min="1" class="form-control ps-5" placeholder="Largeur" name="largeur" required="" style="padding-left: 1rem!important;">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label class="form-label">Choisissez une photo <span class="text-danger">*</span></label>
                                                <div class="form-icon position-relative" >
                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
                                                    <input type="file" min="1" class="form-control ps-5" placeholder="Votre image" name="fileName" required="" style="padding-left: 1rem!important;">
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="mb-3">
                                                <label for="album" name="album" class="form-label">Choisissez l'album <span class="text-danger">*</span></label>
                                                <div class="form-icon position-relative" >
                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
									    			<select class="form-control ps-5" id="album" name="album">
									    				<c:forEach items="${ albums }" var="album">
									    					<option value='<c:out value="${ album.id }" />'> <c:out value="${ album.nom }" /> </option>
									    				</c:forEach>
									    			</select>
									    	</div>
									    </div>		
							
									     <div class="col-lg-12 ">
	                                            <div class="d-grid">
	                                                <button class="btn btn-primary">Ajouter</button>
	                                            </div>
	                                  	</div><!--end col-->                                     
                                   </div>                                                            	                                    
                                </form>
                            </div>
                        </div>
                    </div><!--end col-->
                </div><!--end row-->
            </div> <!--end container-->
        </section>
      </div>
	</body>
</html>