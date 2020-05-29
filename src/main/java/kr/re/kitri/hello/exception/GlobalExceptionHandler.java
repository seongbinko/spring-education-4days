package kr.re.kitri.hello.exception;

import org.springframework.http.HttpStatus;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLInvalidAuthorizationSpecException;

//@ControllerAdvice + @RestController
@RestControllerAdvice
public class GlobalExceptionHandler {
    // 예외 종류 적기
    @ExceptionHandler(value = SQLInvalidAuthorizationSpecException.class)
    public String handleSQLInvalidException(SQLInvalidAuthorizationSpecException se) {
        return "데이터베이스 접속에 문제가 있습니다." + se.getMessage();
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)//옵션
    @ExceptionHandler(value = ArithmeticException.class)
    public String handleArithhException(ArithmeticException ae) {
        return "0으로 나누는 에러가 발생" + ae.getMessage();
    }

    @ExceptionHandler(value = BadSqlGrammarException.class)
    public String handleSyntax(){
        return "SQL Syntax Eroor";
    }


    @ExceptionHandler(value = SQLException.class)
    public String handleSQLException() {
            return "SQL 예외 발생";
    }

    @ExceptionHandler(value = Exception.class)
    public String handleAll(Exception e) {
        return "기타등등 예외를 모두 여기서 잡습니다" + e;
    }
}
