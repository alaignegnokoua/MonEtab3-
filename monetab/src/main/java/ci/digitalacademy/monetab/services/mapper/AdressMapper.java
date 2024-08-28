package ci.digitalacademy.monetab.services.mapper;


import ci.digitalacademy.monetab.models.Adress;
import ci.digitalacademy.monetab.services.dto.AdressDTO;

public final class AdressMapper {

    private AdressMapper() {}

    public static AdressDTO toDto(Adress adress) {
        AdressDTO adressDTO = new AdressDTO();
        adressDTO.setId(adress.getId());
        adressDTO.setCity(adress.getCity());
        adressDTO.setCountry(adress.getCountry());
        adressDTO.setStreet(adress.getStreet());

        return adressDTO;
    }

    public static Adress toEntity(AdressDTO adressDTO) {

        Adress adress = new Adress();
        adress.setId(adressDTO.getId());
        adress.setCity(adressDTO.getCity());
        adress.setCountry(adressDTO.getCountry());
        adress.setStreet(adressDTO.getStreet());
        return adress;
    }




}
