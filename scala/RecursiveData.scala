
sealed trait List[A]
case class Cons[A](head: A, tail: List[A]) extends List[A]
case class Nil[A]() extends List[A]

/** Напишите свои решения в виде функций. */
object RecursiveData {

  // a) Реализуйте функцию, определяющую является ли пустым `List[Int]`.
  def listIntEmpty(list: List[Int]): Boolean = list match {
    case _: Nil[Int] => true
    case _ => false
  }

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntEmpty(list: List[Int]): Boolean = listIntEmpty(list)


  // b) Реализуйте функцию, которая получает head `List[Int]`или возвращает -1 в случае если он пустой.
  def listIntHead(list: List[Int]): Int = list match {
    case list: Cons[Int] => list.head
    case _ => -1
  }

  // используйте функцию из пункта (a) здесь, не изменяйте сигнатуру
  def testListIntHead(list: List[Int]): Int = listIntHead(list)

  // c) Можно ли изменить `List[A]` так чтобы гарантировать что он не является пустым?
  // Определить Nil следующим образом:
  // case class Nil[A](head: A) extends List[A]


  /* d) Реализуйте универсальное дерево (Tree) которое хранит значения в виде листьев и состоит из:
   *      node - левое и правое дерево (Tree)
   *      leaf - переменная типа A
   */
  sealed trait Tree[A]
  case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
  case class Leaf[A](value: A) extends Tree[A]


  def main(args: Array[String]): Unit = {
    println("listIntEmpty = " + testListIntEmpty(Cons(4,Cons(2,Cons(5,Nil())))))
    println("listIntEmpty(Nil()) = " + testListIntEmpty(Nil()))
    println("listIntHead(Cons(1,Cons(2,Cons(3,Cons(4,Cons(5,Nil())))))) = " + testListIntHead(Cons(4,Cons(2,Cons(5,Nil())))))
    println("listIntHead(Nil()) = " + testListIntHead(Nil()))
    println("Tree: " + Node(Node(Leaf(1), Leaf(2)), Leaf(3)))
  }
}
