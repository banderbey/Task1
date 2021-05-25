package com.sql.connection.listData;

import config.DBConfig;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListDoctorLabs {


    //???
    private final DBConfig dbConfig;

    public ListDoctorLabs() {
        this.dbConfig = new DBConfig();

    }

    public void  listDoctorsLabs() {

        String DoctorToSearch="MBob";

        String sqlSelectAllLab =String.format("SELECT l.id, l.doctor, l.date, l.hospitalName, l.name,l.description,l.result,l.patient, d.firstName " +
                "FROM lab l inner join doctors d on l.doctor = d.firstName where d.firstName ='%s'",DoctorToSearch);

        List<DoctorLabs> doctorAllProcedureList = new ArrayList<>();

        try {
            ResultSet rs = dbConfig.executeQuery(sqlSelectAllLab);


            while (rs.next()) {
                Doctor doctor = new Doctor();
                doctor.setFirstName(rs.getString("firstName"));

                Lab lab = new Lab();
                lab.setId(rs.getLong("id"));
                lab.setName(rs.getString("name"));
                lab.setDescription(rs.getString("description"));
                lab.setResult(rs.getString("result"));
                lab.setPatient(rs.getString("patient"));
                lab.setDate(rs.getString("date"));

                DoctorLabs doctorLabs = new DoctorLabs();
                doctorLabs.setLab(lab);
                doctorLabs.setDoctor(doctor);


                doctorAllProcedureList.add(doctorLabs);




                // do something with the extracted data...
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(doctorAllProcedureList);

    }
}
