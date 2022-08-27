package gg.rubit.components.lessons;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import gg.rubit.R;
import gg.rubit.adapters.ConversationListViewAdapter;
import gg.rubit.api.ApiService;
import gg.rubit.data.ConversationDataValues;
import gg.rubit.events.ResponseEventHandler;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConversationActivity extends AppCompatActivity {

    ListView conversationListView;
    ConversationListViewAdapter adapter;
    ResponseEventHandler responseEventHandler = new ResponseEventHandler();
    int size = 0, count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversacion);

        initializeControllers();
        getDialogs();
    }

    private void initializeControllers() {
        conversationListView = findViewById(R.id.lstChats);
    }

    public void updateListViewData() {
        conversationListView.setAdapter(adapter);
    }

    private void AttachEvents() {
        conversationListView.setOnItemClickListener((adapterView, view, i, l) -> {
            String Audio = ((TextView) view.findViewById(R.id.lblaudio)).getText().toString();
            responseEventHandler.playMp3(Audio);
        });
    }

    public void getDialogs() {
        Call<List<ConversationDataValues>> call = ApiService.getApiService().getDialogsList();
        call.enqueue(new Callback<List<ConversationDataValues>>() {
            @Override
            public void onResponse(Call<List<ConversationDataValues>> call, Response<List<ConversationDataValues>> response) {
                if (response.isSuccessful()) {
                    responseEventHandler.setContext(getApplicationContext());
                    size = responseEventHandler.responseReceived(response.body());
                    if (size < 1) {
                        Toast.makeText(getApplicationContext(), "No se encontraron mensajes de la leccion", Toast.LENGTH_LONG).show();
                    } else {
                        adapter = new ConversationListViewAdapter(getApplicationContext(), responseEventHandler.datos(count));
                        AttachEvents();
                        updateListViewData();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Fallo de api", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<ConversationDataValues>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Fallo de red", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void proceedStory(View v) {
        if (count + 1 < size) {
            count = count + 1;
            responseEventHandler.datos(count);
            updateListViewData();
        } else {
            Toast.makeText(this, "Se ha terminado la lección", Toast.LENGTH_LONG).show();
        }
    }

    /*public void IrAlInicio(View v) {
        startActivity(new Intent(getApplicationContext(), CrearDatos.class));
    }*/
}