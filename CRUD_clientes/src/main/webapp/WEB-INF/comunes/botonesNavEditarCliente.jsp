<section id="acciones" class="py-4 mb-4 bg-white">
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-3">
                <a href="index.jsp" class="btn btn-dark btn-block text-white">
                    <i class="bi bi-arrow-return-left"></i>GO BACK!
                </a>
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-secondary btn-block text-white" value="Back">
                    <i class="bi bi-check-circle-fill"></i>
                    Update Client
                </button>
            </div>
             <div class="col-md-3">
                <a href="ServerControlador?accion=eliminar&idCliente=${cliente.idCliente}" class="btn btn-dark btn-danger text-white">
                    <i class="bi bi-trash-fill"></i>
                    Erase Client
                </a>
            </div>
        </div>
    </div>
</section>