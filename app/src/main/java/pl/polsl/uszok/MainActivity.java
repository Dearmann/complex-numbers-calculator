package pl.polsl.uszok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String[] operations = new String[]{"+","-"};
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(),operations[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button plus = findViewById(R.id.button2);
        Button minus = findViewById(R.id.button3);
        EditText real1 = findViewById(R.id.editTextNumber);
        EditText img1 = findViewById(R.id.editTextNumber2);
        EditText real2 = findViewById(R.id.editTextNumber3);
        EditText img2 = findViewById(R.id.editTextNumber4);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,operations);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
//        TextView result = findViewById(R.id.textView4);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (real1.getText().length() == 0 || real2.getText().length() == 0
                        || img1.getText().length() == 0 || img2.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Enter numbers first", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (real1.getText().length() > 15 || real2.getText().length() > 15
                        || img1.getText().length() > 15 || img2.getText().length() > 15)
                    return;
                Double realResult = 0.0;
                Double imgResult = 0.0;
                try {
                    realResult = Double.parseDouble(real1.getText().toString()) +
                            Double.parseDouble(real2.getText().toString());
                    imgResult = Double.parseDouble(img1.getText().toString()) +
                            Double.parseDouble(img2.getText().toString());
                } catch (NumberFormatException nfe) {
                    Toast.makeText(getApplicationContext(), "Enter numbers first", Toast.LENGTH_SHORT).show();
                    return;
                }
//                result.setText(realResult + "   " + imgResult + "i");
//                result.setText(real1.getText().toString());
                String realR;
                String imgR;
                if (realResult >= 0) {
                    realR = "+"+realResult;
                } else {
                    realR = ""+realResult;
                }
                if (imgResult >= 0) {
                    imgR = "+"+imgResult;
                } else {
                    imgR = ""+imgResult;
                }
                Toast.makeText(getApplicationContext(), realR + "   " + imgR + "i", Toast.LENGTH_SHORT).show();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (real1.getText().length() == 0 || real2.getText().length() == 0
                        || img1.getText().length() == 0 || img2.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Enter numbers first", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (real1.getText().length() == 0 || real2.getText().length() == 0
                        || img1.getText().length() == 0 || img2.getText().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Enter numbers first", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (real1.getText().length() > 15 || real2.getText().length() > 15
                        || img1.getText().length() > 15 || img2.getText().length() > 15)
                    return;
                Double realResult = 0.0;
                Double imgResult = 0.0;
                try {
                    realResult = Double.parseDouble(real1.getText().toString()) -
                            Double.parseDouble(real2.getText().toString());
                    imgResult = Double.parseDouble(img1.getText().toString()) -
                            Double.parseDouble(img2.getText().toString());
                } catch (NumberFormatException nfe) {
                    Toast.makeText(getApplicationContext(), "Enter numbers first", Toast.LENGTH_SHORT).show();
                    return;
                }
//                result.setText(realResult + "   " + imgResult + "i");
//                result.setText(real1.getText().toString());
                String realR;
                String imgR;
                if (realResult >= 0) {
                    realR = "+"+realResult;
                } else {
                    realR = ""+realResult;
                }
                if (imgResult >= 0) {
                    imgR = "+"+imgResult;
                } else {
                    imgR = ""+imgResult;
                }

                Toast.makeText(getApplicationContext(), realR + "   " + imgR + "i", Toast.LENGTH_SHORT).show();
            }


        });
    }
}