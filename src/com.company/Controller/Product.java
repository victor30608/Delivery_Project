package com.company.Controller;

import com.company.Point;
import java.time.*;

public class Product {
    public long time;
    public Point place;
    public LocalDateTime t_order;
    public boolean av;
    public Product(long t, Point p, LocalDateTime tmp) {
        this.time = t;
        place=new Point(p);
        this.t_order=tmp;
        av=true;
    }

    public void SetProduct(int t, Point p ,LocalDateTime tmp) {
        this.time = t;
        this.place.Setlng(p.Getlng());
        this.place.Setlat(p.Getlat());
        this.t_order=tmp;
    }


}
