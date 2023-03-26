package com.example.demo.entity;

import com.example.demo.dto.TutorialCustomDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tutorial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SqlResultSetMapping(
        name = "TutorialValueMapping",
        classes = @ConstructorResult(
                targetClass = TutorialCustomDTO.class,
                columns = {
                        @ColumnResult(name = "id", type = Integer.class),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "level", type = int.class),
                        @ColumnResult(name = "description"),
                        @ColumnResult(name = "published", type = boolean.class),
                        @ColumnResult(name = "author_name")
                }))
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 256)
    private String description;

    @Column(nullable = false)
    private int level;

    @Column
    private boolean published;

    @Column
    private String authorName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Tutorial tutorial = (Tutorial) o;
        return id != null && Objects.equals(id, tutorial.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
