package com.company.Model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 8160994 on 05.10.2018.
 */
public class Configuration {
    public void loadconf(Company mycomp)
    {

    }

    public static void saveconf(Company mycomp) {
        try {
            JSONObject config = new JSONObject();
            config.put("latitude", mycomp.place.Getlat());
            config.put("longitude", mycomp.place.Getlng());
            config.put("address", mycomp.address);
            JSONArray work = new JSONArray();
            FileWriter file = new FileWriter("config.json");
            file.write(config.toString());
            file.close();
            for(int i=0;i<mycomp.worker.size();i++) {

                JSONObject tr=new JSONObject();
                tr.put("name",mycomp.worker.get(i).name);
                work.put(tr);
            }
            FileWriter file1 = new FileWriter("workers.json");
            file1.write(work.toString());
            file1.close();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
