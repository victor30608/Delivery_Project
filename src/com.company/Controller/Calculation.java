package com.company.Controller;

import com.company.Model.Company;
import com.company.Model.Transport;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Calculation {
    public static void calculate(Company MC, ArrayList<Product> AllProd) {
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
                        deltime = DeliveryTime.calculate(MC.place.toString(), i.place.toString(), tr.name.toString());
                        tr.alltime += deltime;
                        tr.addProduct(i);
                        free=true;
                        tr.fordertime = i.t_order.plusMinutes((int) i.time);
                        tr.fordertime=tr.fordertime.minusMinutes((int)deltime);
                        break;
                    } else {
                        double diff = ChronoUnit.MINUTES.between(tr.fordertime, i.t_order); // был ли получен заказ до того, как траспорт "ушёл"
                        if (diff > 0) {
                            deltime = DeliveryTime.calculate(tr.Allorder.get(tr.numoforder() - 1).place.toString(), i.place.toString(), tr.name.toString());
                            double prevdel = DeliveryTime.calculate(tr.Allorder.get(tr.numoforder() - 1).place.toString(), MC.place.toString(), tr.name.toString());//время от последнего заказа к фирме
                            double basetothis = DeliveryTime.calculate(MC.place.toString(), i.place.toString(), tr.name.toString()); // время от текущего фирму к текущему заказу
                            double need = ChronoUnit.MINUTES.between(tr.Allorder.get(tr.numoforder() - 1).t_order, i.t_order) + prevdel + basetothis;
                            if (need <= 0) //вернулись на фирму
                            {
                                tr.fordertime = tr.Allorder.get(tr.numoforder() - 1).t_order;
                                tr.fordertime = tr.fordertime.plusMinutes((int) prevdel);
                                tr.Allorder.add(i);
                                free=true;
                            }
                            else
                            {
                                double razn=ChronoUnit.MINUTES.between(tr.fordertime.plusMinutes(tr.alltime+deltime),i.t_order.plusMinutes(i.time));
                            }
                            }
                        }
                    }

                }
            }

        }
