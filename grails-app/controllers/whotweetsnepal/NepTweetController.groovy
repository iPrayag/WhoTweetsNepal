package whotweetsnepal

//import grails.converters.JSON
//import grails.converters.JSONObject
import grails.converters.*
import org.codehaus.groovy.grails.web.json.*; // package containing JSONObject, JSONArray,...
import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

/**
 * @author Prayag Upd
 * @created 20 Nov, 2012
 */

class NepTweetController {

    def index() {
          //def restEndpointUrl = "http://search.twitter.com/search.json?q=%23nepal";
          def restEndpointUrl = "http://search.twitter.com/search.json?q=%23nepal";
          def http = new HTTPBuilder(restEndpointUrl);
          
          // perform a GET request, expecting JSON response data
          http.request( GET, JSON ) {
                //uri.path = '/search.json'
                //uri.query = [ q: '%23nepal' ]
                            response.success = { resp, json ->
                                          //println resp.statusLine
                                          //def tweets = json.responseData;
                                          def tweets = json;
                                          List parsedList = JSON.parse(json) as List;
                                          JSONObject tweetJson = JSON.parse(json);
                                          tweetJson.each { id, data -> 
                                                 println data.text;
                                          }
                                          def tResponse='';
                                          def tweetsRes = json.each{
                                                tResponse = it;         
                                          }
                                          // parse the JSON response object:
                                         // json.responseData.results.each {
                                           // println "  ${it.titleNoFormatting} : ${it.visibleUrl}"
                                         // }//eo each
                                         render(view: "index", model: [message: "Request sent" , tweets: tweets, t:tResponse]);
                             }

                            // handler for any failure status code:
                            response.failure = { resp ->
                                        // println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
                                        def message = "Request Failure";
                                        render(view: "index", model: [message:message]);
                            }
          }//end of request
        // render(view: "index", model: [tweets: tweets]);
    }//end of method
}
