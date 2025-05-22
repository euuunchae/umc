package umc.study.converter;

import umc.study.apiPayload.code.MemberRequestDTO;
import umc.study.apiPayload.code.MemberResponseDTO;
import umc.study.domain.Member;
import umc.study.domain.enums.Gender;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member) {
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request){

        Gender gender = null;

        switch (request.getGender()){
            case MALE:
                gender = Gender.MALE;
                break;
            case FEMALE:
                gender = Gender.FEMALE;
                break;
            case NONE:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .gender(gender)
                .name(request.getName())
                .memberFoodList(new ArrayList<>())
                .build();
    }

}
