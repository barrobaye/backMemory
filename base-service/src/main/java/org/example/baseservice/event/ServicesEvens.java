package org.example.baseservice.event;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class ServicesEvens implements Evens {

    private UUID evensId = UUID.randomUUID();
    private Date evensDate = new Date();

    @Override
    public UUID getEvensId() {
        return evensId;
    }
    @Override
    public Date getEvensDate() {
        return evensDate;
    }
}
