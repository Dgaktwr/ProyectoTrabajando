package application;

import javafx.fxml.FXML;

import Dao.PersonalDao;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import Model.Personal;

public class LoobyController {

    @FXML
    private void btnRegistro() {
        System.out.println("Registro button clicked");
        // Añadir lógica para el botón de Registro aquí
    }

    @FXML
    private void btnConsulta() {
        System.out.println("Consulta button clicked");
        // Añadir lógica para el botón de Consulta aquí
    }

    @FXML
    private void btnControlAdmin() {
        System.out.println("Control administrativo button clicked");
        // Añadir lógica para el botón de Control Administrativo aquí
    }

    @FXML
    private void btnModificacionDatos() {
        System.out.println("Modificacion de Datos button clicked");
        // Añadir lógica para el botón de Modificación de Datos aquí
    }

    @FXML
    private void btnPersonal() {
        System.out.println("Personal button clicked");
        // Añadir lógica para el botón de Personal aquí
    }
    @FXML
    private TextField idField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField phoneField;

    private PersonalDao personalDao = new PersonalDao();

    @FXML
    private void handleAddEmployee(ActionEvent event) {
        int id = Integer.parseInt(idField.getText());
        String name = nameField.getText();
        String lastName = lastNameField.getText();
        String address = addressField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        Personal personal = new Personal(id, "ID Type", name, lastName, address, email, phone);
        personalDao.insertPersonal(personal);
    }

    @FXML
    private void handleShowEmployees(ActionEvent event) {
        // Implementar lógica para mostrar empleados (puede ser una nueva ventana o una lista en la misma)
    }

}
