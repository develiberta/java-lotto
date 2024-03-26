# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 문자열 계산 
> 모짝미를 통해 구현하여 작업목록 및 기능 분석은 네비게이터의 PC에 있습니다..!

## [2단계 로또(자동)](https://edu.nextstep.camp/s/E42ziiPQ/ls/hd8U68zo)
> 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급하고, 발급한 로또의 당첨 통계를 출력한다.

### 1. 구현 기능 목록
- 입력한 구입 금액에 따라 장당 1000원인 로또를 구매한다.
- 로또는 1~45까지의 숫자 중 중복되지 않는 숫자 6개를 뽑아내야 한다.
- 입력 받은 당첨 번호를 ','로 Split 처리 한다.
- 구매한 로또 번호와 당첨 번호의 일치하는 개수를 파악한다.
- 당첨 번호 일치 개수에 따라 등수를 파악한다.
- 각 등수별 당첨 횟수를 카운트 한다.
- 각 등수별 당첨 횟수에 따른 최종 당첨 금액을 산정한다.
- 구매 금액과 최종 당첨 금액에 따른 수익률을 산정한다.

### 2. 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 함. 단, UI 로직은 제외
- indent depth를 2를 넘지 않도록 구현
- 함수의 길이가 15라인을 넘어가지 않도록 구현
- 자바 코드 컨벤션을 지키면서 프로그래밍
- else 예약어 쓰지 않기


## [3단계 로또(2등)](https://edu.nextstep.camp/s/E42ziiPQ/ls/7h2i9xyL)
> 로또의 등수에 2등을 추가한다.

### 1. 구현 기능 목록
- 보너스 볼을 입력받는다.
- 로또 등수의 조건을 변경한다.
  - 기존 2~4등 리팩토링
  - 신규 2등 추가(5개 일치 + 보너스 볼 일치)

### 2. 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 함. 단, UI 로직은 제외
- enum을 적용해 프로그래밍 구현
- 일급 콜렉션 사용하기
- indent depth를 2를 넘지 않도록 구현
- 함수의 길이가 15라인을 넘어가지 않도록 구현
- 자바 코드 컨벤션을 지키면서 프로그래밍
- else 예약어 쓰지 않기

## [4단계 로또(수동)](https://edu.nextstep.camp/s/E42ziiPQ/ls/FY6z6glC)
> 로또 구매 시에 수동으로 일부 수량을 구매할 수 있다.

### 1. 구현 기능 목록
- 수동으로 구매할 로또 수를 입력 받는다.
  - 수동 구매 수량은 구입 금액을 초과할 수 없다.
- 수동으로 구매한 로또 번호를 입력받는다.
- 수동으로 구매하고 남은 잔액으로 구매할 수 있는 만큼 자동으로 구매한다.
  - 자동으로 구매한 수량은 0일 수 있다.
- 수동, 자동으로 구매한 모든 로또 번호를 출력한다.
  - 단, 수동 먼저

### 2. 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 함. 단, UI 로직은 제외
- **모든 원시값과 문자열을 포장**
- **줄여쓰지 않기**
- **예외 처리를 통해 에러가 발생하지 않도록 해야 함**
- enum을 적용해 프로그래밍 구현
- 일급 콜렉션 사용하기
- indent depth를 2를 넘지 않도록 구현
- 함수의 길이가 15라인을 넘어가지 않도록 구현
- 자바 코드 컨벤션을 지키면서 프로그래밍
- else 예약어 쓰지 않기