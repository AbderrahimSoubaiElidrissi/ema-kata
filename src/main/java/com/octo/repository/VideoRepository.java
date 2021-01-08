package com.octo.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.octo.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;
import com.octo.domain.enums.Level;

public interface VideoRepository extends JpaRepository<Video, String>, JpaSpecificationExecutor<Video> {
	public List<Video> findByLevelAndOrTags(Level level, List<String> tags);
}
