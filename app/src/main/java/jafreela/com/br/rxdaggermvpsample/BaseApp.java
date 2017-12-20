package jafreela.com.br.rxdaggermvpsample;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

import jafreela.com.br.rxdaggermvpsample.deps.DaggerSampleComponent;
import jafreela.com.br.rxdaggermvpsample.deps.SampleComponent;
import jafreela.com.br.rxdaggermvpsample.networking.NetworkModule;
import jafreela.com.br.rxdaggermvpsample.source.PreferenceModule;


public class BaseApp  extends AppCompatActivity {
    SampleComponent sampleComponent;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        sampleComponent = DaggerSampleComponent
                .builder()
                .networkModule(new NetworkModule(cacheFile))
                .preferenceModule(new PreferenceModule(this))
                .build();
    }

    public SampleComponent getSampleComponent() {
        return sampleComponent;
    }
}
