package cn.deng.com.pagers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private CheckBox mCheckBox;
    private boolean  mCcIsChecked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCheckBox= (CheckBox) findViewById(R.id.user_is_sure);

    }
}
