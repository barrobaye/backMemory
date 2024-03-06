package org.example.myservices.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.baseservice.dto.EmployerServiceDto;
import org.example.myservices.mapper.EmployerServiceMapper;

import org.example.myservices.repository.EmployerServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
@Data
public class ServiceEmployer {
    private final EmployerServiceRepository employerServiceRepository;
    private final EmployerServiceMapper mapper;
    public List <EmployerServiceDto> getAllEmployerService(){
        return employerServiceRepository.findAll().stream().map(mapper::EmplServToEmplServDTO).toList();
    }


    // public
}




/* private final CompteRepository compteRepository;t
    private final CompteTransactionMapper mapper;
    private final Utils utils;


    public List<CompteDTO> getAllComptes() {
        return compteRepository.findAll()
                .stream()
                .map(mapper::compteToCompteDTO)
                .toList();
    }

    @Transactional
    public CompteEvent saveCompte(ClientEvent clientEvent){
        ClientDTO clientDTO = clientEvent.getClientDTO();
        CompteEvent compteEvent = null;
        CompteDTO compteDTO = new CompteDTO(clientDTO.getId(), clientDTO.getSolde());
        try{
            utils.checkSoldeIsValid(clientDTO.getSolde());
            compteRepository.save(new Compte(clientDTO.getId(), clientDTO.getSolde()));
            compteEvent = new CompteEvent(CompteStatus.UPDATED , compteDTO);
        }catch(Exception ex){
            compteEvent = new CompteEvent(CompteStatus.ERREUR_SOLDE , compteDTO);
        }
        return compteEvent;
    }*/
