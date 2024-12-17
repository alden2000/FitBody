package link.fitbody;

import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.snackbar.Snackbar;

public class MotherActivity extends AppCompatActivity {

    Toast toast = null;

    public void showCalculatorToast(CharSequence message){

        final Snackbar mySnackbar = Snackbar.make(findViewById(android.R.id.content), message, Snackbar.LENGTH_INDEFINITE);
        mySnackbar.setAction("OK", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mySnackbar.dismiss();
            }
        });
        mySnackbar.show();

    }

    public void showInfoToast(CharSequence message){

        LayoutInflater inflater = getLayoutInflater();
        // Inflate the Layout
        View layout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));

        layout.setBackgroundColor(ContextCompat.getColor(this, R.color.toastBackgroundLight));

        TextView text = (TextView) layout.findViewById(R.id.toast_message);
        // Set the Text to show in TextView
        text.setTextSize(TypedValue.COMPLEX_UNIT_SP,28);
        text.setText(message);

        if(toast != null){
            toast.cancel();
        }

        toast = new Toast(this);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

}
