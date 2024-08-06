package io.github.twinklekhj.smart.exception;

public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException() {
        super("원하는 데이터를 찾을 수 없습니다");
    }
    public DataNotFoundException(String message) {
        super(message);
    }
}