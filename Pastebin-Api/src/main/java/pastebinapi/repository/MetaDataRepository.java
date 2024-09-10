package pastebinapi.repository;

import pastebinapi.model.PasteMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaDataRepository extends JpaRepository<PasteMetadata, String> {
}
