package alumnos.ucn.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  {

    private EditText txt_num1, txt_num2;
    private Spinner spinner;
    private ImageButton imageButton;
    private TextView txt_res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_num1 = (EditText) findViewById(R.id.txt_num1);
        txt_num2 = (EditText) findViewById(R.id.txt_num2);
        txt_res = (TextView) findViewById(R.id.txt_res);
        spinner = (Spinner) findViewById(R.id.spinner);
        imageButton = (ImageButton) findViewById(R.id.imageButton);


        String[] operations =
                {
                        "Sumar",
                        "Restar",
                        "Multiplicar",
                        "Dividir",
                };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinnermod, operations);

        spinner.setAdapter(adapter);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
    }
    

    private boolean calcular(){

        double valor1 = 0;
        double valor2 = 0;

        try {
             valor1 = Integer.parseInt(txt_num1.getText().toString());
             valor2 = Integer.parseInt(txt_num2.getText().toString());

        }catch (Exception e){
            txt_res.setText("Error");
            return false;
        }
        String seleccionado = spinner.getSelectedItem().toString();

        if (seleccionado.equals("Sumar")){
            double suma = valor1 + valor2;
            txt_res.setText(String.valueOf(suma));
        } else if (seleccionado.equals("Restar")) {
            double restar = valor1 - valor2;
            txt_res.setText(String.valueOf(restar));
        } else if (seleccionado.equals("Multiplicar")) {
            double multiplicar = valor1*valor2;
            txt_res.setText(String.valueOf(multiplicar));
        } else if (seleccionado.equals("Dividir")) {
            double dividir = valor1/valor2;
            txt_res.setText(String.valueOf(dividir));
        }

        return true;
    }


}