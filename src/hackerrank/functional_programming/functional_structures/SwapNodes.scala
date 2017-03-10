package hackerrank.functional_programming.functional_structures

import java.util.Scanner

import scala.collection.mutable.ListBuffer

/**
  * Created by Aleksandr on 01/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/swap-nodes
  */
object SwapNodes {
  def main(args: Array[String]) {
    val in = new Scanner(System.in)
    val N = in.nextInt
    var cur = new ListBuffer[Node]
    var next = new ListBuffer[Node]
    val root = new Node
    root.`val` = 1
    cur += root
    var i = 1
    while (i <= N) {
      while (cur.nonEmpty) {
        val curNode = cur.remove(0)
        val leftVal = in.nextInt
        if (leftVal != -1) {
          val left = new Node
          left.`val` = leftVal
          curNode.left = left
          next += left
        }
        else {
          curNode.left = null
        }
        val rightVal = in.nextInt
        if (rightVal != -1) {
          val right = new Node
          right.`val` = rightVal
          curNode.right = right
          next += right
        }
        else {
          curNode.right = null
        }
        i += 1
      }
      val temp = cur
      cur = next
      next = temp
    }
    val K: Int = in.nextInt
    i = 0
    while (i < K) {
      {
        val k = in.nextInt
        swap(root, k, 1)
        printTree(root)
        System.out.println()
      }
      i += 1
    }
  }

  private def swap(root: Node, height: Int, curHeight: Int) {
    if (root == null) {
      return
    }
    if (curHeight % height == 0) {
      val temp = root.left
      root.left = root.right
      root.right = temp
    }
    swap(root.left, height, curHeight + 1)
    swap(root.right, height, curHeight + 1)
  }

  private def printTree(root: SwapNodes.Node) {
    if (root == null) {
      return
    }
    printTree(root.left)
    System.out.print(root.`val` + " ")
    printTree(root.right)
  }

  private class Node {
    var `val`: Int = 0
    var left: Node = null
    var right: Node = null
  }

}
