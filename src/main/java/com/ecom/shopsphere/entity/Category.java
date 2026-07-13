package com.ecom.shopsphere.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
<<<<<<< HEAD
=======
import org.hibernate.annotations.CreationTimestamp;

>>>>>>> 9665014f809a43778d5b991f374791091a14099c
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

<<<<<<< HEAD
    private String description;

=======
    @Column(columnDefinition = "TEXT")
    private String description;

    @CreationTimestamp
>>>>>>> 9665014f809a43778d5b991f374791091a14099c
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
