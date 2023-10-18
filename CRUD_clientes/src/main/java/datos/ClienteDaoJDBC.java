/*
 *AQUI VAN TODAS LAS CONSULTAS, aqui se reciben respuestas y envian peticiones
 *a la base de datos
 */
package datos;

import domain.Cliente;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//Especificacion y muestra de las consultas desde la base de datos
//JDBC : Java Data Base Controler
//Dao: Especificacion de conexion a la base de datos
public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, telefono, correo, saldo, direccion "
            + " FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, telefono, correo, saldo, direccion "
            + " FROM cliente WHERE id_cliente =?";
    private static final String SQL_UPDATE = "UPDATE cliente"
            + " SET nombre=?, apellido=?, telefono=?, correo=?, saldo=?, direccion=? WHERE id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";
    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, telefono, correo, saldo, direccion)"
            + " VALUES (?,?,?,?,?,?)";

    public List<Cliente> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            //realizacion de la consulta con stmt
            stmt = conn.prepareStatement(SQL_SELECT);
            //guardando la consulta (informacion en rs/ y tambien la extrae)
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                double saldo = rs.getDouble("saldo");
                String direccion = rs.getString("direccion");

                cliente = new Cliente(idCliente, nombre, apellido, telefono, correo, saldo, direccion);
                clientes.add(cliente);
                //Se guarda en la variable que esta en la linea 27
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return clientes;
        //variable "clientes" sera llamado desde listadoClientes.jsp 

    }

    public Cliente encontrarClienteById(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            boolean valid = rs.next();
            if (valid) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                double saldo = rs.getDouble("saldo");
                String direccion = rs.getString("direccion");

                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setTelefono(telefono);
                cliente.setCorreo(correo);
                cliente.setSaldo(saldo);
                cliente.setDireccion(direccion);
            }

        } catch (Exception ex) {
            ex.printStackTrace(System.out);

        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }
        return cliente;
    }

    public int insertarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getCorreo());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setString(6, cliente.getDireccion());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int actualizarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getTelefono());
            stmt.setString(4, cliente.getCorreo());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setString(6, cliente.getDireccion());
            //Se Envia por ultimo el id del cliente a actualizar
            stmt.setInt(7, cliente.getIdCliente());

            rows = stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }

    public int eliminarCliente(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, cliente.getIdCliente());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;
    }
}
