<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_CO"/>
<section id="clientes">
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>List of Clients</h4>
                        
                     </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Name</th>
                                <th>Balance</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="client" items="${clientes}">
                                <tr>
                                    <td>${client.idCliente}</td>
                                    <td>${client.nombre}  ${client.apellido}</td>
                                    <td>${client.saldo}</td>
                                    <td>
                                        <a 
                                            href="ServerControlador?accion=editar&idCliente=${client.idCliente}" class="btn btn-secondary"><i class="bi bi-pen"></i>EDIT</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-8 align-self-start">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Balance</h3>
                        <h6 class="display-4">
                            <fmt:formatNumber value="${sTotal}" type="currency"/>
                        </h6>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="card text-center bg-primary">
                    <div class="card-body">
                        <h3>Total Clients</h3>
                        <h6 class="display-4">
                            <b><i class="bi bi-people-fill"></i> ${totalClientes}</b>
                        </h6>
                    </div>
                </div>
            </div>
        </div>
    </div>  
</section>
<!<!-- agregar cliente modal -->
<jsp:include page="/WEB-INF/cliente/agregarCliente.jsp"/>