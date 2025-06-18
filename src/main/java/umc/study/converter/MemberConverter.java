package umc.study.converter;

import umc.study.web.dto.MemberRequestDTO;
import umc.study.web.dto.MemberResponseDTO;
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

    public static MemberResponseDTO.LoginResultDTO toLoginResultDTO(Long memberId, String accessToken) {
        return MemberResponseDTO.LoginResultDTO.builder()
                .memberId(memberId)
                .accessToken(accessToken)
                .build();
    }

    public static MemberResponseDTO.MemberInfoDTO toMemberInfoDTO(Member member){
        return MemberResponseDTO.MemberInfoDTO.builder()
                .name(member.getName())
                .email(member.getEmail())
                .gender(member.getGender().name())
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
                .email(request.getEmail())
                .password(request.getPassword())
                .phone(request.getPhone())
                .memberFoodList(new ArrayList<>())
                .role(request.getRole())
                .build();

    }

}
