package be.vdab.groenetenen.services;

import be.vdab.groenetenen.domain.Werknemer;
import be.vdab.groenetenen.repositories.WerknemerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED)
public class DefaultWerknemerService implements WerknemerService {
    private final WerknemerRepository werknemerRepository;

    public DefaultWerknemerService(WerknemerRepository werknemerRepository) {
        this.werknemerRepository = werknemerRepository;
    }

    @Override
    public Page<Werknemer> findAll(Pageable pageable) {
        return werknemerRepository.findAll(pageable);
    }
}
