import scala.annotation.tailrec
import scala.util.Try
/** Реализуйте следующие функции.
  * 
  * List(1, 2) match {
  *   case head :: tail => ???
  *   case Nil          => ???
  *   case l            => ???
  * }
  * 
  * Option(1) match {
  *   case Some(a) => ???
  *   case None    => ???
  * }
  * 
  * Either.cond(true, 1, "right") match {
  *   case Left(i)  => ???
  *   case Right(s) => ???
  * }
  * 
  * Try(impureExpression()) match {
  *   case Success(a)     => ???
  *   case Failure(error) => ???
  * }
  * 
  * Try(impureExpression()).toEither
  * 
  */
object Adts {

  // a) Дан List[Int], верните элемент с индексом n
  def getNth(list: List[Int], n: Int): Option[Int] = {
    @tailrec
    def loop(list: List[Int], n: Int): Option[Int] = list match {
      case head :: tail => if (n == 0) Some(head) else loop(tail, n - 1)
      case Nil => None
    }
    loop(list: List[Int], n: Int)
  }

  // примените функцию из пункта (a) здесь, не изменяйте сигнатуру 
  def testGetNth(list: List[Int], n: Int): Option[Int] = getNth(list, n)


  // b) Напишите функцию, увеличивающую число в два раза.
  def double(n: Option[Int]): Option[Int] = n match {
    case Some(a) => Some(a * 2)
    case None => None
  }

  // примените функцию из пункта (b) здесь, не изменяйте сигнатуру
  def testDouble(n: Option[Int]): Option[Int] = double(n)


  // c) Напишите функцию, проверяющую является ли число типа Int четным. Если так, верните Right. В противном случае, верните Left("Нечетное число.").
  def isEven(n: Int): Either[String, Int] = n % 2 match {
    case 0 => Right(n)
    case _ => Left("Нечетное число.")
  }

  // примените функцию из пункта (c) здесь, не изменяйте сигнатуру
  def testIsEven(n: Int): Either[String, Int] = isEven(n)


  // d) Напишите функцию, реализующую безопасное деление целых чисел. Верните Right с результатом или Left("Вы не можете делить на ноль.").
  def safeDivide(a: Int, b: Int): Either[String, Int] = b match {
    case 0 => Left("Вы не можете делить на ноль.")
    case _ => Right(a / b)
  }

  // примените функцию из пункта (d) здесь, не изменяйте сигнатуру
  def testSafeDivide(a: Int, b: Int): Either[String, Int] = safeDivide(a, b)


  // e) Обработайте исключения функции с побочным эффектом вернув 0.
  def goodOldJava(impure: String => Int, str: String): Try[Int] = Try(impure(str))

  // примените функцию из пункта (e) здесь, не изменяйте сигнатуру
  def testGoodOldJava(impure: String => Int, str: String): Try[Int] = goodOldJava(impure, str)


  def main(args: Array[String]): Unit = {
    println(testGetNth(List(3, 5, 7 ,9), 1))

    println(testDouble(Some(9)))
    println(testDouble(None))

    println(isEven(2))
    println(isEven(1))

    println(testSafeDivide(4, 2))
    println(testSafeDivide(5, 0))

    println(testGoodOldJava((s: String) => s.codePointAt(0), "stroka"))
    println(testGoodOldJava((_: String) => 5 / 0, "stroka"))
  }
}
