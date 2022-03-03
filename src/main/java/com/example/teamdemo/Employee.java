package com.example.teamdemo;




public class Employee {


    private int emp_id;
    private String first_name;

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    private String last_name;
    private int dep_id;



    public int getEmp_id() {
        return emp_id;

    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }



    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }



    public Employee(int emp_id, String first_name, String last_name, int dep_id) {
        this.emp_id = emp_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dep_id = dep_id;
    }


    public Employee( String first_name, String last_name, int dep_id) {

        this.first_name = first_name;
        this.last_name = last_name;
        this.dep_id = dep_id;
    }


}
