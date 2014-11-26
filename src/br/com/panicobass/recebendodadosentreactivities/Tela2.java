package br.com.panicobass.recebendodadosentreactivities;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Tela2 extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela2);
		
		Intent intent = getIntent();
		if (intent!= null) {
			Bundle params = intent.getExtras();
			if (params !=null) {
				String nome = params.getString("nome");
				String email = params.getString("email");
				
				TextView txtNome = (TextView) findViewById(R.id.txtNomeTela2);
				TextView txtEmail = (TextView) findViewById(R.id.txtEmailTela2);
				
				txtNome.setText(nome);
				txtEmail.setText(email);
			}
		}
	}
	
	public void aceitou(View view) {
		Intent intent = new Intent(Tela2.this,MainActivity.class);
		intent.putExtra("msg", "Aceitou dados");
		setResult(1, intent);
		finish();
	}
	public void rejeitou(View view) {
		Intent intent = new Intent(Tela2.this,MainActivity.class);
		intent.putExtra("msg", "Rejeitou dados");
		setResult(2, intent);
		finish();
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
