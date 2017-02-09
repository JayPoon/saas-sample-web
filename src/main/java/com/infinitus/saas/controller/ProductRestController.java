package com.infinitus.saas.controller;

/**
 * Created by administrator on 17/2/7.
 */

import com.infinitus.saas.entity.Product;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping({"/api/product"})
public class ProductRestController
{
    static List<Product> products = new ArrayList();

    @RequestMapping(value={""}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public List<Product> list(String q)
    {
        System.out.println("query all product...............");
        if (StringUtils.isEmpty(q)) {
            return products;
        }

        List resp = new ArrayList();
        for (Product pro : products) {
            if (pro.getDescription().indexOf(q) >= 0) {
                resp.add(pro);
            }
        }
        return resp;
    }

    @RequestMapping(value={"/create"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public Product create(Product product) {
        System.out.println("query product detail...............");
        if (product == null) {
            product = new Product();
        }
        product.setId(Integer.valueOf((int)(Math.random() * 1000.0D)));
        return product;
    }

    static
    {
        Product p = new Product();
        p.setDescription("苹果手机");
        p.setImageUrl("http://img.pconline.com.cn/images/upl.jpg");
        p.setPrice(new BigDecimal(5400));
        p.setId(Integer.valueOf(1));
        products.add(p);

        Product p1 = new Product();
        p1.setDescription("苹果电脑");
        p1.setImageUrl("http://img4.imgtn.bdimg.com/i.jpg");
        p1.setPrice(new BigDecimal(15400));
        p1.setId(Integer.valueOf(2));
        products.add(p1);
    }
}