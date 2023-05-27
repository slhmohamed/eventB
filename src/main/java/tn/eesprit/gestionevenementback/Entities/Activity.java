package tn.eesprit.gestionevenementback.Entities;

import javax.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long ActivityId;

    String title;
    String description;
     String debut;
     String fin;
       public Activity(String title,String description,String debut,String fin){

           this.title=title;
           this.description=description;
           this.debut=debut;
           this.fin=fin;
       }





}
