package fateczl.aps.aula03_mobileex2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView tvConsumo;
    private EditText etConsumo;
    private TextView tvQtdLitros;
    private EditText etQtdLitros;
    private TextView tvMetrosRestantes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvConsumo = findViewById(R.id.tvConsumoMedioAutomovel);
        etConsumo = findViewById(R.id.etConsumoMedioAutomovel);
        tvQtdLitros = findViewById(R.id.tvQuantidadeDeLitrosNoTanque);
        etQtdLitros = findViewById(R.id.etQuantidadeDeLitrosNoTanque);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        tvMetrosRestantes = findViewById(R.id.tvMetrosRestantesQuePodemSerPercorridos);

        btnCalcular.setOnClickListener(operacao -> calculoDeQuilometragemRestante());
    }
    private void calculoDeQuilometragemRestante() {
        float consumoMedio = Float.parseFloat(etConsumo.getText().toString());
        float litrosNoTanque = Float.parseFloat(etQtdLitros.getText().toString());

        float quilometrosRestantes = consumoMedio * litrosNoTanque;
        float metrosRestantes = quilometrosRestantes * 1000;

        tvMetrosRestantes.setText("Você ainda pode Percorrer " + metrosRestantes +" metros");
        etConsumo.setText("");
        etQtdLitros.setText("");
    }


}