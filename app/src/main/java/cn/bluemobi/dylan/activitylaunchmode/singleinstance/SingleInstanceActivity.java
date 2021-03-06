package cn.bluemobi.dylan.activitylaunchmode.singleinstance;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import cn.bluemobi.dylan.activitylaunchmode.singletask.LoginActivity;
import cn.bluemobi.dylan.activitylaunchmode.singletask.RegisterActivity;

/**
 * Created by yuandl on 2016-11-18.
 */

public class SingleInstanceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button button = new Button(this);
        button.setGravity(Gravity.CENTER);
        button.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        button.setText("这是第一界面，标准的启动模式,点击跳转到SecondActivity（SecondActivity启动模式是SingleInstance）");
        setContentView(button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SingleInstanceActivity.this, SecondActivity.class));
            }
        });
    }
}
