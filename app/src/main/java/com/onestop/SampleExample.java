package com.onestop;

import com.onestop.Home.Model.ProductModel;
import com.onestop.ProductDetail.ProductDetailScreen;

import java.util.ArrayList;
import java.util.List;

public class SampleExample {

    private List<ProductModel> productList = new ArrayList<>();

    ProductModel pm1 = new ProductModel("Black Forest",
            "Rs. 500",
            "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
            "https://www.lifeloveandsugar.com/wp-content/uploads/2015/02/Chocolate-Oreo-Cake2.jpg", "1 kg");

    ProductModel pm2 = new ProductModel("Black Forest",
            "Rs. 500",
            "The Black Forest Cake, also called the Schwarzwälder Kirschtorte, is an authentic German cake is made up of a chocolate layer cake with cherries in the middle and whipped cream on top. They are traditionally made with fresh Morello cherries,",
            "https://img.floweraura.com/sites/default/files/Blackforest-cake-2Kg-eggless-A.jpg", "1kg");

    ProductModel pm3 = new ProductModel("Black Forest",
            "Rs. 500",
            "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
            "https://www.lifeloveandsugar.com/wp-content/uploads/2015/02/Chocolate-Oreo-Cake2.jpg", "1 kg");

    ProductModel pm4 = new ProductModel("Black Forest",
            "Rs. 500",
            "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
            "https://img.floweraura.com/sites/default/files/Blackforest-cake-2Kg-eggless-A.jpg", "1kg");

    ProductModel pm5 = new ProductModel("Classic Cake",
            "Rs. 400",
            "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
            "https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2013/05/carrot-cake.jpg", "1kg");

    ProductModel pm6 = new ProductModel("Pink Drip Cake",
            "Rs. 500",
            "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
            "https://chelsweets.com/wp-content/uploads/2019/04/IMG_1029-2-735x1103.jpg", "1kg");

    ProductModel pm7 = new ProductModel("Party Cake",
            "Rs. 700",
            "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
            "https://www.pamperedchef.com/iceberg/com/recipe/1125065-lg.jpg", "1kg");

    ProductModel pm8 = new ProductModel("Strawberry Cake",
            "Rs. 500",
            "As its name implies, Black Forest Cake comes from the Black Forest region of Germany.\n",
            "https://sugargeekshow.com/wp-content/uploads/2019/07/fresh-strawberry-cake-5.jpg", "1kg");

    public List<ProductModel> getProductList() {
        productList.add(pm1);
        productList.add(pm2);
        productList.add(pm3);
        productList.add(pm4);
        productList.add(pm5);
        productList.add(pm6);
        productList.add(pm7);
        productList.add(pm8);
        return productList;
    }
}
