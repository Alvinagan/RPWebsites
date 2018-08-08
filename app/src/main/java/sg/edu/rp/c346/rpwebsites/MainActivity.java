package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnGo;
    WebView wvPage;

    ArrayList<String> alCategory;
    ArrayAdapter<String> aaCategory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnGo = findViewById(R.id.buttonGo);
        wvPage = findViewById(R.id.webViewPage);

        alCategory = new ArrayList<>();

        aaCategory = new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item, alCategory);

        spn2.setAdapter(aaCategory);


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    alCategory.clear();
                    String[] strRp = getResources().getStringArray(R.array.rp);
                    alCategory.addAll(Arrays.asList(strRp));
                } else if (position == 1){
                    alCategory.clear();
                    String[] strSoi = getResources().getStringArray(R.array.soi);
                    alCategory.addAll(Arrays.asList(strSoi));

                }
                aaCategory.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "";

                if(spn1.getSelectedItemPosition() == 0){
                    if(spn2.getSelectedItemPosition() == 0){
                        url = "https://www.rp.edu.sg/";
                    } else if (spn2.getSelectedItemPosition() == 1){
                        url = "https://www.rp.edu.sg/student-life";
                    }
                    else if (spn1.getSelectedItemPosition() == 1){
                        if(spn2.getSelectedItemPosition() == 0){
                            url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r47";
                        }
                        else if(spn2.getSelectedItemPosition() == 1){
                            url = "https://www.rp.edu.sg/soi/full-time-diplomas/details/r12";
                        }
                    }

                    Intent myIntent = new Intent(MainActivity.this, WebViewActivity.class);
                    myIntent.putExtra("url", url);
                    startActivity(myIntent);
                }
            }

        });
    }
}
