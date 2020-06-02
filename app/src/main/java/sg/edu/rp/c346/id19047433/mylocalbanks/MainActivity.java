package sg.edu.rp.c346.id19047433.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;
    String click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDBS = findViewById(R.id.textViewBDS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main2, menu);

        click = "";
        if (v.getId() == tvDBS.getId()){
            click = "DBS";
        }
        else if (v.getId() == tvOCBC.getId()){
            click = "OCBC";
        }else if (v.getId() == tvUOB.getId()){
            click = "UOB";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.WebsiteSelection && click =="DBS") {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
            startActivity(intent);
            return true;
        } else if (id == R.id.Contact && click == "DBS") {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + 18001111));
            startActivity(intent);
            return true;
        } else if (id == R.id.WebsiteSelection && click == "OCBC"){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(intent);
            return true;
        } else if (id == R.id.Contact && click == "OCBC"){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + 18003633));
            startActivity(intent);
            return true;
        } else if (id == R.id.WebsiteSelection && click == "UOB"){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(intent);
            return true;
        }else if (id == R.id.Contact && click == "UOB"){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("Tel: " + 18002222));
            startActivity(intent);
            return true;
        }


        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();
        if (id == R.id.EnglishSelection){
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        }
        else if (id == R.id.ChineseSelection){
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}// end class
