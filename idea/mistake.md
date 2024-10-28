1.  header템플릿,footer템플릿을 재사용하기 위해 따로 만들었다면 css파일도 따로 만드는것이 좋다
    1. 내 생각에는 각 템플릿에 css를 링크해서 템플릿을 로드하는 방식으로 하고싶었는데 이런 방식은 맞지 않는다고 한다.  
2. mysql 은 8.4ver을 다운받지 않으면 9.0Ver으로 업그레이드 할 수가 없다고 한다
3. 인증,인가 클래스에서 /users라는 템플릿을 따로 허가하지 않아서 회원가입이 되지 않았다.
4. Spring Security에서는 login.html 인풋 name이 "username" 이라고 해야지만 email로 인식함 
5. 시큐리티 구성 클래스에서 /renewal로 이동하라는 명령어가 있어서 매핑을 하지 않았는데 이것 때문에 오류가 생겼다 
6.  "status": 999, "error": "None", "message": "No message available"  -> 이런 오류가 떴었다.
   1..formLogin(formLogin -> formLogin
   .loginPage("/login")
   .defaultSuccessUrl("/renewal",true)
   .failureUrl("/login?error=true")) 로그인 폼에서  
   .defaultSuccessUrl("/renewal",true) 이 부분을 true를 추가하니 오류가 생기지 않았다
7. 토큰 방식으로 로그인 인증 방식으로 채택 할 경우 제일 큰 장점은 서버비용을 줄일 수 있음이다.
8. 