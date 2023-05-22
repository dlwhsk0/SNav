# SNav

저시력자를 위한 스마트 내비게이션

주요 특징:
- 사용자의 실시간 위치 정보를 확인해 음성으로 길 안내
  - 음성 신호기가 있는 횡단보도로만 길을 안내함
- 큼지막한 글씨와 버튼과 고대비 색상을 사용한 저시력자를 위한 UI 사용

## 2023-05-21

- 15 개의 화면 (MainActivity.java , Activity_main.xml : 임시 화면 전환 테스트 용)
- figma 도구를 사용해 앱 화면 구성 설계
- 1차적으로 모든 화면을 벡터 이미지로 첨부 (❗변경 필요)
- 동적 기능이 필요하지 않은 화면은 벡터 이미지로 첨부 후 필요한 곳에 투명 버튼 배치
  - 사용자 정보 및 설정 화면 (activity_setting.xml)
    - 공지사항 (activity_setting_notice.xml)
    - 음성 설정 (activity_setting_sound.xml)
    - 테마 설정 (activity_setting_theme.xml)

## 2023-05-22 ~ 23

- (추가) 동적 기능이 필요하지 않은 화면은 벡터 이미지로 첨부 후 필요한 곳에 투명 버튼 배치
  - 사용자 정보 및 설정 화면 (activity_setting.xml)
    - 공지사항 (activity_setting_notice.xml)
    - 음성 설정 (activity_setting_sound.xml)
    - 테마 설정 (activity_setting_theme.xml)
  - 인트로 화면 가장자리에 흰색이 보이는 문제 해결

## To-do

- 지도 첨부 (activity_main_nav.xml) 및 동적 기능 구현
- 음성 신호기가 있는 횡단보도 아이콘 배치 (M)

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

## 화면 구성도

<img width="902" alt="image" src="https://github.com/dlwhsk0/SNav/assets/94193594/685a57df-d607-4cb6-a205-645951b6689c">
