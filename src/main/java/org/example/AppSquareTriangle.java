package org.example;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import static java.lang.Math.sqrt;

/**
 * Hello world!
 *
 */
public class AppSquareTriangle
{
    public static void main( String[] args )
    {
        // Расчёт констант:
         System.out.println(Double.MAX_VALUE);                   // 1.7976931348623157E308
         System.out.println(Double.MAX_VALUE/2);                 // 8.988465674311579E307
         System.out.println(Double.MAX_VALUE/4);                 // 4.4942328371557893E307
         System.out.println(Math.sqrt(Double.MAX_VALUE));        // 1.3407807929942596E154
         System.out.println(Math.pow(Double.MAX_VALUE,0.25));    // 1.157920892373162E77

         System.out.println(Integer.MAX_VALUE);                  // 2147483647
         System.out.println(Math.sqrt(Integer.MAX_VALUE));       // 46340.950001051984
    }

    public static Double squareTriangle(Double a, Double b, Double c) throws TriangleException {
        Double squareTriangle = null;
        String msgErr;
        if ((a == null) || (b == null) || (c == null)){
            //squareTriangle = null;
            msgErr = "Площадь для треугольника со сторонами ("+ a + ";" + b + ";" + c + ") нельзя расчитать: переданы пустые параметры";
            System.out.println(msgErr);
            throw new TriangleException(msgErr);
        } else {
            if ((a.equals(Double.MAX_VALUE)) || (b.equals(Double.MAX_VALUE)) || (c.equals(Double.MAX_VALUE))) {
                //squareTriangle = null;
                msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя расчитать: один из параметров равен максимальному значению типа Double (1.7*10^308)";
                System.out.println(msgErr);
                throw new TriangleException(msgErr);
            } else {
                if ((a < 0) || (b < 0) || (c < 0)) {
                    //squareTriangle = null;
                    msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя расчитать: длина не может быть отрицательной";
                    System.out.println(msgErr);
                    throw new TriangleException(msgErr);
                } else {
                    if ((a.equals(0.0)) || (b.equals(0.0)) || (c.equals(0.0))) {
                        //squareTriangle = null;
                        msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя расчитать: требуется указать значение длины одной из сторон больше 0";
                        System.out.println(msgErr);
                        throw new TriangleException(msgErr);
                    } else {
                        double p = (a + b + c) / 2;
                        // Проверка на вырожденный треугольник
                        if ((p == a) || (p == b) || (p == c)) {
                            squareTriangle = 0.0; //sqrt(p * (p - a) * (p - b) * (p - c));  // squareTriangle = 0.0;
                            System.out.println("Площадь для вырожденного треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                        } else {
                            // Проверка на действительный треугольник
                            if ((a + b > c) && (b + c > a) && (a + c > b)) {
                                try {
                                    squareTriangle = sqrt(p * (p - a) * (p - b) * (p - c));
                                    // Усечение числа до 5 знаков после запятой:
                                    MathContext context = new MathContext(5, RoundingMode.HALF_UP);
                                    BigDecimal result = new BigDecimal(squareTriangle, context);
                                    squareTriangle = result.doubleValue();
                                } catch (NumberFormatException e) {
                                    msgErr = "Переполнение при расчёте, значение равно Infinity";
                                    System.out.println(msgErr);
                                    e.printStackTrace();
                                }
                                if ((a.equals(b)) && (b.equals(c))) {
                                    System.out.println("Площадь для действительного равностороннего треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                                } else {
                                    if ((a.equals(b)) || (b.equals(c)) || (a.equals(c))) {
                                        System.out.println("Площадь для действительного равнобедренного треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                                    } else {
                                        System.out.println("Площадь для действительного неравностороннего треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                                    }
                                }
                            } else {
                                //squareTriangle = null;
                                msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя расчитать: недействительные данные";
                                System.out.println(msgErr);
                                throw new TriangleException(msgErr);
                            }
                        }
                    }
                }
            }
        }

        return squareTriangle;
    }

    public static Double squareTriangleIntParam(Integer a, Integer b, Integer c) throws TriangleException {
        Double squareTriangle = null;
        String msgErr;
        if ((a == null) || (b == null) || (c == null)){
            //squareTriangle = null;
            msgErr = "Площадь для треугольника со сторонами ("+ a + ";" + b + ";" + c + ") нельзя расчитать: переданы пустые параметры";
            System.out.println(msgErr);
            throw new TriangleException(msgErr);
        } else {
            if ((a.equals(Integer.MAX_VALUE)) || (b.equals(Integer.MAX_VALUE)) || (c.equals(Integer.MAX_VALUE))) {
                //squareTriangle = null;
                msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя расчитать: один из параметров равен максимальному значению типа Double (1.7*10^308)";
                System.out.println(msgErr);
                throw new TriangleException(msgErr);
            } else {
                if ((a < 0) || (b < 0) || (c < 0)) {
                    //squareTriangle = null;
                    msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя расчитать: длина не может быть отрицательной";
                    System.out.println(msgErr);
                    throw new TriangleException(msgErr);
                } else {
                    if ((a.equals(0)) || (b.equals(0)) || (c.equals(0))) {
                        //squareTriangle = null;
                        msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя расчитать: требуется указать значение длины одной из сторон больше 0";
                        System.out.println(msgErr);
                        throw new TriangleException(msgErr);
                    } else {
                        double p = (a.doubleValue() + b.doubleValue() + c.doubleValue()) / 2;
                        //System.out.println("p=" + p);
                        // Проверка на вырожденный треугольник
                        if ((p == a) || (p == b) || (p == c)) {
                            squareTriangle = 0.0; //sqrt(p * (p - a) * (p - b) * (p - c));  // squareTriangle = 0.0;
                            System.out.println("Площадь для вырожденного треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                        } else {
                            // Проверка на действительный треугольник
                            if ((a.doubleValue() + b.doubleValue() > c.doubleValue()) &&
                                (b.doubleValue() + c.doubleValue() > a.doubleValue()) &&
                                (a.doubleValue() + c.doubleValue() > b.doubleValue())) {
                                try {
                                    squareTriangle = sqrt(p * (p - a) * (p - b) * (p - c));
                                    // Усечение числа до 5 знаков после запятой:
                                    MathContext context = new MathContext(5, RoundingMode.HALF_UP);
                                    BigDecimal result = new BigDecimal(squareTriangle, context);
                                    squareTriangle = result.doubleValue();
                                } catch (NumberFormatException e) {
                                    msgErr = "Переполнение при расчёте, значение равно Infinity";
                                    System.out.println(msgErr);
                                    e.printStackTrace();
                                }
                                if ((a.equals(b)) && (b.equals(c))) {
                                    System.out.println("Площадь для действительного равностороннего треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                                } else {
                                    if ((a.equals(b)) || (b.equals(c)) || (a.equals(c))) {
                                        System.out.println("Площадь для действительного равнобедренного треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                                    } else {
                                        System.out.println("Площадь для действительного неравностороннего треугольника со сторонами (" + a + ";" + b + ";" + c + ") равна: " + squareTriangle);
                                    }
                                }
                            } else {
                            //  squareTriangle = null;
                                msgErr = "Площадь для треугольника со сторонами (" + a + ";" + b + ";" + c + ") нельзя рассчитать: недействительные данные";
                                System.out.println(msgErr);
                                throw new TriangleException(msgErr);
                            }
                        }
                    }
                }
            }
        }

        return squareTriangle;
    }
}
