package com.example.laskin;

import android.annotation.SuppressLint;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

public class FragmentAlue extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_alue, container, false);
    }

    public class YksikköAlue extends AppCompatActivity {


        private EditText e1,e2;
        private Spinner s1,s2;
        private int count1=0;
        private Muuntaja.Area ca;
        private int item1;
        private int item2;
        private double value;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_alue);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            e1= findViewById(R.id.item1);
            e2= findViewById(R.id.item2);
            s1= findViewById(R.id.spinner1);
            s2= findViewById(R.id.spinner2);

            ca=new Muuntaja.Area();
        }

        @SuppressLint("SetTextI18n")
        public void onClick(View v)
        {
            switch(v.getId())
            {
                case R.id.num0:
                    e1.setText(e1.getText()+"0");
                    break;

                case R.id.num1:
                    e1.setText(e1.getText()+"1");
                    break;

                case R.id.num2:
                    e1.setText(e1.getText()+"2");
                    break;

                case R.id.num3:
                    e1.setText(e1.getText()+"3");
                    break;

                case R.id.num4:
                    e1.setText(e1.getText()+"4");
                    break;

                case R.id.num5:
                    e1.setText(e1.getText()+"5");
                    break;

                case R.id.num6:
                    e1.setText(e1.getText()+"6");
                    break;

                case R.id.num7:
                    e1.setText(e1.getText()+"7");
                    break;

                case R.id.num8:
                    e1.setText(e1.getText()+"8");
                    break;

                case R.id.num9:
                    e1.setText(e1.getText()+"9");
                    break;

                case R.id.piste:
                    if (count1==0)
                    {
                        e1.setText(e1.getText()+".");
                        count1++;
                    }
                    break;

                case R.id.tyjennä:
                    e1.setText("");
                    e2.setText("");
                    count1=0;
                    break;

                case R.id.backSpace:
                    if(e1.length()!=0)
                    {
                        String text=e1.getText().toString();
                        if(text.endsWith("."))
                            count1=0;
                        String newText=text.substring(0,text.length()-1);
                        e1.setText(newText);
                    }
                    break;

                case R.id.on:
                    int item1=s1.getSelectedItemPosition();
                    int item2=s2.getSelectedItemPosition();
                    double value1=Double.parseDouble(e1.getText().toString());
                    double result=evaluate(item1,item2,value1);
                    e2.setText(result+"");
                    break;
            }
        }

        private double evaluate(int item1, int item2, double value)
        {
            this.item1 = item1;
            this.item2 = item2;
            this.value = value;
            double temp=0.0;
            if(item1==item2)
                return value;
            else
            {
                switch (item1)
                {
                    case 0:
                        temp=ca.sqMilliToMeter(value);
                        break;
                    case 1:
                        temp=ca.sqCentiToMeter(value);
                        break;
                    case 2:
                        temp=value;
                        break;
                    case 3:
                        temp=ca.sqKiloToMeter(value);
                        break;
                    case 4:
                        temp=ca.AcreToMeter(value);
                        break;
                    case 5:
                        temp=ca.HectareToMeter(value);
                        break;
                }

                switch (item2)
                {
                    case 0:
                        temp= ca.sqMeterToMilli(temp);
                        break;
                    case 1:
                        temp= ca.sqMeterToCenti(temp);
                        break;
                    case 3:
                        temp= ca.sqMeterToKilo(temp);
                        break;
                    case 4:
                        temp= ca.sqMeterToAcre(temp);
                        break;
                    case 5:
                        temp= ca.sqMeterToHectare(temp);
                        break;
                }
                return temp;
            }
        }
    }
}
