/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author Usuario
 */
import conexion.ConexionBD;
import modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        Connection conn = ConexionBD.getConnection();

        if (conn != null) {
            String sql = "SELECT * FROM Cliente";

            try (PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    Cliente cliente = new Cliente(
                        rs.getInt("id_usuario"),
                        rs.getString("Nombre"),
                        rs.getString("Apellido"),
                        rs.getString("Email"),
                        rs.getString("Telefono"),
                        rs.getString("Direccion"),
                        rs.getString("Contrasena")
                    );
                    lista.add(cliente);
                }

            } catch (SQLException e) {
                System.out.println("Error al listar clientes: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar conexión: " + e.getMessage());
                }
            }
        }
        return lista;
    }


// metodo para crear clientes

public boolean insertarCliente(Cliente cliente) {
    String sql = "INSERT INTO Cliente (Nombre, Apellido, Email, Telefono, Direccion, Contrasena) VALUES (?, ?, ?, ?, ?, ?)";

    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getTelefono());
        stmt.setString(5, cliente.getDireccion());
        stmt.setString(6, cliente.getContrasena());

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;

    } catch (SQLException e) {
        System.out.println("Error al insertar cliente: " + e.getMessage());
        return false;
    }
}
    // metodo para actualizar cliente

public boolean actualizarCliente(Cliente cliente) {
    String sql = "UPDATE Cliente SET Nombre = ?, Apellido = ?, Email = ?, Telefono = ?, Direccion = ?, Contrasena = ? WHERE id_usuario = ?";

    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cliente.getNombre());
        stmt.setString(2, cliente.getApellido());
        stmt.setString(3, cliente.getEmail());
        stmt.setString(4, cliente.getTelefono());
        stmt.setString(5, cliente.getDireccion());
        stmt.setString(6, cliente.getContrasena());
        stmt.setInt(7, cliente.getId_usuario());

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;

    } catch (SQLException e) {
        System.out.println("Error al actualizar cliente: " + e.getMessage());
        return false;
    }
}
    //metodo para eliminar cliente
public boolean eliminarCliente(int id) {
    String sql = "DELETE FROM Cliente WHERE id_usuario = ?";

    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);

        int filasAfectadas = stmt.executeUpdate();
        return filasAfectadas > 0;

    } catch (SQLException e) {
        System.out.println("Error al eliminar cliente: " + e.getMessage());
        return false;
    }
}

}


