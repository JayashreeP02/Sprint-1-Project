package com.tnsif.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Placement")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Placement {

    @Id
    private long id;

    @Column(name="company_name")
    private String CompanyName;

    @Column(name="Job_title")
    private String Role;

    @Column(name="Placement_Date")
    private LocalDate PlacementDate;

    @Column(name="Student_id")
    private long studId;
}

