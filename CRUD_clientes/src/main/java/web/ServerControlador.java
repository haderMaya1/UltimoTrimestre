/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.ClienteDaoJDBC;
import domain.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author Jader
 */
@WebServlet("/ServerControlador")
public class ServerControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //esta accion viene a hacer la de edicionF
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(req, resp);
                    break;
                case "eliminar":
                    this.eliminarCliente (req, resp);
                default:
                    this.accionDefault(req, resp);
            }
        } else {
            this.accionDefault(req, resp);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //esta accion viene a hacer la de edicionF
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "modificar":
                    this.modificarCliente(req, resp);
                    break; 
                case "insertar":
                    this.insertarCliente (req, resp);
                    break;
                default:
                    this.accionDefault(req, resp);
            }
        } 
    }
    
      private void eliminarCliente (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
          //Recuperando ID
          int idCliente = Integer.parseInt(req.getParameter ("idCliente"));
          //Creamos el objeto cliente
          Cliente cliente = new Cliente(idCliente);
          //Enviamos el Dao
          int registroMod = new ClienteDaoJDBC().eliminarCliente(cliente);
          System.out.println(registroMod);
          this.accionDefault(req, resp);
          
      }
      private void insertarCliente (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //recuperamos los valores del formulario
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String telefono = req.getParameter("telefono");
        String correo = req.getParameter("correo");
        /*haciendo validacion, para que no haya errores en la base de datos*/
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
            
        }
        String direccion = req.getParameter("direccion");
        
        //crear objeto cliente
        Cliente cliente = new Cliente(nombre, apellido, telefono, correo, saldo, direccion);
        //insertamos el cliente creado
        int registroMod = new ClienteDaoJDBC().insertarCliente(cliente);
        this.accionDefault(req, resp);
    }
    
    private void modificarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //recuperar datos del cliente
        int idCliente = Integer.parseInt(req.getParameter ("idCliente"));
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        String telefono = req.getParameter("telefono");
        String correo = req.getParameter("correo");
        /*haciendo validacion, para que no haya errores en la base de datos*/
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if (saldoString != null && !"".equals(saldoString)) {
            saldo = Double.parseDouble(saldoString);
            
        }
        String direccion = req.getParameter("direccion");
        
        //crear el objeto cliente
        Cliente cliente = new Cliente(idCliente, nombre, apellido, telefono, correo, saldo, direccion);
        //insertamos el cliente creado
        int registroMod = new ClienteDaoJDBC().actualizarCliente(cliente);
        System.out.println("CANTIDAD DE REGISTROS MODIFICADOS" + registroMod);
        
        //redirigir al inicio o accionDefault
        this.accionDefault (req, resp);
    }

    //Obtencion de accion, accion de redireccion
    private void accionDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDaoJDBC().listar();
        //"Cliente.java" para traer los listados

        HttpSession sesion = req.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("sTotal", calcularSaldoTotal(clientes));
        sesion.setAttribute("totalClientes", clientes.size());

        resp.sendRedirect("clientes.jsp");
    }
    
    private double calcularSaldoTotal(List<Cliente> clientes){
        double sTotal = 0;
        for (Cliente cliente : clientes){
            sTotal += cliente.getSaldo();
        }
        return sTotal;
    }

    //recupearcion de informacion
    private void editarCliente(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //recuperar id del cliente
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        //accediendo a mi metodo "encontrarClienteById"
        Cliente cliente = new ClienteDaoJDBC().encontrarClienteById(new Cliente(idCliente));
        req.setAttribute("cliente", cliente);
        String jspEditar = "/WEB-INF/cliente/editarCliente.jsp";
        req.getRequestDispatcher(jspEditar).forward(req, resp);

    }
}
