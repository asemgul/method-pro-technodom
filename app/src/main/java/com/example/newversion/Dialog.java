package com.example.newversion;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Dialog extends AppCompatDialogFragment {
    private EditText edit_newPassword;
    private Button btnChangePassword;
    private DialogListener listener;

    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog, null);

        builder.setView(view)
                .setTitle("Смените ваш пароль!")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    Intent intent;
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String newPassword=edit_newPassword.getText().toString();
                        listener.applyText(newPassword);
                        intent=new Intent(getContext(), SecondActivity.class);
                        Dialog.this.startActivity(intent);
                    }
                });

        edit_newPassword=view.findViewById(R.id.edit_newPassword);
        //btnChangePassword=view.findViewById(R.id.btnChangePassword);

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener=(DialogListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement DialogListener");
        }
    }

    public interface DialogListener{
        void applyText(String newPassword);
    }
}
