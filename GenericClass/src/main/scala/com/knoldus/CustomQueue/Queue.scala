package com.knoldus.CustomQueue

import scala.collection.immutable.List
import scala.util.Try

class Queue[+A](list:List[A]) {

  override def toString: String = list.toString

  def enqueue[B>:A](input:B):Queue[B]= {        // using lower-type-bound
    new Queue[B](list :+ input)
  }

  def dequeue[B>:A]:Try[Queue[B]] ={
    Try (new Queue[B](list.tail))           //using Try() for error handling
  }

}
