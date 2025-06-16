package org.scoula.persistence;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.fail;

@Log4j2 //로그 찍어야 하니까
public class JDBCTest {
    //여기에 여러 설정 잘 되었는지 함수 만들어서 테스트 할 예정
    //테스트 단위마다 함수 하나씩 만들기
    //함수 단위마다 테스트 함 -> 단위 테스트(Unit Test)
    //JUnit 라이브러리 사용 예정!

    //모든 단위테스트에서 사용할 드라이버를 설정하는 부분이 필요함

    //아래 모든 함수 호출 전에 무조건 한 번 이거 실행하기 위해 @BeforeAll 어노테이션 사용(시작할 때 한번 실행함)
    @BeforeAll
    public static void setup() {
        //드라이버로 클래스 파일을 연결 -> 예외처리 필요! (DB/파일연결은 무조건 예외 처리 필요) -> try catch로
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); //상세한 에러 정보를 프린트할 수 있음.
        }
    }

    @Test
    @DisplayName("JDBC 드라이버연결이된다.")
    public void testConnection() {
        String url = "jdbc:mysql://localhost:3306/scoula_db";
        try (Connection con = DriverManager.getConnection(url, "scoula", "1234")) {
            log.info(con);
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            fail(e.getMessage()); //-> junit에게 테스트하려고 했던 것 실패했다 라고 명시적으로 알려주는 역할의 함수
        }
    }
}

