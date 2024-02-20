package org.example.myusers.service;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.baseservice.dto.UserDto;
import org.example.myusers.entity.Employer;
import org.example.myusers.mapper.EmployerServiceMapper;
import org.example.myusers.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class EmployerService {
    private static final String USERS_TOPIC = "user_event_topic";
    private final EmployerRepository employerRepository;
    private final EmployerServiceMapper mapper;

public List <UserDto> getAllUsers(){
    return employerRepository.findAll().stream().map(mapper::EmployerToUserDto).collect(Collectors.toList());
}
@Transactional
    public Employer saveEmployer(UserDto userDto){
    userDto.setUserStatus("CREATED");
    userDto.setServiceStatus("INIT");
    Employer employer= employerRepository.save(mapper.UserDtoToEmployer(userDto));
    userDto.setId(employer.getId());
    return employer;
}













    /*
    private final KafkaTemplate<String, ClientEvent> kafkaTemplate;


    @Transactional
    public Client saveClient(ClientDTO clientDTO) {
        clientDTO.setClientStatus("CREATED");
        clientDTO.setCompteStatus("INIT");
        Client client = clientRepository.save(mapper.clientDTOToClient(clientDTO));
        clientDTO.setId(client.getId());
        ClientEvent clientEvent = new ClientEvent(clientDTO, ClientStatus.CREATED);
        kafkaTemplate.send(CLIENT_TOPIC, clientEvent);
        return client;
    }

    @Transactional
    public void updateClient(CompteEvent event) {
        UUID clientId = event.getCompteDTO().getClientId();

        clientRepository.findById(clientId).ifPresent(client -> {
            boolean isSaved = CompteStatus.UPDATED.equals(event.getCompteStatus());
            ClientStatus clientStatus = isSaved ? ClientStatus.COMPLETE : ClientStatus.ERREUR;
            client.setClientStatus(clientStatus);
            client.setCompteStatus(event.getCompteStatus());
        });
    }*/
}
