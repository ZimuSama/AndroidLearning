package com.example.test2.Recycler;
import androidx.annotation.DrawableRes;

import com.example.test2.R;

import java.util.ArrayList;
import java.util.List;
public class RecDataSet {
    public static List<RecData> getData() {
        List<RecData> datas = new ArrayList();
        datas.add(new RecData(R.drawable.b01, "服务1","已接单"));
        datas.add(new RecData(R.drawable.b02, "服务2","单号520"));
        datas.add(new RecData(R.drawable.b03, "服务3","收费1314"));
        datas.add(new RecData(R.drawable.b04, "服务4","将于明天下午到达指定地点"));
        datas.add(new RecData(R.drawable.b05, "服务5","合作愉快"));
        datas.add(new RecData(R.drawable.kex, "凯尔希","……"));
        datas.add(new RecData(R.drawable.xx, "星熊","在我面前伤害我的同伴，是我最不能容忍的事情！"));
        datas.add(new RecData(R.drawable.ajln, "安洁莉娜","这是大家一起努力的结果，博士也会好好珍惜的，对吧。"));
        datas.add(new RecData(R.drawable.as, "暗索","有些好东西，留在敌人身上也是种浪费~你说呢？"));
        datas.add(new RecData(R.drawable.ayfl, "艾雅法拉","为什么要这样彼此争斗不休呢……"));
        datas.add(new RecData(R.drawable.bj, "白金","将死。不好意思，是我的胜利呢。"));
        datas.add(new RecData(R.drawable.bmx, "白面鸮","您的逻辑推论完全正确，完美的计算。"));
        return datas;
    }
}
