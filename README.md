# 📗 Spring에서 Session 사용해보기

## 서버에 저장된 Session값 맞추기
1. 클라이언트가 서버에 처음 요청을 하면 서버는 Session id를 생성하고 Key와 Value를 이용한 저장소인 HttpSession을 생성한다.
``` JAVA
int randomNumber = (Integer)session.getAttribute("randomNumber");
```
<br> 2. 서버는 1 - 100 의 랜덤한 숫자를 생성해서 Session에 저장하고 Session id를 쿠키에 담아 클라이언트에 전달한다.
``` JAVA
session.setAttribute("randomNumber", (int)(Math.random() * 100 + 1));
```
<br> 3. 클라이언트는 Session id를 담은 쿠키를 포함한 응답을 받는다.
<br><br> 4. 클라이언트는 숫자 맞추기를 시도할 때 마다 쿠키를 주고받으면서 상태 정보를 유지한다.
<br><br> 5. 숫자를 맞추면 서버에서 Session을 삭제한다.
``` JAVA
session.removeAttribute("randomNumber");
```
<br> 
<img width="600" alt="스크린샷 2020-09-02 오후 7 10 01" src="https://user-images.githubusercontent.com/59954574/91968800-2577db80-ed50-11ea-9dce-24e6748e256d.png">
<img width="600" alt="스크린샷 2020-09-02 오후 7 10 26" src="https://user-images.githubusercontent.com/59954574/91968798-2446ae80-ed50-11ea-9254-b62c8a64bd95.png">
<img width="600" alt="스크린샷 2020-09-02 오후 7 11 17" src="https://user-images.githubusercontent.com/59954574/91968791-21e45480-ed50-11ea-950e-a5328e53f917.png">
