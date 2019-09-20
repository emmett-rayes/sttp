package com.softwaremill.sttp

import java.net.HttpCookie

import com.softwaremill.sttp.model._
import scala.collection.JavaConverters._
import scala.collection.immutable.Seq

trait ResponseExtensions[T] { self: Response[T] =>

  def cookies: Seq[Cookie] =
    headers(HeaderNames.SetCookie)
      .flatMap(h => HttpCookie.parse(h).asScala.map(hc => Cookie.apply(hc, h)))
}
