package cat.solar.api.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SolarDataDTO {

    private Date time;
    
    private Double power_generated;
    
    private Double grid_injection;
    
    private Double grid_consumption;

    private Double power_consumption;
}