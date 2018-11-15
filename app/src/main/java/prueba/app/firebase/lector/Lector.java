package prueba.app.firebase.lector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Lector extends AppCompatActivity {
    EditText codigo;
    Button escaner;
    private ZXingScannerView vistaescaner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lector);
    }

    public void Escanear(View view){
        vistaescaner = new ZXingScannerView(this);
        vistaescaner.setResultHandler(new zxingscanner());
        setContentView(vistaescaner);
        vistaescaner.startCamera();
    }

    class zxingscanner implements ZXingScannerView.ResultHandler{

        @Override
        public void handleResult(Result result) {
            String dato = result.getText();
            int length = dato.length();
            int largo = 9;
            int inicio = length - largo;
            String dua = "";
            dua = dato.substring(inicio,length);

            setContentView(R.layout.activity_lector);
            vistaescaner.stopCamera();
            codigo = (EditText) findViewById(R.id.edtCodigo);
            codigo.setText(dua);
        }
    }

}
