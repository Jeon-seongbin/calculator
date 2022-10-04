package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {


    @DisplayName("덧셈 연산을 수행한다")
    @Test
    void additionTest() {
        int result = Calculator.calculator(1, "+", 2);
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("뺄셈 연산을 수행한다")
    @Test
    void subtractTest() {
        int result = Calculator.calculator(1, "-", 2);
        assertThat(result).isEqualTo(-1);
    }

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

    @DisplayName("나눗셈셈 연산을 수행한다")
    @Test
    void calculatorExceptionTest() {
//        assertThat(Calculator.calculator(10, "/", 0)).isEqualTo(IllegalArgumentException.class);

//                  assertThatCode(Calculator.calculator(10, "/", 0)).isInstanceOf(IllegalArgumentException.class);
    }

}
