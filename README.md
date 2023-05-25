# SNav

저시력자를 위한 스마트 내비게이션

주요 특징:
- 사용자의 실시간 위치 정보를 확인해 음성으로 길 안내
  **- 음성 신호기가 있는 횡단보도로 길을 안내함**
- 큼지막한 글씨와 버튼과 고대비 및 색약 필터를 사용한 저시력자를 위한 UI 사용
- 17개의 화면

## 2023-05-21

- 12개의 화면 제작 (MainActivity.java , Activity_main.xml : 임시 화면 전환 테스트 용)
- figma 도구를 사용해 앱 화면 구성 설계
- 1차적으로 모든 화면을 벡터 이미지로 첨부 (❗변경 필요)
- 동적 기능이 필요하지 않은 화면은 벡터 이미지로 첨부 후 필요한 곳에 투명 버튼 배치
  - 사용자 정보 및 설정 화면 (activity_setting.xml)
    - 공지사항 (activity_setting_notice.xml)
    - 음성 설정 (activity_setting_sound.xml)
    - 테마 설정 (activity_setting_theme.xml)

## 2023-05-22 ~ 23

- 인트로 화면 가장자리에 흰색이 보이는 문제 해결
- 설정 관련 화면 5개 추가
  - 세부 설정 화면 3개
  - 테마 미리보기 버전 2개
- 런처 화면을 IntroActivity로 변경

## 2023-05-24 ~ 25

- 보고서의 레이아웃 구성도 작성을 위한 대부분의 layout xml에 위젯 추가
- 보고서 진행

## 2023-05-26

- (예정) 시스템 설계서
- (예정) 발표 영상 제작

## To-do

- 지도 첨부 (activity_main_nav.xml) 및 동적 기능 구현 (osm)
- 시스템 설계서 작성 (osm)
- 위 단계 수행 후 지도가 들어가는 화면의 대한 보고서 내용 수정 (kmy, chn)
- 시연 및 발표 영상 촬영 및 편집 (chn, kmy)

## 구현 외 할 일

- 모든 화면 간의 관계도 제작
- 보고서 작성 : ~05/25 예정
1) 개요(3쪽 내외)
2) 앱의 주요 기능(2쪽 이내)
3) 화면 설계서(10쪽 내외)
4) 시스템 설계서(5쪽 이내)
5) 설계 제한 요소(1쪽)
6) 향후 계획(1~2쪽)
- 발표 영상 제작 및 제출 : ~05/26 예정

## 화면 전체 구성도

<img width="726" alt="image" src="https://github.com/dlwhsk0/SNav/assets/94193594/98ae4a1b-ed1f-409a-bf09-437dec66860c">

## 기능 별 관계도

### 인트로 및 로그인

<img width="662" alt="인트로 및 로그인" src="https://github.com/dlwhsk0/SNav/assets/94193594/05c75d6f-0438-4e66-b18b-4db7bb1d8808">

### 지도와 장소 및 주소 관련 메뉴

<img width="658" alt="지도와 장소 및 주소 관련 메뉴" src="https://github.com/dlwhsk0/SNav/assets/94193594/067197eb-fc78-498c-a625-6531603cfff6">

### 길 찾기 관련 메뉴

<img width="944" alt="길 찾기 관련 메뉴" src="https://github.com/dlwhsk0/SNav/assets/94193594/c377e9f7-99d0-460e-8ba7-14030b871588">

### 앱 내 부가 설정

<img width="678" alt="앱 내 부가 설정" src="https://github.com/dlwhsk0/SNav/assets/94193594/5b839349-925c-493d-b6fe-5a8c42d5643d">

