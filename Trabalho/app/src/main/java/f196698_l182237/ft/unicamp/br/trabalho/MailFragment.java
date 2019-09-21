package f196698_l182237.ft.unicamp.br.trabalho;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class MailFragment extends Fragment {

    private View view;
    private EditText destinatario;
    private EditText mensagem;

    public MailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_mail, container, false);
        }

        destinatario = view.findViewById(R.id.destinatario);
        mensagem = view.findViewById(R.id.mensagem);

        Button enviar = view.findViewById(R.id.btn_send);
        enviar.setOnClickListener(
            new View.OnClickListener(){
                public void onClick(View view) {
                    String msg = MailFragment.this.mensagem.getText().toString();
                    ((MainActivity)getActivity()).doSomething(msg);
                }
            }
        );
        return view;
    }

}
