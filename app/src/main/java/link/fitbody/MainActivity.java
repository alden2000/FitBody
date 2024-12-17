package link.fitbody;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.core.content.ContextCompat;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends MotherActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void idealWeightOnClick(View view) {
        Intent intent = new Intent(this, IdealWeightActivity.class);
        startActivity(intent);
    }

    public void calorieOnClick(View view) {
        Intent intent = new Intent(this, CalorieActivity.class);
        startActivity(intent);
    }

    public void bodyShapeOnClick(View view) {
        Intent intent = new Intent(this, BodyTypeActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.info_item) {
            int spannableColor = ContextCompat.getColor(this, R.color.primary_text);
            String infoText = "FIT BODY\nAlden Efendic\nITAcademy\nLINK GROUP\n" + Calendar.getInstance().get(Calendar.YEAR);

            Spannable spannable = new SpannableString(infoText);
            spannable.setSpan(new ForegroundColorSpan(spannableColor), 0, infoText.indexOf("\n"), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            spannable.setSpan(new RelativeSizeSpan(0.7f), infoText.indexOf("\n"), infoText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            showInfoToast(spannable);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
