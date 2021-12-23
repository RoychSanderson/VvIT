package exercise1
/** Напишите отдельные функции, решающие поставленную задачу.
  * 
  * Синтаксис:
  *   // метод
  *   def myFunction(param0: Int, param1: String): Double = // тело
  * 
  *   // значение
  *   val myFunction: (Int, String) => Double (param0, param1) => // тело
  */


object Functions {

  /* a) Напишите функцию, которая рассчитывает площадь окружности
   *    r^2 * Math.PI
   */
  def Ploshad(r: Double): Double = Math.pow(r, 2) * Math.PI


  // примените вашу функцию из пункта (a) здесь, не изменяя сигнатуру
  def testCircle(r: Double): Double = Ploshad(r)
  


  /* b) Напишите карированную функцию которая рассчитывает площадь прямоугольника a * b.
   */
  def PP1(a: Double)(b: Double): Double = a * b


  // примените вашу функцию из пукта (b) здесь, не изменяя сигнатуру
  def testRectangleCurried(a: Double, b: Double): Double = PP1(a)(b)
  //def t1(a: Double): Double = PP1(a)(4)

  // c) Напишите не карированную функцию для расчета площади прямоугольника.
  def PP2(a: Double, b: Double): Double = a * b


  // примените вашу функцию из пункта (c) здесь, не изменяя сигнатуру
  def testRectangleUc(a: Double, b: Double): Double = PP2(a, b)

  def main(args: Array[String]): Unit = {
    println(testCircle(2.3))
    println(testRectangleCurried(4.1, 5.4))
    println(testRectangleUc(4.1, 5.4))
  }
}
