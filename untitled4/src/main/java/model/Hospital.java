package model;

import lombok.Data;

@Data
public class Hospital {
    private int id;
    private String name;
    private String description;
    private String address;
    private String phoneNumber;
    private String email;
    private String headDoctor;


}
