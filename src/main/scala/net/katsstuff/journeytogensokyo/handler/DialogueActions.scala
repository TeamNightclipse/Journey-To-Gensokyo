package net.katsstuff.journeytogensokyo.handler

import java.util.UUID

import scala.collection.mutable

object DialogueActions {

  private val answerActions = mutable.Map.empty[UUID, () => Unit]

  def newAction(action: => Unit): UUID = {
    val uuid = UUID.randomUUID()
    answerActions.put(uuid, () => {
      action
    })
    uuid
  }

  def runAnswerAction(id: UUID): Unit = answerActions.get(id).foreach(f => f())

}
