package TravelGuide.config;

import TravelGuide.entity.Utilizator;
import TravelGuide.repository.UtilizatorRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UtilizatorConverter implements Converter<String, Utilizator> {

    private final UtilizatorRepository utilizatorRepository;

    public UtilizatorConverter(UtilizatorRepository utilizatorRepository) {
        this.utilizatorRepository = utilizatorRepository;
    }

    @Override
    public Utilizator convert(String id) {
        if (id == null || id.isBlank()) {
            return null;
        }

        Integer idUtilizator = Integer.valueOf(id);

        return utilizatorRepository.findById(idUtilizator)
                .orElseThrow(() ->
                        new IllegalArgumentException("Utilizator inexistent: " + idUtilizator));
    }
}