<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-black text-white">
                <h4 class="modal-title">Add User</h4>
                <button class="btn btn-black text-white" data-bs-dismiss="modal">
                    <i class="bi bi-x-circle-fill"></i>
                </button>
            </div>
            <form action="ServerControlador?accion=insertar" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="group">
                        <label for="nombre">Name</label>
                        <input type="text" class="form-control" required name="nombre">
                        <br>
                        <label for="apellido">Last Name</label>
                        <input type="text" class="form-control" required name="apellido">
                        <br>
                        <label for="telefono">Phone Number</label>
                        <input type="text" class="form-control" required name="telefono">
                        <br>
                        <label for="correo">Email</label>
                        <input type="email" class="form-control" required name="correo">
                        <br>
                        <label for="saldo">Balance</label>
                        <input type="number" class="form-control" name="saldo">
                        <br>
                        <label for="direccion">Addres</label>
                        <input type="text" class="form-control" name="direccion">
                    </div>
                    <div class="modal-footer">
                        <i class="bi bi-save-fill"></i>
                        <button class="btn btn-primary" type="submit">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div><!-- comment -->
</div>