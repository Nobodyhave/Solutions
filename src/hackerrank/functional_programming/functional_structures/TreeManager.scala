package hackerrank.functional_programming.functional_structures

import java.io.FileInputStream
import java.util.Scanner

import scala.collection.mutable.ListBuffer

/**
  * Created by Aleksandr on 02/03/2017.
  * Project Solutions
  *
  * https://www.hackerrank.com/challenges/tree-manager
  */
object TreeManager {
  def main(args: Array[String]) {
    //val in = new Scanner(System.in)
    val in = new Scanner(new FileInputStream("C:\\Projects\\Solutions\\src\\tests.txt"))

    val Q = in.nextLine.toInt
    val tree = new Tree
    var q = 0
    while (q < Q) {
      val query = in.nextLine
      val querySplit = query.split(" ")

      if (query.contains("change")) {
        tree.changeValue(querySplit.last.toInt)
      } else if (query.contains("print")) {
        tree.print()
      } else if (query.contains("visit left")) {
        tree.visitLeft()
      } else if (query.contains("visit right")) {
        tree.visitRight()
      } else if (query.contains("visit child")) {
        tree.visitChild(querySplit.last.toInt)
      } else if (query.contains("visit parent")) {
        tree.visitParent()
      } else if (query.contains("insert left")) {
        tree.insertLeft(querySplit.last.toInt)
      } else if (query.contains("insert right")) {
        tree.insertRight(querySplit.last.toInt)
      } else if (query.contains("insert child")) {
        tree.insertChild(querySplit.last.toInt)
      } else if (query.contains("delete")) {
        tree.delete()
      }

      q += 1
    }
  }

  private class Tree {
    val root = new Node(0)
    var current = root

    def changeValue(value: Int) = {
      current.changeValue(value)
    }

    def print() = {
      current.print()
    }

    def visitLeft() = {
      current = current.parent.children(current.parent.children.indexOf(current) - 1)
    }

    def visitRight() = {
      current = current.parent.children(current.parent.children.indexOf(current) + 1)
    }

    def visitParent() = {
      current = current.parent
    }

    def visitChild(n: Int) = {
      current = current.children(n - 1)
    }

    def insertLeft(value: Int): Unit = {
      val node = new Node(value)
      node.parent = current.parent
      current.parent.children.insert(current.parent.children.indexOf(current), node)
    }

    def insertRight(value: Int): Unit = {
      val node = new Node(value)
      node.parent = current.parent
      current.parent.children.insert(current.parent.children.indexOf(current) + 1, node)
    }

    def insertChild(value: Int) = {
      val node = new Node(value)
      node.parent = current
      current.children.insert(0, node)
    }

    def delete() = {
      val temp = current
      current = current.parent
      current.children.remove(current.children.indexOf(temp))
    }

    class Node(input: Int) {
      var value = input
      var children = new ListBuffer[Node]()
      var parent: Node = null

      def changeValue(value: Int) = {
        this.value = value
      }

      def print() = {
        println(value)
      }
    }

  }

}
