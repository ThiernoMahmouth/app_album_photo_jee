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
                                <h4 class="card-title text-center">Ajout d'album</h4>                                		                             		                              	
                                	<form class="login-form mt-4"  method="POST">
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
	                                                <label class="form-label">Nom <span class="text-danger">*</span></label>
	                                                <div class="form-icon position-relative" >
	                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
	                                                    <input type="text" class="form-control ps-5" placeholder="Nom" name="nom" required="" style="padding-left: 1rem!important;">
	                                                </div>
	                                            </div>
	                                        </div><!--end col-->
	                                        <div class="col-md-12">
		                                        <div class="form-check">
													  <input class="form-check-input" type="radio" name="isPrivate" id="visibiilite1"  value="1" checked>
													  <label class="form-check-label" for="visibiilite1" >Privée</label>
												</div>
												<div class="mb-3 form-check">
												  	<input class="form-check-input" type="radio" name="isPrivate" id="visibiilite2" value="0">
												  	<label class="form-check-label" for="visibiilite2">Public</label>
												</div>
											</div>
									     <div class="col-lg-12">
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