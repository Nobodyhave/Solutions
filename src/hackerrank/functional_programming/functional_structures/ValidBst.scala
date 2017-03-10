package hackerrank.functional_programming.functional_structures

import java.io.FileInputStream
import java.util.Scanner

/**
  * Created by Aleksandr on 01/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/valid-bst
  */
object ValidBst {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val T = in.nextLine().toInt
    for (t <- 0 until T) {
      val N = in.nextLine().toInt
      val preorder = in.nextLine().split(" ").map(_.toInt).toList

      println(if (isValidBst(preorder)) "YES" else "NO")
    }
  }

  def isValidBst(preorder: List[Int]): Boolean = {
    if (preorder.size <= 1) {
      return true
    }

    val root = preorder.head

    val leftTree = preorder.tail.takeWhile(_ < root)
    val rightTree = preorder.tail.dropWhile(_ <= root).takeWhile(_ > root)

    if (leftTree.size + rightTree.size + 1 == preorder.size) {
      isValidBst(leftTree) & isValidBst(rightTree)
    } else {
      false
    }
  }
}
