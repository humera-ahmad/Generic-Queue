package com.knoldus.CustomQueue

import org.scalatest.flatspec.AnyFlatSpec

class QueueTest extends AnyFlatSpec {

  "Queue" should "return only enqueued value as the list was empty initially" in{
    val queue = new Queue[String](List())
    val enqueued = queue.enqueue("Hi").toString
    assertResult("List(Hi)")(enqueued)
  }

  it should "return enqueued list of string" in{
    val queue = new Queue[String](List("Hello"))
    val result=queue.enqueue("Hi").toString
    assertResult("List(Hello, Hi)")(result)
  }

  it should "return dequeued list of string" in{
    val queue = new Queue[String](List("Hello"))
    val enqueued = queue.enqueue("Hi")
    val dequeued=enqueued.dequeue.toString
    assertResult("Success(List(Hi))")(dequeued)
  }

  it should "return enqueued list of int" in{
    val queue = new Queue[Int](List(1,2))
    val result=queue.enqueue(3).toString
    assertResult("List(1, 2, 3)")(result)
  }

  it should "return dequeued list of int" in{
    val queue = new Queue[Int](List(1,2))
    val enqueued = queue.enqueue(3)
    val dequeued=enqueued.dequeue.toString
    assertResult("Success(List(2, 3))")(dequeued)
  }

  it should "return nothing" in{
    val queue = new Queue[String](List())
    val dequeued=queue.dequeue.toString
    assertResult("Failure(java.lang.UnsupportedOperationException: tail of empty list)")(dequeued)
  }

}
