package camelawong.day6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btn;
    CheckBox cb1, cb2, cb3, cb4;
    TextView tv;
    boolean[] cBool = new boolean[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cb1 = (CheckBox) findViewById(R.id.check1);
        cb2 = (CheckBox) findViewById(R.id.check2);
        cb3 = (CheckBox) findViewById(R.id.check3);
        cb4 = (CheckBox) findViewById(R.id.check4);
        btn = (Button) findViewById(R.id.btn);
        tv = (TextView) findViewById(R.id.tv);

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cBool[0]=isChecked;
            }
        });

        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cBool[1]=isChecked;
            }
        });

        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cBool[2]=isChecked;
            }
        });

        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                cBool[3]=isChecked;
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = new String[]{"Check one", "Check two", "Check three", "Check four"};
                List<String> list = new ArrayList<>();

                for (int i=0; i<4; i++){
                    if (cBool[i]){
                        list.add(strings[i]);
                    }
                }
                if (list.size() == 0){
                    tv.setText(getResources().getString(R.string.no_selection));
                } else if (list.size() == 1){
                    tv.setText(String.format(getString(R.string.select_1), list.get(0)));
                } else if (list.size()==2){
                    tv.setText(String.format(getString(R.string.select_2), list.get(0), list.get(1)));
                } else if (list.size()==3){
                    tv.setText(String.format(getString(R.string.select_3), list.get(0), list.get(1), list.get(2)));
                } else if (list.size()==4){
                    tv.setText(String.format(getString(R.string.select_4), list.get(0), list.get(1), list.get(2), list.get(3)));
                }
            }
        });
    }
}
