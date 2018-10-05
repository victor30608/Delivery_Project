package com.company.Controller;

import com.company.Point;
import java.time.*;

public class Product {
    double time;
    Point place;
    LocalTime t_order;
    public Product(double t, Point p, LocalTime tmp) {
        this.time = t;
        this.place.Setlng(p.Getlng());
        this.place.Setlat(p.Getlat());
        this.t_order=tmp;
    }

    public void SetProduct(double t, Point p ,LocalTime tmp) {
        this.time = t;
        this.place.Setlng(p.Getlng());
        this.place.Setlat(p.Getlat());
        this.t_order=tmp;
    }


}
