package com.football.rest.utility;

import java.lang.reflect.Modifier;

import org.json.JSONObject;

import com.football.rest.bean.FootballBeanData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public final class GsonToJSon {

	public static <T> Object  convertGsonToJson(JSONObject rootObject,Object obj) {
		 Gson gsonObj=new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
		            .excludeFieldsWithModifiers(Modifier.TRANSIENT) // STATIC|TRANSIENT in the default configuration
		            .create();
		 try {
			return gsonObj.fromJson(rootObject.toString(),  obj.getClass());
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
