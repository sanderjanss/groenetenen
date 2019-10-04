package be.vdab.groenetenen.services;

import be.vdab.groenetenen.entities.Offerte;
import be.vdab.groenetenen.repositories.OfferteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
public class DefaultOfferteService implements OfferteService{
    private final OfferteRepository offerteRepository;

    public DefaultOfferteService(OfferteRepository offerteRepository) {
        this.offerteRepository = offerteRepository;
    }

    @Override
    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
    public void create(Offerte offerte) {
        offerteRepository.save(offerte);
    }
}
