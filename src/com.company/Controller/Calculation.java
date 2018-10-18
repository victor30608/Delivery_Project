package com.company.Controller;

import com.company.Model.Company;
import com.company.Model.Transport;
import org.json.JSONException;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Calculation {
    public static void calculate(Company MC, ArrayList<Product> AllProd) throws IOException, JSONException {
//        Date today = Calendar.getInstance().getTime();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MM HH:mm:ss");
//        sdf.setTimeZone(TimeZone.getTimeZone("Europe/Moscow"));
//        String date = sdf.format(today);
//        System.out.println(date);
        boolean free = false;
        for (Product i : AllProd) {
            free=false;
            for (Transport tr : MC.worker) {
                if (tr.available == true) {
                }
                    int deltime = 0;
                    if (tr.Allorder.size() == 0) {
                        deltime = (int)DeliveryTime.calculate(MC.place.toString(), i.place.toString(), tr.name.toString());
                        tr.alltime += deltime;//время , прошедшее с выезда
                        tr.addProduct(i);
                        free=true;
                        tr.fordertime = i.t_order.plusMinutes((int) i.time); // время выезда из фирмы
                        tr.fordertime=tr.fordertime.minusMinutes((int)deltime);// время выезда из фирмы для доставки 1 заказа
                        break;
                    } else {
                        double diff = ChronoUnit.MINUTES.between(tr.fordertime, i.t_order); // был ли получен заказ до того, как транспорт "ушёл"
                        if (diff > 0) {
                            deltime = (int)DeliveryTime.calculate(tr.Allorder.get(tr.numoforder() - 1).place.toString(), i.place.toString(), tr.name.toString());
                            double prevdel = DeliveryTime.calculate(tr.Allorder.get(tr.numoforder() - 1).place.toString(), MC.place.toString(), tr.name.toString());//время от последнего заказа к фирме
                            double basetothis = DeliveryTime.calculate(MC.place.toString(), i.place.toString(), tr.name.toString()); // время от  фирмы к текущему заказу
                            double need = ChronoUnit.MINUTES.between(tr.Allorder.get(tr.numoforder()-1).t_order.plusMinutes(tr.Allorder.get(tr.numoforder()-1).time), i.t_order.plusMinutes(i.time)) + prevdel + basetothis;
                            if (need <= 0) //вернулись на фирму
                            {
                                tr.fordertime = tr.Allorder.get(tr.numoforder()-1).t_order.plusMinutes(tr.Allorder.get(tr.numoforder()-1).time).plusMinutes((int)prevdel);
                                tr.alltime=ChronoUnit.MINUTES.between(i.t_order.plusMinutes(i.time),tr.fordertime);
                                tr.available=true;
                                tr.Allorder.add(i);
                                free=true;
                            }
                            else
                            {
                                double razn=ChronoUnit.MINUTES.between(tr.fordertime.plusMinutes(tr.alltime+deltime),i.t_order.plusMinutes(i.time));
                                if(razn<=0)
                                {
                                    tr.addProduct(i);
                                    tr.alltime=ChronoUnit.MINUTES.between(i.t_order.plusMinutes(i.time),tr.fordertime);
                                }
                            }
                            }
                        }
                    }

                }
            }

        }
