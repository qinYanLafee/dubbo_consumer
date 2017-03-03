package com.raycloud.myproject.test.controller.response;
import com.raycloud.myproject.test.controller.request.Request;
import org.apache.commons.lang.StringUtils;

/**
 * Created by 001117020012 on 2017/2/17.
 */
public class Response {

    private String api_name;

    private String result = "100";

    private String message = "";

    private Object data;

    public Response(){

    }

    public Response(Request request){
        this.api_name = request.getApi_name();
    }
    public String getApi_name() {
        if(StringUtils.isNotBlank(api_name)){
            if(!api_name.matches("[^<>/\\\\\"'=]*")){
                api_name = api_name.replaceAll("[<>/\\\\\"'=]*","");
            }
        }
        return api_name;
    }

    public void setApi_name(String api_name) {
        this.api_name = api_name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}

