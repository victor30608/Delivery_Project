package com.company.View;


import com.company.Point;
import com.company.Controller.*;
import org.json.JSONException;

import javax.swing.*;
import java.io.IOException;
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
        String addres2=" Зеленоград, площадь Шокина , дом 1";
        Geodecoding a = new Geodecoding();
        try {
            DeliveryTime.calculate(addres1,addres2,"bicycling");
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        catch (JSONException e) {
        e.printStackTrace();
        }
        System.out.print("Adress of company: ");
    }
}
