package com.geekbrains.backend.test.db;

import java.util.List;

import com.geekbrains.db.dao.CategoriesMapper;
import com.geekbrains.db.dao.ProductsMapper;
import com.geekbrains.db.model.Categories;
import com.geekbrains.db.model.Products;
import com.geekbrains.db.model.ProductsExample;

public class TestDb {

    public static void main(String[] args) {

       /* DbService dbService = new DbService();
        ProductsMapper productsMapper = dbService.getProductsMapper();
        Products product = productsMapper.selectByPrimaryKey(1L);
        System.out.println(product);

        Products forCreate = new Products();
        forCreate.setTitle("Coca cola");
        forCreate.setPrice(50);
        forCreate.setCategoryId(1L);

        // productsMapper.insert(forCreate);

        ProductsExample filter = new ProductsExample();

        List<Products> products = productsMapper.selectByExample(filter);
        System.out.println(products);

        filter.createCriteria()
                .andCategoryIdEqualTo(2L);

        System.out.println(productsMapper.selectByExample(filter));

        filter.clear();
        filter.createCriteria()
                .andPriceBetween(51, 1000);

        System.out.println(productsMapper.selectByExample(filter));

        product.setPrice(105);
        productsMapper.updateByPrimaryKey(product);

        System.out.println(productsMapper.selectByPrimaryKey(1L));*/

        DbService dbService = new DbService();
        CategoriesMapper categoriesMapper = dbService.getCategoriesMapper();

        Categories catCreate = new Categories();
        catCreate.setTitle("Vegetables");
        int id = categoriesMapper.insert(catCreate);
        System.out.println(catCreate.getId());

        Categories catCreate1 = new Categories();
        catCreate.setTitle("Fruits");
        int id1 = categoriesMapper.insert(catCreate1);
        System.out.println(catCreate1.getId());

        Categories catCreate2 = new Categories();
        catCreate.setTitle("Juice");
        int id2 = categoriesMapper.insert(catCreate2);
        System.out.println(catCreate2.getId());

        Categories catCreate3 = new Categories();
        catCreate.setTitle("Sweets");
        int id3 = categoriesMapper.insert(catCreate3);
        System.out.println(catCreate3.getId());

        ProductsMapper productsMapper = dbService.getProductsMapper();
        Products productCreate = new Products();
        productCreate.setTitle("Cucumder");
        productCreate.setPrice(40);
        int product = productsMapper.insert((productCreate));
        System.out.println(productCreate.getId());

        Products productCucumber = productsMapper.selectByPrimaryKey (productCreate.getId());
        System.out.println(productCucumber);


        ProductsExample filter1 = new ProductsExample();
        filter1.setOrderByClause("price DESC");

        List<Products> products = productsMapper.selectByExample(filter1).subList(0, 3);
        for(int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getPrice());
        }



        dbService.closeSession();


    }




}
