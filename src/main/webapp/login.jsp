<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/header.jsp" />

		<style>
				body 
				{
			     	background-image: url("images/login-bg.jpg");
			     	background-size: cover;
				}
		</style>
		
		<div class="contenuPrincipal">
		

   <section class="bg-home  d-flex align-items-center">
            
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-lg-5 col-md-8"> 
                        <div class="card shadow rounded border-0">
                            <div class="card-body">
                                <h4 class="card-title text-center">Connexion</h4>                                		                             		                              	
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
                                                <label class="form-label">Login <span class="text-danger">*</span></label>
                                                <div class="form-icon position-relative" >
                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
                                                    <input type="text" class="form-control ps-5" placeholder="login" name="login" required="" style="padding-left: 1rem!important;">
                                                </div>
                                            </div>
                                        </div><!--end col-->       
                                                                                                 
                                 		<div class="col-md-12">
                                            <div class="mb-3">
                                                <label class="form-label">Mot de passe <span class="text-danger">*</span></label>
                                                <div class="form-icon position-relative" >
                                                    <i data-feather="mail" class="fea icon-sm icons" style="position: absolute;top: 11px;left: 13px;"></i>
                                                    <input type="password" class="form-control ps-5" placeholder="Mdp" name="password" required="" style="padding-left: 1rem!important;">
                                                </div>
                                            </div>
                                        </div>
                                 		<div class="col-md-12">
                                            <!--<div class="d-grid">-->
                                                <button class="btn btn-primary">Se Connecter</button>
                                           <!-- </div>-->
                                        </div><!--end col-->                                     
                                    </div>
                                    <br/>
                                    <p style="text-align:center">Vous n'avez pas de compte? <a href="register">S'inscrire</a></p>                       	                                    
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