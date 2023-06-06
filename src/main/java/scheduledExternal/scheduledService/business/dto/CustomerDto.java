package scheduledExternal.scheduledService.business.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CustomerDto {
    private int id;
    private String tckn;
    private String name;
    private String surname;
    private String address;
    private int versionNumber;
}
