package com.example.assignmentapp;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assignmentapp.CategoryAdapter;
import com.example.assignmentapp.CategoryModel;
import com.example.assignmentapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.

 */
public class HomeFragment extends Fragment {




    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView categoryRecyclerView;
    private CategoryAdapter categoryAdapter;
    private RecyclerView testing;


    private ViewPager bannerSliderViewPager;
    private List<SliderModel> sliderModelList;
    private int currentPage =2;
    private Timer timer;
    final private long DAELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;


    //////////////horizantal products



    private TextView horizantallayouttitle;
    private Button horizantallayoutviewallbtn;
    private RecyclerView horizantalrecyclerview;
    ///////////hp





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home2, container, false);

        categoryRecyclerView = view.findViewById(R.id.category_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        categoryRecyclerView.setLayoutManager(layoutManager);

        final List<CategoryModel> categoryModelList = new ArrayList<CategoryModel>();

        categoryModelList.add(new CategoryModel("link","Home"));
        categoryModelList.add(new CategoryModel("link","Mobiles"));
        categoryModelList.add(new CategoryModel("link","Appliances"));
        categoryModelList.add(new CategoryModel("link","Fashion"));
        categoryModelList.add(new CategoryModel("link","Electronics"));
        categoryModelList.add(new CategoryModel("link","Furniture"));
        categoryModelList.add(new CategoryModel("link","Kids"));
        categoryModelList.add(new CategoryModel("link","Sports"));
        categoryModelList.add(new CategoryModel("link","Books"));
        categoryModelList.add(new CategoryModel("link","Stationaries"));

        categoryAdapter = new CategoryAdapter(categoryModelList);
        categoryRecyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();


        ///////Slider


        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList = new ArrayList<SliderModel>();


        sliderModelList.add(new SliderModel(R.drawable.slide1,"#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.slide2,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.slide3,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.slide4,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.slide5,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.slide1,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.slide2,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.slide3,"#077AE4"));

        sliderModelList.add(new SliderModel(R.drawable.slide5,"#077AE4"));
        sliderModelList.add(new SliderModel(R.drawable.slide1,"#077AE4"));

        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);


        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage =i;

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if (i == ViewPager.SCROLL_STATE_IDLE)
                {
                    pageLooper();
                }

            }
        };

        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);


        startbannerslideshow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                pageLooper();
                stopbannerslideshow();
                if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    startbannerslideshow();
                }
                return false;
            }
        });




        ///////slider

        //////////hp

        horizantallayouttitle =  view.findViewById(R.id.horizantal_scrolllayout_title);
        horizantallayoutviewallbtn =  view.findViewById(R.id.horozantal_scrolllayout_viewAll_btn);
        horizantalrecyclerview = view.findViewById(R.id.horizantal_scrolllayout_rv);



        List<HorizantalProductScrollModel> horizantalProductScrollModelList = new ArrayList<>();
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone1,"One Plus Nord CE3 Lite","108MP Primary Camera ","Rs.19,999/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone2,"Realme X Pro","Amoled Display ","Rs.18,999/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone3,"Moto g84","SD Processor ","Rs.20,000/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone4,"Poco M4 pro","5G Powerful Chipset ","Rs.17,999/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone5,"IQOO Z7s","In display fingerprint ","Rs.18,9999/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone1,"One Plus Nord CE3 Lite","108MP Primary Camera ","Rs.19,999/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone2,"Realme X Pro","Amoled Display ","Rs.18,999/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone3,"Moto g84","SD Processor ","Rs.20,000/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone4,"Poco M4 pro","5G Powerful Chipset ","Rs.17,999/-"));
        horizantalProductScrollModelList.add(new HorizantalProductScrollModel(R.drawable.phone5,"IQOO Z7s","In display fingerprint ","Rs.18,9999/-"));




        HorizantalProductScrollAdapter horizantalProductScrollAdapter = new HorizantalProductScrollAdapter(horizantalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizantalrecyclerview.setLayoutManager(linearLayoutManager);

        horizantalrecyclerview.setAdapter(horizantalProductScrollAdapter);
        horizantalProductScrollAdapter.notifyDataSetChanged();

        /////////hp



        //////gridview

        TextView gridLayouttitle = view.findViewById(R.id.gridproduct_layout_title);
        Button gridlayoutviewallbtn = view.findViewById(R.id.gridproduct_layout_viewall_btn);
        GridView gridView = view.findViewById(R.id.gridproduct_layout_gridview);
        gridView.setAdapter(new GridproductLayoutAdapter(horizantalProductScrollModelList));





        //////gridview





        return view;
    }

    //////////Banner slider

    private void pageLooper(){
        if(currentPage == sliderModelList.size() - 2)
        {
            currentPage=2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage == 1)
        {
            currentPage=sliderModelList.size()-3;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }

    }

    private void startbannerslideshow(){
        Handler handler = new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                if (currentPage >= sliderModelList.size())
                {
                    currentPage =1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);

            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DAELAY_TIME,PERIOD_TIME);
    }
    private  void stopbannerslideshow(){
        timer.cancel();
    }

    ///////b Slider

}