package kg.avenir.library.entity;


import lombok.Getter;
import lombok.Setter;
import kg.avenir.library.enums.Category;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}