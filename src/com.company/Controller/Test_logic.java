package com.company.Controller;


import com.company.Point;
import org.json.JSONException;

import com.company.Model.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
public class Test_logic {
    public static void start()
    {
        Company My=new Company();
        try
        {
            Configuration.loadconf(My);
            ArrayList<Product> Allpr=new ArrayList<>();
            System.out.println(My.address);
            Scanner in = new Scanner(System.in);
//            LocalDateTime time = LocalDateTime.now();
//            LocalDateTime time1 = LocalDateTime.now().plusMinutes(1000).plusWeeks(1);

//            System.out.print(ChronoUnit.MINUTES.between(time1,time));
            for(int i=0;i<3;i++)
            {
                String addres;
                addres=in.nextLine();
                Point p1 = new Point();
                p1=Geodecoding.decode(addres);
                p1.name=addres;
                Product tmp=new Product(20,p1,LocalDateTime.now().plusMinutes(i*1));
                System.out.println(p1.name);
                Allpr.add(tmp);
            }
         Calculation.calculate(My,Allpr);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
