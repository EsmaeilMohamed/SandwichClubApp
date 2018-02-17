package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        //Declare Sandwich Object
        Sandwich sandwich = null;

        try {

            //get json object
            JSONObject jsonObject = new JSONObject(json);

            //get json name
            JSONObject jsonName = jsonObject.getJSONObject("name");

            //get mainName
            String mainName = jsonName.getString("mainName");
            //get also known as
            List<String> alsoKnownAs = new ArrayList<>();
            JSONArray jsonAlsoKnownAs = jsonName.getJSONArray("alsoKnownAs");

            for (int i = 0; i < jsonAlsoKnownAs.length(); i++) {
                alsoKnownAs.add(jsonAlsoKnownAs.getString(i));
            }

            //get place of origin
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");

            //get description
            String description = jsonObject.getString("description");

            //get image
            String image = jsonObject.getString("image");

            //get ingredients
            List<String> ingredients = new ArrayList<>();
            JSONArray jsonIngredients = jsonObject.getJSONArray("ingredients");
            for (int i = 0; i < jsonIngredients.length(); i++) {
                ingredients.add(jsonIngredients.getString(i));
            }

            //initial new sandwich object
            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return sandwich;
    }
}
