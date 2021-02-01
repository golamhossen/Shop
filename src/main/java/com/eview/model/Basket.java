/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eview.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author HP
 */
@Entity(name = "basket")
public class Basket {
    @Id
    
    private int id;
    private int dId;
    private int pId;
    private String name;
    private String code;
    private int catId;
    private String catName;
    private int subCatId;
    private String subCatName;
    private int bId;
    private String bName;
    private int sId;
    private String sName;
    private int colorId;
    private String colorName;
    private String desc;
    private String photo;
    private Double price;
    private int qty;
    private int discount;
    private Double dPrice;
}
