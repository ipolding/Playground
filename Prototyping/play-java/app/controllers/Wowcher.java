package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Deal;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import play.libs.F;
import play.libs.XML;
import play.libs.XPath;
import play.libs.ws.WS;
import play.mvc.Result;
import play.mvc.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Wowcher extends Controller {

    private static final String LOCATION_PLACEHOLDER = "{location}";
    private static final String DEALS_BY_LOCATION = "http://api.wowcher.co.uk/deals/" + LOCATION_PLACEHOLDER;

    public static F.Promise<Result> dealsByLocationJson(String location) {

               final String feedUrl = DEALS_BY_LOCATION.replace(LOCATION_PLACEHOLDER, location);

        System.out.println("address I am hitting is " + feedUrl);

               return WS.url(feedUrl).get().map(
                        response -> {

                            JsonNode dealFeedResponse = response.asJson();
                            List<Deal> dealList = new ArrayList();

                            JsonNode deals = dealFeedResponse.findPath("theDeals");
                            deals.iterator().forEachRemaining(
                                    node -> {
                                        String title = node.findValue("title").textValue();
                                        String dealDescription = node.findValue("dealDescription").textValue();
                                        String businessName = node.findValue("businessName").textValue();
                                        dealList.add(new Deal(title, dealDescription, businessName));
                                    }
                            );

                            return ok(views.html.deals.render(dealList));
                        }
                );

    }

    public static F.Promise<Result> dealsByLocationXml(String location) {

               final String feedUrl = DEALS_BY_LOCATION.replace(LOCATION_PLACEHOLDER, location);

        System.out.println("address I am hitting is " + feedUrl);

               return WS.url(feedUrl).get().map(
                        response -> {
                            String responseBody = response.getBody();
                            responseBody = responseBody.substring(647);
                            System.out.println("the beginning of the response is : " + responseBody.substring(0, 100));
                            //                            Document dealFeedDom = response.asXml();
                            Document dealFeedDom = XML.fromString(responseBody);
                            NodeList dealList = XPath.selectNodes("deal", dealFeedDom);
                            int numberOfDeals = dealList.getLength();

                            List<Deal> dealModelList = new ArrayList();

                            /* Could replace with parallel to go even faster*/
                            IntStream.range(0, numberOfDeals - 1).forEach(
                                    (int index) -> {
                                        Node deal = dealList.item(0);
                                        String title = XPath.selectText("title", deal);
                                        String dealDescription = XPath.selectText("dealDescription", deal);
                                        String businessName = XPath.selectText("businessName", deal);
                                        dealModelList.add(new Deal(title, dealDescription, businessName));
                                    }
                            );

                            return ok(views.html.deals.render(dealModelList));
                        }
                );

    }
}
