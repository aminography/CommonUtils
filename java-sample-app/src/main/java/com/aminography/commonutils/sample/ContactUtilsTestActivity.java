package com.aminography.commonutils.sample;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.aminography.commonutils.ContactData;
import com.aminography.commonutils.ContactUtilsKt;

import java.util.List;

/**
 * @author aminography
 */
public class ContactUtilsTestActivity extends AppCompatActivity {

    private final int REQUEST_CODE_READ_CONTACTS = 17;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        checkPermissionAndShow();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_READ_CONTACTS) {
            checkPermissionAndShow();
        }
    }

    private void checkPermissionAndShow() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            List<ContactData> contacts = ContactUtilsKt.retrieveAllContacts(getApplicationContext());
            StringBuilder sb = new StringBuilder();
            for (ContactData contact : contacts) {
                sb.append(contact.toString());
                sb.append("\n\n");
            }
            textView.setText(sb.toString());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, REQUEST_CODE_READ_CONTACTS);
        }
    }

}
