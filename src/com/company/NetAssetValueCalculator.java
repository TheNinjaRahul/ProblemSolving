package com.company;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Holding {
    String date;
    String security;
    int quantity;
    String portfolio;

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }

    @Override
    public String toString() {
        return "Holding{" +
                "date='" + date + '\'' +
                ", security='" + security + '\'' +
                ", quantity=" + quantity +
                ", portfolio='" + portfolio + '\'' +
                '}';
    }
}

class MarketPrice {
    String date;
    String security;
    double price;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MarketPrice{" +
                "date='" + date + '\'' +
                ", security='" + security + '\'' +
                ", price=" + price +
                '}';
    }
}

public class NetAssetValueCalculator {

    public static void main(String[] args) throws Exception {
        NetAssetValueCalculator n = new NetAssetValueCalculator();
    }

    public double calculateNAV(String date) {
        Gson gson = new Gson();
        String holding = null;
        try {
            holding = getResponse("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/holding");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String marketPrice = null;
        try {
            marketPrice = getResponse("https://raw.githubusercontent.com/arcjsonapi/HoldingValueCalculator/master/api/pricing");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Holding[] holdings = gson.fromJson(holding, Holding[].class);
        MarketPrice[] marketPrices = gson.fromJson(marketPrice, MarketPrice[].class);
        List<Holding> holdingList = Arrays.asList(holdings);
        List<MarketPrice> marketPriceList = Arrays.asList(marketPrices);
        Map<String, List<Holding>> mapOfHolding = holdingList.stream().collect(Collectors.groupingBy(Holding::getDate));
        Map<String, List<MarketPrice>> mapOfMarketPrice = marketPriceList.stream().collect(Collectors.groupingBy(MarketPrice::getDate));

        List<Holding> dateHolding = mapOfHolding.get(date);
        List<MarketPrice> dateMarketPrice = mapOfMarketPrice.get(date);

        Map<String, Double> mapCurrentDayMap = new HashMap<>();
        for (MarketPrice m : dateMarketPrice) {
            mapCurrentDayMap.put(m.getSecurity(), m.getPrice());
        }


        if (dateHolding.size() == 0 || dateMarketPrice.size() == 0) return 0;
        double result = 0.0;
        for (Holding holding1 : dateHolding) {
            result += holding1.quantity * (mapCurrentDayMap.get(holding1.security));
        }

        return result;

    }


    public static String getResponse(String url) throws IOException {
        URL yahoo = new URL(url);
        URLConnection yc = yahoo.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        StringBuffer sb = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            sb.append(inputLine);
        }

//        System.out.println(sb.toString());
        in.close();
        return sb.toString();
    }
}
