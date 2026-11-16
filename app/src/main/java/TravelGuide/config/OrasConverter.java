package TravelGuide.config;

import TravelGuide.entity.Oras;
import TravelGuide.repository.OrasRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class OrasConverter implements Converter<String, Oras> {

    private final OrasRepository orasRepository;

    public OrasConverter(OrasRepository orasRepository) {
        this.orasRepository = orasRepository;
    }

    @Override
    public Oras convert(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        Integer idOras = Integer.valueOf(id);

        return orasRepository.findById(idOras)
                .orElseThrow(() ->
                        new IllegalArgumentException("Oraș inexistent: " + idOras));
    }
}