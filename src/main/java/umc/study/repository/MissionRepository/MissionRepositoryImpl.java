package umc.study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.study.domain.Mission;
import umc.study.domain.QMission;
import umc.study.domain.QStore;
import umc.study.domain.enums.MissionStatus;
import umc.study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QStore store = QStore.store;

    @Override
    public List<Mission> findMissionsByMemberAndStatus(Long memberId, MissionStatus status, int offset, int limit){
        BooleanBuilder predicate = new BooleanBuilder();

        predicate.and(memberMission.member.id.eq(memberId));
        predicate.and(memberMission.status.eq(status));

        return jpaQueryFactory
                .selectFrom(mission)
                .join(memberMission).on(mission.id.eq(memberMission.mission.id))
                .where(predicate)
                .orderBy(memberMission.createdAt.desc())
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    @Override
    public List<Mission> findMissionsByRegion(Long regionId, int offset, int limit){
        return jpaQueryFactory
                .selectFrom(mission)
                .join(store).on(store.id.eq(store.id))
                .where(store.region.id.eq(regionId))
                .offset(offset)
                .limit(limit)
                .fetch();

    }

    @Override
    public Long findCompleteMissionsByRegion(Long regionId, Long missionId, Long memberId, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if (missionId != null) {
            predicate.and(memberMission.mission.id.eq(missionId));
        }

        if (memberId != null) {
            predicate.and(memberMission.member.id.eq(memberId));
        }

        if (status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        if (regionId != null) {
            predicate.and(store.region.id.eq(regionId));
        }


        return jpaQueryFactory
                .select(memberMission.count())
                .from(memberMission)
                .join(mission).on(memberMission.mission.id.eq(mission.id))
                .where(predicate)
                .fetchOne();

    }
}
