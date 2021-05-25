package com.sql.connection.listData;

import config.DBConfig;
import model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListHospitalLabs {


    //???
    private final DBConfig dbConfig;

    public ListHospitalLabs() {
        this.dbConfig = new DBConfig();

    }

    public void  listHospitalLabs() {

        String HospitalToSearch="LLL";

        String sqlSelectAllLab = String.format("SELECT l.id, l.doctor, l.date, l.hospitalName, l.name,l.description,l.result,l.patient, h.name " +
                "FROM lab l inner join hospital h on h.name = l.hospitalName where h.name ='%s'",HospitalToSearch);

        List<HospitalLabs> hospitalAllProcedureList = new ArrayList<>();

        try {
            ResultSet rs = dbConfig.executeQuery(sqlSelectAllLab);


            while (rs.next()) {
                Hospital hospital = new Hospital();
                hospital.setName(rs.getString("name"));

                Lab lab = new Lab();
                lab.setId(rs.getLong("id"));
                lab.setName(rs.getString("name"));
                lab.setDescription(rs.getString("description"));
                lab.setResult(rs.getString("result"));
                lab.setPatient(rs.getString("patient"));
                lab.setDate(rs.getString("date"));

                HospitalLabs hospitalLabs = new HospitalLabs();
                hospitalLabs.setLab(lab);
                hospitalLabs.setHospital(hospital);


                hospitalAllProcedureList.add(hospitalLabs);




                // do something with the extracted data...
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(hospitalAllProcedureList);

    }
}
