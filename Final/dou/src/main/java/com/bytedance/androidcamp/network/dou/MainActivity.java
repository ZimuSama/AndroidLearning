package com.bytedance.androidcamp.network.dou;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.bytedance.androidcamp.network.dou.camera.CameraActivity;


public class MainActivity extends AppCompatActivity {
    Fragment[] fragments = new Fragment[2];
    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabLayout mainTab = findViewById(R.id.main_tab);
        fragments[0] = new VideoFragment();
        fragments[1] = new MessageFragment();
        mainTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragments[0]).commit();
                        break;

                    case 1:
                        Intent cameraIntent=new Intent(MainActivity.this, CameraActivity.class);
                        MainActivity.this.startActivity(cameraIntent);
                        break;
                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.home_container,fragments[1]).commit();
                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

//    /**
//     * fragment替换（不保留之前的状态）
//     *
//     * @param to
//     * @param i
//     */
//    public void switchContent(Fragment to, int i) {
//        bundle.putString("text", textStrings[i]);
//        to.setArguments(bundle);
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.container, to).commit();
//    }



}
