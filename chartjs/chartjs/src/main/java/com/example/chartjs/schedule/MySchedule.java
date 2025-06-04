package com.example.chartjs.schedule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.chartjs.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MySchedule {

    private final MemberMapper mapper;

    // 매 1분마다 실행
    @Scheduled(cron = "0 1 1 1 1 ?")
    public void cleanOldPwHistory() {
        System.out.println("비밀번호 이력 정리 스케줄러 실행됨");

        List<String> ids = mapper.findAllMemberIds();
        for (String id : ids) {
            System.out.println("정리 대상 ID: " + id);
            mapper.deleteOldPwHistory(id); // 실제로 이 구문이 실행되는지 로그 확인
        }
    }
}
/*
    // 🔹 매월 25일 23:59:00 → 1년 미접속 계정 OFF + 메일 발송 로그
    @Scheduled(cron = "0 59 23 25 * ?")
    public void handleDormantAccounts() {
        List<String> inactiveIds = mapper.findInactiveMembers();
        System.out.println("[휴면대상] " + inactiveIds);
        for (String id : inactiveIds) {
            mapper.updateMemberActive(id);
            String email = mapper.findEmailById(id);
            System.out.println("[메일발송] " + email + "님, 계정이 휴면 상태로 전환되었습니다.");
            sendDormantNotice(email);
        }
    }
    @Autowired
    private JavaMailSender mailSender;

    public void sendDormantNotice(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("휴면 계정 안내");
        message.setText("1년 이상 미접속으로 휴면 처리되었습니다.");
        mailSender.send(message);
    }
}

	/*
	@Scheduled(cron = "0 12 12 * * *")
	public void myScheduleTest() {
		log.info("스케쥴러 테스트");
	}
	*/
	
	/* 휴면계정으로 만드는 서비스 메서드*/
	/* 메일을 보내는 서비스 메서드*/
	/* 1개월 지난 로그인 이력을 삭제하는 서비스 메서드*/
