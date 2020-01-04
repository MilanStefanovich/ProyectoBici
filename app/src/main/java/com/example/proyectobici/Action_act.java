package com.example.proyectobici;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Action_act extends AppCompatActivity {
    static String MQTTHOST = "tcp://tailor.cloudmqtt.com:11943";
    static String USERNAME = "wzijksec";
    static String PASSWORD = "Hw4K8gfTs1u4";
    String topicStr = "Candado";
    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_act);

        String clientId = MqttClient.generateClientId();
        client = new MqttAndroidClient(this.getApplicationContext(), MQTTHOST, clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(), "CONEXION ESTABLECIDA", Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(), "CONEXION NO ESTABLECIDA", Toast.LENGTH_LONG).show();


                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void Abrir(View view) {
        String topic = topicStr;
        String message = "Abierto";
        Toast.makeText(getBaseContext(),"Publicando...", Toast.LENGTH_LONG).show();
        try {
            client.publish(topic, message.getBytes(), 0, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void Cerrar(View view) {
        String topic = topicStr;
        String message = "Cerrado";
        Toast.makeText(getBaseContext(),"Publicando...", Toast.LENGTH_LONG).show();
        try {
            client.publish(topic, message.getBytes(), 0, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}