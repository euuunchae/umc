package umc.study.converter;

import umc.study.domain.Mission;
import umc.study.domain.Store;
import umc.study.web.dto.MissionRequestDTO;
import umc.study.web.dto.MissionResponseDTO;


import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDTO.AddMissionResultDTO toAddMissionResultDTO(Mission mission) {
        return MissionResponseDTO.AddMissionResultDTO.builder()
                .missionId(mission.getId())
                .content(mission.getContent())
                .reward(mission.getReward())
                .createdAt(LocalDateTime.now())
                .deadline(mission.getDeadline())
                .build();
    }


    public static Mission toMission(MissionRequestDTO.AddMissionDTO request, Store store) {
        return Mission.builder()
                .content(request.getContent())
                .reward(request.getReward())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }


}
