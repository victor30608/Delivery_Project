package com.company.View;


import com.company.Point;
import com.company.Controller.*;
import org.json.JSONException;

import com.company.Model.*;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * Created by 8160325 on 21.09.2018.
 */
public class Menu {
    public void start() {
        System.out.print("Adress of company: ");
        Scanner in = new Scanner(System.in);
        Point p = new Point();
        String addres1 ="Зеленоград, улица Юности, дом 11";
        try
        {
            Geodecoding.decode(addres1, p);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        Company mycomp = new Company();
        mycomp.place=p;
        mycomp.address=addres1;
        Transport tr= new Transport();
        tr.available=true;
        tr.name= TypeOfTransport.Type.driving;
        tr.time= LocalTime.now();
        mycomp.worker.add(tr);
        tr.name= TypeOfTransport.Type.driving;
        mycomp.worker.add(tr);
        Configuration.saveconf(mycomp);

//        String addres2=" Зеленоград, площадь Шокина , дом 1";
//        Geodecoding a = new Geodecoding();
//        try {
//            DeliveryTime.calculate(addres1,addres2,"bicycling");
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }
//        catch (JSONException e) {
//        e.printStackTrace();
//        }
        System.out.print("Adress of company: ");
    }
}
