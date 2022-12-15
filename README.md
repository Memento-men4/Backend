# 🧠 MEMENTO       ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white)
```
This is Memento's App Backend  
(Memento's ML Backend : https://github.com/Memento-men4/MEMENTO-Backend-for-Ai)
```
> About Memento > https://github.com/Memento-men4  
> Watch Demo video > https://www.youtube.com/watch?v=7lxRL_99KnQ

### 🖇 Architecture Design
<img width="489" alt="백엔드아키텍처" src="https://user-images.githubusercontent.com/91522259/207849988-2bc60dcf-9f8e-4987-8724-c1ddae513d67.png">  

### 🗄 App Backend
Client 1 : React Native App
```
 기능 1 : 사용자의 Recording 데이터(시간, 장소, 녹음내용)를 DB에 저장하고 조회한다.
 기능 2 : 저장된 Recording 데이터를 활용해 ML Backend로 Daily Quiz 생성 요청을 보낸다. 응답받은 Daily Quiz를 DB에 저장한다.
 기능 3 : 사용자가 선택한 날짜에 해당하는 Recording 데이터를 반환한다.
 그 외 : 회원 생성, 게임기록 생성 및 조회, 가전 생성 및 조회 등
```
Client 2 : AI speaker NUGU
```
기능 : NUGU와의 통신을 진행한다. NUGU에게 해당 날짜의 Daily Quiz 데이터를 전송한다.
```

### 📁 Api Documentation
https://mixolydian-bird-90f.notion.site/16d6b37979ca46029b6f70a95378af6e?v=30cc5aa83b01428b8a2dce91c4e82654  

### 📝 Tech Blog
https://velog.io/@hanueleee/series/HYUSE  

### 🛠 Stacks

- 사용 기술 : Spring, Spring Boot, JPA
- 배포 : AWS EC2, AWS RDS(MySQL)
