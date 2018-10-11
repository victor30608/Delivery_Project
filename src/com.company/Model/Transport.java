package com.company.Model;
import java.time.*;
import java.util.*;
import com.company.Controller.Product;

public class Transport {
   public TypeOfTransport.Type name;
    public LocalTime time ;
    private ArrayList<Product> Allorder;
    public boolean available;
    public  Transport()
    {
        Allorder=new ArrayList<Product>();
    }
    public Transport(TypeOfTransport.Type type, LocalTime t ,boolean mode ) {
        name = type;
        time = t;
        Allorder=new ArrayList<Product>();
        available = mode;
    }
    public void set_avail(boolean mode)
    {
        this.available=mode;
    }
    public void addProduct(Product tmp)
    {
        this.Allorder.add(tmp);
    }

}
