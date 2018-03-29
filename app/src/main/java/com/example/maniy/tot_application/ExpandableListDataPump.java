package com.example.maniy.tot_application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> Ayyar_Bhavan = new ArrayList<String>();
        Ayyar_Bhavan.add("IDLY (SB) 2Nos @ ₹30/- ");
        Ayyar_Bhavan.add("DOSA (SB) 2Nos @ ₹35/-");
        Ayyar_Bhavan.add("POORI (SB) 2Nos @ ₹45/-");
        Ayyar_Bhavan.add("IDIYAPPAM (SB) 2Nos @ ₹40/-");
        Ayyar_Bhavan.add("AAPAM 2Nos (SB) @ ₹40");

        List<String> Saravan_Bhavan = new ArrayList<String>();
        Saravan_Bhavan.add("CHICKEN BIRYANI (AB) each @ ₹170/-");
        Saravan_Bhavan.add("MUTTON BIRYANI (AB) each @ ₹245/-");
        Saravan_Bhavan.add("FISH BIRYANI (AB) each @ ₹120/-");
        Saravan_Bhavan.add("PRAN BIRYANI (AB) each @ ₹110/-");
        Saravan_Bhavan.add("NOODLES (AB) each @ ₹90/-");



        expandableListDetail.put("SARAVANA BHAVAN", Ayyar_Bhavan);
        expandableListDetail.put("AYYAR BHAVAN", Saravan_Bhavan);
        return expandableListDetail;
    }
}