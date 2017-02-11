# yellowid  
spring boot 기반 카카오 옐로우 아이디 예제입니다.  
- api 에 대한 설명은 https://github.com/plusfriend/auto_reply 에서 확인하실 수 있습니다.  
- 해당 api 사용을 위해서는 https://yellowid.kakao.com/bot/api 에서 설정이 필요합니다.
- 테스트를 원하시면 카카오톡에서 `chooco13`을 찾으시거나, http://plus.kakao.com/home/@chooco13 를 통해 추가해 주시면 됩니다.
(heroku free dyno 를 이용하였기 때문에 sleeping 중에는 되지 않을 수 있습니다.)  

## 간단한 설명
- 기본 API와 옵션 API를 구현하였습니다.

### 자동응답
- 단순 응답, 이미지 응답, 키보드 응답, 메세지 버튼 네가지 모두 예제에 포함시켜 두었습니다.   
(위 예제는 매우 단순한 수준의 예제입니다.)  

#### 이미지 응답   
![Image](http://i.imgur.com/EJbiykO.png)  
#### 키보드 응답  
![Keyboard](http://i.imgur.com/jwtvORm.png)  
#### 메세지 버튼  
![MessageButton](http://i.imgur.com/LrUgwaV.png)  

### 옵션 API
- 옵션 API의 경우 logger를 이용하여 로깅되게만 구현하였습니다.  
![Logging](http://i.imgur.com/DxZTU4f.png?1)   

## 2017.02.11 문서화  
