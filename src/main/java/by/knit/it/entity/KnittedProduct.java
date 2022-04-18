package by.knit.it.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
public class KnittedProduct {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Setter
    private String knittedProductId;
    @Setter
    private String authorUsername;
    @Setter
    private String authorId;
    @Setter
    private String Product;
    @Setter
    private LocalDateTime createdDate;
    @Setter
    private String photo;
    @Setter
    private String status;
    @Setter
    private String description; //описание
    @Setter
    private String order;//заказать






}
