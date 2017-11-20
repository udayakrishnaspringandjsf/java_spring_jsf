package com.football.eureka.util;

import java.lang.reflect.Modifier;

import com.football.eureka.FootballBeanData;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JavaToJsonConverterUtil {


	public static void javaToJson(Object footballBeanData ) {
		 Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation()
		            .excludeFieldsWithModifiers(Modifier.TRANSIENT) // STATIC|TRANSIENT in the default configuration
		            .create();
		
		 System.out.println(gson.toJson(footballBeanData.getClass()));
		//return gson.toJson(clazz);
	 }
}
