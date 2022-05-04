package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple AppSquareTriangle
 */

public class TriangleTestIntParam
{

    /**
     *  Пакет тестов для функции squareTriangle(Double a, Double b, Double c)
     */

    // 1.1. Тест-кейс на действительный равносторонний треугольник (целочисленные данные)
    @DisplayName("1.1.Тест-кейс на действительный равносторонний треугольник (целочисленные данные)")
    @Tag("equilateralTriangleIntegerParameter")
    @Test
    public void equilateralTriangleID() throws TriangleException {
        String msgErr = "В тесте полученное значение отлично от ожидаемого:";
        Assertions.assertEquals(0.43301, AppSquareTriangle.squareTriangle(1.0, 1.0, 1.0), msgErr);
        //logger.info("1.1.Тест-кейс на действительный равносторонний треугольник (целочисленные данные) - Passed (S = 0.43301)");
        //logger.error("1.1.Тест-кейс на действительный равносторонний треугольник (целочисленные данные) - Failed");
    }

    // 1.2. Тест-кейс на действительный равносторонний треугольник (дробные данные)
    @DisplayName("1.2.Тест-кейс на действительный равносторонний треугольник (дробные данные)")
    @Tag("equilateralTriangleDoubleParameter")
    @ParameterizedTest
    @CsvSource({"1.5, 1.5, 1.5"})
    public void equilateralTriangleDD(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличаное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        assertEquals(0.97428, AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.3. Тест-кейс на действительный равнобедренный треугольник (целочисленные данные)
    @DisplayName("1.3.Тест-кейс на действительный равнобедренный треугольник (целочисленные данные)")
    @Tag("isoscelesTriangleIntegerParameter")
    @ParameterizedTest
    @CsvSource({"2.0, 2.0, 3.0",
                "2.0, 3.0, 2.0",
                "3.0, 2.0, 2.0"})
    public void isoscelesTriangleID(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertEquals(1.9843, AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.4. Тест-кейс на действительный равнобедренный треугольник (дробные данные)
    @DisplayName("1.4.Тест-кейс на действительный равнобедренный треугольник (дробные данные)")
    @Tag("isoscelesTriangleDoubleParameter")
    @ParameterizedTest
    @CsvSource({"1.8, 1.5, 1.5",
                "1.5, 1.8, 1.5",
                "1.5, 1.5, 1.8"})
    public void isoscelesTriangleDD(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertEquals(1.08, AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.5. Тест-кейс на действительный разносторонний треугольник
    @DisplayName("1.5.Тест-кейс на действительный разносторонний треугольник (целочисленные данные)")
    @Tag("triangleWithDifferentSidesIntegerParameter")
    @ParameterizedTest
    @CsvSource({"3.0, 4.0, 6.0",
                "6.0, 3.0, 4.0",
                "4.0, 6.0, 3.0"})
    public void triangleWithDifferentSidesID(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertEquals(5.3327, AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.6. Тест-кейс на действительный разносторонний треугольник
    @DisplayName("1.6.Тест-кейс на действительный разносторонний треугольник (дробные данные)")
    @Tag("triangleWithDifferentSidesDoubleParameter")
    @ParameterizedTest
    @CsvSource({"1.65, 0.15, 1.68",
                "1.68, 1.65, 0.15",
                "0.15, 1.68, 1.65"})
    public void validIsoscelesTriangle_(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        assertEquals(0.12223, AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.7. Тест-кейс на недействительный треугольник (смешанные данные)
    @DisplayName("1.7.Тест-кейс на недействительный треугольник (смешанные данные)")
    @Tag("invalidTriangleWithMixedData")
    @ParameterizedTest
    @CsvSource({"6.125, 3.7, 2.3",
                "0.06, 0.04, 0.02",
                "10.0, 20.0, 5.0",
                "5.5, 3.5, 13.75"})
    public void invalidTriangleWithMixedData(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.8. Тест-кейс одна из сторон треугольника имеет отрицательное значение
    @DisplayName("1.8.Одна из сторон треугольника имеет отрицательное значение")
    @Tag("sideWithNegativeLength")
    @ParameterizedTest
    @CsvSource({"-1.0, 1.0, 1.0",
                "1.0, -1.0, 1.0",
                "1.0, 1.0, -1.0"})
    public void sideWithNegativeLength(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.9. Тест-кейс все стороны треугольника имеют отрицательное значение
    @DisplayName("1.9.Все стороны трегульника имеют отрицательное значение")
    @Tag("allSideWithNegativeLength")
    @ParameterizedTest
    @CsvSource({"-1.0, -1.0, -1.0"})
    public void allSidesWithNegativeLength(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.10. Тест-кейс одна из сторон треугольника равна нулю
    @DisplayName("1.10.Одна из сторон треугольника равна нулю")
    @Tag("sideWithZeroLength")
    @ParameterizedTest
    @CsvSource({"0.0, 1.0, 1.0",
                "1.0, 0.0, 1.0",
                "1.0, 1.0, 0.0",
                "0.0, 2.5, 2.5",
                "2.5, 0.0, 2.5",
                "2.5, 2.5, 0.0",})
    public void sideWithZeroLength(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.11. Тест-кейс одна из сторон треугольника равна нулю
    @DisplayName("1.11.Все стороны треугольника равны нулю")
    @Tag("allSidesWithZeroLength")
    @ParameterizedTest
    @CsvSource({"0.0, 0.0, 0.0"})
    public void allSidesWithZeroLength(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.12. Тест-кейс на вырожденный треугольник: площадь треугольника равна нулю
    @DisplayName("1.12.Вырожденный треугольник: площадь треугольника равна нулю")
    @Tag("degenerateTriangle")
    @ParameterizedTest
    @CsvSource({"1.0, 2.0, 3.0",
                "0.3, 0.2, 0.5"})
    public void degenerateTriangle(double sideA, double sideB, double sideC) throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
        Assertions.assertEquals(0.0, AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr);
    }

    // 1.13. Тест-кейс на передачу null в качестве одного из параметров
    @DisplayName("1.13.Паметр null передан в функцию для все трех параметров")
    @Tag("oneParameterEqualsNull")
    @Test
    void oneParameterEqualsNull() throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого:";
        Assertions.assertAll(
                () -> assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(null, 1.0, 1.0), msgErr),
                () -> assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(1.0, null, 1.0), msgErr),
                () -> assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(1.0, 1.0, null), msgErr)
        );
    }

    // 1.14. Тест-кейс на передачу null в качестве всех параметров
    @DisplayName("1.14.Паметр null передан в функцию для всех параметров функции")
    @Tag("allParameterEqualsNull")
    @Test
    public void allParameterEqualsNull() throws TriangleException {
        String msgErr = "В тесте полученно значение отличное от ожидаемого:";
        Assertions.assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(null, null, null), msgErr);
    }

    @Nested
    @DisplayName("1.15.Набор тестов для проверки работы функции на больших данных")
    class GroupTests {

        // 1.15.1 Тест-кейс на передачу значение равное верхней граните типа Double в качестве одного из параметров
        @DisplayName("1.15.1.Проверка параметров функции на принадлежность правой границе типа Double (1.7*10^308)")
        @Tag("maxSizeValueForArgument")
        @Test
        public void maxSizeValueForArgument() throws TriangleException {
            String msgErr = "В тесте полученно значение отличное от ожидаемого:";
            Assertions.assertAll(
                    () -> assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(Double.MAX_VALUE, 1.0, 1.0), msgErr),
                    () -> assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(1.0, Double.MAX_VALUE, 1.0), msgErr),
                    () -> assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(1.0, 1.0, Double.MAX_VALUE), msgErr),
                    () -> assertThrows(TriangleException.class, () -> AppSquareTriangle.squareTriangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE), msgErr)
                    );
            /*
            Assertions.assertAll(
                    () -> assertEquals(Double.MAX_VALUE, App.squareTriangle(Double.MAX_VALUE, 1.0, 1.0), msgErr),
                    () -> assertEquals(Double.MAX_VALUE, App.squareTriangle(1.0, Double.MAX_VALUE, 1.0), msgErr),
                    () -> assertEquals(Double.MAX_VALUE, App.squareTriangle(1.0, 1.0, Double.MAX_VALUE), msgErr),
                    () -> assertEquals(Double.MAX_VALUE, App.squareTriangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE), msgErr)
                    );
             */
        }

        // 1.15.2. Тест-кейс на определение типа треугольника на больших числах типа Double
        // Double.MAX_VALUE = 1.7976931348623157E308
        // sqrt(Double.MAX_VALUE) = 1.3407807929942596E154
        @DisplayName("1.15.2.Проверка параметров функции на больших числах, близких к правой границе типа Double")
        @Tag("typeOfBigTriangle")
        @ParameterizedTest
        @CsvSource({"1.7596E77, 1.7596E77, 1.7596E77",
                    "1.7596E77, 1.75962E77, 1.7596E77",
                    "1.7596E77, 1.75963E77, 1.75965E77"})
        public void typeOfBigTriangle(double sideA, double sideB, double sideC) throws TriangleException {
            String msgErr = "В тесте полученно значение отличное от ожидаемого (" + sideA + ";" + sideB + ";" + sideC + "):";
            Assertions.assertAll(
                    () -> assertEquals(1.3407E154, AppSquareTriangle.squareTriangle(sideA, sideB, sideC), msgErr)
            );
        }

        // 1.15.3 Тест-кейс на передачу в функцию валидого значения близкого к границе типа Double
        // Double.MAX_VALUE = 1.7976931348623157E308
        // sqrt(Double.MAX_VALUE) = 1.3407807929942596E154
        @DisplayName("1.15.3.Проверка параметров функции на больших числах, близких к правой границе типа Double")
        @Tag("infinityResult")
        @Test
        public void infinityResult() throws TriangleException {
            String msgErr = "В тесте полученно значение отличное от ожидаемого:";
            Assertions.assertAll(
                    () -> assertEquals(1.3407E154, AppSquareTriangle.squareTriangle(1.7596E77, 1.7596E77, 1.7596E77), msgErr),
                    () -> assertEquals(1.3408E154, AppSquareTriangle.squareTriangle(1.75965E77, 1.75965E77, 1.75965E77), msgErr),
                    () -> assertEquals(Double.POSITIVE_INFINITY, AppSquareTriangle.squareTriangle(1.7597E77, 1.7597E77, 1.7597E77), msgErr),
                    () -> assertEquals(Double.POSITIVE_INFINITY, AppSquareTriangle.squareTriangle(1.7597E308, 1.7597E308, 1.7597E308), msgErr)
            );
        }
    }
}