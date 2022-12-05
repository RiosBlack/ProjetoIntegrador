//package com.dh.clinicaOdontologica.model;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import java.sql.Timestamp;
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//
//public class Agenda {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
//    //private LocalDateTime dataDisponivel;
//    private Timestamp dataDisponivel;
//
//    @OneToMany
//    private List<Dentista> dentistas;
//}
