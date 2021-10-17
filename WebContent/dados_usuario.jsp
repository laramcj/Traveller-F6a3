<!doctype html>
<jsp:useBean id="Usuario" type="br.com.masters3.beans.Usuario" scope="session"></jsp:useBean>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="pt-br">
	<head>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		
		 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
            integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
            integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
            crossorigin="anonymous" />
           
        <link rel="stylesheet" href="./assets/css/style.css"> 
            
		<title>Projeto Traveller</title>
	</head>
	
	<body>
	
		<header class="p-4 text-light cor__fundo meu__header" >
			<h3>Projeto Traveller</h3>
			<h5>Area Logada</h5>
			 <div>
                <a class="btn btn-outline-light" href="./login.jsp">Logout <i class="fas fa-sign-out-alt"></i></a>
            </div>
		</header>
		
		 <div class="container my-5">
		 	 <div class="text-center mb-5">
		 	 	<img src="./assets/images/${Usuario.foto}" class="logo" />
		 	 	<h2 class="my-1">Olá  <c:out value="${Usuario.nome }" ></c:out></h2>
		 	 	<p><c:out value="${Usuario.email }" ></c:out></p>
		 	 	<p><h2 class="my-1">Nível de Acesso:  <c:out value="${Usuario.nivel }" ></c:out></h2></p>
		 	 	 <p>
                    <a href="./cadastrar_usuario" class="btn btn-success btn-sm mr-2">Cadastrar novo usuario</a>
                </p>
		 	 </div>
		 </div>
		 
		 <p class="p-3 bg-info text-light meu__header">Dados da conta
                <button class="btn btn-outline-light " id="alterar"> <i class="fas fa-user-edit"></i> Alterar seus dados</button>
         </p>
         
         <form method="post" id="dados-conta" action="">
         	<div class="row">
         		 <div class="col-12 col-sm-12 col-md-6">
	         		  <div class="form-group">
	         		  		 <label for="nome" class="titulos">Nome</label>
	         		  		 <input type="text" class="form-control" name="nome" value="<c:out value="${Usuario.nome }" ></c:out>" disabled="disabled"/>
	         		  </div>
	         	 </div>
         	</div>
         
         </form>
			
	  	<footer class="p-4 text-light cor__fundo">
            <h5 class="text-center">Projeto Traveller - Direitos reservados</h5>
        </footer>
		
	</body>

</html>