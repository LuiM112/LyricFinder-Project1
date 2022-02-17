package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {
    @SerializedName("message")
    @Expose
    private ArrayList<data> data;

    public ArrayList<Data.data> getData() {
        return data;
    }

    public void setData(ArrayList<Data.data> data) {
        this.data = data;
    }

    public class data{
        String header;
        String body;

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }


}

