package tn.eesprit.gestionevenementback.dto;


import lombok.Data;

import java.util.Date;

@Data
public class EventRequest {

    String title ;
    String description;
  Date  startDate;
   Date endDate;
   String lieu;
   String type;
   String lang;
 String   lat;
    private byte[] imageData;
}
