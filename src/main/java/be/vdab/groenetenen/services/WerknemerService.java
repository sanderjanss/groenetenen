package be.vdab.groenetenen.services;

import be.vdab.groenetenen.domain.Werknemer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface WerknemerService {
    Page<Werknemer> findAll(Pageable pageable);
}
