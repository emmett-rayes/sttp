package sttp.client3.armeria.fs2

import cats.effect.IO
import sttp.client3.SttpBackend
import sttp.client3.impl.cats.{CatsTestBase, DispatcherIOMixin}
import sttp.client3.testing.HttpTest

class ArmeriaFs2HttpTest extends HttpTest[IO] with CatsTestBase with DispatcherIOMixin {
  override val backend: SttpBackend[IO, Any] = ArmeriaFs2Backend(dispatcher = dispatcher)

  override def supportsHostHeaderOverride = false
  override def supportsMultipart = false
  override def supportsCancellation = false
}
