package umc.study.repository.MissionRepository;

import umc.study.domain.Mission;
import umc.study.domain.enums.MissionStatus;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByMemberAndStatus(Long memberId, MissionStatus status, int offset, int limit);
    List<Mission> findMissionsByRegion(Long regionId, int offset, int limit);
    Long findCompleteMissionsByRegion(Long regionId, Long missionId, Long memberId, MissionStatus status);
}
