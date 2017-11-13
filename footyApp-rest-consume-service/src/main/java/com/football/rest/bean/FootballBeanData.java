package com.football.rest.bean;



import org.springframework.data.annotation.Transient;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FootballBeanData {

@SerializedName("data")
@Expose
private Data data;

@Transient
public Object object;

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

}