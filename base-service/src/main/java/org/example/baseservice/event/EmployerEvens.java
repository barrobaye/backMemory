package org.example.baseservice.event;

import lombok.Data;
import org.example.baseservice.dto.MyServiceDto;
import org.example.baseservice.dto.UserDto;

import java.util.Date;
import java.util.UUID;

@Data
public class EmployerEvens implements Evens {
     private MyServiceDto myServiceDto;
    private UserDto userDto;
    private UsersStatus usersStatus;
    private UUID evensId = UUID.randomUUID();
    private Date evensDate = new Date();

    public EmployerEvens(UserDto userDto, UsersStatus usersStatus, UUID evensId, Date evensDate) {
        this.userDto = userDto;
        this.usersStatus = usersStatus;
        this.evensId = evensId;
        this.evensDate = evensDate;
    }

    public EmployerEvens() {
    }

    public EmployerEvens(UserDto userDto, UsersStatus usersStatus) {
        this.userDto = userDto;
        this.usersStatus = usersStatus;
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
