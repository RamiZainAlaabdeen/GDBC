package com.example.teamdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField Employee_Id;


    @FXML
    private  TextField Employee_Name;

    @FXML
    private  TextField lastName;

    @FXML
    private  TextField departmentId;

    @FXML
    private  TextField Bounus;

    @FXML
    private Button Insert;

    @FXML
    private Button Ubdate;

    @FXML
    private Button Delete;


    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, Integer> idCol;
    @FXML
    private TableColumn<Employee, String> firstnameCol;
    @FXML
    private TableColumn<Employee, String> lastnameCol;
    @FXML
    private TableColumn<Employee, Integer> departmentidCol;



    @FXML
    public void onButtonClicked(ActionEvent e) throws Exception{


        if(e.getSource().equals(Insert)) {


            insertRecord();


        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showEmp();
    }


    public ObservableList<Employee> getEmpList(){

        ObservableList<Employee> empList= FXCollections.observableArrayList();
        Connection conn= DBU.getConnection();
        String query= "SELECT * FROM employee";
        Statement st=null;
        ResultSet rs= null;

        try {
            st= conn.createStatement();
            rs= st.executeQuery(query);
            Employee employee;
            while (rs.next()){

                employee= new Employee(rs.getInt("emp_id"),rs.getString("first_name")
                        ,rs.getString("last_name"),rs.getInt("dep_id")
                        );

                empList.add(employee);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IllegalStateException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return empList;

    }

    public void showEmp(){

        ObservableList<Employee> list= getEmpList();

        idCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("emp_id"));
        firstnameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("first_name"));
        lastnameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("last_name"));
        departmentidCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("dep_id"));


        tableView.setItems(list);


    }



    private void insertRecord(){

        String id= Employee_Id.getText();
        String first_name= Employee_Name.getText();
        String last_name= lastName.getText();
        String dep= departmentId.getText();
      //  String bounus= Bounus.getText();

        String query= " insert into employee values (" + id + ",'" +
                first_name + "','" + last_name + "'," + dep + ") ";
        executeQuery(query);
        showEmp();

    }


    private void executeQuery(String query){

        Connection conn= DBU.getConnection();
        Statement st;

        try {
            st= conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}