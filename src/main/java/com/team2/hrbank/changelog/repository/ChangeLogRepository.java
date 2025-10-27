package com.team2.hrbank.changelog.repository;

import com.team2.hrbank.changelog.domain.ChangeLog;
import com.team2.hrbank.changelog.domain.QChangeLog;
import com.team2.hrbank.changelog.dto.ChangeLogRequestDto;
import com.team2.hrbank.changelog.dto.CursorPageResponseChangeLogDto;
import io.github.openfeign.querydsl.jpa.spring.repository.QuerydslJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ChangeLogRepository extends QuerydslJpaRepository<ChangeLog, Long> {

    QChangeLog changeLog = QChangeLog.changeLog;

    default CursorPageResponseChangeLogDto findChangeLogs(ChangeLogRequestDto.PaginatedLogRequest request) {
        // Implementation placeholder
        return null;
    }

    default Long countChangeLogs(LocalDateTime fromDate, LocalDateTime toDate) {
        // Implementation placeholder
        return selectFrom(changeLog)
                .where(changeLog.at.between(fromDate, toDate))
                .fetchCount();
    }

    default Optional<LocalDateTime> findRecentLogDate() {
        // Implementation placeholder
        return select(changeLog.at)
                .from(changeLog)
                .orderBy(changeLog.at.desc())
                .limit(1)
                .fetch()
                .stream()
                .findFirst();
    }

}
