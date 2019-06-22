package com.ak.wars;

import java.util.function.IntBinaryOperator;

public class ArithmeticFunction {

    enum Operation {
        add(Integer::sum), subtract((a, b) -> a - b), divide(Integer::divideUnsigned), multiply((a, b) -> a * b);

        Operation(IntBinaryOperator executor) {
            this.executor = executor;
        }

        private final IntBinaryOperator executor;

        int execute(int a, int b) {
            return executor.applyAsInt(a, b);
        }
    }

    public static int arithmetic(int a, int b, String operator) {
        return Operation.valueOf(operator).execute(a, b);
    }
}