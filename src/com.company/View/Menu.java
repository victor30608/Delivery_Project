package com.company.View;

import com.company.Controller.DeliveryTime;
import com.company.Controller.Geodecoding;
import com.company.Model.Company;
import com.company.Model.Configuration;
import com.company.Model.Transport;
import com.company.Model.TypeOfTransport;
import org.json.JSONException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

import static com.company.Model.Configuration.loadconf;

/**
 * Created by 8160325 on 17.10.2018.
 */

public class NASTYAMENU
{
    //loadconf
    /*Company comp = new Company();
    try{
        Configuration.loadconf(comp);//????????
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    catch (JSONException e)
    {
        e.printStackTrace();
    }*/


    boolean developer_mode = false;
    if(developer_mode)
    {
        System.out.print("1.Edit something\n");
        System.out.print("2.Make an order\n");
        Scanner in = new Scanner(System.in);
        int ans = in.nextInt();
        switch(ans)
        {
            case 1: {
                System.out.print("Adress of company: ");
                String address1 = in.nextLine();
                Point p1 = new Point();
                p1.SetX(in.nextInt());
                p1.SetY(in.nextInt());
                try
                {
                    Geodecoding.decode(address1, p1);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

                if (workers.size() != 0)
                {
                    workers.removeAll();
                }
                    ArrayList<Transport> workers = new ArrayList<Transport>();
                    System.out.print("How many cars?");
                    int cars = in.nextInt();
                    for (int i = 0; i < cars; i++)
                    {
                        workers.add(new Transport());
                    }
                    System.out.print("How many quadro?");
                    int q = in.nextInt();
                    for (int i = 0; i < q; i++)
                    {
                        workers.add(new Transport());
                    }
                    System.out.print("How many men?");
                    int men = in.nextInt();
                    for (int i = 0; i < men; i++)
                    {
                        workers.add(new Transport());
                    }
                    System.out.print("How many bycircles?");
                    int byc = in.nextInt();
                    for (int i = 0; i < byc; i++)
                    {
                        workers.add(new Transport());
                    }



                Company mycomp = new Company(p1, workers);
                try {
                    Configuration.saveconf(mycomp);

                    loadconf(mycomp);
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            case 2:{
                System.out.print("Enter an order: ");
                String order = in.nextLine();

                System.out.print("Enter address: ");
                String address2 = in.nextLine();
                Point p2 = new Point();
                p2.SetX(in.nextInt());
                p2.SetY(in.nextInt());
                try
                {
                    Geodecoding.decode(address2, p2);
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                catch (JSONException e)
                {
                    e.printStackTrace();
                }

                //поиск пути
                try {
                    DeliveryTime.calculate(address1,address2,"bicycling");
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    else
    {
        System.out.print("Enter an order: ");
        Scanner in = new Scanner(System.in);
        String order = in.nextLine();

        System.out.print("Enter address: ");
        String address2 = in.nextLine();
        Point p2 = new Point();
        p2.SetX(in.nextInt());
        p2.SetY(in.nextInt());
        try
        {
            Geodecoding.decode(address2, p2);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        //поиск пути
        try {
            DeliveryTime.calculate(address1,address2,"bicycling");
        }
        catch(IOException e) {
           e.printStackTrace();
        }
       catch (JSONException e) {
       e.printStackTrace();
        }
    }


//save
    /*try{
    Configuration.saveconf(comp);//????????
}
    catch(IOException e)
    {
        e.printStackTrace();
    }
    catch (JSONException e)
    {
        e.printStackTrace();
    }*/
}
