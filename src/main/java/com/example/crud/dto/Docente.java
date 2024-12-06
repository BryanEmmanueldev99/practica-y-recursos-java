package com.example.crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_docentes")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nombre;

    private String email;

    private Integer edad;

    private String fecha_nacimiento;

    private String genero;

    // protected void miSesion(HttpServletRequest request) {
    //     HttpSession misession = request.getSession();
    // }
}
