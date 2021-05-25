package com.sql.connection.listData;

import config.DBConfig;
import model.Lab;
import model.Patient;
import model.Something;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListSomethingBySomething {


    //???
    private final DBConfig dbConfig;

    public ListSomethingBySomething() {
        this.dbConfig = new DBConfig();

    }

    public void  listSomethingBySomething() {

        String patientToSearch="lllll";

        String sqlSelectAllLab = String.format("SELECT l.id, l.patient, l.date, l.hospitalName, l.name,l.description,l.result, p.firstName " +
                "FROM lab l inner join patient p on l.patient = p.firstName where p.firstName ='%s'",patientToSearch);

        List<Something> patientAllProcedureList = new ArrayList<>();

        try {
            ResultSet rs = dbConfig.executeQuery(sqlSelectAllLab);


            while (rs.next()) {
                Patient patient = new Patient();
                patient.setFirstName(rs.getString("firstName"));

                Lab lab = new Lab();
                lab.setId(rs.getLong("id"));
                lab.setName(rs.getString("name"));
                lab.setDescription(rs.getString("description"));
                lab.setResult(rs.getString("result"));
                lab.setPatient(rs.getString("patient"));
                lab.setDate(rs.getString("date"));

                Something something = new Something();
                something.setPatient(patient);
                something.setLab(lab);


                patientAllProcedureList.add(something);




                // do something with the extracted data...
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(patientAllProcedureList);

    }
}
