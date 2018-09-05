package com.a2zdevelopers.hollerads.Sample;

import com.a2zdevelopers.hollerads.Model.DataItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleDataProvider {
    public static List<DataItem> dataItemList;
    public static Map<String, DataItem> dataItemMap;

    static {
        dataItemList = new ArrayList<>();
        dataItemMap = new HashMap<>();

        addItem(new DataItem("Web Development ", "Unisoft Informatics System 1"));

        addItem(new DataItem("App Development", "Unisoft Informatics System 2"));

        addItem(new DataItem("Logo Design", "Unisoft Informatics System 3"));

        addItem(new DataItem("SEO", "SUnisoft Informatic System 4"));

        addItem(new DataItem("SMO ", "Unisoft Informatics System 5"));

        addItem(new DataItem("SMM (Facebook,Twitter,Linked)", "Unisoft Informatics System 6"));

        addItem(new DataItem("Marcketing Company(CPML,CPA)", "Unisoft Informatics System 7"));

        addItem(new DataItem("Content Writing", "Unisoft Informatics System 8"));

    }

    private static void addItem(DataItem item) {
        dataItemList.add(item);
        dataItemMap.put(item.getcFunctionName(), item);
    }
}
