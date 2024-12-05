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
7. JavaScript를 외부에서 불러오는 경우 JavaScript내부에서 타임리프 문법을 사용할 수가 없다
 `예) : const latitude =[[${accommodations.latitude}]];`
   그래서 나는 html렌더링이 완료된 후 JavaScript 파일이 실행되도록 설정하는 방법과 비동기방법으로 네이버지도에 경도와 위도 정보를 넣을 것을 생각했다
   html렌더링 과정에 div태그에 th:data-id=${accommodations.id}로 넣을 수도 있으나 데이터를 가공하고 처리하는 과정을 명확하게 하기 위해서는 후자의 방법을 선택하기로 했음.
8. 