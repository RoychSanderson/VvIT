/** Напишите ваши решения в тестовых функциях.
  * 
  * https://www.scala-lang.org/api/2.12.3/scala/collection/immutable/StringOps.html
  */
object Strings {

  /* a) Преобразуйте все символы типа Char в верхний регистр (не используйте заглавные буквы).
   *    
   */
  def testUppercase(str: String): String = str.toUpperCase


  /* b) Вставьте следующие значения в строку:
   *       Hi my name is <name> and I am <age> years old.
   *    
   */
  def testInterpolations(name: String, age: Int): String = String.format("Hi my name is %s and I am %d years old.\n", name, age)


  /* c) Добавьте два числа в следующую строку:
   *       Hi,
   *       now follows a quite hard calculation. We try to add:
   *         a := <value of a>
   *         b := <value of b>
   *
   *         result is <a + b>
   * 
   *   
   */
  def testComputation(a: Int, b: Int): String = String.format("Hi,\nnow follows a quite hard calculation. We try to add:\n\ta := %d\n\tb := %d\n\n\t  result is %d \n\n", a, b, a + b)

  /* d) Если длина строки равна 2, верните всю строку, иначе верните первые два символа строки.
   */
  def testTakeTwo(str: String): String = str.length match {
    case 2 => str
    case _ => str.take(2)
  }

  def main(args: Array[String]): Unit = {
    println(testUppercase("capslock"))
    println(testInterpolations("Vladislav", 20))
    println(testComputation(3, 5))
    println(testTakeTwo("hi"))
    println(testTakeTwo("hello"))
  }
}
