package br.com.panicobass.recebendodadosentreactivities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	public static final int CONSTANTE_TELA_1 = 1;
	public static final int CONSTANTE_TELA_2 = 2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void enviarDadosTela1(View v) {
		EditText edtNome = (EditText) findViewById(R.id.edtNome);
		EditText edtEmail = (EditText) findViewById(R.id.edtEmail);

		Bundle params = new Bundle();
		params.putString("nome", edtNome.getText().toString());
		params.putString("email", edtEmail.getText().toString());

		Intent intent = new Intent(MainActivity.this, Tela1.class);
		intent.putExtras(params);
		startActivityForResult(intent, CONSTANTE_TELA_1);
	}

	public void enviarDadosTela2(View v) {
		EditText edtNome = (EditText) findViewById(R.id.edtNome);
		EditText edtEmail = (EditText) findViewById(R.id.edtEmail);

		Bundle params = new Bundle();
		params.putString("nome", edtNome.getText().toString());
		params.putString("email", edtEmail.getText().toString());

		Intent intent = new Intent(MainActivity.this, Tela2.class);
		intent.putExtras(params);
		startActivityForResult(intent, CONSTANTE_TELA_2);
	}

	protected void onActivityResult(int codigoTela, int resultado, Intent intent) {
		if (codigoTela == CONSTANTE_TELA_1) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				String msg = bundle.getString("msg");
				Toast.makeText(this,
						"Tela 1 -> resultado:" + resultado + " | Msg: " + msg,
						Toast.LENGTH_SHORT).show();
			}
		} else if (codigoTela == CONSTANTE_TELA_2) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				String msg = bundle.getString("msg");
				Toast.makeText(this,
						"Tela 2 -> resultado:" + resultado + " | Msg: " + msg,
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
