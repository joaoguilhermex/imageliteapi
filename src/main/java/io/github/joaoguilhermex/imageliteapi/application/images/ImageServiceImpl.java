package io.github.joaoguilhermex.imageliteapi.application.images;

import io.github.joaoguilhermex.imageliteapi.domain.entity.Image;
import io.github.joaoguilhermex.imageliteapi.domain.enums.ImageExtension;
import io.github.joaoguilhermex.imageliteapi.domain.service.ImageService;
import io.github.joaoguilhermex.imageliteapi.infra.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository repository;

    @Override
    @Transactional
    public Image save(Image image) {
        return repository.save(image);
    }

    @Override
    public Optional<Image> getById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Image> search(ImageExtension extension, String query) {
        return repository.findByExtensionAndNameOrTagsLike(extension, query);
    }
}
