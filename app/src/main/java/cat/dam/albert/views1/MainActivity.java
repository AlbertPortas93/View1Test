package cat.dam.albert.views1;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button btn_lyt1 = findViewById(R.id.btn_lyt1);
        final Button btn_lyt2 = findViewById(R.id.btn_lyt2);
        final Button btn_lyt3 = findViewById(R.id.btn_lyt3);
        final FrameLayout fl_content = findViewById(R.id.fl_content);
        //Per defecte mostra el primer layout
        View child = getLayoutInflater().inflate(R.layout.layout, null);
        fl_content.addView(child);
        TypedValue typedValue = new TypedValue();
        btn_lyt1.setBackgroundColor(getThemePrimaryVariantColor(this));
        //en cas de que es premi algun dels botons mostrarà el layout corresponent
        btn_lyt1.setOnClickListener(v -> {
            System.out.println("Button 1 Clicked");
            btn_lyt1.setBackgroundColor(getThemePrimaryVariantColor(this));
            btn_lyt2.setBackgroundColor(getThemePrimaryColor(this));
            btn_lyt3.setBackgroundColor(getThemePrimaryColor(this));
            fl_content.removeAllViews();
            View child1 = getLayoutInflater().inflate(R.layout.layout, null);
            fl_content.addView(child1);
        });
        btn_lyt2.setOnClickListener(v -> {
            System.out.println("Button 2 Clicked");
            btn_lyt1.setBackgroundColor(getThemePrimaryColor(this));
            btn_lyt2.setBackgroundColor(getThemePrimaryVariantColor(this));
            btn_lyt3.setBackgroundColor(getThemePrimaryColor(this));
            fl_content.removeAllViews();
            View child2 = getLayoutInflater().inflate(R.layout.layout2, null);
            fl_content.addView(child2);
        });
        btn_lyt3.setOnClickListener(v -> {
            System.out.println("Button 3 Clicked");
            btn_lyt1.setBackgroundColor(getThemePrimaryColor(this));
            btn_lyt2.setBackgroundColor(getThemePrimaryColor(this));
            btn_lyt3.setBackgroundColor(getThemePrimaryVariantColor(this));
            fl_content.removeAllViews();
            View child3 = getLayoutInflater().inflate(R.layout.layout3, null);
            fl_content.addView(child3);
            setContentView(R.layout.layout3);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_dropdown_item_1line, NAMES);
            AutoCompleteTextView atv_Fruita = (AutoCompleteTextView)
                    findViewById(R.id.countries_list);
            atv_Fruita.setAdapter(adapter);
            Button buttonSayHello = (Button) findViewById(R.id.btn_14);
            EditText nameText = (EditText) findViewById(R.id.countries_list);
            TextView textGreeting = (TextView) findViewById(R.id.textGreeting);
            buttonSayHello.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SayHello();
                }

                public void SayHello() {
                    String name = nameText.getText().toString();
                    if (name != null) {
                        textGreeting.setText(name);
                    } else {
                        textGreeting.setText("You must enter a name");
                        buttonSayHello.setEnabled(name.isEmpty());
                    }

                }
            });
        });


    }
    private static final String[] NAMES = new String[] {
            "ADRIANA","AINA","ALBA","ALBERT","ALEXANDRA","ANDREA","ANNA","ARIADNA","AZIZA","BEATRIZ","BERTA","BLANCA","CARLA",
            "CARLOTA","CLARA","CLÀUDIA","CRISTINA","DELILA","DIANA","ELISABET","ESTER","EVA","FÀTIMA","GEORGINA","HELENA",
            "HOUDA","INÉS","IRENE","JUDIT","JÚLIA","KARIMA","LAIA","LORENA","MAR","MARIA","MARINA","MARTA","MIREIA",
            "MÍRIAM","MÒNICA","NATÀLIA","NEREA","NEUS","NOÈLIA","NÚRIA","OLAYA","PATRÍCIA","PAULA","QUERALT","RAQUEL",
            "SANDRA","SARA","SOFIA","SÍLVIA","SÒNIA","TURA","TÀNIA","ÚRSULA","VIOLETA","WASSIMA","YASIRA","ZAFIRA"
    };

    private static int getThemePrimaryColor(Context context) {
        int colorAttr;
        colorAttr = context.getResources().getIdentifier("colorPrimary", "attr", context.getPackageName());
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttr, outValue, true);
        return outValue.data;
    }
    private static int getThemePrimaryVariantColor(Context context) {
        int colorAttr;
        colorAttr = context.getResources().getIdentifier("colorPrimaryVariant", "attr", context.getPackageName());
        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(colorAttr, outValue, true);
        return outValue.data;
    }
}