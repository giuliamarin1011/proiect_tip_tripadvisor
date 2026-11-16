package TravelGuide.config;

import TravelGuide.entity.Atractie;
import TravelGuide.repository.AtractieRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AtractieConverter implements Converter<String, Atractie> {

    private final AtractieRepository atractieRepository;

    public AtractieConverter(AtractieRepository atractieRepository) {
        this.atractieRepository = atractieRepository;
    }

    @Override
    public Atractie convert(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        Integer idAtractie = Integer.valueOf(id);

        return atractieRepository.findById(idAtractie)
                .orElseThrow(() ->
                        new IllegalArgumentException("Atracție inexistentă: " + idAtractie));
    }
}