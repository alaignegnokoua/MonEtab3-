package ci.digitalacademy.monetab.services.Impl;

import ci.digitalacademy.monetab.models.FicheNote;
import ci.digitalacademy.monetab.models.Teacher;
import ci.digitalacademy.monetab.repository.FicheNoteRepository;
import ci.digitalacademy.monetab.services.FicheNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FicheNoteServiceImpl implements FicheNoteService {

    private final FicheNoteRepository ficheNoteRepository;


    @Override
    public FicheNote save(FicheNote ficheNote) {
        return ficheNoteRepository.save(ficheNote);
    }

    @Override
    public FicheNote update(FicheNote ficheNote) {
        Optional<FicheNote> optional = ficheNoteRepository.findById(ficheNote.getId());
        if (optional.isPresent()) {
            FicheNote ficheNoteUpdated = optional.get();
            ficheNoteUpdated.setNote(ficheNote.getNote());
            ficheNoteUpdated.setAnnee(ficheNote.getAnnee());
            return save(ficheNoteUpdated);

        } else {
            throw new IllegalArgumentException("FicheNote not found");
        }
    }

    @Override
    public Optional<FicheNote> findOne(Long id) {
        return ficheNoteRepository.findById(id);
    }

    @Override
    public List<FicheNote> findAll() {
        return ficheNoteRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        ficheNoteRepository.deleteById(id);

    }
}
