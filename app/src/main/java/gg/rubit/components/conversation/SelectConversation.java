package gg.rubit.components.conversation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gg.rubit.R;
import gg.rubit.api.ApiService;
import gg.rubit.components.conversation.data.SubTemas;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectConversation extends AppCompatActivity {

    Spinner spnSubT, spnT;
    int sel, sel2;
    List<Integer> ID = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        setSpnTema();
    }

    private void setSpnTema() {
        spnT = findViewById(R.id.spnTema);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Temas, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnT.setAdapter(adapter);
        spnT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                sel = spnT.getSelectedItemPosition() + 1;
                getSubTemas(sel);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void setSpinnerSubTema(List<SubTemas> list) {
        List<String> datos = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            SubTemas obj = new SubTemas();
            //obj.setDescripcion(list.get(i).getDescripcion());
            //datos.add(obj.getDescripcion());
            datos.add(list.get(i).getDescripcion());
            ID.add(list.get(i).getID());
        }

        spnSubT = findViewById(R.id.spnSubtema);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, datos);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSubT.setAdapter(arrayAdapter);

        spnSubT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                sel2 = spnSubT.getSelectedItemPosition() + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // TODO Auto-generated method stub
            }
        });
    }

    private void getSubTemas(int sel) {
        Call<List<SubTemas>> call = ApiService.getApiService().getSubTemas(sel);
        call.enqueue(new Callback<List<SubTemas>>() {
            @Override
            public void onResponse(Call<List<SubTemas>> call, Response<List<SubTemas>> response) {
                if (response.isSuccessful()) {
                    setSpinnerSubTema(response.body());
                } else {
                    Toast.makeText(getApplicationContext(), "Fallo de api", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<SubTemas>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo de red", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void itemSelected(View v) {
        int select = 0;

        Intent intent = new Intent(this, ConversacionActivity.class);

        switch (sel2) {
            case 1:
                if (sel == 1) {
                    select = 1;
                } else if (sel == 2) {
                    select = 2;
                }
                intent.putExtra("select", select);
                break;
            case 2:
                if (sel == 1) {
                    select = 3;
                } else if (sel == 2) {
                    select = 6;
                }
                intent.putExtra("select", select);
                break;
            case 3:
                if (sel == 1) {
                    select = 4;
                } else if (sel == 2) {
                    select = 7;
                }
                intent.putExtra("select", select);
                break;
            case 4:
                if (sel == 1) {
                    select = 5;
                } else if (sel == 2) {
                    select = 8;
                }
                intent.putExtra("select", select);
                break;
            case 5:
                if (sel == 2) {
                    select = 9;
                }
                intent.putExtra("select", select);
                break;
            case 6:
                if (sel == 2) {
                    select = 10;
                }
                intent.putExtra("select", select);
                break;
        }

        startActivity(intent);
    }
}