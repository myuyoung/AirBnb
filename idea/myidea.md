1. 이 프로젝트에서는 OAuth2를 사용하지 않으려 합니다.
    1. 비용 절감을 위한 고려사항: 
       1. 타사 인증 제공자 활용: 구글, 페이스북 같은 타사 OAuth 인증 서비스를 사용하면 자체 서버에 대한 부하가 줄어듭니다.
       2.	토큰 관리 최적화: 토큰 만료 시간을 적절히 설정하고, 필요할 경우 리프레시 토큰을 사용해 액세스 토큰만 갱신하여 서버 부하를 줄일 수 있습니다.
       3.	캐시 사용: 토큰 검증 요청이 빈번하게 발생하는 경우, 캐시를 사용해 일부 토큰 검증을 빠르게 처리하면 서버 부하를 낮출 수 있습니다.