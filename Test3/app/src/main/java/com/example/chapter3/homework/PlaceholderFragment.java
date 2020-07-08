package com.example.chapter3.homework;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment{
    LottieAnimationView lottie;
    ListView list;
    @Override
    public void onViewCreated(@NonNull final View view,@Nullable Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        lottie=view.findViewById(R.id.lottie);
        lottie.playAnimation();
        list=view.findViewById(R.id.list_item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return inflater.inflate(R.layout.fragment_placeholder, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                ObjectAnimator animator1 = ObjectAnimator.ofInt(lottie,"Visibility",0,8);
                ObjectAnimator animator2 = ObjectAnimator.ofInt(list,"Visibility",8,0);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1);
                animatorSet.playTogether(animator2);
                animatorSet.start();
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
