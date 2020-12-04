package com.example.helloworld.api

import akka.NotUsed
import com.lightbend.lagom.scaladsl.api.Descriptor
import com.lightbend.lagom.scaladsl.api.Service
import com.lightbend.lagom.scaladsl.api.ServiceAcl
import com.lightbend.lagom.scaladsl.api.ServiceCall
import com.lightbend.lagom.scaladsl.api.transport.Method

trait HelloWorldService extends Service {

  def hello(id: String): ServiceCall[NotUsed, String]

  override final def descriptor: Descriptor = {
    import Service._
    named("hello-world")
      .withCalls(
        pathCall("/api/hello/:id", hello _)
      )
      .withAutoAcl(true)
      .withAcls(
        ServiceAcl.forMethodAndPathRegex(Method.OPTIONS, "/api/hello/.*")
      )
  }
}

