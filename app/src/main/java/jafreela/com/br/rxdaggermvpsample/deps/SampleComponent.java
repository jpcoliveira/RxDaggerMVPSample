package jafreela.com.br.rxdaggermvpsample.deps;

import javax.inject.Singleton;

import dagger.Component;
import jafreela.com.br.rxdaggermvpsample.home.HomeActivity;
import jafreela.com.br.rxdaggermvpsample.networking.NetworkModule;
import jafreela.com.br.rxdaggermvpsample.source.PreferenceModule;

@Singleton
@Component(
        modules = {
                NetworkModule.class,
                PreferenceModule.class,
        })
public interface SampleComponent {
    void inject(HomeActivity homeActivity);
}
