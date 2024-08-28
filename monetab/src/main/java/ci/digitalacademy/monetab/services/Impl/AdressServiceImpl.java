package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.repository.AdressRepository;
import ci.digitalacademy.monetab.services.AdressService;
import ci.digitalacademy.monetab.services.dto.AdressDTO;
import ci.digitalacademy.monetab.services.mapper.AdressMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdressServiceImpl implements AdressService {

    private final AdressRepository adressRepository;

    @Override
    public AdressDTO save(AdressDTO adressDTO) {
        log.debug("Request to save : {}", adressDTO);
        Adress adress =  AdressMapper.toEntity(adressDTO);
        adress=adressRepository.save(adress);
        return AdressMapper.toDto(adress);
    }

   /* @Override
    public AdressDTO update(AdressDTO adress) {
        Optional<AdressDTO> adressOptional = adressRepository.findById(adress.getId());
        if (adressOptional.isPresent()) {
            AdressDTO adressDTOToUpdate = adressOptional.get();
            adressDTOToUpdate.setCity(adress.getCity());
            adressDTOToUpdate.setCountry(adressDT.getCountry());
            adressDTOToUpdate.setStreet(adressDTO.getStreet());
            return save(adressDTOToUpdate);
        } else {
            throw new IllegalArgumentException("AdressDTO not found");
        }
    } */

    @Override

    public AdressDTO update(AdressDTO adressDTO) {
        log.debug("Request to update : {}", adressDTO);
//        Adress adress =  AdressMapper.toEntity(adressDTO);
//        adress=adressRepository.save(adress);
//        return AdressMapper.toDto(adress);
            return findOne(adressDTO.getId()).map(existingAdress ->{
                existingAdress.setCity(adressDTO.getCity());
                existingAdress.setCountry(adressDTO.getCountry());
                existingAdress.setStreet(adressDTO.getStreet());
                return save(existingAdress);
            }).orElseThrow(()->new IllegalStateException("Adress not found"));
    }


    @Override
    public Optional<AdressDTO> findOne(Long id) {
        log.debug("Request to find one Adress : {}", id);
        return adressRepository.findById(id).map(AdressMapper::toDto);
    }

    @Override
    public List<AdressDTO> findAll() {
        return adressRepository.findAll().stream().map(adress ->{
            return AdressMapper.toDto(adress);
        }).toList();
    }

    @Override
    public void delete(Long id) {
        adressRepository.deleteById(id);

    }
}
