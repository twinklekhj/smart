# 프로젝트
## Tech Stack

* Language: Java 17
* Framework: Spring Boot 3.x
* Persistence: MyBatis
* DBMS: PostgreSQL

<br>

## 기능
* 간단한 도서 CRUD

<br>

## 주요 클래스
* io.github.twinklekhj.smart.dao.CrudService: Mapper 입력시 CRUD를 자동화한 추상클래스
* io.github.twinklekhj.smart.dao.CrudQuery: Crud 쿼리 정보 클래스
* io.github.twinklekhj.smart.api.service.BookService: CrudService를 적용한 사례

<br>

## 설명
* MyBatis 환경에서 추상클래스를 이용한 CRUD 자동화 사례를 위해 간단한 프로젝트를 구상하였습니다.
* 블로그 포스팅을 작성하며 개발하였습니다.
* 포스트 링크: https://velog.io/@developer_khj/Spring-Code-Refactoring-2




