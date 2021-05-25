package model;

import lombok.Data;

@Data
public class Lab {
    private Long id;
    private String name;
    private String description;
    private String date;
    private String result;
    private String hospitalName;
    private String patient;
    private String doctor;

    //   public Procedure setName(String name) {
    //      this.name = name;
    //      return this;

//    public Procedure setDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    public Procedure setDate(int date) {
//        this.date = date;
//        return this;
//    }
//
//    public Procedure setResult(String result) {
//        this.result = result;
//        return this;
//    }
//
//    public Procedure setHospital(String hospital) {
//        this.hospital = hospital;
//        return this;
//    }
//
//    public Procedure setPatient(String patient) {
//        this.patient = patient;
//        return this;
//    }
//
//    public Procedure setDoctor(String doctor) {
//        this.doctor = doctor;
//        return this;
//
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public int getDate() {
//        return date;
//    }
//
//    public String getResult() {
//        return result;
//    }
//
//    public String getHospital() {
//        return hospital;
//    }
//
//    public String getPatient() {
//        return patient;
//    }
//
//    public String getDoctor() {
//        return doctor;
//    }
}
