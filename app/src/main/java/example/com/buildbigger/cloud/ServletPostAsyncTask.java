package example.com.buildbigger.cloud;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.IOException;

import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;
import example.com.androidlibrary.MainLibraryActivity;
import servelets.backend.myApi.MyApi;

//import com.google.api.client.extensions.android.json.AndroidJsonFactory;

/**
 * Created by GG on 23/11/18.
 */

public class ServletPostAsyncTask extends AsyncTask<Context, Void, String> {

    //private final String ipAddress = "192.168.1.7";
    private final String ipAddress = "localhost";
    private static MyApi myApiService = null;
    private Context mContext;

    public static String mJoke;

    @Override
    protected String doInBackground(Context... params) {

        if(myApiService == null){
            String ipAddress = "192.168.1.7";
        }
        String ipAddress =    "192.168.1.7";

        HttpClient httpClient = new DefaultHttpClient();

        HttpPost httpPost = new HttpPost("http://" + ipAddress +":8080/");

        try {
            HttpResponse response = httpClient.execute(httpPost);


            if(response.getStatusLine().getStatusCode() == 200){
                return EntityUtils.toString(response.getEntity());
            }

            return "Error:" + response.getStatusLine().getStatusCode() + " " + response.getStatusLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }

       /* MyApi.Builder builder = new MyApi.Builder(  AndroidHttp.newCompatibleTransport(),
                new AndroidJsonFactory(), null)
                // options for running against local devappserver
                // - 10.0.2.2 is localhost's IP address in Android emulator
                // - turn off compression when running against local devappserver
                .setRootUrl("http://" + ipAddress +":8080/_ah/api/")
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });*/
        // end options for devappserver

//        jokeApiService = builder.build();
       // return null ;
    }

    @Override
    protected void onPostExecute(String s) {
//            super.onPostExecute(s);

        Toast.makeText(mContext, s, Toast.LENGTH_SHORT).show();

        Intent jokeIntent = new Intent(mContext, MainLibraryActivity.class);
        jokeIntent.putExtra("joke", s);
        mContext.startActivity(jokeIntent);
    }
}

