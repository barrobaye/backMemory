package org.example.baseservice.event;

import lombok.Data;
import org.example.baseservice.dto.EmployerServiceDto;

import java.util.Date;
import java.util.UUID;
@Data
public class EmployerEvens implements Evens{
    private EmployerServiceDto employerServiceDto;
    private EmployerServiceStatus employerServiceStatus;
    private Date evensDate = new Date();
    private UUID evensId = UUID.randomUUID();

    public EmployerEvens(EmployerServiceDto employerServiceDto, EmployerServiceStatus employerServiceStatus, Date evensDate, UUID evensId) {
        this.employerServiceDto = employerServiceDto;
        this.employerServiceStatus = employerServiceStatus;
        this.evensDate = evensDate;
        this.evensId = evensId;
    }

    public EmployerEvens(EmployerServiceDto employerServiceDto, EmployerServiceStatus employerServiceStatus) {
        this.employerServiceDto = employerServiceDto;
        this.employerServiceStatus = employerServiceStatus;
    }

    public EmployerEvens() {
    }

    @Override
    public UUID getEvensId() {
        return evensId;
    }
    @Override
    public Date getEvensDate() {
        return evensDate;
    }
}
