package org.example.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PLANET")
@Data
public class Planet {
    @Id
    @Column(name = "ID", length = 100)
    private String id;

    @Column(name = "NAME", length = 500, nullable = false)
    private String name;
}
