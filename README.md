# calculator
객체지향으로 만들어본 계산기 입니다

# 특징
1. TDD BASED
 - TDD를 기반으로 테스트 코드를 먼저 작성 후 객체지향으로 코드를 바꾸었습니다

```java

    @DisplayName("parameterizedTest")
    @ParameterizedTest
    @MethodSource("formulaAndResult")
    void calculatorTest(int operand1, String operator, int operand2, int result) {
        int result1 = Calculator.calculator(operand1, operator, operand2);
        assertThat(result).isEqualTo(result1);
    }

    private Stream<Arguments> formulaAndResult() {
        return Stream.of(
                arguments(1, "+", 2, 3),
                arguments(1, "-", 2, -1),
                arguments(4, "*", 2, 8),
                arguments(4, "/", 2, 2)
        );
    }

```

2. 객체지향형 코드 사용
 - 객체지향형 코드를 사용하여 코드 확장이 쉽게끔 만들었습니다
```java
    public static int calculator(int operand1, String operator, int operand2) {
        return arithmeticOperatorList.stream()
                .filter(arithmeticOperatorList -> arithmeticOperatorList.surpports(operator))
                .map(ArithmeticOperator -> ArithmeticOperator.calculator(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }
```

# 파일 구성
```
 
.
├── README.md
├── build
│   ├── classes
│   │   └── java
│   │       ├── main
│   │       │   └── org
│   │       │       └── example
│   │       │           ├── AdditionOperator.class
│   │       │           ├── ArithmeticOperator$1.class
│   │       │           ├── ArithmeticOperator$2.class
│   │       │           ├── ArithmeticOperator$3.class
│   │       │           ├── ArithmeticOperator$4.class
│   │       │           ├── ArithmeticOperator.class
│   │       │           ├── Calculator.class
│   │       │           ├── DivitionOperator.class
│   │       │           ├── MultiplyOperator.class
│   │       │           ├── NewArithmeticOperator.class
│   │       │           └── SubtractionOperator.class
│   │       └── test
│   │           └── org
│   │               └── example
│   │                   └── CalculatorTest.class
│   ├── generated
│   │   └── sources
│   │       ├── annotationProcessor
│   │       │   └── java
│   │       │       ├── main
│   │       │       └── test
│   │       └── headers
│   │           └── java
│   │               ├── main
│   │               └── test
│   ├── reports
│   │   └── tests
│   │       └── test
│   │           ├── classes
│   │           │   └── org.example.CalculatorTest.html
│   │           ├── css
│   │           │   ├── base-style.css
│   │           │   └── style.css
│   │           ├── index.html
│   │           ├── js
│   │           │   └── report.js
│   │           └── packages
│   │               └── org.example.html
│   ├── test-results
│   │   └── test
│   │       ├── TEST-org.example.CalculatorTest.xml
│   │       └── binary
│   │           ├── output.bin
│   │           ├── output.bin.idx
│   │           └── results.bin
│   └── tmp
│       ├── compileJava
│       │   └── previous-compilation-data.bin
│       ├── compileTestJava
│       │   └── previous-compilation-data.bin
│       └── test
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── org
    │   │       └── example
    │   │           ├── AdditionOperator.java
    │   │           ├── ArithmeticOperator.java
    │   │           ├── Calculator.java
    │   │           ├── DivitionOperator.java
    │   │           ├── MultiplyOperator.java
    │   │           ├── NewArithmeticOperator.java
    │   │           └── SubtractionOperator.java
    │   └── resources
    └── test
        ├── java
        │   └── org
        │       └── example
        │           └── CalculatorTest.java
        └── resources


```
