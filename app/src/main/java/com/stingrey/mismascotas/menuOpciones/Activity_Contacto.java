package com.stingrey.mismascotas.menuOpciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;

import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stingrey.mismascotas.JavaMailAPI;
import com.stingrey.mismascotas.R;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Activity_Contacto extends AppCompatActivity {

    // Se inicializan las variables
    private EditText etNombre, etEmail, etMensaje;
    private Button bEnviar;
    private Session session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__contacto);

        androidx.appcompat.widget.Toolbar contactoBar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.contactoBar);
        setSupportActionBar(contactoBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Se inicializan las variables
        etNombre = findViewById(R.id.tfeNombreCompleto);
        etEmail = findViewById(R.id.tfeEmail);
        etMensaje = findViewById(R.id.tfeMensaje);
        bEnviar = findViewById(R.id.btnEnviar);

        //sEmail = "Su Email";
        //sPassword = "Contraseña";

        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });




        /*
        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                //Se inicializan las propiedades
                Properties propiedades = new Properties();
                propiedades.put("mail.smtp.auth", "true");
                propiedades.put("mail.smtp.starttls.enable", "true");
                propiedades.put("mail.smtp.host", "smtp.gmail.com");
                propiedades.put("mail.smtp.port", "587");

                //Se inicializa la sesión
                Session sesion = Session.getInstance(propiedades, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sEmail, sPassword);
                    }
                });

                try {

                    //Se inicializa email contexto
                    Message mensaje = new MimeMessage(sesion);
                    //Sender email
                    mensaje.setFrom(new InternetAddress(sEmail));
                    //Recipiente del email
                    mensaje.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(etEmail.getText().toString().trim()));
                    //Email asunto o nombre
                    mensaje.setSubject(etNombre.getText().toString().trim());
                    //Email mensaje
                    mensaje.setText(etMensaje.getText().toString().trim());

                    //Enviar correo
                    new SendMail().execute(mensaje);

                } catch (AddressException e) {
                    e.printStackTrace();
                } catch (MessagingException e) {
                    e.printStackTrace();
                }


            }
        });



        //agregarBotonRaised();
        */
    }

    private void sendEmail() {
        String mEmail = etEmail.getText().toString();
        String mSubject = etNombre.getText().toString();
        String mMessage = etMensaje.getText().toString();

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, session, mEmail, mSubject, mMessage);

        javaMailAPI.execute();
    }

    public void agregarBotonRaised () {

        Button siguiente = (Button) findViewById(R.id.btnEnviar);
        siguiente.setOnClickListener(new View.OnClickListener() {

            //Se crean las instancias de los objetos en la MainActivity para enviar
            /*TextInputEditText tietNombre = (TextInputEditText) findViewById(R.id.tfeNombreCompleto);
            TextInputEditText tietEmail = (TextInputEditText) findViewById(R.id.tfeEmail);
            TextInputEditText tietDescripcion = (TextInputEditText) findViewById(R.id.tfeDescrip);*/

            //Intent intento = new Intent(Activity_Contacto.this, Contactos2.class);


            @Override
            public void onClick(View v) {

                /*intento.putExtra(getResources().getString(R.string.pNombre), tietNombre.getEditableText().toString());
                intento.putExtra(getResources().getString(R.string.pEmail), tietEmail.getEditableText().toString());
                intento.putExtra(getResources().getString(R.string.pDescripcion), tietDescripcion.getEditableText().toString());
                startActivity(intento);*/
            }
        });

    }

    private class SendMail extends AsyncTask<Message,String,String> {

        //Inicializar dialogo de progreso
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //crear y mostrar progreso del dialogo
            progressDialog = progressDialog.show(Activity_Contacto.this
                , "Por favor esperar", "Enviando correo", true, false);
        }

        protected String doInBackground(Message... messages) {

            try {
                //Si es exitoso
                Transport.send(messages(0));
                return "exitoso";
            } catch (MessagingException e) {
                //Si hay error
                e.printStackTrace();
                return "error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();
            if (s.equals("exitoso")){

                AlertDialog.Builder builder = new AlertDialog.Builder(Activity_Contacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Exitoso</font>"));
                builder.setMessage("Correo enviado con exito.");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                        etNombre.setText("");
                        etEmail.setText("");
                        etMensaje.setText("");

                    }
                });

                //Mostrar alertas
                builder.show();

            } else {
                Toast.makeText(getApplicationContext()
                    , "Algo ocurrio?", Toast.LENGTH_LONG).show();
            }
        }
    }

    private Message messages(int i) {
        return null;
    }
}