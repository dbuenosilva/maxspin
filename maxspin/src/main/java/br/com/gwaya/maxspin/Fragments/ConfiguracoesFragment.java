package br.com.gwaya.maxspin.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import br.com.gwaya.maxspin.Activity.LoginActivity;
import br.com.gwaya.maxspin.R;

public class ConfiguracoesFragment extends Fragment {
    private Button btnLogout;
    private TextView rpm;
    private SeekBar rmpMax;
    private SeekBar.OnSeekBarChangeListener listener;

    public ConfiguracoesFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                          Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_configuracoes, container, false);

        btnLogout = (Button) v.findViewById(R.id.buttonLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent i = new Intent(getActivity(),
                        LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                        Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);

            }
        });

        rpm = (TextView) v.findViewById(R.id.textRPM);
        rmpMax = (SeekBar) v.findViewById(R.id.seekBarRpm);

        rmpMax.setOnSeekBarChangeListener(listener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                rpm.setText( i + " RPM");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        {

        }

        return(v);
    }

}
