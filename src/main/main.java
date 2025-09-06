/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.ClienteDAO;

public class Main {
    public static void main(String[] args) {

        ClienteDAO dao = new ClienteDAO();

        int idAEliminar = 1; // ID del cliente a eliminar

        if (dao.eliminarCliente(idAEliminar)) {
            System.out.println("Cliente eliminado con exito.");
        } else {
            System.out.println("No se pudo eliminar el cliente.");
        }

        // Mostrar lista de clientes para confirmar
        System.out.println("\nLista de clientes:");
        dao.listarClientes().forEach(System.out::println);
    }
}
