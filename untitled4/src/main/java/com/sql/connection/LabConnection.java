package com.sql.connection;

import config.DBConfig;
import model.Lab;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LabConnection {


    //???
    private final DBConfig dbConfig;

    public LabConnection() {
        this.dbConfig = new DBConfig();

    }

    public void connectGetAllLabColumn() {
        String tableOne = "Lab";
        String tableTwo = "doctors";
        String tableColumnOne = "doctor";
        String tableColumnTwo = "firstName";
        String condition = "LBob";
        String sqlSelectAllLab = String.format("SELECT  * from %s l inner join %s h on l.%s = h.%s where h.%s = '%s'", tableOne, tableTwo, tableColumnOne, tableColumnTwo, tableColumnTwo, condition);
        List<Lab> labList = new ArrayList<>();

        try {
            ResultSet rs = dbConfig.executeQuery(sqlSelectAllLab);


            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String result = rs.getString("result");
            //    Hospital hospitalId = rs.getString("hospitalName");
                String patient = rs.getString("patient");
            //    String doctor = rs.getString("doctor");
                String data = rs.getString("date");


                Lab lab = new Lab();
                lab.setId(id);

                boolean isCorrectName = (name.length() >= 3 || name.matches("[aA-zZ ] +$"));
                lab.setName(isCorrectName ? name : "err");

                lab.setDescription(description);

                boolean isCorrectDOB = (LocalDate.now().isAfter(LocalDate.parse(data, DateTimeFormatter.ISO_DATE)));
                lab.setDate(isCorrectDOB ? data : "err");



                lab.setResult(result);
             //   lab.setDoctor(doctor);
               lab.setPatient(patient);
              //  lab.setHospital(hospital);


//                     .setName(rs.getString("name"))
//                            .setDescription(rs.getString("description"))
//                            .setHospital(rs.getString("hospitalName"))
//                            .setPatient(rs.getString("patient"))
//                            .setResult(rs.getString("result"))
//                            .setDate(rs.getInt("date"))
//                            .setDoctor(rs.getString("doctor"));

                labList.add(lab);


                // do something with the extracted data...
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(labList);

    }
}