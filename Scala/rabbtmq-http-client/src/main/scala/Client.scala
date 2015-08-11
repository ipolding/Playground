import org.apache.http.HttpResponse
import org.apache.http.auth.{AuthScope, UsernamePasswordCredentials}
import org.apache.http.client.CredentialsProvider
import org.apache.http.client.methods.{HttpDelete}
import org.apache.http.impl.client.{HttpClientBuilder, BasicCredentialsProvider, DefaultHttpClient}
import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

object ScalaRabbitMqHttpClient extends App {

  override def main(args: Array[String]) {


    println("Enter a comma separated list of queues")
    while(true) {
      val input = StdIn.readLine("Queue name or blank space:")


      val commaSeparatedQueues = input.split(",")

      commaSeparatedQueues.foreach(
      q => {
        q.replaceAll(",","")
        deleteQueueOrExchange(q)}  )
    }
    println("queues deleted")
  }

  def deleteQueueOrExchange(queueOrExchange : String): Unit = {

    val deleteQ = s"http://localhost:15672/api/queues/%2f/$queueOrExchange"
    val deleteX = s"http://localhost:15672/api/exchanges/%2f/$queueOrExchange"

    val provider :  CredentialsProvider = new BasicCredentialsProvider
     val credentials : UsernamePasswordCredentials= new UsernamePasswordCredentials("guest", "guest")
    provider.setCredentials(AuthScope.ANY, credentials)


    val httpClient = HttpClientBuilder.create.setDefaultCredentialsProvider(provider).build()

    val httpResponse1 : HttpResponse = httpClient.execute(new HttpDelete(deleteQ))
    val httpResponse2 : HttpResponse = httpClient.execute(new HttpDelete(deleteX))
  }
}