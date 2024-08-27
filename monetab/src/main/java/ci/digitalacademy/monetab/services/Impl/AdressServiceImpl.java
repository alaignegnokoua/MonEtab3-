package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.repository.AdressRepository;
import ci.digitalacademy.monetab.services.AdressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdressServiceImpl implements AdressService {

    private final AdressRepository adressRepository;

    @Override
    public Adress save(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public Adress update(Adress adress) {
        Optional<Adress> adressOptional = adressRepository.findById(adress.getId());
        if (adressOptional.isPresent()) {
            Adress adressToUpdate = adressOptional.get();
            adressToUpdate.setCity(adress.getCity());
            adressToUpdate.setCountry(adress.getCountry());
            adressToUpdate.setStreet(adress.getStreet());
            return save(adressToUpdate);
        } else {
            throw new IllegalArgumentException("Adress not found");
        }
    }

    @Override
    public Optional<Adress> findOne(Long id) {
        return adressRepository.findById(id);
    }

    @Override
    public List<Adress> findAll() {
        return adressRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        adressRepository.deleteById(id);

    }
}
