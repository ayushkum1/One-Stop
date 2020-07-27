package com.onestop.ProductDetail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.onestop.Cart.CartScreen;
import com.onestop.Order.MyOrderScreen;
import com.onestop.R;

import java.util.HashMap;

public class ProductDetailScreen extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,
        ViewPagerEx.OnPageChangeListener{

    TextView tvProductName, tvProductWeight, tvProductPrice, tvProductDescription, tvCount;
    Button btnAddToCart, btnBuyNow, btnPlus, btnMinus;
    ImageButton ibBack, ibCart;
    HashMap<String, String> sliderImageMap = new HashMap<>();
    private SliderLayout labSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail_screen);

        Intent detailIntent = getIntent();
        String name = detailIntent.getStringExtra("product_name");
        String price = detailIntent.getStringExtra("product_price");
        String weight = detailIntent.getStringExtra("product_weight");
        String description = detailIntent.getStringExtra("product_description");

        Toolbar toolbar = findViewById(R.id.toolbar);
        tvProductName = toolbar.findViewById(R.id.product_name);
        tvProductWeight = findViewById(R.id.product_weight_tv);
        tvProductPrice = findViewById(R.id.product_price_tv);
        tvProductDescription = findViewById(R.id.product_description_tv);

        btnAddToCart = findViewById(R.id.add_to_cart_btn);
        btnBuyNow = findViewById(R.id.buy_now_btn);

        ibBack = toolbar.findViewById(R.id.back_ib);
        ibCart = toolbar.findViewById(R.id.cart_ib);
        btnPlus = findViewById(R.id.plus_btn);
        btnMinus = findViewById(R.id.minus_btn);

        labSlider = findViewById(R.id.slider);

        //setting text views
        tvProductName.setText(name);
        tvProductPrice.setText(price);
        tvProductWeight.setText(weight);
        tvProductDescription.setText(description);

        sliderImageMap.put("black forest", "https://www.lifeloveandsugar.com/wp-content/uploads/2015/02/Chocolate-Oreo-Cake2.jpg");
        sliderImageMap.put("white forest", "https://img.floweraura.com/sites/default/files/Blackforest-cake-2Kg-eggless-A.jpg");
        sliderImageMap.put("yellow forest", "https://chelsweets.com/wp-content/uploads/2019/04/IMG_1029-2-735x1103.jpg");
        sliderImageMap.put("orange forest", "https://sugargeekshow.com/wp-content/uploads/2019/07/fresh-strawberry-cake-5.jpg");

        for(String imagename : sliderImageMap.keySet()){
            TextSliderView textSliderView = new TextSliderView(this);
            textSliderView
                    .description(imagename)
                    .image(sliderImageMap.get(imagename))
                    .setScaleType(BaseSliderView.ScaleType.Fit);

            textSliderView.bundle(new Bundle());

            textSliderView.getBundle()
                    .putString("extra",imagename);

            labSlider.addSlider(textSliderView);
        }
        labSlider.setPresetTransformer(SliderLayout.Transformer.DepthPage);

        labSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);

        labSlider.setCustomAnimation(new DescriptionAnimation());

        labSlider.setDuration(10000);

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductDetailScreen.this, "Added to Cart", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ProductDetailScreen.this, CartScreen.class));
            }
        });

        btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDetailScreen.this, MyOrderScreen.class));
            }
        });

        ibCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProductDetailScreen.this, CartScreen.class));
            }
        });

        ibBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductDetailScreen.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProductDetailScreen.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(this,slider.getBundle().get("extra") + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Log.d("Slider Demo", "Page Changed: " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
