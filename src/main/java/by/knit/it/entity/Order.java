package by.knit.it.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Order {
    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;
    @Setter
    private String status;
    @Setter
    private String customername;
    @Setter
    private String customerphone;
    @Setter
    private String customeraddress;
    @Setter
    private String customercomment;


}
