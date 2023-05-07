# NewsApp


## 뉴스 어플리케이션 v5.2

뉴스 등록, 단건 조회, 전체 조회 

repository, service, test 코드 구현


<br><br>

## 뉴스 어플리케이션 v5.3

Spring MVC 패턴

뉴스 글 작성, 저장된 전체 조회, 뉴스 한건 조회

타임리프로 view 구현

<br><br>

## 뉴스 어플리케이션 v5.4

### 스프링 시큐리티를 이용한 회원가입 기능 구현

Member 엔티티 생성, 

Member 회원가입 기능 리포지토리, 서비스, 기능테스트, 웹 계층(컨트롤러, 타임리프)

validation을 사용한 데이터 유효성 검사


<br><br>

## 뉴스 어플리케이션 v5.5

### 스프링 시큐리티를 이용한 로그인 기능 구현

config 파일에서 filterChain 메서드를 만들어 로그인 폼 url 처리 코드 구현

enum 클래스 Role 생성, user와 admin 상수 값 생성

login 컨트롤러, loginError 컨트롤러 생성

login form html 생성

MemberService에서 interface UserDetailsService를 구현하는 구현체 loadUserByUsername 메서드 생성

> #### findByEmail 메서드 수정 <br>
  > DB에 email이 존재하지 않으면 메서드에서 null을 반환 <br>
  > 존재한 다면 해당 객체를 반환하여, 이메일 중복 가입을 방지 <br>


<br><br>

## 뉴스 어플리케이션 v5.7

### 스프링 시큐리티를 이용한 로그아웃, url 권한 설정

Security Config 파일에서 url 접근 권한 설정.

news 글 작성 시 forbidden error 발생하는 것 해결
원인 : csrf 토큰을 선언하지 않았음.

타임리프 시큐리티를 사용하여 타임리프에서 인증/비인증 접근 처리

회원가입 시 권한을 USER -> ADMIN으로 변경

RedirectAttributes 객체를 사용하여 회원가입 완료 시 바로 로그인 창으로 이동.

스프링 시큐리티 테스트 의존성을 추가한 뒤에 MemberControllerTest를 생성하여 로그인 기능 테스트 

로그인을 인증한 사용자만 글을 작성할 수 있도록 글작성 컨트롤러 url에 admin 추가

뉴스 글 작성 권한 테스트를 하기 위해 @WithMockUser(username = "admin", roles = "ADMIN")을 선언 후 성공 및 실패 테스트






