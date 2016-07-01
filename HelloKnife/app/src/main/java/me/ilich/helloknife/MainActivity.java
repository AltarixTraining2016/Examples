package me.ilich.helloknife;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.ilich.nestableviewpager.NestablePagerAdapterHelper;
import me.ilich.nestableviewpager.NestablePagerItem;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.text1)
    EditText text1;

    @BindView(R.id.text2)
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        /*final EditText text1 = (EditText) findViewById(R.id.text1);
        final EditText text2 = (EditText) findViewById(R.id.text2);
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text2.setText(text1.getText().toString());
            }
        });*/
        new NestablePagerItem() {
            @Override
            public int[] getOptionsMenuIds() {
                return new int[0];
            }

            @Override
            public ViewPager getNestedViewPager() {
                return null;
            }
        };
    }

    @OnClick(R.id.button1)
    void foo(){
        text2.setText(text1.getText().toString());
    }

}
