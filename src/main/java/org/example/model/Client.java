package org.example.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "CLIENT")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 200, nullable = false)
    private String name;
}
