package org.example.myservices.services;

import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.baseservice.dto.MyServiceDto;
import org.example.myservices.entity.MyServices;
import org.example.myservices.entity.TypeService;
import org.example.myservices.mapper.ServiceMapper;
import org.example.myservices.repository.MyServiceRepository;
import org.example.myservices.repository.TypeServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
@Data
@Slf4j
public class ServiceSrvs {
  //  private static final String USERS_TOPIC = "user_event_topic";
    private final MyServiceRepository myServiceRepository;
    protected final TypeServiceRepository typeServiceRepository;
    private final ServiceMapper mapper;
    public List<MyServiceDto> getAllServices(){
        return myServiceRepository.findAll().stream().map(mapper::MyserviceToMyServiceDto).collect(Collectors.toList());
    }

  public MyServices saveServices(MyServiceDto myServiceDto) throws Exception {
       myServiceDto.setStatus("INDISPONIBLE");
      UUID typeServiceid = myServiceDto.getTypeService();
      Optional<TypeService> typeServiceOptional = typeServiceRepository.findById(typeServiceid);
    if (typeServiceOptional.isPresent()) {
      TypeService typeService = typeServiceOptional.get();
      myServiceDto.setTypeService(typeService.getId());
      MyServices myServices = myServiceRepository.save(mapper.MyserviceDtoToService(myServiceDto));
      myServiceDto.setId(myServices.getId());
      return myServices;
    } else {
      // Gérer le cas où le typeService correspondant n'est pas trouvé
      throw new Exception("TypeService not found for UUID: " + typeServiceid);
    }


  }

}
