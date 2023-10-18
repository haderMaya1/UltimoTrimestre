<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <title>Editar Cliente</title>
    </head>
    <body>
        <!-- Incluyndo el jsp -->
        <jsp:include page="/WEB-INF/comunes/cabeceroEditarClientes.jsp"/>
        <br>
        <form action="ServerControlador?accion=modificar&idCliente=${cliente.idCliente}" method="post" class="was-validated">
            <section id="details">
                <div class="container">
                    <div class="row justify-content-md-center">
                        <div class="col-9">
                            <div class="card mt-3">
                                <div class="card-header">
                                    <h4>Edit Client</h4>
                                </div>
                                <div class="card-body"> 
                                    <div class="form-gruop">
                                        <!--"cliente" viene de ServerControlador-->
                                        <label for="nombre">Name</label>
                                        <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                    </div>
                                    <div class="form-gruop">   
                                        <br>
                                        <label for="apellido">Last Name</label>
                                        <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
                                    </div>
                                    <div class="form-gruop">    
                                        <br>
                                        <label for="telefono">Phone Number</label>
                                        <input type="text" class="form-control" name="telefono" required value="${cliente.telefono}">
                                    </div>
                                    <div class="form-gruop">
                                        <br>
                                        <label for="correo">Email</label>
                                        <input type="email" class="form-control" name="correo" required value="${cliente.correo}">
                                    <div class="form-gruop">
                                        <br>
                                        <label for="saldo">Balance</label>
                                        <input type="text" class="form-control" name="saldo" required value="${cliente.saldo}">
                                    </div>
                                        <br>
                                        <label for="direccion">Addres</label>
                                        <input type="text" class="form-control" name="direccion" value="${cliente.direccion}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                 
                </div>
            </section>
            <!--Botone de navegacion :D-->
            <jsp:include page="/WEB-INF/comunes/botonesNavEditarCliente.jsp"/>
        </form>


        <br>
        <jsp:include page="/WEB-INF/comunes/pieDePagina.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
